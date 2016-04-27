/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis X-Scanner mit JFlex
 * - Token-Definition stringConst
 * 
 * **********************************************
 */

package de.dhbw.compiler.JFlexXScanner;

public class StringConstToken extends Token {
	String value;
	
	public StringConstToken(int type, String text, String value, int line, int column) {
		super(type, text, line, column);
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}


}
