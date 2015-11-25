package pl.mygames.hackandslash.dto.util.general;

public enum Dice {
	DICE1D4(1, 4),
	DICE1D6(1, 6),
	DICE1D8(1, 8);
	
	private final int numberOfDiceThrow;
	private final int sideNumber;

	private Dice(int numberOfDiceThrow, int sideNumber) {
		this.numberOfDiceThrow = numberOfDiceThrow;
		this.sideNumber = sideNumber;
	}

	public int getNumberOfDiceThrow() {
		return numberOfDiceThrow;
	}

	public int getSideNumber() {
		return sideNumber;
	}
}
