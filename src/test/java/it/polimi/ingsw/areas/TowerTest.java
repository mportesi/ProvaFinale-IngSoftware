package it.polimi.ingsw.areas;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.effects.GainCoin;
import it.polimi.ingsw.effects.GainPrivilegeCouncil;

public class TowerTest {

	@Test
	public void testRefreshTower() {
		 ArrayList<Card> cards = new ArrayList<Card>();
	      ArrayList<Floor> floors = new ArrayList<Floor>();
	      Play play=null;
	      try {
			play = new Play(0);
	      } catch (NullPointerException | IOException | ParseException e1) {
			e1.printStackTrace();
	      }
	      Tower tower = new Tower("", cards, cards, cards, floors, play);
	      Card card=new Card(null, null, 1);
	      cards.add(card);
	      cards.add(card);
	      cards.add(card);
	      cards.add(card);
	      GainCoin gainCoin= new GainCoin(0);
	      Floor floor = new Floor((String) null, 0, gainCoin);
	      Floor floor1 = new Floor((String) null, 0, gainCoin);
	      Floor floor2 = new Floor((String) null, 0, gainCoin);
	      Floor floor3 = new Floor((String) null, 0, gainCoin);
	      floors.add(floor);
	      floors.add(floor1);
	      floors.add(floor2);
	      floors.add(floor3);
	      tower.refreshTower(1);
	      assertTrue(floor.getCard().equals(card));
	      assertFalse(tower.isPresentAnyone());
	}
	
	@Test
	public void testIsPresentAnyone0() {
		  ArrayList<Card> cards = new ArrayList<Card>();
	      ArrayList<Floor> floors = new ArrayList<Floor>();
	      Play play=null;
	      try {
			play = new Play(0);
	      } catch (NullPointerException | IOException | ParseException e1) {
			e1.printStackTrace();
	      }
	      Tower tower = new Tower("", cards, cards, cards, floors, play);
	      GainCoin gainCoin= new GainCoin(0);
	      Floor floor = new Floor((String) null, 0, gainCoin);
	      floors.add(floor);
	      boolean isPresent= tower.isPresentAnyone();
	      assertFalse(isPresent);
	}
	
	@Test
	public void testIsPresentAnyone1() {
		  ArrayList<Card> cards = new ArrayList<Card>();
	      ArrayList<Floor> floors = new ArrayList<Floor>();
	      Play play=null;
	      try {
			play = new Play(0);
	      } catch (NullPointerException | IOException | ParseException e1) {
			e1.printStackTrace();
	      }
	      Tower tower = new Tower("", cards, cards, cards, floors, play);
	      UUID uUID = UUID.randomUUID();
	      Player player = new Player(uUID, play, "", 0);
	      GainCoin gainCoin= new GainCoin(0);
	      Floor floor = new Floor((String) null, 0, gainCoin);
	      Relative relative = new Relative(ColorDice.BLACK, player);
	      try {
			floor.setPlayer(player, relative, tower, 0);
	      } catch (NullPointerException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
	      }
	      floors.add(floor);
	      boolean isPresent= tower.isPresentAnyone();
	      assertTrue(isPresent);
	}

	@Test
	public void testIsPresent0() {
		ArrayList<Card> cards = new ArrayList<Card>();
	      ArrayList<Floor> floors = new ArrayList<Floor>();
	      Play play=null;
	      try {
			play = new Play(0);
	      } catch (NullPointerException | IOException | ParseException e1) {
			e1.printStackTrace();
	      }
	      Tower tower = new Tower("", cards, cards, cards, floors, play);
	      UUID uUID1 = UUID.randomUUID();
	      Player player1 = new Player(uUID1, play, "", 0);
	      UUID uUID2 = UUID.randomUUID();
	      Player player2 = new Player(uUID2, play, "",0);
	      GainCoin gainCoin= new GainCoin(0);
	      Floor floor = new Floor((String) null, 0, gainCoin);
	      Relative relative = new Relative(ColorDice.BLACK, player1);
	      try {
				floor.setPlayer(player1, relative, tower, 0);
		      } catch (NullPointerException | IOException | ParseException | InterruptedException e) {
				e.printStackTrace();
		      }
		      floors.add(floor);
		      boolean isPresent= tower.isPresent(player2);
		      assertFalse(isPresent);
	}
	
	@Test
	public void testIsPresent1() {
		ArrayList<Card> cards = new ArrayList<Card>();
	      ArrayList<Floor> floors = new ArrayList<Floor>();
	      Play play=null;
	      try {
			play = new Play(0);
	      } catch (NullPointerException | IOException | ParseException e1) {
			e1.printStackTrace();
	      }
	      Tower tower = new Tower("", cards, cards, cards, floors, play);
	      UUID uUID1 = UUID.randomUUID();
	      Player player1 = new Player(uUID1, play, "", 0);
	      GainCoin gainCoin= new GainCoin(0);
	      Floor floor = new Floor((String) null, 0, gainCoin);
	      Relative relative = new Relative(ColorDice.BLACK, player1);
	      try {
				floor.setPlayer(player1, relative, tower, 0);
		      } catch (NullPointerException | IOException | ParseException | InterruptedException e) {
				e.printStackTrace();
		      }
		      floors.add(floor);
		      boolean isPresent= tower.isPresent(player1);
		      assertTrue(isPresent);
	}
	
	public void testHashCode()  throws Throwable{
	      ArrayList<Card> arrayList0 = new ArrayList<Card>();
	      LinkedList<Floor> linkedList0 = new LinkedList<Floor>();
	      ArrayList<Floor> arrayList1 = new ArrayList<Floor>(linkedList0);
	      Play play0 = new Play(0);
	      Tower tower0 = new Tower("M", arrayList0, arrayList0, arrayList0, arrayList1, play0);
	      tower0.hashCode();
	  }
	
	public void testEquals1()  throws Throwable  {
	      ArrayList<Card> arrayList0 = new ArrayList<Card>();
	      LinkedList<Floor> linkedList0 = new LinkedList<Floor>();
	      ArrayList<Floor> arrayList1 = new ArrayList<Floor>(linkedList0);
	      Play play0 = new Play(0);
	      Tower tower0 = new Tower("M", arrayList0, arrayList0, arrayList0, arrayList1, play0);
	      String string0 = tower0.getType();
	      assertEquals("M", string0);
	  }
	
	 public void testEquals2()  throws Throwable  {
	      ArrayList<Card> arrayList0 = new ArrayList<Card>();
	      Play play0 = new Play(0);
	      Tower tower0 = new Tower("", arrayList0, arrayList0, arrayList0, (ArrayList<Floor>) null, play0);
	      String string0 = tower0.getType();
	      assertEquals("", string0);
	  }
	 
	 

}
