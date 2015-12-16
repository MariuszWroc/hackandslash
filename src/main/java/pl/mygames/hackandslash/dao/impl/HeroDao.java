package pl.mygames.hackandslash.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IHeroDao;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.model.Hero;

@Repository
public class HeroDao extends GenericExtendedDao<Hero, Integer> implements IHeroDao{
    private static final Logger logger = LoggerFactory.getLogger(HeroDao.class);
    
    @Override
    public List<Hero> getHeroByUserLogin(String login) {
    	logger.info("getHeroByUserLogin");
        Criteria criteria = getSession().createCriteria(Hero.class);
            criteria.setFetchMode(GameUser.class.toString(), FetchMode.JOIN);
            List list = criteria.list();
        return list;
    }
}