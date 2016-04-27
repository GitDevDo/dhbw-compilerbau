/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis AS-Scanner mit JFlex
 * 
 * **********************************************
 */

package de.dhbw.compiler.jflexasscanner;

import java.io.StringReader;


public class JFlexASScannerMain {
	
	private static final String TEST = "[34, x,peter,  34kurt, g56, null,null, 8] ";
	
	public static void main(String[] args) throws Exception {
		
		JFlexASScanner scanner = new JFlexASScanner(new StringReader(TEST));
		
		/* 
		 * Lesen Sie hier die einzelnen Token des oben angebenen String mit Hilfe des 
		 * Scanners ein und geben Sie sie auf die Konsole aus. 
		 */
		Token token = scanner.nextToken();
		
		while (token.getType() != Token.EOF) {
			System.out.println(token.getText());
			token = scanner.nextToken();
		}
	}

}
