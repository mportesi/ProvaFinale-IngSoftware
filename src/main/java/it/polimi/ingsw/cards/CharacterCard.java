
package it.polimi.ingsw.cards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.effects.*;
/**
 * @author Sara
 * This is the subclass of the character card
 */
public class CharacterCard extends Card {
	private int costCoin;
	private String card;
	private int value;
	private Map<String, Integer> discount;
	private CharacterListOfEffect effects;
	private ArrayList<Effect> immediateEffects;
	private boolean gainPrivilegeCouncil=false;

	public CharacterCard(String type, String name, int period, int costCoin, CharacterListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.costCoin = costCoin;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
		setGainPrivilegeCouncil();
	}

	public CharacterCard(String type, String name, int period, int costCoin, String card, int value,
			Map<String, Integer> discount, CharacterListOfEffect effects) throws FileNotFoundException, IOException, ParseException {
		super(type, name, period);
		this.costCoin = costCoin;
		this.card = card;
		this.getCard=true;
		this.value = value;
		this.discount = discount;
		this.effects=effects;
		immediateEffects = effects.createListOfEffect();
	}

	/**
	 * @author Sara
	 * To pay the required resources when the card is taken by a player
	 */
	@Override
	public void payCost(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		player.decrementCoin(costCoin, play);
	}
	
	@Override
	public String toString(){
		return (name + ":\n" + "The cost is "+ costCoin +"\n"+ "The immediate effects are " + immediateEffects );
	}
	
	/**
	 * @author Sara
	 * To apply immediate effects when a player takes the card
	 */
	@Override
	public void applyEffect(Player player , Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		

		for (Effect e : immediateEffects) {
			if (e != null) {
				e.apply(player, play);
			}
			return;
		}
	}
	
	/**
	 * @author Sara
	 * To apply the effect gain privilege is necessary to use another method that ask to the player what resource he wants.
	 */
	public void applyPrivilegeBonus(Play play, Player player, String resource) throws InterruptedException{
		try {
			GainPrivilegeCouncil gain= new GainPrivilegeCouncil(resource);
			gain.apply(player, play);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public int getCostCoin(){
		return costCoin;
	}
	public boolean isGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}
	public String getSecondCard(){
		return card;
	}
	public int getSecondCardValue(){
		return value;
	}
	public int getDiscountCoin(){
		return discount.get("coin");
	}
	public int getDiscountWood(){
		return discount.get("wood");
	}
	public int getDiscountStone(){
		return discount.get("stone");
	}
	public int getDiscountServant(){
		return discount.get("servant");
	}
	public void setGainPrivilegeCouncil() {
		for (Effect e : this.immediateEffects) {
			if (e instanceof HasPrivilege) {
				this.gainPrivilegeCouncil = true;
			}
		}
		
	}
	public boolean getGainPrivilegeCouncil() {
		return gainPrivilegeCouncil;
	}
	
}