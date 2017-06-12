package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.json.JsonPrivilegeCouncil;

public class GainPrivilegeCouncil extends Effect {
	private PrivilegeCouncil privilegeCouncil;
	private int privilege;
	private String resource;
	
	public GainPrivilegeCouncil(int privilege, String resource) throws FileNotFoundException, IOException, ParseException{
		this.privilege=privilege;
		this.resource = resource;
		JsonPrivilegeCouncil jsonPrivilegeCouncil= new JsonPrivilegeCouncil();
		jsonPrivilegeCouncil.importPrivilegeCouncil();
		this.privilegeCouncil=jsonPrivilegeCouncil.getPrivilegeCouncil();
	}

	@Override
	public void apply(Player player) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		// Resource resource = chooseResource();
		privilegeCouncil.applyEffect(player, resource);
		
	//metto uno switch e incremento a seconda del case

	}

	public void apply(Player player, String resource) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public String toString(){
		return ("Effect: gain " + privilegeCouncil + " privilegeCouncil in "+ resource  );
	}


}
