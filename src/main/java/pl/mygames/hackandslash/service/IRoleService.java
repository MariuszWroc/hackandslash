package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.GameRole;

public interface IRoleService extends IGenericService<GameRole, Integer>{
    void add(GameRole role);
    void delete(GameRole role);
    void update(GameRole role);
    GameRole findById(Integer id);
    List<GameRole> findAll();
	void delete(Integer id);
}
