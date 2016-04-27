/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis X Abstiegsparser
 * - Testfall-Utility f�r Parser
 * 
 * **********************************************
 */


package de.dhbw.compiler.xparser.test;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import de.dhbw.compiler.xparser.JFlexXScanner;
import de.dhbw.compiler.xparser.TokenReader;
import de.dhbw.compiler.xparser.Tree;
import de.dhbw.compiler.xparser.XParser;

public abstract class ParseTreeTest {
	
	protected void testParseTree(String in, String expected) throws Exception {
		JFlexXScanner scanner = new JFlexXScanner(new StringReader(in));
		TokenReader 	reader	= new TokenReader(scanner);
		XParser			parser	= new XParser(reader);
		
		Tree out = parser.parseProgram();
		
		if (out==null) {
			assertEquals(expected, out);
		} else {
			assertEquals(expected, out.toString());
		}
	}
	
}
