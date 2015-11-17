package pl.mygames.hackandslash.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.Place;
import pl.mygames.hackandslash.service.IPlaceService;

@Controller
public class PlaceTestController {
    private static final Logger logger = LoggerFactory.getLogger(PlaceTestController.class);
	@Autowired
    private IPlaceService placeService;
    
	@RequestMapping(value = {"/places"}, method = RequestMethod.GET)
    public String getPlaces(ModelMap model) {
    	List<Place> places = findPlaces();
    	Place one_place = findPlace(ProjectConstants.TEST_ID.getValue());
    	model.addAttribute("places", places);
    	model.addAttribute("one_place", one_place);
        return "test/places";
    }
	
    @RequestMapping(value = "/places/add", method = RequestMethod.POST)  
    public String addPlace(@ModelAttribute("one_place")Place place) {
        if (place.getId() == 0) {
        	placeService.add(place);
        } else {
        	placeService.update(place);
        } 
        return "redirect:/places";  
    } 
    
    /*
     * This method will list all existing places.
     */
	private List<Place> findPlaces() {
		List<Place> places;
		if(placeService.findAll().isEmpty()) {
        	logger.info("Places list is empty");
        	places = new ArrayList<>();
        } else {
        	places = placeService.findAll();
        }
		return places;
	}
	
    /*
     * This method will return one equipment.
     */
	private Place findPlace(Integer id) {
		Place place;
		List<Place> places = placeService.findById(id);
		if (places.isEmpty()){
    		logger.info("Places list is empty");
    		place = new Place();
    	} else {
    		place = places.iterator().next();
    		if (places.size() > 1) {
    			logger.info("Method findPlace(Integer id) returned more then one result");
    		}
    	}
		return place;
	}
}
