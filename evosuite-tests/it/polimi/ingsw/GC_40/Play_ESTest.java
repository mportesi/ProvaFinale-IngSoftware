/*
 * This file was automatically generated by EvoSuite
 * Tue May 30 10:36:23 CEST 2017
 */

package it.polimi.ingsw.GC_40;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class Play_ESTest extends Play_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.BLUE;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(player0);
      Play play0 = new Play(4, 0, arrayList0);
      play0.changePeriod();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      arrayList0.add((Player) null);
      Play play0 = new Play(0, 0, arrayList0);
      // Undeclared exception!
      try { 
        play0.changeRound();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.GREEN;
      Player player0 = new Player(colorPlayer0);
      Player player1 = new Player(colorPlayer0);
      arrayList0.add(player1);
      arrayList0.add(player0);
      arrayList0.add(player1);
      Play play0 = new Play(0, 0, arrayList0);
      play0.changeCurrentPlayer();
      play0.changeCurrentPlayer();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.RED;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(player0);
      Play play0 = new Play(0, 0, arrayList0);
      ArrayList<String> arrayList1 = new ArrayList<String>();
      arrayList0.retainAll(arrayList1);
      ArrayList<Player> arrayList2 = play0.checkWinner();
      assertNotSame(arrayList2, arrayList0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      arrayList0.add((Player) null);
      Play play0 = new Play(0, 0, arrayList0);
      // Undeclared exception!
      try { 
        play0.checkWinner();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.GREEN;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(player0);
      Play play0 = new Play(0, 0, arrayList0);
      // Undeclared exception!
      try { 
        play0.changeTurnOrder();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.BLUE;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(player0);
      Play play0 = new Play(0, 0, arrayList0);
      arrayList0.removeAll(arrayList0);
      // Undeclared exception!
      try { 
        play0.changeCurrentPlayer();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Play play0 = null;
      try {
        play0 = new Play(0, 0, (ArrayList<Player>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.GREEN;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(player0);
      Play play0 = new Play(0, 0, arrayList0);
      ArrayList<Player> arrayList1 = play0.checkWinner();
      assertEquals(1, arrayList1.size());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      arrayList0.add((Player) null);
      Play play0 = new Play(2, 0, arrayList0);
      play0.changePeriod();
      // Undeclared exception!
      try { 
        play0.changePeriod();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      arrayList0.add((Player) null);
      Play play0 = new Play(0, 6, arrayList0);
      // Undeclared exception!
      try { 
        play0.changeRound();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.RED;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(player0);
      Play play0 = new Play(0, 4, arrayList0);
      // Undeclared exception!
      try { 
        play0.changeRound();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.GREEN;
      Player player0 = new Player(colorPlayer0);
      arrayList0.add(0, player0);
      Play play0 = new Play(0, 2, arrayList0);
      // Undeclared exception!
      try { 
        play0.changeRound();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.GC_40.Play", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      ColorPlayer colorPlayer0 = ColorPlayer.GREEN;
      Player player0 = new Player(colorPlayer0);
      Player player1 = new Player(colorPlayer0);
      arrayList0.add(player1);
      arrayList0.add(player0);
      Play play0 = new Play(0, 0, arrayList0);
      play0.changeCurrentPlayer();
      play0.changeCurrentPlayer();
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      ArrayList<Player> arrayList0 = new ArrayList<Player>();
      Play play0 = null;
      try {
        play0 = new Play(0, 0, arrayList0);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }
}
