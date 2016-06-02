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

tree grammar XTreeGrammar;

options {
  language = Java;
  output = AST;
  tokenVocab = X;
  ASTLabelType = CommonTree;
}

@header {package de.dhbw.compiler.antlrxtreegrammar;}


program:      'todo';


