package Actions;

import Components.CouncilPalace;
import Components.Relative;
import it.polimi.ingsw.GC_40.Player;
import Components.Piece;

public class PutRelativeOnCouncilPalace extends PutRelative {

	Relative relative;
	Player player;
	CouncilPalace councilPalace;
	Piece piece;

	@Override
	public boolean isApplicable() {
		// the required value is 1 to put a relative on the CouncilPalace
		if (relative.getValue() >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void apply() {
		if (isApplicable()) {
			// The player puts a relative on the councilPalace
			councilPalace.addPlayer(player);
			// The player receive the bonus
			// TODO give player the council privilege bonus choice
			councilPalace.giveBonus(piece, player);
		}

	}

}
