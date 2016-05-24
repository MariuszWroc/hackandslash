package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Item;

public interface IItemService extends IGenericService<Item, Integer>{
    void add(Item item);
    void delete(Item item);
    void update(Item item);
    Item findById(Integer id);	
    List<Item> findAll();
	void delete(Integer id);
	List<Item> findByName(String name);
}
