/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis LL(1)-Parser f�r X
 * - Token-Definition stringConst
 * 
 * **********************************************
 */

package de.dhbw.compiler.xparser;

public class StringConstToken extends Token {
	
	private String value="";
	
	public StringConstToken(int type, String text, int line, int column, String value) {
		super(type,text,line,column);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}


}
