package pl.mygames.hackandslash.dto.util;

public enum Dice {
	DICE1D4(1, 1, 4),
	DICE1D6(2, 1, 6),
	DICE1D8(3, 1, 8);
	
	private final int id;
	private final int numberOfDiceThrow;
	private final int rolledValue;

	private Dice(int id, int numberOfDiceThrow, int rolledValue) {
		this.id = id;
		this.numberOfDiceThrow = numberOfDiceThrow;
		this.rolledValue = rolledValue;
	}
	
	public int getId() {
		return id;
	}

	public int getNumberOfDiceThrow() {
		return numberOfDiceThrow;
	}

	public int getRolledValue() {
		return rolledValue;
	}
}
