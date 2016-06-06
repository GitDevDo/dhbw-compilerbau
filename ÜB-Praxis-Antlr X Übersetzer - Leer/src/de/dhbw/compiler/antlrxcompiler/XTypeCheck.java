// $ANTLR 3.5.2 D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g 2016-06-06 12:00:35

package de.dhbw.compiler.antlrxcompiler;
   
import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings("all")
public class XTypeCheck extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "DECL", "DECLLIST", 
		"DIGIT", "FLOATCONST", "ID", "INTCONST", "INVALID", "LETTER", "OTHER", 
		"POSDIGIT", "STATLIST", "STRINGCONST", "UMINUS", "WS", "ZERO", "'('", 
		"')'", "'*'", "'+'", "'-'", "'.'", "'/'", "':'", "':='", "';'", "'<'", 
		"'='", "'>'", "'begin'", "'else'", "'end'", "'float'", "'for'", "'if'", 
		"'int'", "'print'", "'program'", "'read'", "'string'", "'then'", "'while'"
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
	public static final int FLOAT=36;
	public static final int INT=39;
	public static final int PLUS=23;
	public static final int STRING=43;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public XTypeCheck(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public XTypeCheck(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return XTypeCheck.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g"; }



	   private SymbolTable  symbols = SymbolTable.getInstance();  
	   
	   private XType getXType(String varType) {
	    switch(varType) {
	      case "int": return XType.IntType;
	      case "float": return XType.FloatType;
	      case "string": return XType.StringType;
	      default: return XType.InvalidType;
	    }
	   }


	public static class decl_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "decl"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:1: decl : ( ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) ) | ^( DECL ID ( 'int' | 'float' | 'string' ) 'read' ) | ^( DECL ID ( 'int' | 'float' | 'string' ) 'print' ) | ^( DECL ID ( 'int' | 'float' | 'string' ) 'read' 'print' ) );
	public final XTypeCheck.decl_return decl() throws RecognitionException {
		XTypeCheck.decl_return retval = new XTypeCheck.decl_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree type=null;
		XTree DECL1=null;
		XTree ID2=null;
		XTree DECL3=null;
		XTree ID4=null;
		XTree set5=null;
		XTree string_literal6=null;
		XTree DECL7=null;
		XTree ID8=null;
		XTree set9=null;
		XTree string_literal10=null;
		XTree DECL11=null;
		XTree ID12=null;
		XTree set13=null;
		XTree string_literal14=null;
		XTree string_literal15=null;

		XTree type_tree=null;
		XTree DECL1_tree=null;
		XTree ID2_tree=null;
		XTree DECL3_tree=null;
		XTree ID4_tree=null;
		XTree set5_tree=null;
		XTree string_literal6_tree=null;
		XTree DECL7_tree=null;
		XTree ID8_tree=null;
		XTree set9_tree=null;
		XTree string_literal10_tree=null;
		XTree DECL11_tree=null;
		XTree ID12_tree=null;
		XTree set13_tree=null;
		XTree string_literal14_tree=null;
		XTree string_literal15_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:5: ( ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) ) | ^( DECL ID ( 'int' | 'float' | 'string' ) 'read' ) | ^( DECL ID ( 'int' | 'float' | 'string' ) 'print' ) | ^( DECL ID ( 'int' | 'float' | 'string' ) 'read' 'print' ) )
			int alt2=4;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==DECL) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==DOWN) ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2==ID) ) {
						switch ( input.LA(4) ) {
						case 39:
							{
							switch ( input.LA(5) ) {
							case 42:
								{
								int LA2_7 = input.LA(6);
								if ( (LA2_7==UP) ) {
									alt2=2;
								}
								else if ( (LA2_7==40) ) {
									alt2=4;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 40:
								{
								alt2=3;
								}
								break;
							case UP:
								{
								alt2=1;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
							}
							break;
						case 36:
							{
							switch ( input.LA(5) ) {
							case 42:
								{
								int LA2_7 = input.LA(6);
								if ( (LA2_7==UP) ) {
									alt2=2;
								}
								else if ( (LA2_7==40) ) {
									alt2=4;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 40:
								{
								alt2=3;
								}
								break;
							case UP:
								{
								alt2=1;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
							}
							break;
						case 43:
							{
							switch ( input.LA(5) ) {
							case 42:
								{
								int LA2_7 = input.LA(6);
								if ( (LA2_7==UP) ) {
									alt2=2;
								}
								else if ( (LA2_7==40) ) {
									alt2=4;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 40:
								{
								alt2=3;
								}
								break;
							case UP:
								{
								alt2=1;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:9: ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					_last = (XTree)input.LT(1);
					DECL1=(XTree)match(input,DECL,FOLLOW_DECL_in_decl100); 
					DECL1_tree = (XTree)adaptor.dupNode(DECL1);


					root_1 = (XTree)adaptor.becomeRoot(DECL1_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID2=(XTree)match(input,ID,FOLLOW_ID_in_decl102); 
					ID2_tree = (XTree)adaptor.dupNode(ID2);


					adaptor.addChild(root_1, ID2_tree);

					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:19: (type= 'int' |type= 'float' |type= 'string' )
					int alt1=3;
					switch ( input.LA(1) ) {
					case 39:
						{
						alt1=1;
						}
						break;
					case 36:
						{
						alt1=2;
						}
						break;
					case 43:
						{
						alt1=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 1, 0, input);
						throw nvae;
					}
					switch (alt1) {
						case 1 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:20: type= 'int'
							{
							_last = (XTree)input.LT(1);
							type=(XTree)match(input,39,FOLLOW_39_in_decl107); 
							type_tree = (XTree)adaptor.dupNode(type);


							adaptor.addChild(root_1, type_tree);

							}
							break;
						case 2 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:33: type= 'float'
							{
							_last = (XTree)input.LT(1);
							type=(XTree)match(input,36,FOLLOW_36_in_decl113); 
							type_tree = (XTree)adaptor.dupNode(type);


							adaptor.addChild(root_1, type_tree);

							}
							break;
						case 3 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:37:48: type= 'string'
							{
							_last = (XTree)input.LT(1);
							type=(XTree)match(input,43,FOLLOW_43_in_decl119); 
							type_tree = (XTree)adaptor.dupNode(type);


							adaptor.addChild(root_1, type_tree);

							}
							break;

					}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					          symbols.put((ID2!=null?ID2.getText():null), new Symbol((ID2!=null?ID2.getText():null), getXType((type!=null?type.getText():null))));
					        
					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:40:9: ^( DECL ID ( 'int' | 'float' | 'string' ) 'read' )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					_last = (XTree)input.LT(1);
					DECL3=(XTree)match(input,DECL,FOLLOW_DECL_in_decl134); 
					DECL3_tree = (XTree)adaptor.dupNode(DECL3);


					root_1 = (XTree)adaptor.becomeRoot(DECL3_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID4=(XTree)match(input,ID,FOLLOW_ID_in_decl136); 
					ID4_tree = (XTree)adaptor.dupNode(ID4);


					adaptor.addChild(root_1, ID4_tree);

					_last = (XTree)input.LT(1);
					set5=(XTree)input.LT(1);
					if ( input.LA(1)==36||input.LA(1)==39||input.LA(1)==43 ) {
						input.consume();
						set5_tree = (XTree)adaptor.dupNode(set5);


						adaptor.addChild(root_1, set5_tree);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					_last = (XTree)input.LT(1);
					string_literal6=(XTree)match(input,42,FOLLOW_42_in_decl150); 
					string_literal6_tree = (XTree)adaptor.dupNode(string_literal6);


					adaptor.addChild(root_1, string_literal6_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:41:9: ^( DECL ID ( 'int' | 'float' | 'string' ) 'print' )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					_last = (XTree)input.LT(1);
					DECL7=(XTree)match(input,DECL,FOLLOW_DECL_in_decl162); 
					DECL7_tree = (XTree)adaptor.dupNode(DECL7);


					root_1 = (XTree)adaptor.becomeRoot(DECL7_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID8=(XTree)match(input,ID,FOLLOW_ID_in_decl164); 
					ID8_tree = (XTree)adaptor.dupNode(ID8);


					adaptor.addChild(root_1, ID8_tree);

					_last = (XTree)input.LT(1);
					set9=(XTree)input.LT(1);
					if ( input.LA(1)==36||input.LA(1)==39||input.LA(1)==43 ) {
						input.consume();
						set9_tree = (XTree)adaptor.dupNode(set9);


						adaptor.addChild(root_1, set9_tree);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					_last = (XTree)input.LT(1);
					string_literal10=(XTree)match(input,40,FOLLOW_40_in_decl178); 
					string_literal10_tree = (XTree)adaptor.dupNode(string_literal10);


					adaptor.addChild(root_1, string_literal10_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 4 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:42:9: ^( DECL ID ( 'int' | 'float' | 'string' ) 'read' 'print' )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					_last = (XTree)input.LT(1);
					DECL11=(XTree)match(input,DECL,FOLLOW_DECL_in_decl190); 
					DECL11_tree = (XTree)adaptor.dupNode(DECL11);


					root_1 = (XTree)adaptor.becomeRoot(DECL11_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID12=(XTree)match(input,ID,FOLLOW_ID_in_decl192); 
					ID12_tree = (XTree)adaptor.dupNode(ID12);


					adaptor.addChild(root_1, ID12_tree);

					_last = (XTree)input.LT(1);
					set13=(XTree)input.LT(1);
					if ( input.LA(1)==36||input.LA(1)==39||input.LA(1)==43 ) {
						input.consume();
						set13_tree = (XTree)adaptor.dupNode(set13);


						adaptor.addChild(root_1, set13_tree);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					_last = (XTree)input.LT(1);
					string_literal14=(XTree)match(input,42,FOLLOW_42_in_decl206); 
					string_literal14_tree = (XTree)adaptor.dupNode(string_literal14);


					adaptor.addChild(root_1, string_literal14_tree);

					_last = (XTree)input.LT(1);
					string_literal15=(XTree)match(input,40,FOLLOW_40_in_decl208); 
					string_literal15_tree = (XTree)adaptor.dupNode(string_literal15);


					adaptor.addChild(root_1, string_literal15_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;

			}
			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "decl"


	public static class decllist_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "decllist"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:1: decllist : ^( DECLLIST ( decl )* ) -> ^( DECLLIST ( decl )* ) ;
	public final XTypeCheck.decllist_return decllist() throws RecognitionException {
		XTypeCheck.decllist_return retval = new XTypeCheck.decllist_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree DECLLIST16=null;
		TreeRuleReturnScope decl17 =null;

		XTree DECLLIST16_tree=null;
		RewriteRuleNodeStream stream_DECLLIST=new RewriteRuleNodeStream(adaptor,"token DECLLIST");
		RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:9: ( ^( DECLLIST ( decl )* ) -> ^( DECLLIST ( decl )* ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:11: ^( DECLLIST ( decl )* )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			DECLLIST16=(XTree)match(input,DECLLIST,FOLLOW_DECLLIST_in_decllist217); 
			 
			stream_DECLLIST.add(DECLLIST16);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:22: ( decl )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==DECL) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:22: decl
						{
						_last = (XTree)input.LT(1);
						pushFollow(FOLLOW_decl_in_decllist219);
						decl17=decl();
						state._fsp--;

						stream_decl.add(decl17.getTree());
						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			// AST REWRITE
			// elements: decl, DECLLIST
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (XTree)adaptor.nil();
			// 44:29: -> ^( DECLLIST ( decl )* )
			{
				// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:32: ^( DECLLIST ( decl )* )
				{
				XTree root_1 = (XTree)adaptor.nil();
				root_1 = (XTree)adaptor.becomeRoot(
				stream_DECLLIST.nextNode()
				, root_1);
				// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:44:43: ( decl )*
				while ( stream_decl.hasNext() ) {
					adaptor.addChild(root_1, stream_decl.nextTree());
				}
				stream_decl.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "decllist"


	public static class expr_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:46:1: expr : ( ^( ( '+' | '-' | '*' | '/' ) expr expr ) | simpleexpr );
	public final XTypeCheck.expr_return expr() throws RecognitionException {
		XTypeCheck.expr_return retval = new XTypeCheck.expr_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree set18=null;
		TreeRuleReturnScope expr19 =null;
		TreeRuleReturnScope expr20 =null;
		TreeRuleReturnScope simpleexpr21 =null;

		XTree set18_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:46:5: ( ^( ( '+' | '-' | '*' | '/' ) expr expr ) | simpleexpr )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= 22 && LA4_0 <= 24)||LA4_0==26) ) {
				alt4=1;
			}
			else if ( ((LA4_0 >= FLOATCONST && LA4_0 <= INTCONST)||(LA4_0 >= STRINGCONST && LA4_0 <= UMINUS)) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:46:9: ^( ( '+' | '-' | '*' | '/' ) expr expr )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					set18=(XTree)input.LT(1);
					if ( (input.LA(1) >= 22 && input.LA(1) <= 24)||input.LA(1)==26 ) {
						input.consume();
						set18_tree = (XTree)adaptor.dupNode(set18);


						root_1 = (XTree)adaptor.becomeRoot(set18_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr256);
					expr19=expr();
					state._fsp--;

					adaptor.addChild(root_1, expr19.getTree());

					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr258);
					expr20=expr();
					state._fsp--;

					adaptor.addChild(root_1, expr20.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:47:9: simpleexpr
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_simpleexpr_in_expr269);
					simpleexpr21=simpleexpr();
					state._fsp--;

					adaptor.addChild(root_0, simpleexpr21.getTree());

					}
					break;

			}
			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "expr"


	public static class simpleexpr_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "simpleexpr"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:49:1: simpleexpr : ( INTCONST | ^( UMINUS INTCONST ) | FLOATCONST | ^( UMINUS FLOATCONST ) | ID | STRINGCONST );
	public final XTypeCheck.simpleexpr_return simpleexpr() throws RecognitionException {
		XTypeCheck.simpleexpr_return retval = new XTypeCheck.simpleexpr_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree INTCONST22=null;
		XTree UMINUS23=null;
		XTree INTCONST24=null;
		XTree FLOATCONST25=null;
		XTree UMINUS26=null;
		XTree FLOATCONST27=null;
		XTree ID28=null;
		XTree STRINGCONST29=null;

		XTree INTCONST22_tree=null;
		XTree UMINUS23_tree=null;
		XTree INTCONST24_tree=null;
		XTree FLOATCONST25_tree=null;
		XTree UMINUS26_tree=null;
		XTree FLOATCONST27_tree=null;
		XTree ID28_tree=null;
		XTree STRINGCONST29_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:49:11: ( INTCONST | ^( UMINUS INTCONST ) | FLOATCONST | ^( UMINUS FLOATCONST ) | ID | STRINGCONST )
			int alt5=6;
			switch ( input.LA(1) ) {
			case INTCONST:
				{
				alt5=1;
				}
				break;
			case UMINUS:
				{
				int LA5_2 = input.LA(2);
				if ( (LA5_2==DOWN) ) {
					int LA5_6 = input.LA(3);
					if ( (LA5_6==INTCONST) ) {
						alt5=2;
					}
					else if ( (LA5_6==FLOATCONST) ) {
						alt5=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOATCONST:
				{
				alt5=3;
				}
				break;
			case ID:
				{
				alt5=5;
				}
				break;
			case STRINGCONST:
				{
				alt5=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:49:15: INTCONST
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					INTCONST22=(XTree)match(input,INTCONST,FOLLOW_INTCONST_in_simpleexpr278); 
					INTCONST22_tree = (XTree)adaptor.dupNode(INTCONST22);


					adaptor.addChild(root_0, INTCONST22_tree);

					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:50:15: ^( UMINUS INTCONST )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					_last = (XTree)input.LT(1);
					UMINUS23=(XTree)match(input,UMINUS,FOLLOW_UMINUS_in_simpleexpr295); 
					UMINUS23_tree = (XTree)adaptor.dupNode(UMINUS23);


					root_1 = (XTree)adaptor.becomeRoot(UMINUS23_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					INTCONST24=(XTree)match(input,INTCONST,FOLLOW_INTCONST_in_simpleexpr297); 
					INTCONST24_tree = (XTree)adaptor.dupNode(INTCONST24);


					adaptor.addChild(root_1, INTCONST24_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:51:15: FLOATCONST
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					FLOATCONST25=(XTree)match(input,FLOATCONST,FOLLOW_FLOATCONST_in_simpleexpr314); 
					FLOATCONST25_tree = (XTree)adaptor.dupNode(FLOATCONST25);


					adaptor.addChild(root_0, FLOATCONST25_tree);

					}
					break;
				case 4 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:52:15: ^( UMINUS FLOATCONST )
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					XTree root_1 = (XTree)adaptor.nil();
					_last = (XTree)input.LT(1);
					UMINUS26=(XTree)match(input,UMINUS,FOLLOW_UMINUS_in_simpleexpr331); 
					UMINUS26_tree = (XTree)adaptor.dupNode(UMINUS26);


					root_1 = (XTree)adaptor.becomeRoot(UMINUS26_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					FLOATCONST27=(XTree)match(input,FLOATCONST,FOLLOW_FLOATCONST_in_simpleexpr333); 
					FLOATCONST27_tree = (XTree)adaptor.dupNode(FLOATCONST27);


					adaptor.addChild(root_1, FLOATCONST27_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 5 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:53:15: ID
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					ID28=(XTree)match(input,ID,FOLLOW_ID_in_simpleexpr350); 
					ID28_tree = (XTree)adaptor.dupNode(ID28);


					adaptor.addChild(root_0, ID28_tree);

					}
					break;
				case 6 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:54:15: STRINGCONST
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					STRINGCONST29=(XTree)match(input,STRINGCONST,FOLLOW_STRINGCONST_in_simpleexpr366); 
					STRINGCONST29_tree = (XTree)adaptor.dupNode(STRINGCONST29);


					adaptor.addChild(root_0, STRINGCONST29_tree);

					}
					break;

			}
			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "simpleexpr"


	public static class assignstat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "assignstat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:56:1: assignstat : ^( ':=' ID expr ) ;
	public final XTypeCheck.assignstat_return assignstat() throws RecognitionException {
		XTypeCheck.assignstat_return retval = new XTypeCheck.assignstat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal30=null;
		XTree ID31=null;
		TreeRuleReturnScope expr32 =null;

		XTree string_literal30_tree=null;
		XTree ID31_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:56:11: ( ^( ':=' ID expr ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:56:13: ^( ':=' ID expr )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			string_literal30=(XTree)match(input,28,FOLLOW_28_in_assignstat386); 
			string_literal30_tree = (XTree)adaptor.dupNode(string_literal30);


			root_1 = (XTree)adaptor.becomeRoot(string_literal30_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			ID31=(XTree)match(input,ID,FOLLOW_ID_in_assignstat388); 
			ID31_tree = (XTree)adaptor.dupNode(ID31);


			adaptor.addChild(root_1, ID31_tree);

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_assignstat390);
			expr32=expr();
			state._fsp--;

			adaptor.addChild(root_1, expr32.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "assignstat"


	public static class cond_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "cond"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:58:1: cond : ^( ( '<' | '>' | '=' ) expr expr ) ;
	public final XTypeCheck.cond_return cond() throws RecognitionException {
		XTypeCheck.cond_return retval = new XTypeCheck.cond_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree set33=null;
		TreeRuleReturnScope expr34 =null;
		TreeRuleReturnScope expr35 =null;

		XTree set33_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:58:5: ( ^( ( '<' | '>' | '=' ) expr expr ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:58:7: ^( ( '<' | '>' | '=' ) expr expr )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			set33=(XTree)input.LT(1);
			if ( (input.LA(1) >= 30 && input.LA(1) <= 32) ) {
				input.consume();
				set33_tree = (XTree)adaptor.dupNode(set33);


				root_1 = (XTree)adaptor.becomeRoot(set33_tree, root_1);

				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_cond411);
			expr34=expr();
			state._fsp--;

			adaptor.addChild(root_1, expr34.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_cond413);
			expr35=expr();
			state._fsp--;

			adaptor.addChild(root_1, expr35.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "cond"


	public static class condstat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "condstat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:60:1: condstat : ^( 'if' cond stat ( stat )? ) ;
	public final XTypeCheck.condstat_return condstat() throws RecognitionException {
		XTypeCheck.condstat_return retval = new XTypeCheck.condstat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal36=null;
		TreeRuleReturnScope cond37 =null;
		TreeRuleReturnScope stat38 =null;
		TreeRuleReturnScope stat39 =null;

		XTree string_literal36_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:60:9: ( ^( 'if' cond stat ( stat )? ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:60:11: ^( 'if' cond stat ( stat )? )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			string_literal36=(XTree)match(input,38,FOLLOW_38_in_condstat422); 
			string_literal36_tree = (XTree)adaptor.dupNode(string_literal36);


			root_1 = (XTree)adaptor.becomeRoot(string_literal36_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_condstat424);
			cond37=cond();
			state._fsp--;

			adaptor.addChild(root_1, cond37.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_stat_in_condstat426);
			stat38=stat();
			state._fsp--;

			adaptor.addChild(root_1, stat38.getTree());

			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:60:28: ( stat )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==STATLIST||LA6_0==28||(LA6_0 >= 37 && LA6_0 <= 38)||LA6_0==45) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:60:28: stat
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_stat_in_condstat428);
					stat39=stat();
					state._fsp--;

					adaptor.addChild(root_1, stat39.getTree());

					}
					break;

			}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "condstat"


	public static class whilestat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "whilestat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:62:1: whilestat : ^( 'while' cond stat ) ;
	public final XTypeCheck.whilestat_return whilestat() throws RecognitionException {
		XTypeCheck.whilestat_return retval = new XTypeCheck.whilestat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal40=null;
		TreeRuleReturnScope cond41 =null;
		TreeRuleReturnScope stat42 =null;

		XTree string_literal40_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:62:10: ( ^( 'while' cond stat ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:62:12: ^( 'while' cond stat )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			string_literal40=(XTree)match(input,45,FOLLOW_45_in_whilestat438); 
			string_literal40_tree = (XTree)adaptor.dupNode(string_literal40);


			root_1 = (XTree)adaptor.becomeRoot(string_literal40_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_whilestat440);
			cond41=cond();
			state._fsp--;

			adaptor.addChild(root_1, cond41.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_stat_in_whilestat442);
			stat42=stat();
			state._fsp--;

			adaptor.addChild(root_1, stat42.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "whilestat"


	public static class forstat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "forstat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:63:1: forstat : ^( 'for' assignstat cond assignstat stat ) ;
	public final XTypeCheck.forstat_return forstat() throws RecognitionException {
		XTypeCheck.forstat_return retval = new XTypeCheck.forstat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal43=null;
		TreeRuleReturnScope assignstat44 =null;
		TreeRuleReturnScope cond45 =null;
		TreeRuleReturnScope assignstat46 =null;
		TreeRuleReturnScope stat47 =null;

		XTree string_literal43_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:63:8: ( ^( 'for' assignstat cond assignstat stat ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:63:10: ^( 'for' assignstat cond assignstat stat )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			string_literal43=(XTree)match(input,37,FOLLOW_37_in_forstat450); 
			string_literal43_tree = (XTree)adaptor.dupNode(string_literal43);


			root_1 = (XTree)adaptor.becomeRoot(string_literal43_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_assignstat_in_forstat452);
			assignstat44=assignstat();
			state._fsp--;

			adaptor.addChild(root_1, assignstat44.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_forstat454);
			cond45=cond();
			state._fsp--;

			adaptor.addChild(root_1, cond45.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_assignstat_in_forstat456);
			assignstat46=assignstat();
			state._fsp--;

			adaptor.addChild(root_1, assignstat46.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_stat_in_forstat458);
			stat47=stat();
			state._fsp--;

			adaptor.addChild(root_1, stat47.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "forstat"


	public static class stat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:1: stat : ( assignstat | condstat | whilestat | forstat | statlist );
	public final XTypeCheck.stat_return stat() throws RecognitionException {
		XTypeCheck.stat_return retval = new XTypeCheck.stat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		TreeRuleReturnScope assignstat48 =null;
		TreeRuleReturnScope condstat49 =null;
		TreeRuleReturnScope whilestat50 =null;
		TreeRuleReturnScope forstat51 =null;
		TreeRuleReturnScope statlist52 =null;


		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:5: ( assignstat | condstat | whilestat | forstat | statlist )
			int alt7=5;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt7=1;
				}
				break;
			case 38:
				{
				alt7=2;
				}
				break;
			case 45:
				{
				alt7=3;
				}
				break;
			case 37:
				{
				alt7=4;
				}
				break;
			case STATLIST:
				{
				alt7=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:7: assignstat
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_assignstat_in_stat466);
					assignstat48=assignstat();
					state._fsp--;

					adaptor.addChild(root_0, assignstat48.getTree());

					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:20: condstat
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_condstat_in_stat470);
					condstat49=condstat();
					state._fsp--;

					adaptor.addChild(root_0, condstat49.getTree());

					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:31: whilestat
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_whilestat_in_stat474);
					whilestat50=whilestat();
					state._fsp--;

					adaptor.addChild(root_0, whilestat50.getTree());

					}
					break;
				case 4 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:43: forstat
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_forstat_in_stat478);
					forstat51=forstat();
					state._fsp--;

					adaptor.addChild(root_0, forstat51.getTree());

					}
					break;
				case 5 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:65:53: statlist
					{
					root_0 = (XTree)adaptor.nil();


					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_statlist_in_stat482);
					statlist52=statlist();
					state._fsp--;

					adaptor.addChild(root_0, statlist52.getTree());

					}
					break;

			}
			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "stat"


	public static class statlist_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "statlist"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:67:1: statlist : ^( STATLIST ( stat )* ) ;
	public final XTypeCheck.statlist_return statlist() throws RecognitionException {
		XTypeCheck.statlist_return retval = new XTypeCheck.statlist_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree STATLIST53=null;
		TreeRuleReturnScope stat54 =null;

		XTree STATLIST53_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:67:9: ( ^( STATLIST ( stat )* ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:67:11: ^( STATLIST ( stat )* )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			STATLIST53=(XTree)match(input,STATLIST,FOLLOW_STATLIST_in_statlist490); 
			STATLIST53_tree = (XTree)adaptor.dupNode(STATLIST53);


			root_1 = (XTree)adaptor.becomeRoot(STATLIST53_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:67:22: ( stat )*
				loop8:
				while (true) {
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==STATLIST||LA8_0==28||(LA8_0 >= 37 && LA8_0 <= 38)||LA8_0==45) ) {
						alt8=1;
					}

					switch (alt8) {
					case 1 :
						// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:67:22: stat
						{
						_last = (XTree)input.LT(1);
						pushFollow(FOLLOW_stat_in_statlist492);
						stat54=stat();
						state._fsp--;

						adaptor.addChild(root_1, stat54.getTree());

						}
						break;

					default :
						break loop8;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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
	// $ANTLR end "statlist"


	public static class program_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "program"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:69:1: program : ^( 'program' ID decllist statlist ) ;
	public final XTypeCheck.program_return program() throws RecognitionException {
		XTypeCheck.program_return retval = new XTypeCheck.program_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal55=null;
		XTree ID56=null;
		TreeRuleReturnScope decllist57 =null;
		TreeRuleReturnScope statlist58 =null;

		XTree string_literal55_tree=null;
		XTree ID56_tree=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:69:8: ( ^( 'program' ID decllist statlist ) )
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XTypeCheck.g:69:10: ^( 'program' ID decllist statlist )
			{
			root_0 = (XTree)adaptor.nil();


			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			XTree root_1 = (XTree)adaptor.nil();
			_last = (XTree)input.LT(1);
			string_literal55=(XTree)match(input,41,FOLLOW_41_in_program502); 
			string_literal55_tree = (XTree)adaptor.dupNode(string_literal55);


			root_1 = (XTree)adaptor.becomeRoot(string_literal55_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			ID56=(XTree)match(input,ID,FOLLOW_ID_in_program504); 
			ID56_tree = (XTree)adaptor.dupNode(ID56);


			adaptor.addChild(root_1, ID56_tree);

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_decllist_in_program506);
			decllist57=decllist();
			state._fsp--;

			adaptor.addChild(root_1, decllist57.getTree());

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_statlist_in_program508);
			statlist58=statlist();
			state._fsp--;

			adaptor.addChild(root_1, statlist58.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);

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



	public static final BitSet FOLLOW_DECL_in_decl100 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl102 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_39_in_decl107 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_36_in_decl113 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_43_in_decl119 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_decl134 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl136 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_set_in_decl138 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_decl150 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_decl162 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl164 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_set_in_decl166 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_decl178 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_decl190 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl192 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_set_in_decl194 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_decl206 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_decl208 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLLIST_in_decllist217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_decllist219 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_set_in_expr240 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr256 = new BitSet(new long[]{0x0000000005C30700L});
	public static final BitSet FOLLOW_expr_in_expr258 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_simpleexpr_in_expr269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTCONST_in_simpleexpr278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UMINUS_in_simpleexpr295 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_INTCONST_in_simpleexpr297 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FLOATCONST_in_simpleexpr314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UMINUS_in_simpleexpr331 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_FLOATCONST_in_simpleexpr333 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_simpleexpr350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRINGCONST_in_simpleexpr366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_assignstat386 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assignstat388 = new BitSet(new long[]{0x0000000005C30700L});
	public static final BitSet FOLLOW_expr_in_assignstat390 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_cond399 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond411 = new BitSet(new long[]{0x0000000005C30700L});
	public static final BitSet FOLLOW_expr_in_cond413 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_38_in_condstat422 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_condstat424 = new BitSet(new long[]{0x0000206010008000L});
	public static final BitSet FOLLOW_stat_in_condstat426 = new BitSet(new long[]{0x0000206010008008L});
	public static final BitSet FOLLOW_stat_in_condstat428 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_45_in_whilestat438 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_whilestat440 = new BitSet(new long[]{0x0000206010008000L});
	public static final BitSet FOLLOW_stat_in_whilestat442 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_37_in_forstat450 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assignstat_in_forstat452 = new BitSet(new long[]{0x00000001C0000000L});
	public static final BitSet FOLLOW_cond_in_forstat454 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_assignstat_in_forstat456 = new BitSet(new long[]{0x0000206010008000L});
	public static final BitSet FOLLOW_stat_in_forstat458 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_assignstat_in_stat466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condstat_in_stat470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whilestat_in_stat474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forstat_in_stat478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statlist_in_stat482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STATLIST_in_statlist490 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_in_statlist492 = new BitSet(new long[]{0x0000206010008008L});
	public static final BitSet FOLLOW_41_in_program502 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_program504 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_decllist_in_program506 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_statlist_in_program508 = new BitSet(new long[]{0x0000000000000008L});
}
