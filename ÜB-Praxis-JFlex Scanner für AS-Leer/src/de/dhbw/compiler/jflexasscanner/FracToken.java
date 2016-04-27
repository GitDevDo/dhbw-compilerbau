/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
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
