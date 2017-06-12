package it.polimi.ingsw.areas;


import it.polimi.ingsw.colors.ColorDice;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.components.Relative;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HarvestAndProductionArea implements Serializable {
	// it is necessary to keep a a leftPlayer because when the first player use
	// this area, there is a penalty for the others
	private Relative leftRelative;
	private ArrayList<Relative> rightRelatives;
	private int valueOfLeftArea;
	private int valueOfRightArea;
	private int malus;
	private String type;
	
	public HarvestAndProductionArea (String type, int valueOfLeftArea, int valueOfRightArea, int malus){
		this.type = type;
		this.valueOfLeftArea = valueOfLeftArea;
		this.valueOfRightArea = valueOfRightArea;
		this.malus = malus;
		this.rightRelatives = new ArrayList<Relative>();
		
	}
	
	public boolean isAlreadyPresent(Player player) {
		for (Relative r : rightRelatives){
			if (r.getPlayer()==null || !(r.getPlayer()==player && r.getColor() != null)){
				return false;
			}		
	}
		return true;
	}



	public Relative getLeftRelative() {
		return leftRelative;
	}

	public ArrayList<Relative> getRightRelatives() {
		return rightRelatives;
	}

	public void setLeftRelative(Relative relative) {
		leftRelative = relative;
	}

	public void setRightRelative(Relative relative) {
		rightRelatives.add(relative);
	}

	public int getValueOfLeftArea() {
		return valueOfLeftArea;
	}

	public int getMalus() {
		return malus;
	}

	public String getType() {
		return type;
	}

	public void refresh() {
		leftRelative = null;
		rightRelatives.clear();
	}

	public int getValueOfRightArea() {
		return valueOfRightArea;
	}

	
	@Override
	public String toString() {
		return ("The harvestAndProductionArea of type: " + type + " is: \n" + "The left value is " + valueOfLeftArea + "\n" + "The right value is "
				+ valueOfRightArea + "\n" + "The malus is " + malus + "\n");
	}

	

}
