package pl.mygames.hackandslash.service.impl.logic;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.mygames.hackandslash.dto.util.user.UserRace;
import pl.mygames.hackandslash.service.util.RandomValue;

public class Rules {
    private static final Logger logger = LoggerFactory.getLogger(Rules.class);
    
	public static int diceRoller(int diceNumber, int sideNumber) {
		int value = 0;
		for(int i=1; i<=diceNumber; i++) {
			value = value + RandomValue.randomInteger(1, sideNumber);
		}
		
		return value;
	}
	
	public static Map<String, Map<String, Integer>> getCharacterAttributes(Integer idProfession, Integer idRace) {
		Map<String, Map<String, Integer>> generalAttibutesMap = new HashMap<>();
		
		int minStrengthByRace = 3;
		int minStrengthByProfession = 3;
		int maxStrengthByRace = 3;
		int maxStrengthByProfession = 3;
		int minStrength = determineAttribute("minStrength", minStrengthByRace, minStrengthByProfession);
		int maxStrength  = determineAttribute("maxStrength", maxStrengthByRace, maxStrengthByProfession);
		
		int minDexterityByRace = 3;
		int minDexterityByProfession = 3;
		int minIntelligenceByProfession = 3;
		int minIntelligenceByRace = 3;
		int minConstitutionByProfession = 3;
		int minConstitutionByRace = 3;
		int minCharismaByProfession = 3;
		int minCharismaByRace = 3;

		int maxDexterityByRace = 3;
		int maxDexterityByProfession = 3;
		int maxIntelligenceByProfession = 3;
		int maxIntelligenceByRace = 3;
		int maxConstitutionByProfession = 3;
		int maxConstitutionByRace = 3;
		int maxCharismaByProfession = 3;
		int maxnCharismaByRace = 3;
		
		
		int minDexterity  = determineAttribute("minDexterity", minIntelligenceByProfession, minIntelligenceByRace);
		int maxDexterity  = determineAttribute("maxDexterity", minConstitutionByProfession, minConstitutionByRace);
		int minConstitution  = determineAttribute("minIntelligence", minCharismaByProfession, minCharismaByRace);
		int maxConstitution  = determineAttribute("maxIntelligence", maxStrengthByProfession, maxStrengthByRace);
		int minCharisma  = determineAttribute("minConstitution", maxDexterityByProfession, maxDexterityByRace);
		int maxCharisma  = determineAttribute("maxConstitution", maxIntelligenceByProfession, maxIntelligenceByRace);
		int minIntelligence  = determineAttribute("minCharisma", maxConstitutionByProfession, maxConstitutionByRace);
		int maxIntelligence  = determineAttribute("maxCharisma", maxCharismaByProfession, maxnCharismaByRace);

		generalAttibutesMap.put("Strength", determineSpecificAttributes("Strength", idProfession, idRace));
		generalAttibutesMap.put("Dexterity", determineSpecificAttributes("Dexterity", idProfession, idRace));
		generalAttibutesMap.put("Intelligence", determineSpecificAttributes("Intelligence", idProfession, idRace));
		generalAttibutesMap.put("Constitution", determineSpecificAttributes("Constitution", idProfession, idRace));
		generalAttibutesMap.put("Charisma", determineSpecificAttributes("Charisma", idProfession, idRace));
		
		return generalAttibutesMap;
	}

	private static Map<String, Integer> determineSpecificAttributes(String attributeName, int idProfession, int idRace) {
		Map<String, Integer> map = new HashMap<>();
		int minValue = findMinValue(attributeName, idProfession, idRace);
		int maxValue = findMaxValue(attributeName, idProfession, idRace);
		map.put("minValue", minValue);
		map.put("maxValue", maxValue);
		map.put("generatedValue", generateValue(attributeName, minValue, maxValue));
		
		return map;
	}
	
	private static int findMinValue(String attributeName, int idProfession, int idRace) {
		return 0;
		
	}
	
	private static int findMaxValue(String attributeName, int idProfession, int idRace) {
		return 0;
		
	}
	
	private static int generateValue(String attributeName, int idProfession, int idRace) {
		return 0;
		
	}

	private static int determineAttribute(String attributeName, int professionValue, int raceValue) {
		int attributeValue = 0;
		String prefix = attributeName.substring(0, 3);
		String body = attributeName.substring(4); 
		switch (body) {
			case "Strength" : attributeValue = checkMinOrMax(prefix, professionValue, raceValue);
			break;
			case "Dexterity" : attributeValue = checkMinOrMax(prefix, professionValue, raceValue);
			break;
			case "Intelligence" : attributeValue = checkMinOrMax(prefix, professionValue, raceValue);
			break;
			case "Constitution" : attributeValue = checkMinOrMax(prefix, professionValue, raceValue);
			break;
			case "Charisma" : attributeValue = checkMinOrMax(prefix, professionValue, raceValue);
			break;
			default: break;
		}
		
		return attributeValue;
	}

	private static int checkMinOrMax(String prefix, int professionValue, int raceValue) {
		if(prefix.equals("min")) {
			return checkWhichIsBigger(professionValue, raceValue);
		} else if (prefix.equals("max")) {
			return checkWhichIsSmaller(professionValue, raceValue);
		} else {
			logger.error("Attribute name have a wrong prefix. Check if name start from 'max' or 'min'. ");
			return 0;
		}
	}

	private static int checkWhichIsBigger(int firstValue, int secondValue) {
		if (firstValue > secondValue) {
			return firstValue;
		} else {
			return secondValue;
		}
	}
	
	private static int checkWhichIsSmaller(int firstValue, int secondValue) {
		if (firstValue < secondValue) {
			return firstValue;
		} else {
			return secondValue;
		}
	}

	public static int[] getAllowedProffession(Integer idRace) {
		int[] professionAccess;
		switch(idRace) {
		case 1 : professionAccess = UserRace.HUMAN.getProfessionAccess();
				 break;
		case 2 : professionAccess = UserRace.ELF.getProfessionAccess();
				 break;
		case 3 : professionAccess = UserRace.DWARF.getProfessionAccess();
				 break;
		case 4 : professionAccess = UserRace.HALFLING.getProfessionAccess();	
				 break;
		
		default :
			professionAccess = UserRace.HUMAN.getProfessionAccess();
			break;
		}

		return professionAccess;
	}
}
