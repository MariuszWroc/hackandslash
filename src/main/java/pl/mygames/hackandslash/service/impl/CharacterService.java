package pl.mygames.hackandslash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.CharacterDao;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.service.ICharacterService;

@Service
@Transactional(readOnly = true)
public class CharacterService implements ICharacterService{
	@Autowired
	private CharacterDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(GameCharacter character) {
		dao.save(character);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(GameCharacter character) {
		dao.delete(character);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(GameCharacter character) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameCharacter findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}
}
