package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;

/**This class represents the action made at the beginning of the game, when a player gives his/her name to sign up to a match.
 * 
 * @author Chiara
 * 
 *
 */

public class RegisterClientSocket implements Serializable {
	private String name;
	public RegisterClientSocket(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}
