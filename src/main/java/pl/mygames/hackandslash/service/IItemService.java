package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Item;

public interface IItemService extends IGenericService<Item, Integer>{
	List<Item> findByName(String name);
}
