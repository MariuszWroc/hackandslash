package pl.mygames.hackandslash.service.impl.logic;

import java.util.HashMap;
import java.util.Map;

import pl.mygames.hackandslash.service.util.RandomValue;

public class Rules {

	public static int diceRoller(int diceNumber, int sideNumber) {
		int value = 0;
		for(int i=1; i<=diceNumber; i++) {
			value = value + RandomValue.randomInteger(1, sideNumber);
		}
		
		return value;
	}
	
	public static Map<String, Integer> getProfessionAttributes(Integer idProfession) {
		Map<String, Integer> attibutes = new HashMap<>();
		attibutes.put("min", 3);
		attibutes.put("max", 10);
		
		return attibutes;
	}
	
	public static Integer [] getAllowedProffession(Integer idRace) {
		return null;
	}
}
