/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis X Abstiegsparser
 * - Token-Definition intConst
 * 
 * **********************************************
 */

package de.dhbw.compiler.xparser;

public class IntConstToken extends Token {
	
	private int value=0;
	
	public IntConstToken(int type, String text, int line, int column, int value) {
		super(type,text,line,column);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}


}
