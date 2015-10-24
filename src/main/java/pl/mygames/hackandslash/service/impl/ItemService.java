package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.ItemDao;
import pl.mygames.hackandslash.model.Item;
import pl.mygames.hackandslash.service.IItemService;

@Service
@Transactional(readOnly = true)
public class ItemService implements IItemService{
	@Autowired
	private ItemDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Item item) {
		dao.save(item);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Item item) {
		dao.delete(item);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item findById(Integer id) {
		return dao.findOne(id);
	}
}
