package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.GameRole;

public interface IRoleService {
    void add(GameRole role);
    void delete(GameRole role);
    void update(GameRole role);
    GameRole findById(Integer id);	
}
