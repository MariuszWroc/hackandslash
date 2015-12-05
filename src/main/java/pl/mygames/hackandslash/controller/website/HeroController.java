/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller.website;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.dto.ProfessionDTO;
import pl.mygames.hackandslash.dto.RaceDTO;
import pl.mygames.hackandslash.dto.util.user.UserProfession;
import pl.mygames.hackandslash.dto.util.user.UserRace;

@RestController
public class HeroController {
        
	@RequestMapping(value = "/hero/details", method = RequestMethod.GET)
        public @ResponseBody HeroDTO getHero(){
            return new HeroDTO();
        }
        
        @RequestMapping(value = "/hero/raceList", method = RequestMethod.GET)
        public @ResponseBody List<RaceDTO> getRaces(){
            List <RaceDTO> list = new ArrayList<RaceDTO>();
            for(UserRace u:UserRace.values()){
                list.add(new RaceDTO(u));
            }
            return list;
        }
        
        @RequestMapping(value = "/hero/professionsList", method = RequestMethod.GET)
        public @ResponseBody List<ProfessionDTO> getProfessions(){
            List <ProfessionDTO> list = new ArrayList<ProfessionDTO>();
            for(UserProfession u:UserProfession.values()){
                list.add(new ProfessionDTO(u));
            }
            return list;
        }
}
