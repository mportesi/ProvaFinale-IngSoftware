package Actions;
import Components.CouncilPalace;
import Components.Relative;
import it.polimi.ingsw.GC_40.Player;
import Components.Piece;

public class PutRelativeOnCouncil extends PutRelative {

	Relative relative;
	Player player;
	CouncilPalace council;
	Piece piece;
	@Override
	public boolean isApplicable() {
		if (relative.getValue()>=1) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void apply() {
		if(isApplicable()){
			council.addPlayer(player);
			//TODO give player the council privilege bonus choice
			council.giveBonus(piece, player);
		}

	}

}
