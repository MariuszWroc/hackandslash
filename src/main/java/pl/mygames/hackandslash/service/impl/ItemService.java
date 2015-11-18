package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.ItemDao;
import pl.mygames.hackandslash.model.Item;
import pl.mygames.hackandslash.service.IItemService;

@Service
@Transactional(readOnly = true)
public class ItemService implements IItemService {

    @Autowired
    private ItemDao dao;

    @Transactional(readOnly = false)
    @Override
    public void add(Item item) {
        dao.add(item);
    }

    @Transactional(readOnly = false)
//    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Item item) {
        dao.delete(item);
    }
    
    @Transactional(readOnly = false)
//  @Secured("ROLE_ADMIN")
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
    public List<Item> findById(Integer id) {
        return dao.findByQuery("Item.findById", id);
    }

    @Override
    public List<Item> findAll() {
        return dao.findByQuery("Item.findAll");
    }

    public void setDao(ItemDao dao) {
        this.dao = dao;
    }
}
