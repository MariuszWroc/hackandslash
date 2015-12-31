package pl.mygames.hackandslash.controller.website;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.GenderDTO;

import pl.mygames.hackandslash.dto.util.general.GenderEnum;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;


@RestController
@RequestMapping(value = "/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class); 
    
	@Autowired
    private IUserService userService;
        
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
	public ResponseEntity<Void> processRegistration(@RequestBody GameUser userRegister, BindingResult result) {
		logger.info("Creating User " + userRegister.getLogin());
		if (result.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			userService.add(userRegister);
			HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
        
        @RequestMapping(value = {"/genderList"}, method = RequestMethod.GET)
        public @ResponseBody List<GenderDTO> getGenderList(ModelMap model) {
            List<GenderDTO> list = new ArrayList<>();
            for(GenderEnum gender: GenderEnum.values()){
               list.add(new GenderDTO(gender));
            }
            return list;
        }
}
