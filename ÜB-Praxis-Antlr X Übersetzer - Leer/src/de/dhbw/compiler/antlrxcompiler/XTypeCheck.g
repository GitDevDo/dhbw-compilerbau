tree grammar XTypeCheck;

options {
  language = Java;
  output = AST;
  tokenVocab = X;
  ASTLabelType = XTree;
}

tokens{
  PLUS='+';
  INT='int';
  FLOAT='float';
  STRING='string';
}

@header {
package de.dhbw.compiler.antlrxcompiler;
   
import java.util.HashMap;
}

@members {

   private SymbolTable  symbols = SymbolTable.getInstance();  
   
   private XType getXType(String varType) {
    switch(varType) {
      case "int": return XType.IntType;
      case "float": return XType.FloatType;
      case "string": return XType.StringType;
      default: return XType.InvalidType;
    }
   }
}

decl:   ^(DECL ID (type='int' | type='float' | type='string')) {
          symbols.put($ID.text, new Symbol($ID.text, getXType($type.text)));
        }
      | ^(DECL ID ('int' | 'float' | 'string') 'read')
      | ^(DECL ID ('int' | 'float' | 'string') 'print')
      | ^(DECL ID ('int' | 'float' | 'string') 'read' 'print');

decllist: ^(DECLLIST decl*) -> ^(DECLLIST decl*);

expr:   ^(('+' | '-' | '*' | '/') expr expr)
      | simpleexpr;

simpleexpr:   INTCONST
            | ^(UMINUS INTCONST)
            | FLOATCONST
            | ^(UMINUS FLOATCONST)
            | ID
            | STRINGCONST;
            
assignstat: ^(':=' ID expr);

cond: ^(('<' | '>' | '=') expr expr);

condstat: ^('if' cond stat stat?);

whilestat: ^('while' cond stat);
forstat: ^('for' assignstat cond assignstat stat);

stat: assignstat | condstat | whilestat | forstat | statlist;

statlist: ^(STATLIST stat*);

program: ^('program' ID decllist statlist);

