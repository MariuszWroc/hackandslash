package pl.mygames.hackandslash.manual.main;

import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.service.impl.HeroCreationService;

public class AddHero {

	public static void main(String[] args) {
		HeroCreationService creationService = new HeroCreationService();
		HeroDTO heroDTO = new HeroDTO();
		heroDTO.setAge(26);
		heroDTO.setGender(1);
		heroDTO.setFirstname("Mario");
		heroDTO.setRace(1);
		heroDTO.setProfession(2);
		heroDTO.setStrength(16);
		heroDTO.setDexterity(12);
		heroDTO.setConstitution(14);
		heroDTO.setIntelligence(10);
		heroDTO.setCharisma(8);
		String login = "mczarny";
		creationService.add(heroDTO, login);
		
		System.out.println("OK");
	}

}
