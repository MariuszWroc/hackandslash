package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IJournalDao;
import pl.mygames.hackandslash.model.JournalPage;

@Repository
public final class JournalDao extends GenericExtendedDao<JournalPage, Integer> implements IJournalDao{

}