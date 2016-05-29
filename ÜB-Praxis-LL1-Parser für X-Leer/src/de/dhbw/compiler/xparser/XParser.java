/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis LL(1)-Parser für X
 * - LL1-Parser
 * 
 * **********************************************
 */

package de.dhbw.compiler.xparser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class XParser {
	private TokenBuffer in = null;
	private long comparecount = 0;
	
	private Set<Integer> PlusMinus;
	private Set<Integer> MultDiv;

	public XParser(TokenBuffer in) {
		this.in = in;
		PlusMinus = new HashSet<Integer>();
		PlusMinus.add(Token.PLUS);
		PlusMinus.add(Token.MINUS);
		MultDiv = new HashSet<Integer>();
		MultDiv.add(Token.MULT);
		MultDiv.add(Token.DIV);
	}

	public long getCompareCount() {
		return this.comparecount;
	}
	
	private Tree addLeftAssoziativ(Tree left, Tree opRight, Set<Integer> samePrio) {
		Tree right = opRight.getChild(0);
		
		if (right.getChildren().isEmpty() || !samePrio.contains(right.getToken().getType())) {
			opRight.addFirstChild(left);
			return opRight;
		} else {
			Tree leftop = right;
			while (samePrio.contains(leftop.getChild(0).getToken().getType())) {
				leftop = leftop.getChild(0);
			}
			Tree leftright = leftop.getChild(0);
			leftop.removeChild(0);
			opRight.addLastChild(leftright);
			opRight.addFirstChild(left);
			leftop.addFirstChild(opRight);
			return right;
		}
	}
	
	public Tree parseModifier2() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.PRINT:
			return parseToken(Token.PRINT);
		case Token.ID:
			return new Tree(null);		 
		default:
			printError(lookaheadToken(), Token.PRINT, Token.ID);
		 	return null;
	 	}
	}
	
	public Tree parseModifier() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.READ: {
			Tree read, modifier2;
			
			if ((read = parseToken(Token.READ)) != null &&
					((modifier2 = parseModifier2()) != null)) {
				Tree modifier = new Tree(new Token(Token.MODIFIER));
				modifier.addFirstChild(read);
				modifier.addLastChild(modifier2);
				return modifier;
			}
			return null;
		}
		case Token.PRINT: {
			Tree print;
			
			if ((print = parseToken(Token.PRINT)) != null) {
				Tree modifier = new Tree(new Token(Token.MODIFIER));
				modifier.addFirstChild(print);
				return modifier;
			}
			return null;
		}
		case Token.ID:
			return new Tree(null);
		 
		default:
			printError(lookaheadToken(), Token.READ, Token.PRINT, Token.ID);
		 	return null;
	 	}
	}
	
	public Tree parseType() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.INT:
			return parseToken(Token.INT);
		case Token.FLOAT:
			return parseToken(Token.FLOAT);
		case Token.STRING:
			return parseToken(Token.STRING);
		 
		default:
			printError(lookaheadToken(), Token.INT, Token.FLOAT, Token.STRING);
		 	return null;
	 	}
	}
	
	public Tree parseDecl() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.READ:
		case Token.PRINT:
		case Token.ID:
			Tree modifier, id, type;
			
			if(((modifier = parseModifier()) != null) &&
					((id = parseToken(Token.ID)) != null) &&
					(parseToken(Token.COLON) != null) &&
					((type = parseType()) != null) &&
					(parseToken(Token.SEMICOLON) != null)) {
				Tree decl = new Tree(new Token(Token.DECL));
				decl.addLastChild(id);
				decl.addLastChild(type);
				decl.addLastChild(modifier);
				return decl;
			}
			
			return null;		 
		default:
			printError(lookaheadToken(), Token.READ, Token.PRINT, Token.ID);
		 	return null;
	 	}
	}
	
	public Tree parseExpr3a() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.INTCONST :
			return parseToken(Token.INTCONST);
		case Token.FLOATCONST:
			return parseToken(Token.FLOATCONST);
			
		default:
			printError(lookaheadToken(), Token.INTCONST, Token.FLOATCONST);
		 	return null;
	 	}	
	}
	
	public Tree parseExpr3() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.MINUS: {
			Tree minus, expr3a;
			Token uminus;
			
			if (((minus = parseToken(Token.MINUS)) != null) &&
					((expr3a = parseExpr3a()) != null)) {
				uminus = new Token(Token.UMINUS, "-", minus.getToken().getLine(), minus.getToken().getColumn());
				minus = new Tree(uminus);
				minus.addLastChild(expr3a);
				return minus;
			}
			return null;
		}
		case Token.INTCONST:
			return parseToken(Token.INTCONST);
		case Token.FLOATCONST:
			return parseToken(Token.FLOATCONST);
		case Token.STRINGCONST:
			return parseToken(Token.STRINGCONST);
		case Token.ID:
			return parseToken(Token.ID);
		case Token.LBR:
			return parseToken(Token.LBR);
			
		default:
			printError(lookaheadToken(), Token.MINUS, Token.INTCONST, Token.FLOATCONST,
					Token.STRINGCONST, Token.ID, Token.LBR);
		 	return null;
	 	}
	}
	
	public Tree parseExpr2a() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.MULT: {
			Tree mult, right;
			
			if(((mult = parseToken(Token.MULT)) != null) &&
					((right = parseExpr2()) != null)) {
				mult.addLastChild(right);
				return mult;
			}
		}
		case Token.DIV: {
			Tree div, right;
			
			if(((div = parseToken(Token.DIV)) != null) &&
					((right = parseExpr2()) != null)) {
				div.addLastChild(right);
				return div;
			}
		}
		case Token.PLUS:
		case Token.MINUS:
		case Token.SEMICOLON:
		case Token.LESS:
		case Token.MORE:
		case Token.EQUALS:
		case Token.RBR:
		case Token.THEN:
		case Token.ELSE:
			return new Tree(null);
		 
		default:
			printError(lookaheadToken(), Token.MULT, Token.DIV,Token.PLUS, Token.MINUS, Token.SEMICOLON,
					Token.LESS, Token.MORE, Token.EQUALS, Token.RBR, Token.THEN, Token.ELSE);
		 	return null;
	 	}
	}
	
	public Tree parseExpr2() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.MINUS:
		case Token.INTCONST:
		case Token.FLOATCONST:
		case Token.STRINGCONST:
		case Token.ID:
		case Token.LBR: {
			Tree expr3, expr2a;
			
			if (((expr3 = parseExpr3()) != null) &&
					(((expr2a = parseExpr2a())) != null)) {
				return addLeftAssoziativ(expr3, expr2a, MultDiv);
			}
			return null;
		}
		default:
			printError(lookaheadToken(), Token.MINUS, Token.INTCONST,
					Token.FLOATCONST, Token.STRINGCONST, Token.ID, Token.LBR);
		 	return null;
	 	}
	}
	
	public Tree parseExpr1a() throws IOException {
		switch(lookaheadToken().getType()) {
		 case Token.PLUS: {
			 Tree plus, right;
			 
			 if(((plus = parseToken(Token.PLUS)) != null) &&
					 ((right = parseExpr()) != null)) {
				 plus.addLastChild(right);
				 return plus;
			 }
			 return null;
		 }
		 case Token.MINUS: {
			 Tree minus, right;
			 
			 if(((minus = parseToken(Token.MINUS)) != null) &&
					 ((right = parseExpr()) != null)) {
				 minus.addLastChild(right);
				 return minus;
			 }
			 return null;
		 }
		 case Token.SEMICOLON:
		 case Token.LESS:
		 case Token.MORE:
		 case Token.EQUALS:
		 case Token.RBR:
		 case Token.THEN:
		 case Token.ELSE:
			 return new Tree(null);
		 default:
		 	printError(lookaheadToken(), Token.PLUS, Token.MINUS, Token.SEMICOLON, Token.LESS,
		 			Token.MORE, Token.EQUALS, Token.RBR, Token.THEN, Token.ELSE);
		 	return null;
	 	}
	}
	
	public Tree parseExpr() throws IOException {
		switch(lookaheadToken().getType()) {
		 case Token.MINUS:
		 case Token.INTCONST:
		 case Token.FLOATCONST:
		 case Token.STRINGCONST:
		 case Token.ID:
		 case Token.LBR:
			 Tree exprl, op;
			// expr ::= expr2 expr1a
			if (((exprl = parseExpr2()) != null) &&
					((op = parseExpr1a()) != null)) {
				return addLeftAssoziativ(exprl, op, PlusMinus);
			}
			return null;
			
		 default:
		 	printError(lookaheadToken(), Token.MINUS, Token.INTCONST, Token.FLOATCONST,
		 			Token.STRINGCONST, Token.ID, Token.LBR);
		 	return null;
	 	}
	}
	
	public Tree parseAssignStat() throws IOException {
		switch(lookaheadToken().getType()) {
		 case Token.ID:
				Tree id, assign, expr;

				// assignStat ::= id ":=" expr ";".
				if (((id = parseToken(Token.ID)) != null)
						&& ((assign = parseToken(Token.ASSIGN)) != null)
						&& ((expr = parseExpr()) != null)) {
					assign.addLastChild(id);
					assign.addLastChild(expr);
					return assign;
				}
				return null;
		 default:
		 	printError(lookaheadToken(), Token.ID);
		 	return null;
	 	}
	}
	
	public Tree parseForStat() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.FOR:
			Tree tfor, init, cond, cont, stat;

			// forstat ::= for "(" assignstat cond ";" assignstat ")" stat.
			if (((tfor = parseToken(Token.FOR)) != null) && ((parseToken(Token.LBR)) != null)
					&& ((init = parseAssignStat()) != null) && ((parseToken(Token.SEMICOLON)) != null)
					&& ((cond = parseCond()) != null) && ((parseToken(Token.SEMICOLON)) != null)
					&& ((cont = parseAssignStat()) != null) && ((parseToken(Token.RBR)) != null)
					&& ((stat = parseStat()) != null)) {
				tfor.addLastChild(init);
				tfor.addLastChild(cond);
				tfor.addLastChild(cont);
				tfor.addLastChild(stat);
				return tfor;
			}
			return null;
			
		default:
			printError(lookaheadToken(), Token.FOR);
			return null;
		}
	}

	public Tree parseWhileStat() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.WHILE:
			Tree twhile, cond, stat;
			if (((twhile = parseToken(Token.WHILE)) != null) && ((parseToken(Token.LBR)) != null)
					&& ((cond = parseCond()) != null) && ((parseToken(Token.RBR)) != null)
					&& ((stat = parseStat()) != null)) {
				twhile.addLastChild(cond);
				twhile.addLastChild(stat);
				return twhile;
			}
			return null;

		default:
			printError(lookaheadToken(), Token.WHILE);
			return null;
		}
	}

	public Tree parseCondStat2() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.ELSE:
			Tree elsestat;
			if (((parseToken(Token.ELSE)) != null) && ((elsestat = parseStat()) != null)) {
				return elsestat;
			}
			return null;
		case Token.SEMICOLON:
			return new Tree(null);
		default:
			printError(lookaheadToken(), Token.ELSE, Token.SEMICOLON);
			return null;
		}
	}

	public Tree parseCondStat() throws IOException {
		Tree tif, cond, thenstat, elsestat;
		switch (lookaheadToken().getType()) {
		case Token.IF:
			if (((tif = parseToken(Token.IF)) != null) && ((cond = parseCond()) != null)
					&& (parseToken(Token.THEN) != null) && ((thenstat = parseStat()) != null)
					&& ((elsestat = parseCondStat2()) != null)) {
				tif.addLastChild(cond);
				tif.addLastChild(thenstat);
				tif.addLastChild(elsestat);
				return tif;
			}
			return null;
		default:
			printError(lookaheadToken(), Token.IF);
			return null;
		}
	}

	public Tree parseCond2() throws IOException {
		Tree comp, right;
		switch (lookaheadToken().getType()) {
		case Token.LESS:
			if (((comp = parseToken(Token.LESS)) != null) && ((right = parseExpr()) != null)) {
				comp.addLastChild(right);
				return comp;
			}
			return null;
		case Token.MORE:
			if (((comp = parseToken(Token.MORE)) != null) && ((right = parseExpr()) != null)) {
				comp.addLastChild(right);
				return comp;
			}
			return null;
		case Token.EQUALS:
			if (((comp = parseToken(Token.EQUALS)) != null) && ((right = parseExpr()) != null)) {
				comp.addLastChild(right);
				return comp;
			}
			return null;
		default:
			printError(lookaheadToken(), Token.LESS, Token.MORE, Token.EQUALS);
			return null;
		}
	}

	public Tree parseCond() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.MINUS:
		case Token.INTCONST:
		case Token.FLOATCONST:
		case Token.STRINGCONST:
		case Token.ID:
		case Token.LBR:
			Tree left, comp;
			
			// cond ::= expr "<" expr.
			if (((left = parseExpr()) != null)
					&& ((comp = parseCond2()) != null)){
				comp.addFirstChild(left);
				return comp;
			}
		default:
			printError(lookaheadToken(), Token.MINUS, Token.INTCONST, Token.FLOATCONST,
					Token.STRINGCONST, Token.ID, Token.LBR);
			return null;
		}
	}

	public Tree parseStat() throws IOException {
		Tree stat;
		switch (lookaheadToken().getType()) {
		case Token.ID:
			// stat ::= assignstat.
			if (((stat = parseAssignStat()) != null)) {
				return stat;
			}
			return null;
		case Token.IF:
			// stat ::= condstat.
			if (((stat = parseCondStat()) != null)) {
				return stat;
			}
			return null;
		case Token.WHILE:
			// stat ::= whilestat.
			if (((stat = parseWhileStat()) != null)) {
				return stat;
			}
			return null;
		case Token.FOR:
			// stat ::= forstat.
			if (((stat = parseForStat()) != null)) {
				return stat;
			}
			return null;
		case Token.BEGIN:
			// stat ::= block.
			if (((stat = parseBlock()) != null)) {
				return stat;
			}
			return null;
		default:
			printError(lookaheadToken(), Token.ID, Token.IF, Token.WHILE, Token.FOR, Token.BEGIN);
			return null;
		}
	}

	public Tree parseBlock() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.BEGIN:
			Tree statlist;

			// block ::= begin statlist end.
			if ((parseToken(Token.BEGIN) != null) && ((statlist = parseStatlist()) != null)
					&& (parseToken(Token.END) != null)) {
				return statlist;
			}
		default:
			printError(lookaheadToken(), Token.BEGIN);
			return null;
		}
	}

	public Tree parseStatlist() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.ID:
		case Token.IF:
		case Token.WHILE:
		case Token.FOR:
		case Token.BEGIN:
			Tree stat;

			Tree tree = new Tree(new Token(Token.STATLIST));
			// statlist ::= { statwithsemi }.
			while (((stat = parseStatwithsemi())) != null) {
				tree.addLastChild(stat);
			}
			return tree;
		case Token.END:
			return new Tree(new Token(Token.STATLIST));
		default:
			printError(lookaheadToken(), Token.ID, Token.IF, Token.WHILE, Token.FOR, Token.BEGIN, Token.END);
			return null;
		}
	}

	public Tree parseStatwithsemi() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.ID:
		case Token.IF:
		case Token.WHILE:
		case Token.FOR:
		case Token.BEGIN:
			Tree stat;

			// statwithsemi ::= stat ";"
			if ((((stat = parseStat())) != null) && (parseToken(Token.SEMICOLON) != null)) {
				return stat;
			} else {
				return null;
			}

		default:
			printError(lookaheadToken(), Token.ID, Token.IF, Token.WHILE, Token.FOR, Token.BEGIN);
			return null;
		}
	}

	public Tree parseDecllist() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.READ:
		case Token.PRINT:
		case Token.ID:
			Tree decl;

			Tree tree = new Tree(new Token(Token.DECLLIST));
			// decllist ::= { decl }.
			while (((decl = parseDecl())) != null) {
				tree.addLastChild(decl);
			}
			return tree;
		case Token.BEGIN:
			return new Tree(new Token(Token.DECLLIST));
		default:
			printError(lookaheadToken(), Token.READ, Token.PRINT, Token.ID, Token.BEGIN);
			return null;
		}
	}

	public Tree parseProgram() throws IOException {
		switch (lookaheadToken().getType()) {
		case Token.PROGRAM:
			Tree program, id, decllist, statlist;

			if (((program = parseToken(Token.PROGRAM)) != null) && ((id = parseToken(Token.ID)) != null)
					&& (parseToken(Token.SEMICOLON) != null) && ((decllist = parseDecllist()) != null)
					&& ((statlist = parseBlock()) != null) && (parseToken(Token.DOT) != null)
					&& (parseToken(Token.EOF) != null)) {
				program.addFirstChild(statlist);
				program.addFirstChild(decllist);
				program.addFirstChild(id);
				return program;
			} else {
				return null;
			}
		default:
			printError(lookaheadToken(), Token.PROGRAM);
			return null;
		}
	}

	public Tree parseToken(int tokenType) throws IOException {
		comparecount++;
		if (lookaheadToken().getType() == tokenType) {
			return new Tree(in.nextToken());
		} else {
			printError(lookaheadToken(), tokenType);
			return null;
		}
	}

	private Token lookaheadToken() {
		return this.in.lookaheadToken();
	}

	private void printError(Token actual, int... expected) {
		StringBuilder errorMessage = new StringBuilder();

		errorMessage.append("Found: ").append(actual.toString()).append("\nExpected one of {");

		for (int i = 0; i < expected.length; i++) {
			errorMessage.append(" ").append(Token.getTypeName(expected[i]));
			if (i < expected.length - 1) {
				errorMessage.append(",");
			}
		}

		errorMessage.append(" }");

		System.err.println(errorMessage);
	}
}