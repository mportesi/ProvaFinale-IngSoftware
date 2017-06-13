package it.polimi.ingsw.changes;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.colors.ColorPlayer;

public class ChangeCoin implements Change {
	private int coin;
	private Player player;

	public ChangeCoin(Player player, int coin) {
		this.coin = coin;
		this.player = player;
	}

	@Override
	public void applyChange(ClientModel client){
		System.out.println("sono nel change coin");
		if (client.getName().equals(player.getName())){
		//if(client.getPlayer().equals(client)){
			client.getPlayer().setCoin(coin);
		//}
			System.out.println("ho cambiato i coin");
		}
		//}
		/*for (Player p : client.getPlayers()) {
			if (player.equals(p)) {
				p.setCoin(coin);
			}
		}*/

	}
}

