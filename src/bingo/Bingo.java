package bingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entites.Player;

public class Bingo {
	private Scanner scannerInt = new Scanner(System.in);
	private Scanner scannerString = new Scanner(System.in);

	public void start() {
		System.out.println("Welcome to the bingo! Each player will receive one Card, the first player to mark \n"
				+ "all numbers on a card wins the game!");

		ArrayList<Player> players = addPlayer();

		boolean wasAWinner = false;
		Player theBigBoss = null;
		while (!wasAWinner) {
			int numberDrawn = drawNumber();
			System.out.println("The number drawn was:" + numberDrawn);
			markNumber(players, numberDrawn);
			theBigBoss = checkWinner(players);
			wasAWinner = theBigBoss == null ? false : true;
		}
		System.out.println("The big winner is:" + theBigBoss.getPlayerName());

	}

	private Player checkWinner(ArrayList<Player> players) {
		boolean wasAWinner = true;
		Player theBigBoss;
		playerloop: for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
			wasAWinner = true;
			for (int lineIndex = 0; lineIndex < players.get(playerIndex).getPlayerCard().size(); lineIndex++) {
				for (int elementIndex = 0; elementIndex < players.get(playerIndex).getPlayerCard().get(lineIndex)
						.size(); elementIndex++) {
					if (players.get(playerIndex).getPlayerCard().get(lineIndex).get(elementIndex).getIsMarked()
							.equals(false)) {
						wasAWinner = false;
						continue playerloop;
					}
				}
				if (wasAWinner = true) {
					theBigBoss = players.get(playerIndex);
					return theBigBoss;
				}
			}

		}
		return theBigBoss = null;
	}

	private Integer drawNumber() {
		Integer numberDrawn = new Random().nextInt(50);
		while (numberDrawn.equals(0)) {
			numberDrawn = new Random().nextInt(50);

		}
		return numberDrawn;
	}

	private void markNumber(ArrayList<Player> players, Integer numberDrawn) {
		for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
			for (int lineIndex = 0; lineIndex < players.get(playerIndex).getPlayerCard().size(); lineIndex++) {
				for (int elementIndex = 0; elementIndex < players.get(playerIndex).getPlayerCard().get(lineIndex)
						.size(); elementIndex++) {
					if (players.get(playerIndex).getPlayerCard().get(lineIndex).get(elementIndex).getValue()
							.equals(numberDrawn)) {
						players.get(playerIndex).getPlayerCard().get(lineIndex).get(elementIndex).setIsMarked(true);
						System.out.println(
								"The player " + players.get(playerIndex).getPlayerName() + " marked the number "
										+ numberDrawn + " on his card\n" + players.get(playerIndex).getPlayerCard());
					}
				}

			}
		}

	}

	private ArrayList<Player> addPlayer() {
		ArrayList<Player> players = new ArrayList<Player>();
		System.out.println("How many people will play?");
		int numberOfPlayers = scannerInt.nextInt();
		System.out.println("How many lines will the card have?");
		int numberOfLines = scannerInt.nextInt();
		System.out.println("How many columns will the card have?");
		int numberOfColumns = scannerInt.nextInt();

		for (int index = 1; index <= numberOfPlayers; index++) {
			System.out.println("What is your name?");
			String playerName = scannerString.nextLine();
			int playerId = index;
			Player player = new Player(playerName, playerId, numberOfLines, numberOfColumns);
			players.add(player);
			System.out.println("The player's card is " + player.getPlayerName() + " é");
			showCard(player);

		}
		return players;
	}

	private void showCard(Player player) {
		for (int index = 0; index < player.getPlayerCard().size(); index++) {
			System.out.println(player.getPlayerCard().get(index));
		}
	}

}
