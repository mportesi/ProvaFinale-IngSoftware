package Components;


import it.polimi.ingsw.GC_40.ColorDice;
import it.polimi.ingsw.GC_40.Player;
import java.util.ArrayList;
import java.util.List;

public class HarvestAndProductionArea {
	// it is necessary to keep a a leftPlayer because when the first player use
	// this area, there is a penalty for the others
	private Relative leftRelative;
	private List<Relative> rightRelatives;
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
			if (r.getPlayer() == player && r.getColor() != null){
				return true;
			}		
	}
		return false;
	}



	public Relative getLeftRelative() {
		return leftRelative;
	}

	public List<Relative> getRightRelatives() {
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

	
	

}
