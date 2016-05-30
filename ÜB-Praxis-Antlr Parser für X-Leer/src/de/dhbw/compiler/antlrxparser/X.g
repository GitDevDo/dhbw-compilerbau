/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis ANTLR-Parser für X
 * - Grammatik für Scanner und Parser
 * 
 * **********************************************
 */

grammar X;

options {
  language = Java;
  output = AST;
}

// AST-Tokens
tokens { 
  DECL;
  STATLIST;
  DECLLIST;
  UMINUS;
}

@parser::header {package de.dhbw.compiler.antlrxparser;}
@lexer::header  {package de.dhbw.compiler.antlrxparser;}


INVALID:  .;

fragment LETTER: 'a'..'z'|'A'..'Z';
fragment DIGIT: '0'..'9';
fragment OTHER: ' '|'.'|':'|'"';
    
INTCONST: '0' | '1'..'9' (DIGIT)*;
FLOATCONST: INTCONST (('.' DIGIT*)? ('e'|'E')('+'|'-')? INTCONST)?;
STRINGCONST: '"' (LETTER | DIGIT | OTHER)* '"';
ID: LETTER (LETTER | DIGIT)*;

program: 'program'^ ID ';'! decllist block '.'! EOF!;

decllist: decl* -> ^(DECLLIST decl+);

decl: modifier ID ':' type ';' -> ^(DECL modifier ID type);

modifier: 'read' ('print')? | 'print';

type: 'int' | 'float' | 'string';

block: 'begin' statementlist 'end' -> ^(STATLIST statementlist);

statementlist: (stat ';')* -> (stat)+;

stat: assignstat | condstat | whilestat | forstat | block;

whilestat: 'while'^ '('! cond ')'! stat;

forstat: 'for'^ '('! assignstat ';'! cond ';'! assignstat ')'! stat;

assignstat: ID ':=' expr ';' -> ^(':=' ID expr);

condstat: 'if' cond 'then' thenStat=stat 'else' elseStat=stat -> ^('if' cond $thenStat $elseStat)
          | 'if' cond 'then' stat -> ^('if' cond stat);

expr: expr2 expr1a^;

expr1a: '+'^ expr
      | '-'^ expr;

expr2: expr3 expr2a^;

expr2a: '*'^ expr2
      | '/'^ expr2;

expr3: '-' INTCONST -> ^(UMINUS INTCONST)
      | INTCONST
      | '-' FLOATCONST -> ^(UMINUS FLOATCONST)
      | FLOATCONST
      | STRINGCONST
      | ID
      | '('! expr ')'!;

cond: expr cond2^;

cond2 :'<'^ expr
    | '>'^ expr
    | '='^ expr;

