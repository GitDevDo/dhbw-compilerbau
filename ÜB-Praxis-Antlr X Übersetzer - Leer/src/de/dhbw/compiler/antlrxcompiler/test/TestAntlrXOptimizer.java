/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis ANTLR-Parser f�r X
 * - Testsuite f�r Typ-Pr�fung
 * 
 * **********************************************
 */
package de.dhbw.compiler.antlrxcompiler.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAntlrXScanner1.class, TestAntlrXScanner2.class, TestAntlrXScanner3.class, 
	            TestAntlrXParser1.class, TestAntlrXParser2.class,
	            TestAntlrXOptimizer1.class})
public class TestAntlrXOptimizer {

}
