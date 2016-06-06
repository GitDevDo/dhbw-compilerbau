// $ANTLR 3.5.2 D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g 2016-06-06 12:00:37

    package de.dhbw.compiler.antlrxcompiler;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings("all")
public class XtoJava extends TreeParser {
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


	public XtoJava(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public XtoJava(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected StringTemplateGroup templateLib =
	  new StringTemplateGroup("XtoJavaTemplates", AngleBracketTemplateLexer.class);

	public void setTemplateLib(StringTemplateGroup templateLib) {
	  this.templateLib = templateLib;
	}
	public StringTemplateGroup getTemplateLib() {
	  return templateLib;
	}
	/** allows convenient multi-value initialization:
	 *  "new STAttrMap().put(...).put(...)"
	 */
	@SuppressWarnings("serial")
	public static class STAttrMap extends HashMap<String, Object> {
		public STAttrMap put(String attrName, Object value) {
			super.put(attrName, value);
			return this;
		}
	}
	@Override public String[] getTokenNames() { return XtoJava.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g"; }



	  private SymbolTable  symbols = SymbolTable.getInstance();  
	     


	public static class decl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "decl"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:1: decl : ( ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\"| ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'read' ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\"| ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'print' ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\"| ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'read' 'print' ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\");
	public final XtoJava.decl_return decl() throws RecognitionException {
		XtoJava.decl_return retval = new XtoJava.decl_return();
		retval.start = input.LT(1);

		XTree type=null;
		XTree ID1=null;
		XTree ID2=null;
		XTree ID3=null;
		XTree ID4=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:5: ( ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\"| ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'read' ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\"| ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'print' ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\"| ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'read' 'print' ) -> template(t=$type.textv=$ID.text) \"<t> <v>;\")
			int alt5=4;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==DECL) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==DOWN) ) {
					int LA5_2 = input.LA(3);
					if ( (LA5_2==ID) ) {
						switch ( input.LA(4) ) {
						case 39:
							{
							switch ( input.LA(5) ) {
							case UP:
								{
								alt5=1;
								}
								break;
							case 42:
								{
								int LA5_8 = input.LA(6);
								if ( (LA5_8==UP) ) {
									alt5=2;
								}
								else if ( (LA5_8==40) ) {
									alt5=4;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 40:
								{
								alt5=3;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 5, 4, input);
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
							case UP:
								{
								alt5=1;
								}
								break;
							case 42:
								{
								int LA5_8 = input.LA(6);
								if ( (LA5_8==UP) ) {
									alt5=2;
								}
								else if ( (LA5_8==40) ) {
									alt5=4;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 40:
								{
								alt5=3;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 5, 5, input);
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
							case UP:
								{
								alt5=1;
								}
								break;
							case 42:
								{
								int LA5_8 = input.LA(6);
								if ( (LA5_8==UP) ) {
									alt5=2;
								}
								else if ( (LA5_8==40) ) {
									alt5=4;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 40:
								{
								alt5=3;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
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
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 3, input);
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
								new NoViableAltException("", 5, 2, input);
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
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:9: ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) )
					{
					match(input,DECL,FOLLOW_DECL_in_decl69); 
					match(input, Token.DOWN, null); 
					ID1=(XTree)match(input,ID,FOLLOW_ID_in_decl71); 
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:19: (type= 'int' |type= 'float' |type= 'string' )
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
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:20: type= 'int'
							{
							type=(XTree)match(input,39,FOLLOW_39_in_decl76); 
							}
							break;
						case 2 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:33: type= 'float'
							{
							type=(XTree)match(input,36,FOLLOW_36_in_decl82); 
							}
							break;
						case 3 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:22:48: type= 'string'
							{
							type=(XTree)match(input,43,FOLLOW_43_in_decl88); 
							}
							break;

					}

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 22:64: -> template(t=$type.textv=$ID.text) \"<t> <v>;\"
					{
						retval.st = new StringTemplate(templateLib, "<t> <v>;",new STAttrMap().put("t", (type!=null?type.getText():null)).put("v", (ID1!=null?ID1.getText():null)));
					}



					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:23:9: ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'read' )
					{
					match(input,DECL,FOLLOW_DECL_in_decl117); 
					match(input, Token.DOWN, null); 
					ID2=(XTree)match(input,ID,FOLLOW_ID_in_decl119); 
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:23:19: (type= 'int' |type= 'float' |type= 'string' )
					int alt2=3;
					switch ( input.LA(1) ) {
					case 39:
						{
						alt2=1;
						}
						break;
					case 36:
						{
						alt2=2;
						}
						break;
					case 43:
						{
						alt2=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						throw nvae;
					}
					switch (alt2) {
						case 1 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:23:20: type= 'int'
							{
							type=(XTree)match(input,39,FOLLOW_39_in_decl124); 
							}
							break;
						case 2 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:23:33: type= 'float'
							{
							type=(XTree)match(input,36,FOLLOW_36_in_decl130); 
							}
							break;
						case 3 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:23:48: type= 'string'
							{
							type=(XTree)match(input,43,FOLLOW_43_in_decl136); 
							}
							break;

					}

					match(input,42,FOLLOW_42_in_decl139); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 23:71: -> template(t=$type.textv=$ID.text) \"<t> <v>;\"
					{
						retval.st = new StringTemplate(templateLib, "<t> <v>;",new STAttrMap().put("t", (type!=null?type.getText():null)).put("v", (ID2!=null?ID2.getText():null)));
					}



					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:24:9: ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'print' )
					{
					match(input,DECL,FOLLOW_DECL_in_decl167); 
					match(input, Token.DOWN, null); 
					ID3=(XTree)match(input,ID,FOLLOW_ID_in_decl169); 
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:24:19: (type= 'int' |type= 'float' |type= 'string' )
					int alt3=3;
					switch ( input.LA(1) ) {
					case 39:
						{
						alt3=1;
						}
						break;
					case 36:
						{
						alt3=2;
						}
						break;
					case 43:
						{
						alt3=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}
					switch (alt3) {
						case 1 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:24:20: type= 'int'
							{
							type=(XTree)match(input,39,FOLLOW_39_in_decl174); 
							}
							break;
						case 2 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:24:33: type= 'float'
							{
							type=(XTree)match(input,36,FOLLOW_36_in_decl180); 
							}
							break;
						case 3 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:24:48: type= 'string'
							{
							type=(XTree)match(input,43,FOLLOW_43_in_decl186); 
							}
							break;

					}

					match(input,40,FOLLOW_40_in_decl189); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 24:72: -> template(t=$type.textv=$ID.text) \"<t> <v>;\"
					{
						retval.st = new StringTemplate(templateLib, "<t> <v>;",new STAttrMap().put("t", (type!=null?type.getText():null)).put("v", (ID3!=null?ID3.getText():null)));
					}



					}
					break;
				case 4 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:25:9: ^( DECL ID (type= 'int' |type= 'float' |type= 'string' ) 'read' 'print' )
					{
					match(input,DECL,FOLLOW_DECL_in_decl217); 
					match(input, Token.DOWN, null); 
					ID4=(XTree)match(input,ID,FOLLOW_ID_in_decl219); 
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:25:19: (type= 'int' |type= 'float' |type= 'string' )
					int alt4=3;
					switch ( input.LA(1) ) {
					case 39:
						{
						alt4=1;
						}
						break;
					case 36:
						{
						alt4=2;
						}
						break;
					case 43:
						{
						alt4=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}
					switch (alt4) {
						case 1 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:25:20: type= 'int'
							{
							type=(XTree)match(input,39,FOLLOW_39_in_decl224); 
							}
							break;
						case 2 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:25:33: type= 'float'
							{
							type=(XTree)match(input,36,FOLLOW_36_in_decl230); 
							}
							break;
						case 3 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:25:48: type= 'string'
							{
							type=(XTree)match(input,43,FOLLOW_43_in_decl236); 
							}
							break;

					}

					match(input,42,FOLLOW_42_in_decl239); 
					match(input,40,FOLLOW_40_in_decl241); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 25:79: -> template(t=$type.textv=$ID.text) \"<t> <v>;\"
					{
						retval.st = new StringTemplate(templateLib, "<t> <v>;",new STAttrMap().put("t", (type!=null?type.getText():null)).put("v", (ID4!=null?ID4.getText():null)));
					}



					}
					break;

			}
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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "decllist"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:27:1: decllist : ^( DECLLIST (declarations+= decl )* ) -> template(d=$declarations) \"<d; separator=\"\\n\">\";
	public final XtoJava.decllist_return decllist() throws RecognitionException {
		XtoJava.decllist_return retval = new XtoJava.decllist_return();
		retval.start = input.LT(1);

		List<Object> list_declarations=null;
		RuleReturnScope declarations = null;
		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:27:9: ( ^( DECLLIST (declarations+= decl )* ) -> template(d=$declarations) \"<d; separator=\"\\n\">\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:27:11: ^( DECLLIST (declarations+= decl )* )
			{
			match(input,DECLLIST,FOLLOW_DECLLIST_in_decllist266); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:27:22: (declarations+= decl )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==DECL) ) {
						alt6=1;
					}

					switch (alt6) {
					case 1 :
						// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:27:23: declarations+= decl
						{
						pushFollow(FOLLOW_decl_in_decllist271);
						declarations=decl();
						state._fsp--;

						if (list_declarations==null) list_declarations=new ArrayList<Object>();
						list_declarations.add(declarations.getTemplate());
						}
						break;

					default :
						break loop6;
					}
				}

				match(input, Token.UP, null); 
			}

			// TEMPLATE REWRITE
			// 27:45: -> template(d=$declarations) \"<d; separator=\"\\n\">\"
			{
				retval.st = new StringTemplate(templateLib, "<d; separator=\"\\n\">",new STAttrMap().put("d", list_declarations));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "expr"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:1: expr : ( ^( (op= '+' |op= '-' |op= '*' |op= '/' ) left= expr right= expr ) -> template(o=$op.textl=$left.str=$right.st) \"<l> <o> <r>\"| simpleexpr -> template(e=$simpleexpr.st) \"<e>\");
	public final XtoJava.expr_return expr() throws RecognitionException {
		XtoJava.expr_return retval = new XtoJava.expr_return();
		retval.start = input.LT(1);

		XTree op=null;
		TreeRuleReturnScope left =null;
		TreeRuleReturnScope right =null;
		TreeRuleReturnScope simpleexpr5 =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:5: ( ^( (op= '+' |op= '-' |op= '*' |op= '/' ) left= expr right= expr ) -> template(o=$op.textl=$left.str=$right.st) \"<l> <o> <r>\"| simpleexpr -> template(e=$simpleexpr.st) \"<e>\")
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( ((LA8_0 >= 22 && LA8_0 <= 24)||LA8_0==26) ) {
				alt8=1;
			}
			else if ( ((LA8_0 >= FLOATCONST && LA8_0 <= INTCONST)||(LA8_0 >= STRINGCONST && LA8_0 <= UMINUS)) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:9: ^( (op= '+' |op= '-' |op= '*' |op= '/' ) left= expr right= expr )
					{
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:11: (op= '+' |op= '-' |op= '*' |op= '/' )
					int alt7=4;
					switch ( input.LA(1) ) {
					case 23:
						{
						alt7=1;
						}
						break;
					case 24:
						{
						alt7=2;
						}
						break;
					case 22:
						{
						alt7=3;
						}
						break;
					case 26:
						{
						alt7=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}
					switch (alt7) {
						case 1 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:12: op= '+'
							{
							op=(XTree)match(input,23,FOLLOW_23_in_expr298); 
							}
							break;
						case 2 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:21: op= '-'
							{
							op=(XTree)match(input,24,FOLLOW_24_in_expr304); 
							}
							break;
						case 3 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:30: op= '*'
							{
							op=(XTree)match(input,22,FOLLOW_22_in_expr310); 
							}
							break;
						case 4 :
							// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:29:39: op= '/'
							{
							op=(XTree)match(input,26,FOLLOW_26_in_expr316); 
							}
							break;

					}

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr321);
					left=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr325);
					right=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 29:69: -> template(o=$op.textl=$left.str=$right.st) \"<l> <o> <r>\"
					{
						retval.st = new StringTemplate(templateLib, "<l> <o> <r>",new STAttrMap().put("o", (op!=null?op.getText():null)).put("l", (left!=null?((StringTemplate)left.getTemplate()):null)).put("r", (right!=null?((StringTemplate)right.getTemplate()):null)));
					}



					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:30:9: simpleexpr
					{
					pushFollow(FOLLOW_simpleexpr_in_expr357);
					simpleexpr5=simpleexpr();
					state._fsp--;

					// TEMPLATE REWRITE
					// 30:20: -> template(e=$simpleexpr.st) \"<e>\"
					{
						retval.st = new StringTemplate(templateLib, "<e>",new STAttrMap().put("e", (simpleexpr5!=null?((StringTemplate)simpleexpr5.getTemplate()):null)));
					}



					}
					break;

			}
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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "simpleexpr"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:32:1: simpleexpr : ( INTCONST -> template(c=$INTCONST.text) \"<c>\"| ^( UMINUS INTCONST ) -> template(c=$INTCONST.text) \"-<c>\"| FLOATCONST -> template(c=$FLOATCONST.text) \"<c>\"| ^( UMINUS FLOATCONST ) -> template(c=$FLOATCONST.text) \"-<c>\"| ID -> template(v=$ID.text) \"<v>\"| STRINGCONST -> template(c=$STRINGCONST.text) \"<c>\");
	public final XtoJava.simpleexpr_return simpleexpr() throws RecognitionException {
		XtoJava.simpleexpr_return retval = new XtoJava.simpleexpr_return();
		retval.start = input.LT(1);

		XTree INTCONST6=null;
		XTree INTCONST7=null;
		XTree FLOATCONST8=null;
		XTree FLOATCONST9=null;
		XTree ID10=null;
		XTree STRINGCONST11=null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:32:11: ( INTCONST -> template(c=$INTCONST.text) \"<c>\"| ^( UMINUS INTCONST ) -> template(c=$INTCONST.text) \"-<c>\"| FLOATCONST -> template(c=$FLOATCONST.text) \"<c>\"| ^( UMINUS FLOATCONST ) -> template(c=$FLOATCONST.text) \"-<c>\"| ID -> template(v=$ID.text) \"<v>\"| STRINGCONST -> template(c=$STRINGCONST.text) \"<c>\")
			int alt9=6;
			switch ( input.LA(1) ) {
			case INTCONST:
				{
				alt9=1;
				}
				break;
			case UMINUS:
				{
				int LA9_2 = input.LA(2);
				if ( (LA9_2==DOWN) ) {
					int LA9_6 = input.LA(3);
					if ( (LA9_6==INTCONST) ) {
						alt9=2;
					}
					else if ( (LA9_6==FLOATCONST) ) {
						alt9=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 6, input);
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
							new NoViableAltException("", 9, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOATCONST:
				{
				alt9=3;
				}
				break;
			case ID:
				{
				alt9=5;
				}
				break;
			case STRINGCONST:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:32:15: INTCONST
					{
					INTCONST6=(XTree)match(input,INTCONST,FOLLOW_INTCONST_in_simpleexpr377); 
					// TEMPLATE REWRITE
					// 32:24: -> template(c=$INTCONST.text) \"<c>\"
					{
						retval.st = new StringTemplate(templateLib, "<c>",new STAttrMap().put("c", (INTCONST6!=null?INTCONST6.getText():null)));
					}



					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:33:15: ^( UMINUS INTCONST )
					{
					match(input,UMINUS,FOLLOW_UMINUS_in_simpleexpr405); 
					match(input, Token.DOWN, null); 
					INTCONST7=(XTree)match(input,INTCONST,FOLLOW_INTCONST_in_simpleexpr407); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 33:34: -> template(c=$INTCONST.text) \"-<c>\"
					{
						retval.st = new StringTemplate(templateLib, "-<c>",new STAttrMap().put("c", (INTCONST7!=null?INTCONST7.getText():null)));
					}



					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:34:15: FLOATCONST
					{
					FLOATCONST8=(XTree)match(input,FLOATCONST,FOLLOW_FLOATCONST_in_simpleexpr435); 
					// TEMPLATE REWRITE
					// 34:26: -> template(c=$FLOATCONST.text) \"<c>\"
					{
						retval.st = new StringTemplate(templateLib, "<c>",new STAttrMap().put("c", (FLOATCONST8!=null?FLOATCONST8.getText():null)));
					}



					}
					break;
				case 4 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:35:15: ^( UMINUS FLOATCONST )
					{
					match(input,UMINUS,FOLLOW_UMINUS_in_simpleexpr463); 
					match(input, Token.DOWN, null); 
					FLOATCONST9=(XTree)match(input,FLOATCONST,FOLLOW_FLOATCONST_in_simpleexpr465); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 35:36: -> template(c=$FLOATCONST.text) \"-<c>\"
					{
						retval.st = new StringTemplate(templateLib, "-<c>",new STAttrMap().put("c", (FLOATCONST9!=null?FLOATCONST9.getText():null)));
					}



					}
					break;
				case 5 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:36:15: ID
					{
					ID10=(XTree)match(input,ID,FOLLOW_ID_in_simpleexpr493); 
					// TEMPLATE REWRITE
					// 36:18: -> template(v=$ID.text) \"<v>\"
					{
						retval.st = new StringTemplate(templateLib, "<v>",new STAttrMap().put("v", (ID10!=null?ID10.getText():null)));
					}



					}
					break;
				case 6 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:37:15: STRINGCONST
					{
					STRINGCONST11=(XTree)match(input,STRINGCONST,FOLLOW_STRINGCONST_in_simpleexpr520); 
					// TEMPLATE REWRITE
					// 37:27: -> template(c=$STRINGCONST.text) \"<c>\"
					{
						retval.st = new StringTemplate(templateLib, "<c>",new STAttrMap().put("c", (STRINGCONST11!=null?STRINGCONST11.getText():null)));
					}



					}
					break;

			}
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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "assignstat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:39:1: assignstat : ^( ':=' ID expr ) -> template(a=$ID.texte=$expr.st) \"<a> = <e>;\";
	public final XtoJava.assignstat_return assignstat() throws RecognitionException {
		XtoJava.assignstat_return retval = new XtoJava.assignstat_return();
		retval.start = input.LT(1);

		XTree ID12=null;
		TreeRuleReturnScope expr13 =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:39:11: ( ^( ':=' ID expr ) -> template(a=$ID.texte=$expr.st) \"<a> = <e>;\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:39:13: ^( ':=' ID expr )
			{
			match(input,28,FOLLOW_28_in_assignstat551); 
			match(input, Token.DOWN, null); 
			ID12=(XTree)match(input,ID,FOLLOW_ID_in_assignstat553); 
			pushFollow(FOLLOW_expr_in_assignstat555);
			expr13=expr();
			state._fsp--;

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 39:29: -> template(a=$ID.texte=$expr.st) \"<a> = <e>;\"
			{
				retval.st = new StringTemplate(templateLib, "<a> = <e>;",new STAttrMap().put("a", (ID12!=null?ID12.getText():null)).put("e", (expr13!=null?((StringTemplate)expr13.getTemplate()):null)));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "cond"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:1: cond : ^( (operator= '<' |operator= '>' |operator= '=' ) left= expr right= expr ) -> template(o=$operator.textl=$left.str=$right.st) \"<l> <o> <r>\";
	public final XtoJava.cond_return cond() throws RecognitionException {
		XtoJava.cond_return retval = new XtoJava.cond_return();
		retval.start = input.LT(1);

		XTree operator=null;
		TreeRuleReturnScope left =null;
		TreeRuleReturnScope right =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:5: ( ^( (operator= '<' |operator= '>' |operator= '=' ) left= expr right= expr ) -> template(o=$operator.textl=$left.str=$right.st) \"<l> <o> <r>\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:7: ^( (operator= '<' |operator= '>' |operator= '=' ) left= expr right= expr )
			{
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:9: (operator= '<' |operator= '>' |operator= '=' )
			int alt10=3;
			switch ( input.LA(1) ) {
			case 30:
				{
				alt10=1;
				}
				break;
			case 32:
				{
				alt10=2;
				}
				break;
			case 31:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:10: operator= '<'
					{
					operator=(XTree)match(input,30,FOLLOW_30_in_cond583); 
					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:25: operator= '>'
					{
					operator=(XTree)match(input,32,FOLLOW_32_in_cond589); 
					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:41:40: operator= '='
					{
					operator=(XTree)match(input,31,FOLLOW_31_in_cond595); 
					}
					break;

			}

			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expr_in_cond600);
			left=expr();
			state._fsp--;

			pushFollow(FOLLOW_expr_in_cond604);
			right=expr();
			state._fsp--;

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 41:76: -> template(o=$operator.textl=$left.str=$right.st) \"<l> <o> <r>\"
			{
				retval.st = new StringTemplate(templateLib, "<l> <o> <r>",new STAttrMap().put("o", (operator!=null?operator.getText():null)).put("l", (left!=null?((StringTemplate)left.getTemplate()):null)).put("r", (right!=null?((StringTemplate)right.getTemplate()):null)));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "condstat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:44:1: condstat : ^( 'if' cond then= stat (elseSt= stat )? ) -> template(c=$cond.stt=$then.ste=$elseSt.st) \"if (<cond>) {<t>} else {<e>}\";
	public final XtoJava.condstat_return condstat() throws RecognitionException {
		XtoJava.condstat_return retval = new XtoJava.condstat_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope then =null;
		TreeRuleReturnScope elseSt =null;
		TreeRuleReturnScope cond14 =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:44:9: ( ^( 'if' cond then= stat (elseSt= stat )? ) -> template(c=$cond.stt=$then.ste=$elseSt.st) \"if (<cond>) {<t>} else {<e>}\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:44:11: ^( 'if' cond then= stat (elseSt= stat )? )
			{
			match(input,38,FOLLOW_38_in_condstat644); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_cond_in_condstat646);
			cond14=cond();
			state._fsp--;

			pushFollow(FOLLOW_stat_in_condstat650);
			then=stat();
			state._fsp--;

			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:44:39: (elseSt= stat )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==STATLIST||LA11_0==28||(LA11_0 >= 37 && LA11_0 <= 38)||LA11_0==45) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:44:39: elseSt= stat
					{
					pushFollow(FOLLOW_stat_in_condstat654);
					elseSt=stat();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 44:47: -> template(c=$cond.stt=$then.ste=$elseSt.st) \"if (<cond>) {<t>} else {<e>}\"
			{
				retval.st = new StringTemplate(templateLib, "if (<cond>) {<t>} else {<e>}",new STAttrMap().put("c", (cond14!=null?((StringTemplate)cond14.getTemplate()):null)).put("t", (then!=null?((StringTemplate)then.getTemplate()):null)).put("e", (elseSt!=null?((StringTemplate)elseSt.getTemplate()):null)));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "whilestat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:47:1: whilestat : ^( 'while' cond stat ) -> template(c=$cond.sts=$stat.st) \"while (<c>) {<s>}\";
	public final XtoJava.whilestat_return whilestat() throws RecognitionException {
		XtoJava.whilestat_return retval = new XtoJava.whilestat_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope cond15 =null;
		TreeRuleReturnScope stat16 =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:47:10: ( ^( 'while' cond stat ) -> template(c=$cond.sts=$stat.st) \"while (<c>) {<s>}\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:47:12: ^( 'while' cond stat )
			{
			match(input,45,FOLLOW_45_in_whilestat709); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_cond_in_whilestat711);
			cond15=cond();
			state._fsp--;

			pushFollow(FOLLOW_stat_in_whilestat713);
			stat16=stat();
			state._fsp--;

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 47:33: -> template(c=$cond.sts=$stat.st) \"while (<c>) {<s>}\"
			{
				retval.st = new StringTemplate(templateLib, "while (<c>) {<s>}",new STAttrMap().put("c", (cond15!=null?((StringTemplate)cond15.getTemplate()):null)).put("s", (stat16!=null?((StringTemplate)stat16.getTemplate()):null)));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "forstat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:48:1: forstat : ^( 'for' var= assignstat cond inc= assignstat stat ) -> template(v=$var.stc=$cond.sti=$inc.stb=$stat.st) \"for (<v>; <c>; <i>) {<b>}\";
	public final XtoJava.forstat_return forstat() throws RecognitionException {
		XtoJava.forstat_return retval = new XtoJava.forstat_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope var =null;
		TreeRuleReturnScope inc =null;
		TreeRuleReturnScope cond17 =null;
		TreeRuleReturnScope stat18 =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:48:8: ( ^( 'for' var= assignstat cond inc= assignstat stat ) -> template(v=$var.stc=$cond.sti=$inc.stb=$stat.st) \"for (<v>; <c>; <i>) {<b>}\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:48:10: ^( 'for' var= assignstat cond inc= assignstat stat )
			{
			match(input,37,FOLLOW_37_in_forstat737); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_assignstat_in_forstat741);
			var=assignstat();
			state._fsp--;

			pushFollow(FOLLOW_cond_in_forstat743);
			cond17=cond();
			state._fsp--;

			pushFollow(FOLLOW_assignstat_in_forstat747);
			inc=assignstat();
			state._fsp--;

			pushFollow(FOLLOW_stat_in_forstat749);
			stat18=stat();
			state._fsp--;

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 48:59: -> template(v=$var.stc=$cond.sti=$inc.stb=$stat.st) \"for (<v>; <c>; <i>) {<b>}\"
			{
				retval.st = new StringTemplate(templateLib, "for (<v>; <c>; <i>) {<b>}",new STAttrMap().put("v", (var!=null?((StringTemplate)var.getTemplate()):null)).put("c", (cond17!=null?((StringTemplate)cond17.getTemplate()):null)).put("i", (inc!=null?((StringTemplate)inc.getTemplate()):null)).put("b", (stat18!=null?((StringTemplate)stat18.getTemplate()):null)));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "stat"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:1: stat : (stmt= assignstat |stmt= condstat |stmt= whilestat |stmt= forstat |stmt= statlist ) -> template(s=$stmt.st) \"<s>\";
	public final XtoJava.stat_return stat() throws RecognitionException {
		XtoJava.stat_return retval = new XtoJava.stat_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope stmt =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:5: ( (stmt= assignstat |stmt= condstat |stmt= whilestat |stmt= forstat |stmt= statlist ) -> template(s=$stmt.st) \"<s>\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:7: (stmt= assignstat |stmt= condstat |stmt= whilestat |stmt= forstat |stmt= statlist )
			{
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:7: (stmt= assignstat |stmt= condstat |stmt= whilestat |stmt= forstat |stmt= statlist )
			int alt12=5;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt12=1;
				}
				break;
			case 38:
				{
				alt12=2;
				}
				break;
			case 45:
				{
				alt12=3;
				}
				break;
			case 37:
				{
				alt12=4;
				}
				break;
			case STATLIST:
				{
				alt12=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:8: stmt= assignstat
					{
					pushFollow(FOLLOW_assignstat_in_stat798);
					stmt=assignstat();
					state._fsp--;

					}
					break;
				case 2 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:26: stmt= condstat
					{
					pushFollow(FOLLOW_condstat_in_stat804);
					stmt=condstat();
					state._fsp--;

					}
					break;
				case 3 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:42: stmt= whilestat
					{
					pushFollow(FOLLOW_whilestat_in_stat810);
					stmt=whilestat();
					state._fsp--;

					}
					break;
				case 4 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:59: stmt= forstat
					{
					pushFollow(FOLLOW_forstat_in_stat816);
					stmt=forstat();
					state._fsp--;

					}
					break;
				case 5 :
					// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:51:74: stmt= statlist
					{
					pushFollow(FOLLOW_statlist_in_stat822);
					stmt=statlist();
					state._fsp--;

					}
					break;

			}

			// TEMPLATE REWRITE
			// 51:89: -> template(s=$stmt.st) \"<s>\"
			{
				retval.st = new StringTemplate(templateLib, "<s>",new STAttrMap().put("s", (stmt!=null?((StringTemplate)stmt.getTemplate()):null)));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "statlist"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:53:1: statlist : ^( STATLIST (stmt+= stat )* ) -> template(s=$stmt) \"<s; separator=\"\\n\">\";
	public final XtoJava.statlist_return statlist() throws RecognitionException {
		XtoJava.statlist_return retval = new XtoJava.statlist_return();
		retval.start = input.LT(1);

		List<Object> list_stmt=null;
		RuleReturnScope stmt = null;
		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:53:9: ( ^( STATLIST (stmt+= stat )* ) -> template(s=$stmt) \"<s; separator=\"\\n\">\")
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:53:11: ^( STATLIST (stmt+= stat )* )
			{
			match(input,STATLIST,FOLLOW_STATLIST_in_statlist842); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:53:22: (stmt+= stat )*
				loop13:
				while (true) {
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==STATLIST||LA13_0==28||(LA13_0 >= 37 && LA13_0 <= 38)||LA13_0==45) ) {
						alt13=1;
					}

					switch (alt13) {
					case 1 :
						// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:53:23: stmt+= stat
						{
						pushFollow(FOLLOW_stat_in_statlist847);
						stmt=stat();
						state._fsp--;

						if (list_stmt==null) list_stmt=new ArrayList<Object>();
						list_stmt.add(stmt.getTemplate());
						}
						break;

					default :
						break loop13;
					}
				}

				match(input, Token.UP, null); 
			}

			// TEMPLATE REWRITE
			// 53:37: -> template(s=$stmt) \"<s; separator=\"\\n\">\"
			{
				retval.st = new StringTemplate(templateLib, "<s; separator=\"\\n\">",new STAttrMap().put("s", list_stmt));
			}



			}

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
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "program"
	// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:55:1: program : ^( 'program' ID decllist statlist ) -> template(n=$ID.textd=$decllist.sts=$statlist.st) <<\r\npublic class <n> {\r\n <d>\r\n \r\n public static void main(String[] args){\r\n <s>\r\n }\r\n}\r\n >>;
	public final XtoJava.program_return program() throws RecognitionException {
		XtoJava.program_return retval = new XtoJava.program_return();
		retval.start = input.LT(1);

		XTree ID19=null;
		TreeRuleReturnScope decllist20 =null;
		TreeRuleReturnScope statlist21 =null;

		try {
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:55:8: ( ^( 'program' ID decllist statlist ) -> template(n=$ID.textd=$decllist.sts=$statlist.st) <<\r\npublic class <n> {\r\n <d>\r\n \r\n public static void main(String[] args){\r\n <s>\r\n }\r\n}\r\n >>)
			// D:\\Compilerbau\\workspace\\ÜB-Praxis-Antlr X Übersetzer - Leer\\src\\de\\dhbw\\compiler\\antlrxcompiler\\XtoJava.g:55:10: ^( 'program' ID decllist statlist )
			{
			match(input,41,FOLLOW_41_in_program869); 
			match(input, Token.DOWN, null); 
			ID19=(XTree)match(input,ID,FOLLOW_ID_in_program871); 
			pushFollow(FOLLOW_decllist_in_program873);
			decllist20=decllist();
			state._fsp--;

			pushFollow(FOLLOW_statlist_in_program875);
			statlist21=statlist();
			state._fsp--;

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 55:44: -> template(n=$ID.textd=$decllist.sts=$statlist.st) <<\r\npublic class <n> {\r\n <d>\r\n \r\n public static void main(String[] args){\r\n <s>\r\n }\r\n}\r\n >>
			{
				retval.st = new StringTemplate(templateLib, "\r\npublic class <n> {\r\n  <d>\r\n  \r\n  public static void main(String[] args){\r\n    <s>\r\n  }\r\n}\r\n  ",new STAttrMap().put("n", (ID19!=null?ID19.getText():null)).put("d", (decllist20!=null?((StringTemplate)decllist20.getTemplate()):null)).put("s", (statlist21!=null?((StringTemplate)statlist21.getTemplate()):null)));
			}



			}

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



	public static final BitSet FOLLOW_DECL_in_decl69 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl71 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_39_in_decl76 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_36_in_decl82 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_43_in_decl88 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_decl117 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl119 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_39_in_decl124 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_36_in_decl130 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_43_in_decl136 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_decl139 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_decl167 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl169 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_39_in_decl174 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_36_in_decl180 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_43_in_decl186 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_decl189 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_decl217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl219 = new BitSet(new long[]{0x0000089000000000L});
	public static final BitSet FOLLOW_39_in_decl224 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_36_in_decl230 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_43_in_decl236 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_decl239 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_decl241 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLLIST_in_decllist266 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_decllist271 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_23_in_expr298 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_24_in_expr304 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_22_in_expr310 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_26_in_expr316 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr321 = new BitSet(new long[]{0x0000000005C30700L});
	public static final BitSet FOLLOW_expr_in_expr325 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_simpleexpr_in_expr357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTCONST_in_simpleexpr377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UMINUS_in_simpleexpr405 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_INTCONST_in_simpleexpr407 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FLOATCONST_in_simpleexpr435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UMINUS_in_simpleexpr463 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_FLOATCONST_in_simpleexpr465 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_simpleexpr493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRINGCONST_in_simpleexpr520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_assignstat551 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assignstat553 = new BitSet(new long[]{0x0000000005C30700L});
	public static final BitSet FOLLOW_expr_in_assignstat555 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_30_in_cond583 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_32_in_cond589 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_31_in_cond595 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond600 = new BitSet(new long[]{0x0000000005C30700L});
	public static final BitSet FOLLOW_expr_in_cond604 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_38_in_condstat644 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_condstat646 = new BitSet(new long[]{0x0000206010008000L});
	public static final BitSet FOLLOW_stat_in_condstat650 = new BitSet(new long[]{0x0000206010008008L});
	public static final BitSet FOLLOW_stat_in_condstat654 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_45_in_whilestat709 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_whilestat711 = new BitSet(new long[]{0x0000206010008000L});
	public static final BitSet FOLLOW_stat_in_whilestat713 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_37_in_forstat737 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assignstat_in_forstat741 = new BitSet(new long[]{0x00000001C0000000L});
	public static final BitSet FOLLOW_cond_in_forstat743 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_assignstat_in_forstat747 = new BitSet(new long[]{0x0000206010008000L});
	public static final BitSet FOLLOW_stat_in_forstat749 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_assignstat_in_stat798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condstat_in_stat804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whilestat_in_stat810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forstat_in_stat816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statlist_in_stat822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STATLIST_in_statlist842 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_in_statlist847 = new BitSet(new long[]{0x0000206010008008L});
	public static final BitSet FOLLOW_41_in_program869 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_program871 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_decllist_in_program873 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_statlist_in_program875 = new BitSet(new long[]{0x0000000000000008L});
}
