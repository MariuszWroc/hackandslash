package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.QuestDao;
import pl.mygames.hackandslash.model.Quest;
import pl.mygames.hackandslash.service.IQuestService;

@Service
@Transactional(readOnly = true)
public class QuestService implements IQuestService {

    @Autowired
    private QuestDao dao;

    public void setDao(QuestDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = false)
    @Override
    public void add(Quest quest) {
        dao.add(quest);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Quest quest) {
        dao.delete(quest);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Quest quest) {
	dao.update(quest);
    }

    @Override
    public Quest findById(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    public List<Quest> findByQuery(Integer id) {
        String query = "FROM Quest Q WHERE Q.id = " + id;
        
        return dao.findByQuery(query);
    }

    @Override
    public List<Quest> findAll() {
        return dao.findAll();
    }
}
