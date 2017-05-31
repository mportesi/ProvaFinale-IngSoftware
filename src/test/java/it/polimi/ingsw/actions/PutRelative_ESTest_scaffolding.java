/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue May 30 13:45:08 CEST 2017
 */

package it.polimi.ingsw.actions;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;

@EvoSuiteClassExclude
public class PutRelative_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "Actions.PutRelative"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PutRelative_ESTest_scaffolding.class.getClassLoader() ,
      "Actions.PutRelative",
      "Components.Card",
      "Actions.PutRelativeOnProductionArea",
      "Components.Market",
      "it.polimi.ingsw.GC_40.ColorPlayer",
      "Components.Relative",
      "it.polimi.ingsw.GC_40.ColorDice",
      "Actions.PutRelativeOnMarket",
      "Components.Floor",
      "Components.HarvestAndProductionArea",
      "Actions.PutRelativeOnTower",
      "Components.Tower",
      "Components.MarketBuilding",
      "it.polimi.ingsw.GC_40.Player",
      "Components.PersonalBonusTile",
      "Actions.PutRelativeOnCouncilPalace",
      "Components.Piece"
    );
  } 
}
