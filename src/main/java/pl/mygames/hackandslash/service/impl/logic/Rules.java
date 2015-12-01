package pl.mygames.hackandslash.service.impl.logic;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.mygames.hackandslash.dto.AttributeDTO;
import pl.mygames.hackandslash.dto.DefaultAttributesDTO;
import pl.mygames.hackandslash.dto.util.general.Dice;
import pl.mygames.hackandslash.dto.util.user.UserProfession;
import pl.mygames.hackandslash.dto.util.user.UserRace;
import pl.mygames.hackandslash.service.util.RandomValue;

public class Rules {
    private static final Logger logger = LoggerFactory.getLogger(Rules.class);
    private static Map<String, DefaultAttributesDTO> allAttributes = populateDefaultAttributes();
    
	public static int diceRoller(int diceNumber, int sideNumber) {
		int value = 0;
		for(int i=1; i<=diceNumber; i++) {
			value = value + RandomValue.randomInteger(1, sideNumber);
		}
		
		return value;
	}
	
	public static Map<String, DefaultAttributesDTO> populateDefaultAttributes() {
		Map<String, DefaultAttributesDTO> allAttributes = new HashMap<>();
		
		DefaultAttributesDTO elfAttributes = new DefaultAttributesDTO(UserRace.ELF.getMinStrength(),
				UserRace.ELF.getMinDexterity(), UserRace.ELF.getMinIntelligence(), UserRace.ELF.getMinConstitution(),
				UserRace.ELF.getMinCharisma(), UserRace.ELF.getMaxStrength(), UserRace.ELF.getMaxDexterity(),
				UserRace.ELF.getMaxIntelligence(), UserRace.ELF.getMaxConstitution(), UserRace.ELF.getMaxCharisma());

		DefaultAttributesDTO dwarfAttributes = new DefaultAttributesDTO(UserRace.DWARF.getMinStrength(),
				UserRace.DWARF.getMinDexterity(), UserRace.DWARF.getMinIntelligence(), UserRace.DWARF.getMinConstitution(),
				UserRace.DWARF.getMinCharisma(), UserRace.DWARF.getMaxStrength(), UserRace.DWARF.getMaxDexterity(),
				UserRace.DWARF.getMaxIntelligence(), UserRace.DWARF.getMaxConstitution(), UserRace.DWARF.getMaxCharisma());

		DefaultAttributesDTO humanAttributes = new DefaultAttributesDTO(UserRace.HUMAN.getMinStrength(),
				UserRace.HUMAN.getMinDexterity(), UserRace.HUMAN.getMinIntelligence(), UserRace.HUMAN.getMinConstitution(),
				UserRace.HUMAN.getMinCharisma(), UserRace.HUMAN.getMaxStrength(), UserRace.HUMAN.getMaxDexterity(),
				UserRace.HUMAN.getMaxIntelligence(), UserRace.HUMAN.getMaxConstitution(), UserRace.HUMAN.getMaxCharisma());

		DefaultAttributesDTO halflingAttributes = new DefaultAttributesDTO(UserRace.HALFLING.getMinStrength(),
				UserRace.HALFLING.getMinDexterity(), UserRace.HALFLING.getMinIntelligence(), UserRace.HALFLING.getMinConstitution(),
				UserRace.HALFLING.getMinCharisma(), UserRace.HALFLING.getMaxStrength(), UserRace.HALFLING.getMaxDexterity(),
				UserRace.HALFLING.getMaxIntelligence(), UserRace.HALFLING.getMaxConstitution(), UserRace.HALFLING.getMaxCharisma());
		
		DefaultAttributesDTO warriorAttributes = new DefaultAttributesDTO(UserProfession.WARRIOR.getMinStrength(),
				UserProfession.WARRIOR.getMinDexterity(), UserProfession.WARRIOR.getMinIntelligence(), UserProfession.WARRIOR.getMinConstitution(),
				UserProfession.WARRIOR.getMinCharisma());

		DefaultAttributesDTO hunterAttributes = new DefaultAttributesDTO(UserProfession.HUNTER.getMinStrength(),
				UserProfession.HUNTER.getMinDexterity(), UserProfession.HUNTER.getMinIntelligence(), UserProfession.HUNTER.getMinConstitution(),
				UserProfession.HUNTER.getMinCharisma());

		DefaultAttributesDTO thiefAttributes = new DefaultAttributesDTO(UserProfession.THIEF.getMinStrength(),
				UserProfession.THIEF.getMinDexterity(), UserProfession.THIEF.getMinIntelligence(), UserProfession.THIEF.getMinConstitution(),
				UserProfession.THIEF.getMinCharisma());

		DefaultAttributesDTO mageAttributes = new DefaultAttributesDTO(UserProfession.MAGE.getMinStrength(),
				UserProfession.MAGE.getMinDexterity(), UserProfession.MAGE.getMinIntelligence(), UserProfession.MAGE.getMinConstitution(),
				UserProfession.MAGE.getMinCharisma());
		
		allAttributes.put("ELF", elfAttributes);
		allAttributes.put("DWARF", dwarfAttributes);
		allAttributes.put("HUMAN", humanAttributes);
		allAttributes.put("HALFLING", halflingAttributes);
		allAttributes.put("WARRIOR", warriorAttributes);
		allAttributes.put("HUNTER", hunterAttributes);
		allAttributes.put("THIEF", thiefAttributes);
		allAttributes.put("MAGE", mageAttributes);
		
		return allAttributes;
	}
	
