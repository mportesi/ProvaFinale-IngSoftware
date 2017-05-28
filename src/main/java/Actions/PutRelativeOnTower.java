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
	Card cardtogive;

	public PutRelativeOnTower(Player player, Tower tower, int floor, Relative relative) {
		this.relative = relative;
		this.player = player;
		this.tower = tower;
		this.floor = floor;
	}

	public boolean isApplicable() {
		// TODO it misses the cost of the card
		if (tower.floors[floor].isFree() && relative.getValue() >= tower.floors[floor].getCost()
				&& tower.isPresent(player) == false) {
			return true;
		} else
			return false;
	}

	@Override
	public void apply() {
		if (isApplicable()) {
			// put the player on the chosen floor
			tower.floors[floor].setPlayer(player);
			// give the card to the player
			cardtogive = tower.floors[floor].giveCard();
			player.getCard(cardtogive);
			// apply immediate Effects of the Card
			cardtogive.applyEffect(player);
		}
		return;
	}
}
