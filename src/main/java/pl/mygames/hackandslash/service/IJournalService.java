package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.Journal;

public interface IJournalService {
    void add(Journal journal);
    void delete(Journal journal);
    void update(Journal journal);
    Journal findById(Integer id);	
}
