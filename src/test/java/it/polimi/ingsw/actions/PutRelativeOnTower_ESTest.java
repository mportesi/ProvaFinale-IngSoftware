/*
 * This file was automatically generated by EvoSuite
 * Thu Jun 08 08:33:41 CEST 2017
 */

package it.polimi.ingsw.actions;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.components.Relative;
import java.util.ArrayList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class PutRelativeOnTower_ESTest extends PutRelativeOnTower_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Player player0 = new Player();
      PutRelativeOnTower putRelativeOnTower0 = new PutRelativeOnTower(player0, (Tower) null, 0, (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnTower0.isApplicable();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.actions.PutRelativeOnTower", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Player player0 = new Player();
      ArrayList<Card> arrayList0 = new ArrayList<Card>();
      ArrayList<Floor> arrayList1 = new ArrayList<Floor>();
      Tower tower0 = new Tower("", arrayList0, arrayList0, arrayList0, arrayList1);
      PutRelativeOnTower putRelativeOnTower0 = new PutRelativeOnTower(player0, tower0, 0, (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnTower0.isApplicable();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Player player0 = new Player();
      ArrayList<Card> arrayList0 = new ArrayList<Card>();
      ArrayList<Floor> arrayList1 = new ArrayList<Floor>();
      Tower tower0 = new Tower("", arrayList0, arrayList0, arrayList0, arrayList1);
      PutRelativeOnTower putRelativeOnTower0 = new PutRelativeOnTower(player0, tower0, (-1), (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnTower0.isApplicable();
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Player player0 = new Player();
      PutRelativeOnTower putRelativeOnTower0 = new PutRelativeOnTower(player0, (Tower) null, 0, (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnTower0.apply();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.actions.PutRelativeOnTower", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Player player0 = new Player();
      ArrayList<Card> arrayList0 = new ArrayList<Card>();
      ArrayList<Floor> arrayList1 = new ArrayList<Floor>();
      Tower tower0 = new Tower("", arrayList0, arrayList0, arrayList0, arrayList1);
      PutRelativeOnTower putRelativeOnTower0 = new PutRelativeOnTower(player0, tower0, 0, (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnTower0.apply();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ArrayList<Card> arrayList0 = new ArrayList<Card>();
      ArrayList<Floor> arrayList1 = new ArrayList<Floor>();
      Tower tower0 = new Tower("", arrayList0, arrayList0, arrayList0, arrayList1);
      PutRelativeOnTower putRelativeOnTower0 = new PutRelativeOnTower((Player) null, tower0, (-1), (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnTower0.apply();
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
}
