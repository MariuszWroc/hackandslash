package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IItemDao;
import pl.mygames.hackandslash.model.Item;

@Repository
public final class ItemDao extends GenericExtendedDao<Item, Integer> implements IItemDao{

}