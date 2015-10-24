package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.RoleDao;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.service.IRoleService;

@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService{

	@Autowired
	private RoleDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(GameRole role) {
		dao.save(role);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(GameRole role) {
		dao.delete(role);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(GameRole role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameRole findById(Integer id) {
		return dao.findOne(id);
	}


	
}
