package entites;

import java.util.ArrayList;

public class Card {
	private ArrayList<ArrayList<Number>> playerCard;

	private Integer numberOfLines;
	private Integer numberOfColumns;

	public ArrayList<ArrayList<Number>> generateCard() {
		boolean firstLine = true;
		ArrayList<ArrayList<Number>> playerCard = new ArrayList<ArrayList<Number>>();
		for (int index = 1; index <= numberOfLines; index++) {
			if (playerCard.isEmpty()) {
				playerCard.add(generateLine(firstLine, playerCard));
			} else {
				playerCard.add(generateLine(!firstLine, playerCard));
			}

		}
		return playerCard;
	}

	private ArrayList<Number> generateLine(boolean firstLine, ArrayList<ArrayList<Number>> playerCard) {
		ArrayList<Number> line = new ArrayList<Number>();
		if (firstLine) {
			for (int index = 0; index < numberOfColumns; index++) {
				if (line.isEmpty()) {
					line.add(new Number());
				} else {
					line.add(uniqueNumberLine(line));
				}
			}
			return line;
		} else {
			for (int index = 0; index < numberOfColumns; index++) {
				if (line.isEmpty()) {
					boolean firstElement = true;
					line.add(uniqueNumberCard(playerCard, line, firstElement));
				} else {
					boolean firstElement = false;
					line.add(uniqueNumberCard(playerCard, line, firstElement));
				}
			}
			return line;
		}
	}

	private Number uniqueNumberCard(ArrayList<ArrayList<Number>> playerCard, ArrayList<Number> line,
			boolean firstElement) {
		if (firstElement) {
			boolean uniqueNumber;
			Number randomNumber;
			do {
				randomNumber = new Number();
				uniqueNumber = checkUniqueNumberCard(playerCard, randomNumber);
			} while (!uniqueNumber);
			return randomNumber;
		} else {
			boolean uniqueNumber;
			Number randomNumber;
			do {
				randomNumber = uniqueNumberLine(line);
				uniqueNumber = checkUniqueNumberCard(playerCard, randomNumber);
			} while (!uniqueNumber);
			return randomNumber;
		}
	}

	private Number uniqueNumberLine(ArrayList<Number> line) {
		Number randomNumber;
		boolean uniqueNumber;
		do {
			uniqueNumber = true;
			randomNumber = new Number();
			for (int index = 0; index < line.size(); index++) {
				if (line.get(index).getValue().equals(randomNumber.getValue())) {
					uniqueNumber = false;
					break;
				}
			}
		} while (!uniqueNumber);

		return randomNumber;
	}

	private boolean checkUniqueNumberCard(ArrayList<ArrayList<Number>> playerCard, Number randomNumber) {
		boolean isUniqueNumber = true;
		for (int cardIndex = 0; cardIndex < playerCard.size(); cardIndex++) {
			for (int lineIndex = 0; lineIndex < numberOfColumns; lineIndex++) {
				if (playerCard.get(cardIndex).get(lineIndex).getValue().equals(randomNumber.getValue())) {
					isUniqueNumber = false;
					break;
				}
			}
		}
		return isUniqueNumber;
	}

	public ArrayList<ArrayList<Number>> getPlayerCard() {
		return playerCard;
	}

	public void setPlayerCard(ArrayList<ArrayList<Number>> playerCard) {
		this.playerCard = playerCard;
	}

	public Integer getNumberOfLines() {
		return numberOfLines;
	}

	public void setNumberOfLines(Integer numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public Integer getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(Integer numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

}
