package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.JournalDao;
import pl.mygames.hackandslash.model.Journal;
import pl.mygames.hackandslash.service.IJournalService;

@Service
@Transactional(readOnly = true)
public class JournalService implements IJournalService {

    @Autowired
    private JournalDao dao;

    @Transactional(readOnly = false)
    @Override
    public void add(Journal journal) {
        dao.add(journal);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Journal journal) {
        dao.delete(journal);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Journal journal) {
	dao.update(journal);
    }

    @Override
    public Journal findById(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    public List<Journal> findByQuery(Integer id) {
        String query = "FROM Journal J WHERE J.id = " + id;
        
        return dao.findByQuery(query);
    }

    @Override
    public List<Journal> findAll() {
        return dao.findAll();
    }

    public void setDao(JournalDao dao) {
        this.dao = dao;
    }
}
