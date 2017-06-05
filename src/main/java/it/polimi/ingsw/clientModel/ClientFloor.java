package it.polimi.ingsw.clientModel;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.cards.Card;
import it.polimi.ingsw.effects.Effect;

public class ClientFloor {
		private int cost;
		public ClientCard currentCard;
		private Player player;
		public String bonusEffect;
		private boolean isFree = true;


		public int getCost(){
			return cost;
}
		public ClientCard getCard(){
			return currentCard;
		}
		
		@Override
		public String toString(){
			if (isFree){
				return ("Cost: " + cost+ "\n Bonus: "+ bonusEffect+ "\n Card" +currentCard +"\n The floor is free!");
			}
			else{
			return ("Cost: " + cost+ "\n Bonus: "+ bonusEffect + "\n Card" +currentCard + "\n The floor is occupied by: "+player);
		}
}
}
