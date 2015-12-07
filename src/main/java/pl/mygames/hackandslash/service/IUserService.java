package pl.mygames.hackandslash.service;

import java.util.List;

import pl.mygames.hackandslash.dto.LoginDTO;
import pl.mygames.hackandslash.dto.UserDTO;

import pl.mygames.hackandslash.model.GameUser;

public interface IUserService {
    Boolean add(GameUser user);
    void delete(GameUser user);
    void update(GameUser user);
    List<GameUser> findById(Integer id);
    List<GameUser> findAll();
	void delete(Integer id);
	List<GameUser> findByLogin(String login);
	Integer generateId();
    UserDTO getUserDTO(String login);
	Boolean isLoginSuccess(LoginDTO loginDTO);
	List<GameUser> findByPassword(String password);
}
