// $ANTLR 3.5.2 C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g 2016-05-09 13:42:27
package de.dhbw.compiler.antlrxparser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class XParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECL", "DECLLIST", "INVALID", 
		"STATLIST", "UMINUS", "'TODO'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int DECL=4;
	public static final int DECLLIST=5;
	public static final int INVALID=6;
	public static final int STATLIST=7;
	public static final int UMINUS=8;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public XParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public XParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return XParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:33:1: program : 'TODO' ;
	public final XParser.program_return program() throws RecognitionException {
		XParser.program_return retval = new XParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal1=null;

		Object string_literal1_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:33:8: ( 'TODO' )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:33:10: 'TODO'
			{
			root_0 = (Object)adaptor.nil();


			string_literal1=(Token)match(input,9,FOLLOW_9_in_program89); 
			string_literal1_tree = (Object)adaptor.create(string_literal1);
			adaptor.addChild(root_0, string_literal1_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"

	// Delegated rules



	public static final BitSet FOLLOW_9_in_program89 = new BitSet(new long[]{0x0000000000000002L});
}
