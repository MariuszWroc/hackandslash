package pl.mygames.hackandslash.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IHeroDao;
import pl.mygames.hackandslash.model.Hero;

@Repository
public class HeroDao extends GenericExtendedDao<Hero, Integer> implements IHeroDao{
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Hero> getHeroByParam(String paramName, String paramValue) {
        Criteria criteria = getSession().createCriteria(Hero.class);
            criteria.setFetchMode("gameUser", FetchMode.JOIN).createAlias("gameUser", "user");
            criteria.add(Restrictions.like("user.".concat(paramName), paramValue));
        return criteria.list();
    }
}