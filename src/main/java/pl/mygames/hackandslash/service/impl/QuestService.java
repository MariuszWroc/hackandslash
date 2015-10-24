package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.QuestDao;
import pl.mygames.hackandslash.model.Quest;
import pl.mygames.hackandslash.service.IQuestService;

@Service
@Transactional(readOnly = true)
public class QuestService implements IQuestService{
	@Autowired
	private QuestDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Quest quest) {
		dao.save(quest);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Quest quest) {
		dao.delete(quest);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Quest quest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quest findById(Integer id) {
		return dao.findOne(id);
	}
}
