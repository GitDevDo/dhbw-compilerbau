/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis X-Scanner mit JFlex
 * - Token-Definition intConst
 * 
 * **********************************************
 */

package de.dhbw.compiler.JFlexXScanner;

public class IntConstToken extends Token {
	private int value;
	
	public IntConstToken(int type, String text, int value, int line, int column) {
		super(type, text, line, column);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}


}
