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
		
		Tree expression1 = parseNumberExpression();
		Tree operator = parseLogicOperator();
		Tree expression2 = parseNumberExpression();
		
		if (expression1 != null && operator != null && expression2 != null) {
			Tree tree = new Tree(new Token(Token.EXPR3));
			tree.addFirstChild(expression2);
			tree.addFirstChild(operator);
			tree.addFirstChild(expression1);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseLogicOperator() {
		myPosition = getTokenStreamPosition();
		
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

	private Tree parseGreaterOperator() {
		return parseToken(Token.LESS);
	}

	private Tree parseEqualsOperator() {
		return parseToken(Token.EQUALS);
	}

	private Tree parseLessOperator() {
		return parseToken(Token.MORE);
	}

	private Tree parseNumberExpression() {
		myPosition = getTokenStreamPosition();
		
		Tree expression = parseInteger();
		if(expression != null) {
			return expression;
		}
		
		expression = parseIdentifier();
		if(expression != null) {
			return expression;
		}
		
		expression = parseArithmeticExpression();
		if(expression != null) {
			return expression;
		}
		
		expression = parseExpressionParenthesis();
		if(expression != null) {
			return expression;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseExpressionParenthesis() {
		myPosition = getTokenStreamPosition();
		
		Tree leftP = parseToken(Token.LBR);
		Tree expression = parseNumberExpression();
		Tree rightP = parseToken(Token.RBR);
		
		if(leftP != null && expression != null && rightP != null) {
			Tree tree = new Tree(new Token(Token.EXPR2));			
			tree.addFirstChild(rightP);
			tree.addFirstChild(expression);
			tree.addFirstChild(leftP);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseArithmeticExpression() {
		myPosition = getTokenStreamPosition();
		
		Tree expression1 = parseNumberExpression();
		Tree operator = parseArithmeticOperator();
		Tree expression2 = parseNumberExpression();
		
		if( expression1 != null && operator != null && expression2 != null) {
			Tree tree = new Tree(new Token(Token.EXPR));
			tree.addFirstChild(expression2);
			tree.addFirstChild(operator);
			tree.addFirstChild(expression1);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseArithmeticOperator() {
		myPosition = getTokenStreamPosition();
		
		Tree operator = parseToken(Token.PLUS);
		if(operator != null) {
			return operator;
		}
		
		operator = parseToken(Token.MINUS);
		if(operator != null) {
			return operator;
		}
		
		operator = parseToken(Token.MULT);
		if(operator != null) {
			return operator;
		}
		
		operator = parseToken(Token.DIV);
		if(operator != null) {
			return operator;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	private Tree parseIdentifier() {
		return parseToken(Token.ID);
	}

	private Tree parseIf() {
		return parseToken(Token.IF);
	}

	private Tree parseNumberAssignment() {
		myPosition = getTokenStreamPosition();
		
		Tree identifier = parseIdentifier();
		Tree assignment = parseToken(Token.ASSIGN);
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

	private Tree createStatementTree(Tree child) {
		Tree tree = new Tree(new Token(Token.STAT));
		tree.addFirstChild(child);
		
		return tree;
	}

	private Tree parseBegin() {
		return parseToken(Token.BEGIN);
	}

	private Tree parseInteger() {
		myPosition = getTokenStreamPosition();
		
		Tree unaryMinus = parseUnaryMinus();
		Tree number = parseNumber();
		
		if(number != null) {
			Tree tree = new Tree(new Token(Token.INTCONST));
			tree.addFirstChild(number);
			
			if (unaryMinus != null) {
				tree.addFirstChild(unaryMinus);
			}
			
			return tree;
		}
		
		
		setTokenStreamPosition(myPosition);
		return null;
	}
	
	private Tree parseNumber() {
		return parseToken(Token.INTCONST);
	}

	private Tree parseUnaryMinus() {
		myPosition = getTokenStreamPosition();
		
		Tree minus = parseToken(Token.MINUS);
		if(minus != null) {
			return new Tree(new Token(Token.UMINUS));
		}
		
		setTokenStreamPosition(myPosition);
		return null;
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
