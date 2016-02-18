package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IUserDao;
import pl.mygames.hackandslash.model.GameUser;

@Repository
public class UserDao extends GenericExtendedDao<GameUser, Integer> implements IUserDao{

}
