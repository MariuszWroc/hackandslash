package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IPlaceDao;
import pl.mygames.hackandslash.model.Place;

@Repository
public class PlaceDao extends GenericExtendedDao<Place, Integer> implements IPlaceDao{

}