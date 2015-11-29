/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mygames.hackandslash.controller.test.CreateHeroTestController;
import pl.mygames.hackandslash.dto.HeroDTO;

@RestController
public class HeroController {
	private static final Logger logger = LoggerFactory.getLogger(CreateHeroTestController.class); 
        
	@RequestMapping(value = "/hero/details", method = RequestMethod.GET)
        public @ResponseBody HeroDTO getHero(){
            return new HeroDTO();
        }
}
