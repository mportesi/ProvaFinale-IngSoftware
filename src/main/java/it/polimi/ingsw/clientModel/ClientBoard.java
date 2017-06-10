package it.polimi.ingsw.clientModel;

public class ClientBoard {
	public static ClientTower territoryTower;
	public static ClientTower buildingTower;
	public static ClientTower characterTower;
	public static ClientTower ventureTower;
	public static ClientCouncilPalace councilPalace;
	public static ClientHarvestArea harvestArea;
	public static ClientProductionArea productionArea;
	
	public ClientBoard(){
	
	territoryTower = new ClientTower ("territory");
	buildingTower = new ClientTower ("building");
	characterTower = new ClientTower ("character");
	ventureTower = new ClientTower("venture");
	
	}

}
