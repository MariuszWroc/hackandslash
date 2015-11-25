package pl.mygames.hackandslash.service.impl.logic;

import pl.mygames.hackandslash.service.util.RandomValue;

public class Rules {

	public static int diceRoller(int diceNumber, int sideNumber) {
		int value = 0;
		for(int i=1; i<=diceNumber; i++) {
			value = value + RandomValue.randomInteger(1, sideNumber);
		}
		
		return value;
	}
}
