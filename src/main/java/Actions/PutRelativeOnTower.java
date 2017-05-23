package Actions;

import Components.Card;
import Components.Relative;
import Components.Tower;
import it.polimi.ingsw.GC_40.Player;

public class PutRelativeOnTower extends PutRelative  {
	Tower tower;
	Relative relative;
	int floor;
	Player player;
	Card cardtogive;
	
	public boolean isApplicable(){
		if(tower.floors[floor].isFree()&& relative.getValue()>= tower.floors[floor].getCost() && tower.isPresent(player)==false)
			 {return true;}
		else return false;
	}
	@Override
	public void apply(){
		if(isApplicable()){
				tower.floors[floor].setPlayer(player);
				cardtogive= tower.floors[floor].giveCard();
				player.getCard(cardtogive); //need to add getCard method to player, to set a given card in the current player deck based on type.
			}
		return;
	}
}
