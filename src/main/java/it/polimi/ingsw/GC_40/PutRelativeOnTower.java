package it.polimi.ingsw.GC_40;

public class PutRelativeOnTower extends PutRelative  {
	Tower tower;
	Relative relative;
	int floor;
	Player player;
	Card cardtogive;
	@Override
	public void apply(){
		if (!tower.isPresent(player)){
			if(tower.floors[floor].isFree()&& relative.getValue()>= tower.floors[floor].getCost()){
				tower.floors[floor].setPlayer(player);
				cardtogive= tower.floors[floor].giveCard();
				player.getCard(cardtogive); //need to add getCard method to player, to set a given card in the current player deck based on type.
			}
			else{
				System.out.println("floor already occupied, choose another one");
			}
		}
		else{
			System.out.println("Familiar already placed on this tower!");
		}
		return;
	}
}
