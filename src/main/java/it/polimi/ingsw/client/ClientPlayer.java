package it.polimi.ingsw.client;

import java.util.ArrayList;

import it.polimi.ingsw.cards.BuildingCard;
import it.polimi.ingsw.cards.CharacterCard;
import it.polimi.ingsw.cards.TerritoryCard;
import it.polimi.ingsw.cards.VentureCard;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.LeaderTile;
import it.polimi.ingsw.components.PersonalBonusTile;
import it.polimi.ingsw.components.Relative;

public class ClientPlayer {
	
	private ColorPlayer color;
	private int coin;
	private int wood;
	private int stone;
	private int servant;
	private int faithPoint;
	private int victoryPoint;
	private int militaryPoint;
	private ArrayList<TerritoryCard> territoryCard;
	private ArrayList<CharacterCard> characterCard;
	private ArrayList<BuildingCard> buildingCard;
	private ArrayList<VentureCard> ventureCard;
	private ArrayList<LeaderTile> leader;
	/*public ArrayList<Relative> relatives;*/
	public Relative blackRelative;
	public Relative whiteRelative;
	public Relative orangeRelative;
	public Relative neutralRelative;
	public PersonalBonusTile personalBonusTile;
	
	public void setCoin(int n){
		coin=n;
		
		
	}

}
