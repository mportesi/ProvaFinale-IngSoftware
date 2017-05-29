package Actions;

import Components.Card;
import Components.Relative;
import Components.Tower;
import it.polimi.ingsw.GC_40.Player;

public class PutRelativeOnTower extends PutRelative {
	Tower tower;
	Relative relative;
	int floor;
	Player player;
	Card cardToGive;
	
	public PutRelativeOnTower(Player player, Tower tower, int floor, Relative relative){
		this.relative=relative;
		this.player=player;
		this.tower=tower;
		this.floor=floor;
	}
	
	public boolean isApplicable(){
		if(tower.floors.get(floor).isFree() && relative.getValue()>= tower.floors.get(floor).getCost() && tower.isPresent(player)==false)
			 {
			return true;
			 }
		else return false;
	}
	
	
	@Override
	public void apply(){
		if(isApplicable()){
				tower.floors.get(floor).setPlayer(player);
				cardToGive= tower.floors.get(floor).giveCard();
				player.getCard(cardToGive);
				cardToGive.applyEffect(player);
				tower.floors.get(floor).bonusEffect.apply(player);
			}
		return;
	}
}
