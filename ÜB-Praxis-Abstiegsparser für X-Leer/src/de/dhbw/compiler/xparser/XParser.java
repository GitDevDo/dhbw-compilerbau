/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis X Abstiegsparser
 * - Abstiegsparser
 * 
 * **********************************************
 */

package de.dhbw.compiler.xparser;

public class XParser {
	private int counter = 0;
	private TokenReader tokenReader;

	public XParser(TokenReader in) {
		//TODO Initialization
		this.tokenReader = in;
	}

	// <program> ::= program id ';' block '.' <eof>.
	public Tree parseProgram() {
		Tree program = parseToken(Token.PROGRAM);
		Tree identifier = parseIdentifier();
		Tree semicolon = parseSemicolon();
		Tree block = parseBlock();
		Tree dot = parseToken(Token.DOT);
		Tree eof = parseToken(Token.EOF);
		
		if(program != null
				&& identifier != null
				&& semicolon != null
				&& block != null
				&& dot != null
				&& eof != null) {
			Tree tree = new Tree(new Token(Token.APROGRAM));
			tree.addFirstChild(eof);
			tree.addFirstChild(dot);
			tree.addFirstChild(block);
			tree.addFirstChild(semicolon);
			tree.addFirstChild(identifier);
			tree.addFirstChild(program);
			System.out.println(counter);
			
			return tree;
		}
		
		return null;
	}
	
