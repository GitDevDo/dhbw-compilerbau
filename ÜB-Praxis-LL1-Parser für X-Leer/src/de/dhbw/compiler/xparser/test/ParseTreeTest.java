/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis LL(1)-Parser f�r X
 * - Testfall-Utility f�r Scanner
 * 
 * **********************************************
 */


package de.dhbw.compiler.xparser.test;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import de.dhbw.compiler.xparser.JFlexXScanner;
import de.dhbw.compiler.xparser.TokenBuffer;
import de.dhbw.compiler.xparser.Tree;
import de.dhbw.compiler.xparser.XParser;

public abstract class ParseTreeTest {
	
	protected void testParseTree(String in, String expected) throws Exception {
		JFlexXScanner scanner = new JFlexXScanner(new StringReader(in));
		TokenBuffer 	buffer	= new TokenBuffer(scanner);
		XParser			parser	= new XParser(buffer);
		
		Tree out = parser.parseProgram();
		
		if (out==null) {
			assertEquals(expected, out);
		} else {
			assertEquals(expected, out.toString());
		}
	}
	
}
