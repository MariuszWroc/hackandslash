package pl.mygames.hackandslash.service;

import java.util.List;

import pl.mygames.hackandslash.model.Quest;

public interface IQuestService extends IGenericService<Quest, Integer>{
    void add(Quest quest);
    void delete(Quest quest);
    void update(Quest quest);
    Quest findById(Integer id);
    List<Quest> findAll();
	void delete(Integer id);
}
