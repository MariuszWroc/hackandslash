package pl.mygames.hackandslash.dto.util;

public enum NpcBehaviour {
	Aggressive(1);
	
	private int value;

	private NpcBehaviour(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
