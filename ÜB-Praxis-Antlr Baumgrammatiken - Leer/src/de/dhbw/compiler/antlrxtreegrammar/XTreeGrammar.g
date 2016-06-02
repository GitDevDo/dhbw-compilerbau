/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis ANTLR-Parser f�r X
 * - Grammatik f�r Scanner und Parser
 * 
 * **********************************************
 */

tree grammar XTreeGrammar;

options {
  language = Java;
  output = AST;
  tokenVocab = X;
  ASTLabelType = CommonTree;
}

@header {package de.dhbw.compiler.antlrxtreegrammar;}


program:      'todo';


