/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis AS-Scanner mit JFlex
 * - Token-Definition frac
 * 
 * **********************************************
 */

package de.dhbw.compiler.jflexasscanner;

public class FracToken extends Token {
	float value;
	
	public FracToken(int type, String text, float value, int line, int column) {
		super(type, text, line, column);
		this.value = value;
	}

	double getValue() {
		return this.value;
	}


}
