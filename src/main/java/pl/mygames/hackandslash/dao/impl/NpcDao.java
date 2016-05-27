package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.INpcDao;
import pl.mygames.hackandslash.model.Npc;

@Repository
public final class NpcDao extends GenericExtendedDao<Npc, Integer> implements INpcDao{

}