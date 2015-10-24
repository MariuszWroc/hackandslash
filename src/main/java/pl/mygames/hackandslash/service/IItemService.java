package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.Item;

public interface IItemService {
    void add(Item item);
    void delete(Item item);
    void update(Item item);
    Item findById(Integer id);	
}
