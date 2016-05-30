// $ANTLR 3.5.2 C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g 2016-05-09 13:42:27
package de.dhbw.compiler.antlrxparser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class XLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int DECL=4;
	public static final int DECLLIST=5;
	public static final int INVALID=6;
	public static final int STATLIST=7;
	public static final int UMINUS=8;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public XLexer() {} 
	public XLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public XLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:9:6: ( 'TODO' )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:9:8: 'TODO'
			{
			match("TODO"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "INVALID"
	public final void mINVALID() throws RecognitionException {
		try {
			int _type = INVALID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:31:8: ( . )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:31:11: .
			{
			matchAny(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INVALID"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:1:8: ( T__9 | INVALID )
		int alt1=2;
		int LA1_0 = input.LA(1);
		if ( (LA1_0=='T') ) {
			int LA1_1 = input.LA(2);
			if ( (LA1_1=='O') ) {
				alt1=1;
			}

			else {
				alt1=2;
			}

		}
		else if ( ((LA1_0 >= '\u0000' && LA1_0 <= 'S')||(LA1_0 >= 'U' && LA1_0 <= '\uFFFF')) ) {
			alt1=2;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 1, 0, input);
			throw nvae;
		}

		switch (alt1) {
			case 1 :
				// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// C:\\Users\\eisenbiegler\\Dropbox\\workspace_üb\\ÜB-Praxis-Antlr Parser für X-Leer\\src\\de\\dhbw\\compiler\\antlrxparser\\X.g:1:15: INVALID
				{
				mINVALID(); 

				}
				break;

		}
	}



}
