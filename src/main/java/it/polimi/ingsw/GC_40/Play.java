package it.polimi.ingsw.GC_40;

import java.util.Arrays;

public class Play {
	private int period;
	private int round;
	private Player currentPlayer;
	private Player[] currentTurnOrder;
	
	public void changeTurnOrder(){
		
		Player[] nextTurnOrder = new Player[4];
		Player[] councilPalaceOrder=Board.councilPalace.getOrder();
		
		for (int j=0; j<councilPalaceOrder.length; j++){
			Player checkedPlayer=councilPalaceOrder[j];
			nextTurnOrder[j]=checkedPlayer;
		
			for(int i=0; i<currentTurnOrder.length; i++){
			if (currentTurnOrder[i].equals(checkedPlayer)){
				currentTurnOrder[i]=null;
				}
			}
		}
		
		for (int i=0; i<currentTurnOrder.length; i++){
			if (currentTurnOrder[i]!=null){
				int j=0;
				while (nextTurnOrder[j]!=null){
					j++;
				}
				nextTurnOrder[j]=currentTurnOrder[i];
				currentTurnOrder[i]=null;
			}}
		currentTurnOrder= Arrays.copyOf(nextTurnOrder, nextTurnOrder.length);
		Arrays.fill(nextTurnOrder, 0);
	}
	
		public void changeCurrentPlayer(){
			int i=0;
			int n=0;
			
			while(currentTurnOrder[i]!=currentPlayer){
				i++;
				
			}
			if (i==(currentTurnOrder.length)-1){
				currentPlayer=currentTurnOrder[0];
				n+=1;
			}else{
			currentPlayer=currentTurnOrder[i+1];
			}
			
			if (n==4) {
				changeRound();
			}
		}
		
		public void changeRound(){
			if (round==2 || round ==4 || round==6){changePeriod();}
			round+=1;
			changeTurnOrder();
			
			//refresh tower( place new card and remove family member)
			Board.territoryTower.refreshTower(period);
			Board.buildingTower.refreshTower(period);
			Board.characterTower.refreshTower(period);
			Board.ventureTower.refreshTower(period);
			
			//refresh harvest and production area
			//TODO refresh 
			Board.harvestArea.refresh();
			Board.productionArea.refresh();
			//refresh market
			Board.market1.setFree();
			Board.market2.setFree();
			Board.market3.setFree();
			Board.market4.setFree();
			
			//refresh council palace
			Board.councilPalace.refresh();
			
			//roll dice
			Board.blackDice.setValue();
			Board.orangeDice.setValue();
			Board.whiteDice.setValue();
		}
		
		public void changePeriod(){
			
		}
		
		
}


