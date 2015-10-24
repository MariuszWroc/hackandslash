package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.Journal;

@Repository
public interface JournalDao extends CrudRepository<Journal, Integer>{

}