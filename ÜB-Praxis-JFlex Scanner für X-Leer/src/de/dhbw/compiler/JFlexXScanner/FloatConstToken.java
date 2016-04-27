/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis X-Scanner mit JFlex
 * - Token-Definition floatConst
 * 
 * **********************************************
 */

package de.dhbw.compiler.JFlexXScanner;

public class FloatConstToken extends Token {
	private float value;
	
	public FloatConstToken(int type, String text, float value, int line, int column) {
		super(type, text, line, column);
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
}
