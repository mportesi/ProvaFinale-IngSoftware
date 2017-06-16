package it.polimi.ingsw.effects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Board;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.PrivilegeCouncil;
import it.polimi.ingsw.json.JsonPrivilegeCouncil;

public class GainPrivilegeCouncil extends Effect {
	private PrivilegeCouncil privilegeCouncil;
	private int privilege;
	private String resource;
	
	public GainPrivilegeCouncil(int privilege){
		this.privilege=privilege;
	}
	
	public GainPrivilegeCouncil(int privilege, String resource) throws FileNotFoundException, IOException, ParseException{
		this.privilege=privilege;
		this.resource = resource;
		JsonPrivilegeCouncil jsonPrivilegeCouncil= new JsonPrivilegeCouncil();
		jsonPrivilegeCouncil.importPrivilegeCouncil();
		this.privilegeCouncil=jsonPrivilegeCouncil.getPrivilegeCouncil();
	}
	
	public GainPrivilegeCouncil(String resource) throws FileNotFoundException, IOException, ParseException{
		this.resource = resource;
		JsonPrivilegeCouncil jsonPrivilegeCouncil= new JsonPrivilegeCouncil();
		jsonPrivilegeCouncil.importPrivilegeCouncil();
		this.privilegeCouncil=jsonPrivilegeCouncil.getPrivilegeCouncil();
	}
	
	@Override
	public void apply(Player player, Play play) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		privilegeCouncil.applyEffect(play, player, resource);
	}

	public void apply(Player player, String resource) {
		
	}
	

	@Override
	public String toString(){
		return ("Effect: gain" + privilege + " privilegeCouncil in "+ resource  );
	}


}
