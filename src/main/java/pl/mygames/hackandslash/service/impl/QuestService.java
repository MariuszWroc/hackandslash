package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IQuestDao;
import pl.mygames.hackandslash.dao.impl.QuestDao;
import pl.mygames.hackandslash.model.Quest;
import pl.mygames.hackandslash.service.IQuestService;

@Service
@Transactional(readOnly = true)
public class QuestService implements IQuestService {
	private static final Logger logger = LoggerFactory.getLogger(QuestService.class);
	
    @Autowired
    private IQuestDao dao;


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
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Quest quest) {
	dao.update(quest);
    }

    @Override
    public Quest findById(Integer id) {
    	Quest quest;
		List<Quest> quests = dao.findByQuery("GameCharacter.findById", id);
		if (quests.isEmpty()){
    		logger.info("Equipments list is empty");
    		quest = new Quest();
    	} else {
    		quest = quests.iterator().next();
    		if (quests.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return quest;
    }

    @Override
    public List<Quest> findAll() {
        return dao.findByQuery("Quest.findAll");
    }

    public void setDao(QuestDao dao) {
        this.dao = dao;
    }
}
