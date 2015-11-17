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
import pl.mygames.hackandslash.model.Item;
import pl.mygames.hackandslash.model.Journal;
import pl.mygames.hackandslash.service.IItemService;

@Controller
public class ItemTestController {
    private static final Logger logger = LoggerFactory.getLogger(ItemTestController.class);
	@Autowired
    private IItemService itemService;
	
	@RequestMapping(value = {"/items"}, method = RequestMethod.GET)
    public String getItems(ModelMap model) {
        List<Item> items = findItems();
        Item one_item = findItem(ProjectConstants.TEST_ID.getValue());
    	model.addAttribute("items", items);
    	model.addAttribute("one_item", one_item);
        return "test/items";
    }
	  
    @RequestMapping(value = "/items/add", method = RequestMethod.POST)  
    public String addItem(@ModelAttribute("one_item")Item item) {
        if (item.getId() == 0) {
        	itemService.add(item);
        } else {
        	itemService.update(item);
        } 
        return "redirect:/items";  
    } 
    
    /*
     * This method will list all existing items.
     */
	private List<Item> findItems() {
		List<Item> items;
		if(itemService.findAll().isEmpty()) {
        	logger.info("Item list is empty");
        	items = new ArrayList<>();
        } else {
        	items = itemService.findAll();
        }
		return items;
	}
	
    /*
     * This method will return one item.
     */
	private Item findItem(Integer id) {
		Item item;
		List<Item> items = itemService.findById(id);
		if (items.isEmpty()){
    		logger.info("Items list is empty");
    		item = new Item();
    	} else {
    		item = items.iterator().next();
    		if (items.size() > 1) {
    			logger.info("Method findItem(Integer id) returned more then one result");
    		}
    	}
		return item;
	}
}
