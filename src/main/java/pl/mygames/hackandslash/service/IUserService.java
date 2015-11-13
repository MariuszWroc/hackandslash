package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.GameUser;

public interface IUserService {
    void add(GameUser user);
    void delete(GameUser user);
    void update(GameUser user);
    GameUser findById(Integer id);
    List<GameUser> findAll();
    List<GameUser> findByQuery(Integer id);
}
