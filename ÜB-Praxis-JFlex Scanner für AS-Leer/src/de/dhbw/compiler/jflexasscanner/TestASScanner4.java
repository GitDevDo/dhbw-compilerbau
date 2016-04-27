/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis AS-Scanner mit JFlex
 * - Testf�lle Aufgabe 3
 * 
 * **********************************************
 */

package de.dhbw.compiler.jflexasscanner;

import org.junit.Test;

public class TestASScanner4 extends TokenStreamTest {
	
	@Test
	public void tokenTo() throws Exception {
		testTokenList("  .. ", false, new Token(Token.TO,"..",1,3));
	}

	@Test
	public void tokenNumToNum() throws Exception {
		testTokenList("  4 .. 5 ", false, 
				new Token(Token.NUM,"4",1,3), 
				new Token(Token.TO,"..",1,5), 
				new Token(Token.NUM,"5",1,8));
		System.out.println("test1 done");
		testTokenList("  4..5 ", false, 
				new Token(Token.NUM,"4",1,3), 
				new Token(Token.TO,"..",1,4), 
				new Token(Token.NUM,"5",1,6));
		System.out.println("test2 done");
		testTokenList("  4......5 ", false, 
				new Token(Token.NUM,"4",1,3), 
				new Token(Token.TO,"..",1,4), 
				new Token(Token.TO,"..",1,6), 
				new Token(Token.TO,"..",1,8), 
				new Token(Token.NUM,"5",1,10));
		System.out.println("test3 done");
	}

	@Test
	public void tokenFracToNum() throws Exception {
		testTokenList("  4. .. 5 ", false, 
				new Token(Token.FRAC,"4.",1,3), 
				new Token(Token.TO,"..",1,6), 
				new Token(Token.NUM,"5",1,9));
		testTokenList("  4.5 ", false, new Token(Token.FRAC,"4.5",1,3));
		testTokenList("  4...5 ", false, 
				new Token(Token.FRAC,"4.",1,3), 
				new Token(Token.TO,"..",1,5), 
				new Token(Token.NUM,"5",1,7));
		testTokenList("  4.......5 ", false, 
				new Token(Token.FRAC,"4.",1,3), 
				new Token(Token.TO,"..",1,5), 
				new Token(Token.TO,"..",1,7), 
				new Token(Token.TO,"..",1,9), 
				new Token(Token.NUM,"5",1,11));
	}

}
