package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.JournalDao;
import pl.mygames.hackandslash.model.Journal;
import pl.mygames.hackandslash.service.IJournalService;

@Service
@Transactional(readOnly = true)
public class JournalService implements IJournalService{
	@Autowired
	private JournalDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Journal journal) {
		dao.save(journal);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Journal journal) {
		dao.delete(journal);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Journal journal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Journal findById(Integer id) {
		return dao.findOne(id);
	}
}
