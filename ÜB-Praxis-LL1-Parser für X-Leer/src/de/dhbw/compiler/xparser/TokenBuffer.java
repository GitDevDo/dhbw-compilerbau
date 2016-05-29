/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis LL(1)-Parser f�r X
 * - Token-Puffer
 * 
 * **********************************************
 */

package de.dhbw.compiler.xparser;

import java.io.IOException;

public class TokenBuffer {
	
	private JFlexXScanner scanner;
	private int count = 0;
	private Token token = null;
	
	public TokenBuffer(JFlexXScanner scanner) throws IOException {
		this.scanner = scanner;
		token = scanner.nextToken();
		count++;
	}
	
	public Token nextToken() throws IOException {
		Token help = token;
		if (help.getType()!=Token.EOF) {
			token = scanner.nextToken();
			count++;
		}
		return help;
	}
	
	public Token lookaheadToken()  {
		return token;
	}
	
	public int getTokenCount() {
		return count;
	}

}
