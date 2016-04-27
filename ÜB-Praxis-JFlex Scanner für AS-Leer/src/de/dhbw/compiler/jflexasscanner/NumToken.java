/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Praxis AS-Scanner mit JFlex
 * - Token-Definition num
 * 
 * **********************************************
 */

package de.dhbw.compiler.jflexasscanner;

public class NumToken extends Token {
	int value;
	
	public NumToken(int type, String text, int value, int line, int column) {
		super(type,text,line,column);
		this.value = value;
	}
	
	int getValue() {
		return this.value;
	}


}
