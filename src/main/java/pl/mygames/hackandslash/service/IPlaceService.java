package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Place;

public interface IPlaceService {
    void add(Place place);
    void delete(Place place);
    void update(Place place);
    List<Place> findById(Integer id);
    List<Place> findAll();
	void delete(Integer id);
}
