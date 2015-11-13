package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Journal;

public interface IJournalService {
    void add(Journal journal);
    void delete(Journal journal);
    void update(Journal journal);
    Journal findById(Integer id);	
    List<Journal> findAll();
    List<Journal> findByQuery(Integer id);
}
