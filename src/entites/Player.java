package entites;

import java.util.ArrayList;

public class Player {
	private int playerID;
	private String playerName;
	private ArrayList<ArrayList<Number>> playerCard;

	public Player(String playerName, int playerID, int numberOfLines, int numberOfColumns) {
		this.setPlayerID(playerID);
		this.setPlayerName(playerName);
		Card newCard = new Card();
		newCard.setNumberOfColumns(numberOfColumns);
		newCard.setNumberOfLines(numberOfLines);
		this.playerCard = newCard.generateCard();

	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public ArrayList<ArrayList<Number>> getPlayerCard() {
		return playerCard;
	}

	public void setPlayerCard(ArrayList<ArrayList<Number>> playerCard) {
		this.playerCard = playerCard;
	}

	public Integer getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}

//	}

}
