package entites;

import java.util.Random;

public class Number {
	private Integer value;
	private Boolean isMarked;

	public String toString() {
		if (isMarked) {
			return value.toString() + " - X";
		}
		return value.toString();
	}

	public Number() {
		this.value = generateNumber();
		this.isMarked = false;
	}

	private Integer generateNumber() {

		Integer randomNumber = new Random().nextInt(50);
		while (randomNumber == 0) {
			randomNumber = new Random().nextInt(50);
		}

		return randomNumber;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Boolean getIsMarked() {
		return isMarked;
	}

	public void setIsMarked(Boolean isMarked) {
		this.isMarked = isMarked;
	}

}