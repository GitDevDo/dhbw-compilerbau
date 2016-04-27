/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis X-Scanner mit JFlex
 * - Scanner-Definition
 * 
 * **********************************************
 */


package de.dhbw.compiler.JFlexXScanner;

%%

%class JFlexXScanner
%type Token
%function nextToken

%unicode
%line
%column

%public
%final

%{
	int startLine 				= 0;
	int startColumn 			= 0;
	int prefixMultiplier		= 1;
	int integerValue 			= 0;
	int exponentValue 			= 0;
	int exponentMultiplier 		= 1;
	int decimalPlaceValue 		= 0;
	int decimalPlaceCounter 	= 0;
	StringBuilder stringValue 	= new StringBuilder(16);
	StringBuilder valueText		= new StringBuilder(16);
	
	private String resetTextBuffer() {
		String text = valueText.toString();
		valueText = new StringBuilder(16);
		return text;
	}
	
	private void startInt(char digit) {
		yybegin(INT);
		integerValue = digit - '0';
		decimalPlaceValue = 0;
		decimalPlaceCounter = 1;
		valueText.append(digit);
		startLine = yyline+1;
		startColumn = yycolumn+1;
	}
	
	private void startFloat(String text) {
		yybegin(FLOAT);
		valueText.append(text);
	}
	
	private void startExponent(char digit, boolean isNegative, String text) {
		yybegin(EXP);
		exponentValue = digit - '0';
		exponentMultiplier = isNegative ? -1 : 1;
		valueText.append(text);
	}
	
	private void detectedInt(char digit) {
		integerValue = integerValue * 10 + (digit - '0');
		decimalPlaceValue = integerValue;
		valueText.append(digit); 
	}
	
	private void detectedFloat(char digit) {
		decimalPlaceValue = decimalPlaceValue * 10 + (digit - '0');
		decimalPlaceCounter++;
		valueText.append(digit);
	}
	
	private void detectedExponent(char digit) {
		exponentValue = exponentValue * 10 + (digit - '0');
		valueText.append(digit);
	}
%}

%xstate INT, FLOAT, EXP, STRING

PLUS			= \+
MINUS			= -
MULT			= \*
DIV				= \/
ZERO			= 0
DIGIT 			= [0-9]
DIDIT_NON_ZERO	= [1-9]
LETTER			= [a-zA-Z]
SPECIAL_CHAR	= [ .:\\]
QUOTE			= \"
WS				= [ \t\b\r\n\f]

%%

//	operator keywords
\(		{ return new Token(Token.LBR,  yytext(), yyline+1, yycolumn+1); }
\)		{ return new Token(Token.RBR,  yytext(), yyline+1, yycolumn+1); }
{PLUS}	{ return new Token(Token.PLUS,  yytext(), yyline+1, yycolumn+1); }
{MINUS}	{ return new Token(Token.MINUS,  yytext(), yyline+1, yycolumn+1); }
{MULT}	{ return new Token(Token.MULT,  yytext(), yyline+1, yycolumn+1); }
{DIV}	{ return new Token(Token.DIV,  yytext(), yyline+1, yycolumn+1); }
:=		{ return new Token(Token.ASSIGN,  yytext(), yyline+1, yycolumn+1); }
:		{ return new Token(Token.COLON,  yytext(), yyline+1, yycolumn+1); }
;		{ return new Token(Token.SEMICOLON,  yytext(), yyline+1, yycolumn+1); }
\<		{ return new Token(Token.LESS,  yytext(), yyline+1, yycolumn+1); }
=		{ return new Token(Token.EQUALS,  yytext(), yyline+1, yycolumn+1); }
\>		{ return new Token(Token.MORE,  yytext(), yyline+1, yycolumn+1); }

//	control flow keywords
if		{ return new Token(Token.IF,  yytext(), yyline+1, yycolumn+1); }
then	{ return new Token(Token.THEN,  yytext(), yyline+1, yycolumn+1); }
else	{ return new Token(Token.ELSE,  yytext(), yyline+1, yycolumn+1); }
for		{ return new Token(Token.FOR,  yytext(), yyline+1, yycolumn+1); }
while	{ return new Token(Token.WHILE,  yytext(), yyline+1, yycolumn+1); }

//	operation keywords
program	{ return new Token(Token.PROGRAM,  yytext(), yyline+1, yycolumn+1); }
begin	{ return new Token(Token.BEGIN,  yytext(), yyline+1, yycolumn+1); }
end		{ return new Token(Token.END,  yytext(), yyline+1, yycolumn+1); }
read	{ return new Token(Token.READ,  yytext(), yyline+1, yycolumn+1); }
print	{ return new Token(Token.PRINT,  yytext(), yyline+1, yycolumn+1); }
\.		{ return new Token(Token.DOT,  yytext(), yyline+1, yycolumn+1); }

