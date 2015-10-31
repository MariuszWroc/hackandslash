package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.PlaceDao;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.Place;
import pl.mygames.hackandslash.service.IPlaceService;

@Service
@Transactional(readOnly = true)
public class PlaceService implements IPlaceService{
	@Autowired
	private PlaceDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Place place) {
		dao.add(place);
	}

	@Transactional(readOnly = false)
        @Secured("ROLE_ADMIN")
	@Override
	public void delete(Place place) {
		dao.delete(place);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Place place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Place findById(Integer id) {
		return dao.findById(id);
	}
                
        @Override
	public List<Place> findAll() {
		return dao.findAll();
	}

    public void setDao(PlaceDao dao) {
        this.dao = dao;
    }
}
