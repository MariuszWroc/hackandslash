package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IQuestDao;
import pl.mygames.hackandslash.model.Quest;

@Repository
public class QuestDao extends GenericExtendedDao<Quest, Integer> implements IQuestDao{

}