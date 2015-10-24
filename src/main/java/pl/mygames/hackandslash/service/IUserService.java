package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.GameUser;

public interface IUserService {
    void add(GameUser user);
    void delete(GameUser user);
    void update(GameUser user);
    GameUser findById(Integer id);	
}
