package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.EquipmentDao;
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.service.IEquipmentService;

@Service
@Transactional(readOnly = true)
public class EquipmentService implements IEquipmentService{
	@Autowired
	private EquipmentDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Equipment equipment) {
		dao.add(equipment);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Equipment equipment) {
		dao.delete(equipment);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Equipment findById(Integer id) {
		return dao.findById(id);
	}
}
