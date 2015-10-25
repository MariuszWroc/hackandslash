package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.NpcDao;
import pl.mygames.hackandslash.model.Npc;
import pl.mygames.hackandslash.service.INpcService;

@Service
@Transactional(readOnly = true)
public class NpcService implements INpcService{
	@Autowired
	private NpcDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Npc npc) {
		dao.add(npc);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Npc npc) {
		dao.delete(npc);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Npc npc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Npc findById(Integer id) {
		return dao.findById(id);
	}
}
