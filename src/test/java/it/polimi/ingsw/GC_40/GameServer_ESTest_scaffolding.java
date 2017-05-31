/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue May 30 13:39:12 CEST 2017
 */

package it.polimi.ingsw.GC_40;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;

@EvoSuiteClassExclude
public class GameServer_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "it.polimi.ingsw.GC_40.Play"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 


  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(GameServer_ESTest_scaffolding.class.getClassLoader() ,
      "Components.Servant",
      "Components.Resource",
      "Components.Coin",
      "it.polimi.ingsw.GC_40.Board",
      "it.polimi.ingsw.GC_40.ColorPlayer",
      "Effects.Effect",
      "Effects.GainWood",
      "it.polimi.ingsw.GC_40.JSon",
      "Effects.GainCoin",
      "Components.FaithPoint",
      "Components.MilitaryPoint",
      "Components.Wood",
      "Components.Point",
      "Components.Stone",
      "it.polimi.ingsw.GC_40.Player",
      "Effects.GainMilitaryPoint",
      "it.polimi.ingsw.GC_40.Play",
      "Components.Piece",
      "Effects.GainStone"
    );
  } 
}
