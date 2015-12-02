package pl.mygames.hackandslash.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.model.Item;
import pl.mygames.hackandslash.service.IItemService;

@Controller
public class ItemAdminController {
    private static final Logger logger = LoggerFactory.getLogger(ItemAdminController.class);
	@Autowired
    private IItemService itemService;
	private Integer keyValue;
	
	@RequestMapping(value = {"/items"}, method = RequestMethod.GET)
    public String getItems(ModelMap model) {
        List<Item> items = findItems();
        keyValue = Autoincrementation.getValue(items.size());
    	model.addAttribute("items", items);
    	model.addAttribute("one_item", new Item());
        return "test/items";
    }
	  
    @RequestMapping(value = "/items/add", method = RequestMethod.POST)  
    public String addItem(@ModelAttribute("one_item")Item item, @RequestParam String action) {
        if ((item.getId() == null) && (action.equals("Add"))) {
        	item.setId(keyValue);
        	itemService.add(item);
            logger.info("Item with id = " + keyValue + ", added");
        } else if (action.equals("Edit")){
        	itemService.update(item);
            logger.info("Item with id = " + item.getId() + ", updated");
        } 
        return "redirect:/items";  
    } 
    
    @RequestMapping(value = "/items/remove/{id}")
    public String removeItem(@PathVariable("id") Integer id){
        itemService.delete(id);
        logger.info("Item with id = " + id + ", deleted");
        return "redirect:/items";
    }
    
    @RequestMapping(value = "/items/edit/{id}")
    public String editItem(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("items", findItems());
        model.addAttribute("one_item", findItem(id));
        logger.info("Item with id = " + id + ", edited");
        return "test/items";
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
