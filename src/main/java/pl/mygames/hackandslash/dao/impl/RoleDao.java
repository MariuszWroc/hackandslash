package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IRoleDao;
import pl.mygames.hackandslash.model.GameRole;

@Repository
public class RoleDao extends GenericExtendedDao<GameRole, Integer> implements IRoleDao{

}
