package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.HeroDao;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.IHeroService;

@Service
@Transactional(readOnly = true)
public class HeroService implements IHeroService{
	@Autowired
	private HeroDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Hero hero) {
		dao.save(hero);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Hero hero) {
		dao.delete(hero);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hero findById(Integer id) {
		return dao.findOne(id);
	}
}