	public static AttributeDTO createMinimumAttributes(DefaultAttributesDTO race, DefaultAttributesDTO profession) {
		int minStrength = drawAttribute("minStrength", race.getMinStrength(), profession.getMinStrength());
		int minDexterity  = drawAttribute("minDexterity", race.getMinDexterity(), profession.getMinDexterity());
		int minIntelligence  = drawAttribute("minIntelligence", race.getMinIntelligence(), profession.getMinIntelligence());
		int minConstitution  = drawAttribute("minConstitution", race.getMinConstitution(), profession.getMinConstitution());
		int minCharisma  = drawAttribute("minCharisma", race.getMinCharisma(), profession.getMinCharisma());
		
		AttributeDTO minAttributes = new AttributeDTO(minStrength, minDexterity, minConstitution, minCharisma, minIntelligence);
		
		return minAttributes;
	}
	
	public static AttributeDTO createMaximumAttributes(DefaultAttributesDTO race) {
		int maxStrength  = race.getMaxStrength();
		int maxDexterity  = race.getMaxDexterity();
		int maxConstitution  = race.getMaxIntelligence();
		int maxCharisma  = race.getMaxConstitution();
		int maxIntelligence  = race.getMaxCharisma();

		AttributeDTO maxAttributes = new AttributeDTO(maxStrength, maxDexterity, maxConstitution, maxCharisma, maxIntelligence);
		
		return maxAttributes;
	}
	
	public static AttributeDTO getDrawedAttributes(AttributeDTO minAttributes, AttributeDTO maxAttributes) {
		int strength  = generateAttribute(minAttributes.getStrength(), maxAttributes.getStrength());
		int dexterity  = generateAttribute(minAttributes.getDexterity(), maxAttributes.getDexterity());
		int constitution  = generateAttribute(minAttributes.getIntelligence(), maxAttributes.getIntelligence());
		int charisma  = generateAttribute(minAttributes.getConstitution(), maxAttributes.getConstitution());
		int intelligence  = generateAttribute(minAttributes.getCharisma(), maxAttributes.getCharisma());

		AttributeDTO drawedAttributes = new AttributeDTO(strength, dexterity, constitution, charisma, intelligence);
		
		return drawedAttributes;
	}

	public static int generateAttribute(int min, int max) {
		int rolledValue = diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());
		while ((min > rolledValue) || (max < rolledValue)) {
			rolledValue = diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());
		}
		return rolledValue;
	}

	private static int drawAttribute(String attributeName, int raceValue, int professionValue) {
		String prefix = attributeName.substring(0, 3);
		String body = attributeName.substring(3); 
		logger.info("Attribute name " + attributeName + " ,professionValue " + professionValue + " ,raceValue " +  raceValue + " ,prefix " + prefix + " ,body " + body);
		switch (body) {
			case "Strength" : 
				return checkWhichIsBigger(raceValue, professionValue);
			case "Dexterity" :
				return checkWhichIsBigger(raceValue, professionValue);
			case "Intelligence" :
				return checkWhichIsBigger(raceValue, professionValue);
			case "Constitution" : 
				return checkWhichIsBigger(raceValue, professionValue);
			case "Charisma" : 
				return checkWhichIsBigger(raceValue, professionValue);
			default:
				logger.error("Attribute name have wrong name. There is no such attribute.");
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

	public static Map<String, DefaultAttributesDTO> getAllAttributes() {
		return allAttributes;
	}

	public static void setAllAttributes(Map<String, DefaultAttributesDTO> allAttributes) {
		Rules.allAttributes = allAttributes;
	}
}
