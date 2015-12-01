package pl.mygames.hackandslash.manual.main;

import java.util.Map;

import pl.mygames.hackandslash.dto.AttributeDTO;
import pl.mygames.hackandslash.dto.DefaultAttributesDTO;
import pl.mygames.hackandslash.service.impl.logic.Rules;

public class RulesMain {

	public static void main(String[] args) {
		Map<String, DefaultAttributesDTO> populateDefaultAttributes = Rules.populateDefaultAttributes();
		DefaultAttributesDTO elfAttributesDTO = populateDefaultAttributes.get("ELF");
		DefaultAttributesDTO warriorAttributesDTO = populateDefaultAttributes.get("MAGE");
//		DefaultAttributesDTO elfAttributesDTO = new DefaultAttributesDTO(3,4,5,6,7,8,1,2,3,4);
//		DefaultAttributesDTO warriorAttributesDTO = new DefaultAttributesDTO(3,4,5,6,7,8,1,2,3,4);
		AttributeDTO createMinimumAttributes = Rules.createMinimumAttributes(elfAttributesDTO, warriorAttributesDTO);
		AttributeDTO createMaximumAttributes = Rules.createMaximumAttributes(elfAttributesDTO);
		System.out.println("Test minimum " + createMinimumAttributes.getStrength() + " " + createMinimumAttributes.getDexterity() + " " + createMinimumAttributes.getIntelligence() +" " + createMinimumAttributes.getConstitution() + " " + createMinimumAttributes.getCharisma());
		System.out.println("Test maximum " + createMaximumAttributes.getStrength() + " " + createMaximumAttributes.getDexterity() + " " + createMaximumAttributes.getIntelligence() +" " + createMaximumAttributes.getConstitution() + " " + createMaximumAttributes.getCharisma());
//		for(int i=1; i<100; i++) {
//		for(int i=1; i<100; i++) {
//			for(int j=3; j<18; j++)
//			System.out.println("Rules.generateAttribute(" + j + ", " + 18 + ") " + Rules.generateAttribute(j, 18));
//		}
	}

}
