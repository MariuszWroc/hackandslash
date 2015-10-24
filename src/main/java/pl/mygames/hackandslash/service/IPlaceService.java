package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.Place;

public interface IPlaceService {
    void add(Place place);
    void delete(Place place);
    void update(Place place);
    Place findById(Integer id);	
}
