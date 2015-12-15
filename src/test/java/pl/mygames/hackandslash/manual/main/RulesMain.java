package pl.mygames.hackandslash.manual.main;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.mygames.hackandslash.dto.AttributeDTO;
import pl.mygames.hackandslash.dto.DefaultAttributesDTO;
import pl.mygames.hackandslash.service.impl.logic.Rules;

public class RulesMain {
	private static final Logger logger = LoggerFactory.getLogger(RulesMain.class);
	
	public static void popuateAttributes() {
		logger.info("Testing popuate Attributes");
		Map<String, DefaultAttributesDTO> populateDefaultAttributes = Rules.populateDefaultAttributes();
		DefaultAttributesDTO elfAttributesDTO = populateDefaultAttributes.get("ELF");
		DefaultAttributesDTO warriorAttributesDTO = populateDefaultAttributes.get("MAGE");
		AttributeDTO createMinimumAttributes = Rules.createMinimumAttributes(elfAttributesDTO, warriorAttributesDTO);
		AttributeDTO createMaximumAttributes = Rules.createMaximumAttributes(elfAttributesDTO);
		logger.info("Test minimum " + createMinimumAttributes.getStrength() + " " + createMinimumAttributes.getDexterity() + " " + createMinimumAttributes.getIntelligence() +" " + createMinimumAttributes.getConstitution() + " " + createMinimumAttributes.getCharisma());
		logger.info("Test maximum " + createMaximumAttributes.getStrength() + " " + createMaximumAttributes.getDexterity() + " " + createMaximumAttributes.getIntelligence() +" " + createMaximumAttributes.getConstitution() + " " + createMaximumAttributes.getCharisma());
		logger.info("OK");
	}

}