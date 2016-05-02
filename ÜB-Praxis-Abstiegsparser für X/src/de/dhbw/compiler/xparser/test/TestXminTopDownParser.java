/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis Xmin Abstiegsparser
 * - Testsuite f�r Xmin
 * 
 * **********************************************
 */
package de.dhbw.compiler.xparser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestXScanner1.class, TestXScanner2.class, TestXScanner3.class, 
				TestXminTopDownParser1.class })
public class TestXminTopDownParser {

}
