package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IPlaceDao;
import pl.mygames.hackandslash.dao.impl.PlaceDao;
import pl.mygames.hackandslash.model.Place;
import pl.mygames.hackandslash.service.IPlaceService;

@Service
@Transactional(readOnly = true)
public class PlaceService implements IPlaceService {
	private static final Logger logger = LoggerFactory.getLogger(PlaceService.class);
	
    @Autowired
    private IPlaceDao dao;

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
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Place place) {
	dao.update(place);
    }

    @Override
    public Place findById(Integer id) {
    	Place place;
		List<Place> places = dao.findByQuery("GameCharacter.findById", id);
		if (places.isEmpty()){
    		logger.info("Equipments list is empty");
    		place = new Place();
    	} else {
    		place = places.iterator().next();
    		if (places.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return place;
    }

    @Override
    public List<Place> findAll() {
        return dao.findByQuery("Place.findAll");
    }

    public void setDao(PlaceDao dao) {
        this.dao = dao;
    }
}
