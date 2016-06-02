/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis ANTLR-Parser f�r X
 * - Testsuite f�r leere Baum-Grammatik
 * 
 * **********************************************
 */
package de.dhbw.compiler.antlrxtreegrammar.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAntlrXScanner1.class, TestAntlrXScanner2.class, TestAntlrXScanner3.class, 
	            TestAntlrXParser1.class, TestAntlrXParser2.class,
	            TestAntlrXTreeGrammar1.class, TestAntlrXTreeGrammar2.class})
public class TestAntlrXTreeGrammar {

}
