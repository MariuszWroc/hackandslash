package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IJournalDao;
import pl.mygames.hackandslash.dao.impl.JournalDao;
import pl.mygames.hackandslash.model.JournalPage;
import pl.mygames.hackandslash.service.IJournalService;

@Service
@Transactional(readOnly = true)
public class JournalService implements IJournalService {
	private static final Logger logger = LoggerFactory.getLogger(JournalService.class);
	
    @Autowired
    private IJournalDao dao;

    @Transactional(readOnly = false)
    @Override
    public void add(JournalPage journal) {
        dao.add(journal);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(JournalPage journal) {
        dao.delete(journal);
    }
    
    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(JournalPage journal) {
    	dao.update(journal);
    }

    @Override
    public JournalPage findById(Integer id) {
    	JournalPage journal;
		List<JournalPage> journals = dao.findByQuery("GameCharacter.findById", id);
		if (journals.isEmpty()){
    		logger.info("Equipments list is empty");
    		journal = new JournalPage();
    	} else {
    		journal = journals.iterator().next();
    		if (journals.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return journal;
    }

    @Override
    public List<JournalPage> findAll() {
        return dao.findByQuery("Journal.findAll");
    }

    public void setDao(JournalDao dao) {
        this.dao = dao;
    }
}
