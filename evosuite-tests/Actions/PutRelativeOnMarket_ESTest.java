/*
 * This file was automatically generated by EvoSuite
 * Tue May 30 13:41:15 CEST 2017
 */

package Actions;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import Components.MarketBuilding;
import Components.Relative;
import it.polimi.ingsw.GC_40.ColorDice;
import it.polimi.ingsw.GC_40.ColorPlayer;
import it.polimi.ingsw.GC_40.Player;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class PutRelativeOnMarket_ESTest extends PutRelativeOnMarket_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      ColorDice colorDice0 = ColorDice.WHITE;
      Relative relative0 = new Relative(colorDice0);
      relative0.setValue(5);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, relative0);
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      MarketBuilding marketBuilding0 = new MarketBuilding((String) null, hashMap0, 5);
      putRelativeOnMarket0.setMarket(marketBuilding0);
      boolean boolean0 = putRelativeOnMarket0.isApplicable();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, (Relative) null);
      // Undeclared exception!
      try { 
        putRelativeOnMarket0.apply();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Actions.PutRelativeOnMarket", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      ColorDice colorDice0 = ColorDice.WHITE;
      Relative relative0 = new Relative(colorDice0);
      relative0.setValue(5);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, relative0);
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      MarketBuilding marketBuilding0 = new MarketBuilding((String) null, hashMap0, 0);
      putRelativeOnMarket0.setMarket(marketBuilding0);
      boolean boolean0 = putRelativeOnMarket0.isApplicable();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      ColorDice colorDice0 = ColorDice.WHITE;
      Relative relative0 = new Relative(colorDice0);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, relative0);
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      MarketBuilding marketBuilding0 = new MarketBuilding((String) null, hashMap0, 1);
      putRelativeOnMarket0.setMarket(marketBuilding0);
      putRelativeOnMarket0.apply();
      assertFalse(putRelativeOnMarket0.isApplicable());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      ColorDice colorDice0 = ColorDice.WHITE;
      Relative relative0 = new Relative(colorDice0);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, relative0);
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      MarketBuilding marketBuilding0 = new MarketBuilding((String) null, hashMap0, 1);
      putRelativeOnMarket0.setMarket(marketBuilding0);
      boolean boolean0 = putRelativeOnMarket0.isApplicable();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      ColorDice colorDice0 = ColorDice.WHITE;
      Relative relative0 = new Relative(colorDice0);
      relative0.setValue(5);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, relative0);
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      MarketBuilding marketBuilding0 = new MarketBuilding((String) null, hashMap0, 0);
      putRelativeOnMarket0.setMarket(marketBuilding0);
      assertTrue(putRelativeOnMarket0.isApplicable());
      
      putRelativeOnMarket0.apply();
      boolean boolean0 = putRelativeOnMarket0.isApplicable();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ColorPlayer colorPlayer0 = ColorPlayer.YELLOW;
      Player player0 = new Player(colorPlayer0);
      PutRelativeOnMarket putRelativeOnMarket0 = new PutRelativeOnMarket(player0, player0.neutralRelative);
      HashMap<String, Integer> hashMap0 = new HashMap<String, Integer>();
      MarketBuilding marketBuilding0 = new MarketBuilding((String) null, hashMap0, 0);
      putRelativeOnMarket0.setMarket(marketBuilding0);
      // Undeclared exception!
      try { 
        putRelativeOnMarket0.isApplicable();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Actions.PutRelativeOnMarket", e);
      }
  }
}