//	type keywords
int		{ return new Token(Token.INT,  yytext(), yyline+1, yycolumn+1); }
float	{ return new Token(Token.FLOAT,  yytext(), yyline+1, yycolumn+1); }
string	{ return new Token(Token.STRING,  yytext(), yyline+1, yycolumn+1); }

{WS}	{ /* eat whitespace */}

[^]		{ return new Token(Token.INVALID,  yytext(), yyline+1, yycolumn+1); }

<<EOF>>	{ return new Token(Token.EOF,  yytext(), yyline+1, yycolumn+1); }


/* Integer detection and type conversion */
{DIGIT} {
	startInt(yycharat(0));
}

<INT> {
	{DIGIT} {
		detectedInt(yycharat(0));
	}
	
	\. {
		startFloat(yytext());
	}
	
	{LETTER}({LETTER}|{DIGIT}|{SPECIAL_CHAR})* {
		yybegin(YYINITIAL);
		valueText.append(yytext());
		return new Token(Token.ID, resetTextBuffer(), yyline+1, yycolumn+1);
	}
	
	[^] {
		yybegin(YYINITIAL);
		yypushback(1);
		return new IntConstToken(Token.INTCONST, resetTextBuffer(), integerValue, startLine, startColumn);
	}
	
	<<EOF>> {
		yybegin(YYINITIAL);
		return new IntConstToken(Token.INTCONST, resetTextBuffer(), integerValue, startLine, startColumn);
	}
}

<FLOAT> {
	{DIGIT} {
		detectedFloat(yycharat(0));
	}
	
	(e|E){DIGIT} {
		startExponent(yycharat(1), false, yytext());		
	}
	
	(e|E)-{DIGIT} {
		startExponent(yycharat(2), true, yytext());
	}
	
	[^] {
		yybegin(YYINITIAL);
		yypushback(1);
		float value = (float)(integerValue + (decimalPlaceValue * 1.0f )/ Math.pow(10, decimalPlaceCounter));
		return new FloatConstToken(Token.FLOATCONST, resetTextBuffer(), value, startLine, startColumn);
	}
	
	<<EOF>> {
		yybegin(YYINITIAL);
		float value = (float)(integerValue + (decimalPlaceValue * 1.0f )/ Math.pow(10, decimalPlaceCounter));
		return new FloatConstToken(Token.FLOATCONST, resetTextBuffer(), value, startLine, startColumn);
	}
}

<EXP> {
	{DIGIT} {
		detectedExponent(yycharat(0));
	}
	
	[^] {
		yybegin(YYINITIAL);
		yypushback(1);
		float value = (float)((integerValue + (decimalPlaceValue * 1.0f) / Math.pow(10, decimalPlaceCounter)) * Math.pow(10, exponentMultiplier * exponentValue));
		return new FloatConstToken(Token.FLOATCONST, resetTextBuffer(), value, startLine, startColumn);
	}
	
	<<EOF>> {
		yybegin(YYINITIAL);
		float value = (float)((integerValue + (decimalPlaceValue * 1.0f) / Math.pow(10, decimalPlaceCounter)) * Math.pow(10, exponentMultiplier * exponentValue));
		return new FloatConstToken(Token.FLOATCONST, resetTextBuffer(), value, startLine, startColumn);
	}
}

{QUOTE} {
	yybegin(STRING);
	valueText = new StringBuilder(yytext());
	startLine = yyline+1;
	startColumn = yycolumn+1;
	stringValue = new StringBuilder(16);
}

<STRING> {
	({LETTER}|{DIGIT}|{SPECIAL_CHAR})+ {
		valueText.append(yytext());
		stringValue.append(yytext());
	}
	
	\\{QUOTE} {
		valueText.append(yytext());
		stringValue.append(yytext());
	}
	
	{QUOTE} {
		yybegin(YYINITIAL);
		valueText.append(yytext());
		return new StringConstToken(Token.STRINGCONST, resetTextBuffer(), stringValue.toString(), startLine, startColumn);
	}
	
	[^] {
		yybegin(YYINITIAL);
		return new Token(Token.INVALID, resetTextBuffer(), startLine, startColumn);
	}
	
	<<EOF>> {
		yybegin(YYINITIAL);
		return new Token(Token.INVALID, resetTextBuffer(), startLine, startColumn);
	}
}

{LETTER}({LETTER}|{DIGIT})* {
	return new Token(Token.ID, yytext(), yyline+1, yycolumn+1);
}






