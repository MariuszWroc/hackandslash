/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller;

import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.HeroDTO;

@RestController
public class HeroController {
        
	@RequestMapping(value = "/hero/details", method = RequestMethod.GET)
        public @ResponseBody HeroDTO getHero(){
            return new HeroDTO();
        }
}
