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

public class XParser {
	private TokenBuffer in = null;
	private long comparecount = 0;

	public XParser(TokenBuffer in) {
		this.in = in;
	}

	public long getCompareCount() {
		return this.comparecount;
	}
	
	public Tree parseCondStat2() throws IOException {
		switch(lookaheadToken().getType()) {
		case Token.ELSE:
			Tree elsestat;
			if(((parseToken(Token.ELSE)) != null) &&
					((elsestat = parseStat()) != null)) {
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
		switch(lookaheadToken().getType()) {
		case Token.IF:
			if (((tif = parseToken(Token.IF)) != null)
					&& ((cond = parseCond()) != null)
					&& (parseToken(Token.THEN) != null)
					&& ((thenstat = parseStat()) != null)
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

	public Tree parseCond2() {
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
		}
	}

	public Tree parseCond() {
		switch(lookaheadToken().getType()) {
		case Token.MINUS:
		case Token.INTCONST:
		case Token.FLOATCONST:
		case Token.STRINGCONST:
		case Token.ID:
		case Token.LBR:
			Tree left, comp
			
			// cond ::= expr "<" expr.
			if (((left = parseExpr()) != null)
					&& ((comp = parseCond2()) != null)){
				comp.addFirstChild(left);
				return comp;
			}
		}
	}

	public Tree parseStat() {
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

	public Tree parseBlock()throws IOException {
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

	public Tree parseStatlist() {
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

	public Tree parseStatwithsemi() {
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

		// fail
		return null;
	}

	public Tree parseDecllist() {
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