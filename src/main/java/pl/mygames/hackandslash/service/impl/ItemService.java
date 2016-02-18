package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IItemDao;
import pl.mygames.hackandslash.dao.impl.ItemDao;
import pl.mygames.hackandslash.model.Item;
import pl.mygames.hackandslash.service.IItemService;

@Service
@Transactional(readOnly = true)
public class ItemService implements IItemService {
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
    @Autowired
    private IItemDao dao;

    @Transactional(readOnly = false)
    @Override
    public void add(Item item) {
        dao.add(item);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Item item) {
        dao.delete(item);
    }
    
    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Item item) {
        dao.update(item);
    }

    @Override
    public Item findById(Integer id) {
    	Item item;
		List<Item> items = dao.findByQuery("GameCharacter.findById", id);
		if (items.isEmpty()){
    		logger.info("Equipments list is empty");
    		item = new Item();
    	} else {
    		item = items.iterator().next();
    		if (items.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return item;
    }

    @Override
    public List<Item> findAll() {
        return dao.findByQuery("Item.findAll");
    }
    
    @Override
    public List<Item> findByName(String name) {
        return dao.findByQuery("Item.findByName", "name", name);
    }

    public void setDao(ItemDao dao) {
        this.dao = dao;
    }
}
