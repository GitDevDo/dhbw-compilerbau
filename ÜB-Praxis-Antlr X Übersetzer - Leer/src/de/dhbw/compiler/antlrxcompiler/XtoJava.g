tree grammar XtoJava;

options {
  language = Java;
  output = template;
  tokenVocab = XOptimizer;
  ASTLabelType = XTree;
}

@header {
    package de.dhbw.compiler.antlrxcompiler;
}

@members {

  private SymbolTable  symbols = SymbolTable.getInstance();  
     
}

//program:      'todo' -> template() "Hello World!";

decl:   ^(DECL ID (type='int' | type='float' | type='string')) -> template(t={$type.text}, v={$ID.text}) "<t> <v>;"
      | ^(DECL ID (type='int' | type='float' | type='string') 'read') -> template(t={$type.text}, v={$ID.text}) "<t> <v>;"
      | ^(DECL ID (type='int' | type='float' | type='string') 'print') -> template(t={$type.text}, v={$ID.text}) "<t> <v>;"
      | ^(DECL ID (type='int' | type='float' | type='string') 'read' 'print') -> template(t={$type.text}, v={$ID.text}) "<t> <v>;";

decllist: ^(DECLLIST (declarations+=decl)*) -> template(d={$declarations}) "<d; separator=\"\n\">";

expr:   ^((op='+' | op='-' | op='*' | op='/') left=expr right=expr) -> template(o={$op.text}, l={$left.st}, r={$right.st}) "<l> <o> <r>"
      | simpleexpr -> template(e={$simpleexpr.st}) "<e>";

simpleexpr:   INTCONST -> template(c={$INTCONST.text}) "<c>"
            | ^(UMINUS INTCONST) -> template(c={$INTCONST.text}) "-<c>"
            | FLOATCONST -> template(c={$FLOATCONST.text}) "<c>"
            | ^(UMINUS FLOATCONST) -> template(c={$FLOATCONST.text}) "-<c>"
            | ID -> template(v={$ID.text}) "<v>"
            | STRINGCONST -> template(c={$STRINGCONST.text}) "<c>";
            
assignstat: ^(':=' ID expr) -> template(a={$ID.text}, e={$expr.st}) "<a> = <e>;";

cond: ^((operator='<' | operator='>' | operator='=') left=expr right=expr) ->
          template(o={$operator.text}, l={$left.st}, r={$right.st}) "<l> <o> <r>";

condstat: ^('if' cond then=stat elseSt=stat?) ->            
            template(c={$cond.st}, t={$then.st}, e={$elseSt.st}) "if (<cond>) {<t>} else {<e>}";

whilestat: ^('while' cond stat) -> template(c={$cond.st}, s={$stat.st}) "while (<c>) {<s>}";
forstat: ^('for' var=assignstat cond inc=assignstat stat) ->
            template(v={$var.st}, c={$cond.st}, i={$inc.st}, b={$stat.st}) "for (<v>; <c>; <i>) {<b>}";

stat: (stmt=assignstat | stmt=condstat | stmt=whilestat | stmt=forstat | stmt=statlist) -> template(s={$stmt.st}) "<s>";

statlist: ^(STATLIST (stmt+=stat)*) -> template(s={$stmt}) "<s; separator=\"\n\">";

program: ^('program' ID decllist statlist) -> template(n={$ID.text}, d={$decllist.st}, s={$statlist.st}) <<
public class <n> {
  <d>
  
  public static void main(String[] args){
    <s>
  }
}
  >>;
