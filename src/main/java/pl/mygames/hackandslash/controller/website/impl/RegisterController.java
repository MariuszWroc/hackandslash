package pl.mygames.hackandslash.controller.website.impl;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<ObjectError>> addUser(@RequestBody @Valid GameUser userRegister, BindingResult result) {
		String login = userRegister.getLogin();
		logger.info("Validating user " + login);

		if ((!result.hasErrors()) && (userService.isRegisterUserValid(login, userRegister.getEmail()))) {
			logger.info("Creating user " + login);
			userService.add(userRegister);
			logger.info("Success.");
			return new ResponseEntity<List<ObjectError>>(result.getAllErrors(),HttpStatus.CREATED);
		} else {
			logger.info("Failed add " + login);
			return new ResponseEntity<List<ObjectError>>(result.getAllErrors(),HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = { "/genderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GenderDTO> getGenderList(ModelMap model) {
		List<GenderDTO> list = new ArrayList<>();
		for (GenderEnum gender : GenderEnum.values()) {
			list.add(new GenderDTO(gender));
		}
		return list;
	}
}
