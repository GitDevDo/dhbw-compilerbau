// $ANTLR 3.5.2 D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr Baumgrammatiken - Leer\\src\\de\\dhbw\\compiler\\antlrxtreegrammar\\XTreeGrammar.g 2016-06-02 10:50:04
package de.dhbw.compiler.antlrxtreegrammar;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings("all")
public class XTreeGrammar extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "DECL", "DECLLIST", 
		"DIGIT", "FLOATCONST", "ID", "INTCONST", "INVALID", "LETTER", "OTHER", 
		"POSDIGIT", "STATLIST", "STRINGCONST", "UMINUS", "WS", "ZERO", "'('", 
		"')'", "'*'", "'+'", "'-'", "'.'", "'/'", "':'", "':='", "';'", "'<'", 
		"'='", "'>'", "'begin'", "'else'", "'end'", "'float'", "'for'", "'if'", 
		"'int'", "'print'", "'program'", "'read'", "'string'", "'then'", "'while'", 
		"'todo'"
	};
	public static final int EOF=-1;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int COMMENT=4;
	public static final int DECL=5;
	public static final int DECLLIST=6;
	public static final int DIGIT=7;
	public static final int FLOATCONST=8;
	public static final int ID=9;
	public static final int INTCONST=10;
	public static final int INVALID=11;
	public static final int LETTER=12;
	public static final int OTHER=13;
	public static final int POSDIGIT=14;
	public static final int STATLIST=15;
	public static final int STRINGCONST=16;
	public static final int UMINUS=17;
	public static final int WS=18;
	public static final int ZERO=19;
	public static final int T__46=46;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public XTreeGrammar(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public XTreeGrammar(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return XTreeGrammar.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr Baumgrammatiken - Leer\\src\\de\\dhbw\\compiler\\antlrxtreegrammar\\XTreeGrammar.g"; }


	public static class program_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "program"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr Baumgrammatiken - Leer\\src\\de\\dhbw\\compiler\\antlrxtreegrammar\\XTreeGrammar.g:24:1: program : 'todo' ;
	public final XTreeGrammar.program_return program() throws RecognitionException {
		XTreeGrammar.program_return retval = new XTreeGrammar.program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree string_literal1=null;

		CommonTree string_literal1_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr Baumgrammatiken - Leer\\src\\de\\dhbw\\compiler\\antlrxtreegrammar\\XTreeGrammar.g:24:8: ( 'todo' )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr Baumgrammatiken - Leer\\src\\de\\dhbw\\compiler\\antlrxtreegrammar\\XTreeGrammar.g:24:15: 'todo'
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			string_literal1=(CommonTree)match(input,46,FOLLOW_46_in_program67); 
			string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);


			adaptor.addChild(root_0, string_literal1_tree);

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"

	// Delegated rules



	public static final BitSet FOLLOW_46_in_program67 = new BitSet(new long[]{0x0000000000000002L});
}
