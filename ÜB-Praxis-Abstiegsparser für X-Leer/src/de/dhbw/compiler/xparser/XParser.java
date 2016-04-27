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
			tree.addFirstChild(dot);
			tree.addFirstChild(block);
			tree.addFirstChild(semicolon);
			tree.addFirstChild(identifier);
			tree.addFirstChild(identifier);
			tree.addFirstChild(program);
			
			return tree;
		}
		
		return null;
	}
	
	// <block> ::= begin <finished_statements> end.
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

	// <finished_statement> ::= <stat> ';' <finished_statement> | .
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

	// <stat> ::= <numAssign> | <condStat> | <block>.
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
	
	// <condStat> ::= if <cond> then <stat>
	//				| if <cond> then <stat> else <stat>.
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

	// <cond> ::= <numExpr> <logic_operator> <numExpr>.
	private Tree parseCondition() {
		myPosition = getTokenStreamPosition();
		
		Tree expression1 = parseNumberExpression();
		Tree operator = parseLogicOperator();
		Tree expression2 = parseNumberExpression();
		
		if (expression1 != null && operator != null && expression2 != null) {
			Tree tree = new Tree(new Token(Token.EXPR));
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

	// <numExpr> ::= <intConst> | <id> | <arithm_expression> | <parenth_expression>.
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
		
		// Endlosschleife, da der erste Aufruf in parseArithmeticExpression() wieder parseNumberExpression() ist..
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


	// <arithm_expression> ::= <numExpr> <arithm_operator> <numExpr>.
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
	
	// <parenth_expression> ::= '(' <numExpr> ')'.
	private Tree parseExpressionParenthesis() {
		myPosition = getTokenStreamPosition();
		
		Tree leftP = parseToken(Token.LBR);
		Tree expression = parseNumberExpression();
		Tree rightP = parseToken(Token.RBR);
		
		if(leftP != null && expression != null && rightP != null) {
			Tree tree = new Tree(new Token(Token.EXPR));			
			tree.addFirstChild(rightP);
			tree.addFirstChild(expression);
			tree.addFirstChild(leftP);
			
			return tree;
		}
		
		setTokenStreamPosition(myPosition);
		return null;
	}

	// <arithm_operator> ::= '+' | '-' | '*' | '/'.
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

	// <numAssign> ::= <id> ':=' <numExpr>.
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

	// <intConst> ::= <number> | '-' <number>.
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
	
	// <number>
	private Tree parseNumber() {
		return parseToken(Token.INTCONST);
	}
	
	// <id>
	private Tree parseIdentifier() {
		return parseToken(Token.ID);
	}

	// -
	private Tree parseUnaryMinus() {
		myPosition = getTokenStreamPosition();
		
		Tree minus = parseToken(Token.MINUS);
		if(minus != null) {
			return new Tree(new Token(Token.UMINUS));
		}
		
		setTokenStreamPosition(myPosition);
		return null;
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
		this.tokenReader.setPosition(position);
	}
	
	private Tree createStatementTree(Tree child) {
		Tree tree = new Tree(new Token(Token.STAT));
		tree.addFirstChild(child);
		
		return tree;
	}
}
