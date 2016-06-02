/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis ANTLR-Parser f�r X
 * - Hilfsklasse f�r Scanner-tests
 * 
 * **********************************************
 */

package de.dhbw.compiler.antlrxtreegrammar.test;

import org.antlr.runtime.CommonToken;

public class TestToken extends CommonToken {
	
	private static final long serialVersionUID = 1L;

	public TestToken(int type, String text, int line, int column) {
		super(type, text);
		super.setLine(line);
		// Antlr beginnt mit 0, Kompatibilit�t zu anderen Tests
		super.setCharPositionInLine(column-1);
	}

}
