package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.IEquipmentDao;
import pl.mygames.hackandslash.model.Equipment;

@Repository
public final class EquipmentDao extends GenericExtendedDao<Equipment, Integer> implements IEquipmentDao{

}
