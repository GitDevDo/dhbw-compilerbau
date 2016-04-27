/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * Praxis AS-Scanner mit JFlex
 * - Testsuite
 * 
 * **********************************************
 */

package de.dhbw.compiler.jflexasscanner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestASScanner1.class, TestASScanner2.class, TestASScanner3.class, TestASScanner4.class })
public class TestsAll {

}
