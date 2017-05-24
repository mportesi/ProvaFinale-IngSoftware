package Effects;

import it.polimi.ingsw.GC_40.Player;

public class GainStone extends Effect {
	Long stone;
	
	public GainStone(Long stone){
		this.stone=stone;
	}

	@Override
	public void apply(Player player){
		// TODO Auto-generated method stub
		player.incrementStone(stone);

	}

}