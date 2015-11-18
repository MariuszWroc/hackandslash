package pl.mygames.hackandslash.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.Place;
import pl.mygames.hackandslash.service.IPlaceService;

@Controller
public class PlaceTestController {
    private static final Logger logger = LoggerFactory.getLogger(PlaceTestController.class);
	@Autowired
    private IPlaceService placeService;
	private Integer keyValue;
    
	@RequestMapping(value = {"/places"}, method = RequestMethod.GET)
    public String getPlaces(ModelMap model) {
    	List<Place> places = findPlaces();
    	keyValue = Autoincrementation.getValue(places.size());
    	model.addAttribute("places", places);
    	model.addAttribute("one_place", new Place());
        return "test/places";
    }
	
    @RequestMapping(value = "/places/add", method = RequestMethod.POST)  
    public String addPlace(@ModelAttribute("one_place")Place place) {
        if (place.getId() == null) {
        	place.setId(keyValue);
        	placeService.add(place);
        } else {
        	placeService.update(place);
        } 
        return "redirect:/places";  
    } 
    
    @RequestMapping(value = "/places/remove/{id}")
    public String removePlace(@PathVariable("id") Integer id){
        placeService.delete(id);
        return "redirect:/places";
    }
    
    @RequestMapping(value = "/places/edit/{id}")
    public String editPlace(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("places", findPlaces());
        model.addAttribute("one_place", findPlace(id));
        return "test/places";
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
