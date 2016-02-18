package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Place;

public interface IPlaceService extends IGenericService<Place, Integer>{
    void add(Place place);
    void delete(Place place);
    void update(Place place);
    Place findById(Integer id);
    List<Place> findAll();
	void delete(Integer id);
}
