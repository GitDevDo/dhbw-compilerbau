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
	private TokenReader tokenReader;
	private int myPosition;

	public XParser(TokenReader in) {
		//TODO Initialization
		this.tokenReader = in;
		this.myPosition = in.getPosition();
	}

	public Tree parseProgram() {
		//TODO Parser
		return null;
	}
	
	private Tree parseBlock() {
		myPosition = getTokenStreamPosition();
		
		Tree begin = parseBegin();
		Tree statement = parseFinishedStatement();
		Tree end = parseEnd();
		if (begin != null && statement != null && end != null) {
			Tree tree = new Tree(new Token(Token.BLOCK));
			tree.addFirstChild(end);
			tree.addFirstChild(statement);
			tree.addFirstChild(begin);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}
	
	private Tree parseEnd() {
		return parseToken(Token.END);
	}

	private Tree parseFinishedStatement() {
		myPosition = getTokenStreamPosition();
		
		Tree statement = parseStatement();
		Tree semicolon = parseSemicolon();
		Tree recursiveStatement = parseFinishedStatement();
		
		if (statement != null && semicolon != null) {
			//TODO evtl abhängig vom recursive child entweder einen STATTLIST Knoten oder einen STATWITHSEMI Knoten erzeugen.
			Tree tree = new Tree(new Token(Token.STATLIST));
			tree.addFirstChild(semicolon);
			tree.addFirstChild(statement);
			
			if (recursiveStatement != null) {
				tree.addLastChild(recursiveStatement);
			}
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseSemicolon() {
		return parseToken(Token.SEMICOLON);
	}

	private Tree parseStatement() {
		myPosition = getTokenStreamPosition();
		
		Tree statement = parseNumberAssignment();
		if (statement != null) {
			Tree tree = createStatementTree(statement);
			return tree;
		}
		
		statement = parseConditionalStatement();
		if (statement != null) {
			Tree tree = createStatementTree(statement);
			return tree;
		}
		
		statement = parseBlock();
		if (statement != null) {
			Tree tree = createStatementTree(statement);
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}
	
	private Tree parseConditionalStatement() {
		myPosition = getTokenStreamPosition();
		
		Tree ifTree = parseIf();
		Tree condition = parseCondition();
		Tree then = parseThen();
		Tree ifStatement = parseStatement();
		Tree elseTree = parseElse();
		Tree elseStatement = parseStatement();
		
		if (ifTree != null && condition != null && then != null && ifStatement != null) {
			Tree tree = new Tree(new Token(Token.CONDSTAT));
			tree.addFirstChild(ifStatement);
			tree.addFirstChild(then);
			tree.addFirstChild(condition);
			tree.addFirstChild(ifTree);
			
			if (elseTree != null && elseStatement != null) {
				tree.addLastChild(elseTree);
				tree.addLastChild(elseStatement);
			}
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseElse() {
		return parseToken(Token.ELSE);
	}

	private Tree parseThen() {
		return parseToken(Token.THEN);
	}

	private Tree parseCondition() {
		myPosition = getTokenStreamPosition();
		
		Tree expression1 = parseExpression();
		Tree operator = parseOperator();
		Tree expression2 = parseExpression();
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseIf() {
		return parseToken(Token.IF);
	}

	private Tree parseNumberAssignment() {
		// TODO Auto-generated method stub
		return null;
	}

	private Tree createStatementTree(Tree child) {
		Tree tree = new Tree(new Token(Token.STAT));
		tree.addFirstChild(child);
		
		return tree;
	}

	private Tree parseBegin() {
		return parseToken(Token.BEGIN);
	}

	private Tree parseInteger() {
		return parseToken(Token.INTCONST);
	}
	
	private Tree parseToken(int tokenType) {
		myPosition = getTokenStreamPosition();
		
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
		this.setTokenStreamPosition(position);
	}
}
