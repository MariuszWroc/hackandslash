package pl.mygames.hackandslash.controller.website;



import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mygames.hackandslash.dto.GenderWorkAround;

import pl.mygames.hackandslash.dto.RegisterDTO;
import pl.mygames.hackandslash.dto.util.general.Gender;
import pl.mygames.hackandslash.service.IRegisterService;
import pl.mygames.hackandslash.service.IUserService;

@RestController
@RequestMapping(value = "/register")
@Deprecated
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class); 
    
	@Autowired
    private IUserService userService;
        
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistration(ModelMap model) {
    	RegisterDTO register = new RegisterDTO();
    	model.addAttribute("registerDTO", register);
    	logger.info("register view"); 
        return "register";
    }
	
	@RequestMapping(value = "/register/add", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute(value = "registerDTO") RegisterDTO register, BindingResult result) {
		
		if (result.hasErrors()) {
			return "redirect:/failed";
		} else {
			logger.info("User values is : " + register.getLogin() + " " + register.getPassword());
//			registerService.add(register);
			return "redirect:/success";
		}
	}
        
        @RequestMapping(value = {"/userList.json"}, method = RequestMethod.GET)
        public @ResponseBody int getUserList() {
            return userService.findAll().size();
        }
        
        @RequestMapping(value = {"/genderList"}, method = RequestMethod.GET)
        public @ResponseBody List<GenderWorkAround> getGenderList(ModelMap model) {
            List<GenderWorkAround> list = new ArrayList<>();
            for(Gender g:Gender.values()){
               list.add(new GenderWorkAround(g));
            }
            return list;
        }
}
