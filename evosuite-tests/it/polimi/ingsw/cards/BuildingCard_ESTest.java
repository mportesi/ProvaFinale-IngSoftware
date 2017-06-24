/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 23 18:06:45 CEST 2017
 */

package it.polimi.ingsw.cards;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.BuildingListOfEffect;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class BuildingCard_ESTest extends BuildingCard_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      buildingCard0.alternativeCost = true;
      boolean boolean0 = buildingCard0.getGainPrivilegeCouncil();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      buildingCard0.alternativeCost = true;
      boolean boolean0 = buildingCard0.isGainPrivilegeCouncil();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      Integer integer0 = new Integer(1);
      hashMap0.put("stone", integer0);
      int int0 = buildingCard0.getCostStone();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      Integer integer0 = new Integer((-1));
      hashMap0.put("stone", integer0);
      int int0 = buildingCard0.getCostStone();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      Integer integer0 = new Integer(1);
      hashMap0.put("servant", integer0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostServant();
      assertEquals(1, int0);
      assertFalse(buildingCard0.getGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      Integer integer0 = new Integer((-1));
      hashMap0.put("servant", integer0);
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostServant();
      assertEquals((-1), int0);
      assertFalse(buildingCard0.isGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      Integer integer0 = new Integer(1);
      hashMap0.put("coin", integer0);
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostCoin();
      assertFalse(buildingCard0.getGainPrivilegeCouncil());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      Integer integer0 = new Integer((-1));
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      hashMap0.put("coin", integer0);
      int int0 = buildingCard0.getCostCoin();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, (Map<String, Integer>) null, buildingListOfEffect0);
      // Undeclared exception!
      try { 
        buildingCard0.getCostWood();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.cards.BuildingCard", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", (String) null, 0, (Map<String, Integer>) null, buildingListOfEffect0);
      // Undeclared exception!
      try { 
        buildingCard0.getCostStone();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.cards.BuildingCard", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect((Map<String, Integer>) null);
      BuildingCard buildingCard0 = null;
      try {
        buildingCard0 = new BuildingCard("", "", 0, (Map<String, Integer>) null, buildingListOfEffect0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.cards.BuildingListOfEffect", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      buildingCard0.setGainPrivilegeCouncil();
      assertFalse(buildingCard0.getGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Play play0 = new Play();
      Board board0 = new Board(play0, 0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostServant();
      assertFalse(buildingCard0.getGainPrivilegeCouncil());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostStone();
      assertEquals(0, int0);
      assertFalse(buildingCard0.isGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostWood();
      assertEquals(0, int0);
      assertFalse(buildingCard0.getGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      int int0 = buildingCard0.getCostCoin();
      assertFalse(buildingCard0.isGainPrivilegeCouncil());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      Play play0 = new Play();
      buildingCard0.applyEffect((Player) null, play0);
      assertFalse(buildingCard0.isGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      Integer integer0 = new Integer(0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      Play play0 = new Play();
      hashMap0.put("stone", integer0);
      try { 
        buildingCard0.payCost((Player) null, play0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("it.polimi.ingsw.cards.BuildingCard", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      Integer integer0 = new Integer(0);
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      hashMap0.put("coin", integer0);
      Play play0 = new Play();
      UUID uUID0 = UUID.randomUUID();
      Player player0 = new Player(uUID0, play0, "");
      buildingCard0.payCost(player0, play0);
      //  // Unstable assertion: assertEquals("dad24116-15d6-48f3-bedd-d4f8704b1584", uUID0.toString());
      //  // Unstable assertion: assertEquals((-2679007265220572941L), uUID0.getMostSignificantBits());
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      Integer integer0 = new Integer(0);
      hashMap0.put("", integer0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      Play play0 = new Play();
      buildingCard0.payCost((Player) null, play0);
      assertFalse(buildingCard0.isGainPrivilegeCouncil());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      BuildingListOfEffect buildingListOfEffect0 = new BuildingListOfEffect(hashMap0);
      BuildingCard buildingCard0 = new BuildingCard("", "", 0, hashMap0, buildingListOfEffect0);
      String string0 = buildingCard0.toString();
      assertEquals(":\n The cost is {}\n The immediate effects are []", string0);
      assertFalse(buildingCard0.isGainPrivilegeCouncil());
  }
}
