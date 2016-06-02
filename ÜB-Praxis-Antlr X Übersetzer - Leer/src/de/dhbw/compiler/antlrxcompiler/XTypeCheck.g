tree grammar XTypeCheck;

options {
  language = Java;
  output = AST;
  tokenVocab = X;
  ASTLabelType = XTree;
}

tokens{
  PLUS='+';
}

@header {
package de.dhbw.compiler.antlrxcompiler;
   
import java.util.HashMap;
}

@members {

   private SymbolTable  symbols = SymbolTable.getInstance();  
   
}


program:      'todo';

