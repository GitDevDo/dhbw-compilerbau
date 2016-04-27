/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis AS-Scanner mit JFlex
 * 
 * **********************************************
 */

package de.dhbw.compiler.jflexasscanner;

%%

%class JFlexASScanner
%function nextToken
%type  Token 

%unicode
%line
%column
%public
%final 

%xstate NUM, FRAC, EXP, STRING

%{
	String text = "";
	String stringValue = "";
	int intValue = 0;
	float floatValue = 0f;
	int floatCount = 0;
	int exponent = 0;
	int startLine = 0;
	int startColumn = 0;
%}

DIGIT 				= [0-9]
WHITESPACE 			= [ \t\b\r\n]
LETTER 				= [a-zA-Z]
NAME_CHARACTER 		= [a-zA-Z0-9]
STRING_CHARACTER	= [a-zA-Z0-9 ]

%%
null		{ return new Token(Token.NULL, yytext(), yyline+1, yycolumn+1); }

\[			{ return new Token(Token.LSBR, yytext(), yyline+1, yycolumn+1); }

\]			{ return new Token(Token.RSBR, yytext(), yyline+1, yycolumn+1); }

,			{ return new Token(Token.COMMA, yytext(), yyline+1, yycolumn+1); }

{DIGIT}		{	
	yybegin(NUM);
	intValue = yycharat(0) - '0';
	text += yycharat(0);
	startLine = yyline+1;
	startColumn = yycolumn+1;
}

<NUM> {
	{DIGIT}	{
		intValue = intValue * 10 + yycharat(0) - '0';
		text += yycharat(0);
	}

	\.	{	
		yybegin(FRAC);
		floatValue = intValue * 1.0f;
		floatCount = 0;
		text += yycharat(0);
	}

	(\.\.)+ {
		yybegin(YYINITIAL);
		yypushback(yylength());
		String textValue = text;
		text = "";
		return new NumToken(Token.NUM, textValue, intValue, startLine, startColumn);
	}

	\./(\.\.)+ {
		yybegin(YYINITIAL);
		yypushback(yylength() - 1);
		floatValue = intValue * 1.0f;
		text += yycharat(0);
		String textValue = text;
		text = "";
		return new FracToken(Token.FRAC, textValue, floatValue, startLine, startColumn);
	}

	{LETTER}{NAME_CHARACTER}* {
		yybegin(YYINITIAL);
		text += yytext();
		String textValue = text;
		text = "";
		return new Token(Token.ID, textValue, startLine, startColumn);
	}

	[^] {
		yybegin(YYINITIAL);
		yypushback(1);
		String textValue = text;
		text = "";
		return new NumToken(Token.NUM, textValue, intValue, startLine, startColumn);
	}
	
	<<EOF>> {
		yybegin(YYINITIAL);
		String textValue = text;
		text = "";
		return new NumToken(Token.NUM, textValue, intValue, startLine, startColumn);
	}
}

<FRAC> {
	{DIGIT}	{
		floatValue += (float)(yycharat(0) - '0') / (float)Math.pow(10f, ++floatCount);
		text += yycharat(0);
	}

	\^{DIGIT}	{
		yybegin(EXP);
		exponent = yycharat(1) - '0';
		text += yytext();
	}

	[^]	{
		yybegin(YYINITIAL);
		yypushback(1);
		String textValue = text;
		text = "";
		return new FracToken(Token.FRAC, textValue, floatValue, startLine, startColumn);
	}
}

<EXP> {
	{DIGIT} {
		exponent = exponent * 10 + yycharat(0) - '0';
		text += yycharat(0);
	}
	
	[^]	{
		yybegin(YYINITIAL);
		yypushback(1);
		floatValue = floatValue * (float)Math.pow(10, exponent);
		String textValue = text;
		text = "";
		return new FracToken(Token.FRAC, textValue, floatValue, startLine, startColumn);
	}
}

\"	{
	yybegin(STRING);
	text += yytext();
	startLine = yyline+1;
	startColumn = yycolumn+1;
}

<STRING> {
	{STRING_CHARACTER}* {
		text += yytext();
		stringValue += yytext();
	}
	
	\\\" {
		text += yytext();
		stringValue += "\"";
	}
	
	\" {
		yybegin(YYINITIAL);
		text += yytext();
		String textValue = text;
		text = "";
		//return new StringToken(Token.STRING, textValue, stringValue, startLine, startColumn);
	}
}

{LETTER}{NAME_CHARACTER}*	{
	return new Token(Token.ID, yytext(), yyline+1, yycolumn+1);
}

\.\.	{
	return new Token(Token.TO, yytext(), yyline+1, yycolumn+1);
}

{WHITESPACE}	{ /* eat whitespace */}

[^]			{ return new Token(Token.INVALID, yytext(), yyline+1, yycolumn+1); }

<<EOF>>		{ return new Token(Token.EOF, yytext(), yyline+1, yycolumn+1); }