	// <block> ::= begin <statlist> end.
	private Tree parseBlock() {
		int myPosition = getTokenStreamPosition();
		
		Tree begin;
		Tree statlist;
		Tree end;
		if ((begin = parseBegin()) != null
				&& (statlist = parseStatlist()) != null
				&& (end = parseEnd()) != null) {
			Tree tree = new Tree(new Token(Token.BLOCK));
			tree.addFirstChild(end);
			tree.addFirstChild(statlist);
			tree.addFirstChild(begin);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <statlist> ::= {<statWithSemi>}.
	private Tree parseStatlist() {
		int myPosition = getTokenStreamPosition();
		
		Tree statlist = new Tree(new Token(Token.STATLIST));
		Tree statWithSemi;
		
		while((statWithSemi = parseStatWithSemi()) != null) {
			statlist.addLastChild(statWithSemi);
		}
		
		if (statlist.getChildCount() == 0) {
			setTokenStreamPosition(myPosition);
		}
		
		return statlist;
	}

	private Tree parseStatWithSemi() {
		int myPosition = getTokenStreamPosition();
		
		Tree statement;
		Tree semicolon;
		if ((statement = parseStatement()) != null
				&& (semicolon = parseSemicolon()) != null) {
			Tree tree = new Tree(new Token(Token.STATWITHSEMI));
			tree.addFirstChild(semicolon);
			tree.addFirstChild(statement);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <stat> ::= <numAssign> | <condStat> | <block>.
	private Tree parseStatement() {
		int myPosition = getTokenStreamPosition();
		
		Tree statement = parseNumberAssignment();
		if (statement != null) {
			Tree tree = new Tree(new Token(Token.STAT));
			tree.addFirstChild(statement);			
			return tree;
		}
		
		statement = parseConditionalStatement();
		if (statement != null) {
			Tree tree = new Tree(new Token(Token.STAT));
			tree.addFirstChild(statement);			
			return tree;
		}
		
		statement = parseBlock();
		if (statement != null) {
			Tree tree = new Tree(new Token(Token.STAT));
			tree.addFirstChild(statement);			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}
	
	// <condStat> ::= if <cond> then <stat> else <stat>
	//				| if <cond> then <stat>.
	private Tree parseConditionalStatement() {
		int myPosition = getTokenStreamPosition();
		
		Tree ifTree;
		Tree condition;
		Tree then;
		Tree ifStatement;
		Tree elseTree;
		Tree elseStatement;
		
		if ((ifTree = parseIf()) != null
				&& (condition = parseCondition()) != null
				&& (then = parseThen()) != null
				&& (ifStatement = parseStatement()) != null
				&& (elseTree = parseElse()) != null
				&& (elseStatement = parseStatement()) != null) {
			Tree tree = new Tree(new Token(Token.CONDSTAT));
			tree.addFirstChild(elseStatement);
			tree.addFirstChild(elseTree);
			tree.addFirstChild(ifStatement);
			tree.addFirstChild(then);
			tree.addFirstChild(condition);
			tree.addFirstChild(ifTree);
			
			return tree;
		}
		setTokenStreamPosition(myPosition);
		
		if ((ifTree = parseIf()) != null
				&& (condition = parseCondition()) != null
				&& (then = parseThen()) != null
				&& (ifStatement = parseStatement()) != null) {
			Tree tree = new Tree(new Token(Token.CONDSTAT));
			tree.addFirstChild(ifStatement);
			tree.addFirstChild(then);
			tree.addFirstChild(condition);
			tree.addFirstChild(ifTree);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <cond> ::= <numExpr> <logic_operator> <numExpr>.
	private Tree parseCondition() {
		int myPosition = getTokenStreamPosition();
		
		Tree expression1 = parseNumberExpression();
		Tree operator = parseLogicOperator();
		Tree expression2 = parseNumberExpression();
		
		if (expression1 != null && operator != null && expression2 != null) {
			Tree tree = new Tree(new Token(Token.COND));
			tree.addFirstChild(expression2);
			tree.addFirstChild(operator);
			tree.addFirstChild(expression1);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <logic_operator> ::= '>' | '=' | '<'.
	private Tree parseLogicOperator() {
		int myPosition = getTokenStreamPosition();
		
		Tree operator = parseLessOperator();
		if (operator != null) {
			return operator;
		}
		
		operator = parseEqualsOperator();
		if (operator!= null) {
			return operator;
		}
		
		operator = parseGreaterOperator();
		if(operator != null) {
			return operator;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <numExpr3> ::= '-' <intConst> | <intConst> | <id> | '(' <numExpr> ')'.
	private Tree parseNumberExpression3() {
		int myPosition = getTokenStreamPosition();
		
		Tree unaryMinus;
		Tree expression;
		if( (unaryMinus = parseMinus()) != null
				&& (expression = parseInteger()) != null) {
			Tree tree = new Tree(new Token(Token.EXPR3));
			tree.addFirstChild(expression);
			tree.addFirstChild(unaryMinus);
			
			return tree;
		}
		setTokenStreamPosition(myPosition);
		
		expression = parseInteger();
		if( expression != null) {
			Tree tree = new Tree(new Token(Token.EXPR3));
			tree.addFirstChild(expression);
			
			return tree;
		}
		
		expression = parseIdentifier();
		if(expression != null) {
			Tree tree = new Tree(new Token(Token.EXPR3));
			tree.addFirstChild(expression);
			return tree;
		}
		
		Tree leftParenthesis;
		Tree rightParenthesis;
		
		if((leftParenthesis = parseLBR()) != null
				&& (expression = parseNumberExpression()) != null
				&& (rightParenthesis = parseRBR()) != null) {
			Tree tree = new Tree(new Token(Token.EXPR3));
			tree.addFirstChild(rightParenthesis);
			tree.addFirstChild(expression);
			tree.addFirstChild(leftParenthesis);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <numExpr2> ::= <numExpr3> <multDivOp> <numExpr2> | <numExpre3> <multDivOp> <numExpr2> | <numExpr3>
	private Tree parseNumberExpression2() {
		int myPosition = getTokenStreamPosition();
		
		Tree numExpr3;
		Tree operator;
		Tree numExpr2;
		
		if ((numExpr3 = parseNumberExpression3()) != null
				&& (operator = parseMultOrDivOp()) != null
				&& (numExpr2 = parseNumberExpression2()) != null) {
			Tree tree = new Tree(new Token(Token.EXPR2));
			tree.addFirstChild(numExpr2);
			tree.addFirstChild(operator);
			tree.addFirstChild(numExpr3);
			
			return tree;
		}
		setTokenStreamPosition(myPosition);
		
		numExpr3 = parseNumberExpression3();
		if (numExpr3 != null) {
			Tree tree = new Tree(new Token(Token.EXPR2));
			tree.addFirstChild(numExpr3);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}
	
	// <numExpr> ::= <numExpr2> <addOrSubOp> <numExpr> | <numExpr2>
	private Tree parseNumberExpression() {
		int myPosition = getTokenStreamPosition();
		
		Tree numExpr2;
		Tree operator;
		Tree numExpr;
		
		if ((numExpr2 = parseNumberExpression2()) != null
				&& (operator = parseAddOrSubOp()) != null
				&& (numExpr = parseNumberExpression()) != null) {
			Tree tree = new Tree(new Token(Token.EXPR));
			tree.addFirstChild(numExpr);
			tree.addFirstChild(operator);
			tree.addFirstChild(numExpr2);
			
			return tree;
		}
		setTokenStreamPosition(myPosition);
		
		numExpr2 = parseNumberExpression2();
		if (numExpr2 != null) {
			Tree tree = new Tree(new Token(Token.EXPR));
			tree.addFirstChild(numExpr2);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseAddOrSubOp() {
		int myPosition = getTokenStreamPosition();
		
		Tree operator = parsePlus();
		if (operator != null) {
			return operator;
		}
		
		operator = parseMinus();
		if (operator != null) {
			return operator;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <multDivOp> ::= '*' | '/'.
	private Tree parseMultOrDivOp() {
		int myPosition = getTokenStreamPosition();
		
		Tree operator = parseMult();
		if (operator != null) {
			return operator;
		}
		
		operator = parseDiv();
		if (operator != null) {
			return operator;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <numAssign> ::= <id> ':=' <numExpr>.
	private Tree parseNumberAssignment() {
		int myPosition = getTokenStreamPosition();
		
		Tree identifier = parseIdentifier();
		Tree assignment = parseAssignOperator();
		Tree expression = parseNumberExpression();
		
		if(identifier != null && assignment != null && expression != null) {
			Tree tree = new Tree(new Token(Token.ASSIGNSTAT));
			tree.addFirstChild(expression);
			tree.addFirstChild(assignment);
			tree.addFirstChild(identifier);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <intConst>
	private Tree parseInteger() {
		return parseToken(Token.INTCONST);
	}
	
	// <id>
	private Tree parseIdentifier() {
		return parseToken(Token.ID);
	}

	// begin
	private Tree parseBegin() {
		return parseToken(Token.BEGIN);
	}
	
	// end
	private Tree parseEnd() {
		return parseToken(Token.END);
	}

	// ;
	private Tree parseSemicolon() {
		return parseToken(Token.SEMICOLON);
	}

	// if
	private Tree parseIf() {
		return parseToken(Token.IF);
	}

	// then
	private Tree parseThen() {
		return parseToken(Token.THEN);
	}
	
	// else
	private Tree parseElse() {
		return parseToken(Token.ELSE);
	}

	// :=
	private Tree parseAssignOperator() {
		return parseToken(Token.ASSIGN);
	}

	// )
	private Tree parseRBR() {
		return parseToken(Token.RBR);
	}

	// (
	private Tree parseLBR() {
		return parseToken(Token.LBR);
	}
	
	// +
	private Tree parsePlus() {
		return parseToken(Token.PLUS);
	}

	// -
	private Tree parseMinus() {
		return parseToken(Token.MINUS);
	}

	// /
	private Tree parseDiv() {
		return parseToken(Token.DIV);
	}

	// *
	private Tree parseMult() {
		return parseToken(Token.MULT);
	}
	
	// <
	private Tree parseGreaterOperator() {
		return parseToken(Token.LESS);
	}

	// =
	private Tree parseEqualsOperator() {
		return parseToken(Token.EQUALS);
	}

	// >
	private Tree parseLessOperator() {
		return parseToken(Token.MORE);
	}

	private Tree parseToken(int tokenType) {
		int myPosition = getTokenStreamPosition();
		counter++;
		Token token;
		if ((token = nextToken()).getType() == tokenType) {
			return new Tree(token);
		}
		
		setTokenStreamPosition(myPosition);		
		return null;
	}
	
	private Token nextToken() {
		return this.tokenReader.nextToken();
	}
	
	private int getTokenStreamPosition() {
		return this.tokenReader.getPosition();
	}
	
	private void setTokenStreamPosition(int position) {
		this.tokenReader.setPosition(position);
	}
}
