/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 08 08:44:30 CEST 2017
 */

package it.polimi.ingsw.GC_40;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import it.polimi.ingsw.GC_40.JSon;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class JSon_ESTest extends JSon_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      // Undeclared exception!
      JSon.importCards();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      JSon jSon0 = new JSon();
      //  // Unstable assertion: assertEquals(0, JSon.victoryPointForTheFirst);
  }
}