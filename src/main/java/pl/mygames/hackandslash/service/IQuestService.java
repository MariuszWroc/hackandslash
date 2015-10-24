package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.Quest;

public interface IQuestService {
    void add(Quest quest);
    void delete(Quest quest);
    void update(Quest quest);
    Quest findById(Integer id);	
}
