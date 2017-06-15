package it.polimi.ingsw.changes;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.areas.Floor;
import it.polimi.ingsw.areas.Tower;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;

public class ChangeTower implements Change {
	private Tower tower;
	private int floor;
	private Relative relative;
	private Player player;
	
	public ChangeTower(Tower tower, int floor, Player player, Relative relative){
		this.tower=tower;
		this.floor=floor;
		this.relative=relative;
		this.player=player;
	}

	@Override
	public void applyChange(ClientModel client) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		client.setTower(tower, floor, player, relative);
		System.out.println("\nThe player " + player + " put a relative on the " + tower.getType() + " tower, on the floor n°" + floor);
		System.out.println("\n"+ client.getBoard());
	}

}
