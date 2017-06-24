package it.polimi.ingsw.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;

public class RegisterClientSocket implements Serializable {
	private String name;
	public RegisterClientSocket(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}
