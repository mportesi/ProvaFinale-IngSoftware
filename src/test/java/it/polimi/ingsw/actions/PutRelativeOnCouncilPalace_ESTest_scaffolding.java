/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Jun 08 08:28:22 CEST 2017
 */

package it.polimi.ingsw.actions;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;

@EvoSuiteClassExclude
public class PutRelativeOnCouncilPalace_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "it.polimi.ingsw.actions.PutRelativeOnCouncilPalace"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PutRelativeOnCouncilPalace_ESTest_scaffolding.class.getClassLoader() ,
      "it.polimi.ingsw.effects.GainCoin",
      "it.polimi.ingsw.changes.Change",
      "it.polimi.ingsw.actions.PutRelative",
      "it.polimi.ingsw.colors.ColorPlayer",
      "it.polimi.ingsw.components.Relative",
      "it.polimi.ingsw.GC_40.Observable",
      "it.polimi.ingsw.cards.Card",
      "it.polimi.ingsw.components.PersonalBonusTile",
      "it.polimi.ingsw.actions.Action",
      "it.polimi.ingsw.GC_40.Observer",
      "it.polimi.ingsw.areas.CouncilPalace",
      "it.polimi.ingsw.actions.PutRelativeOnCouncilPalace",
      "it.polimi.ingsw.changes.ChangeCouncilPalace",
      "it.polimi.ingsw.GC_40.Player",
      "it.polimi.ingsw.effects.Effect",
      "it.polimi.ingsw.colors.ColorDice"
    );
  } 
}
