package pl.mygames.hackandslash.service;

import java.util.List;

import pl.mygames.hackandslash.dto.web.LoginDTO;
import pl.mygames.hackandslash.dto.user.UserDTO;
import pl.mygames.hackandslash.model.GameUser;

public interface IUserService extends IGenericService<GameUser, Integer>{
	List<GameUser> findByLogin(String login);
	Integer generateId();
    UserDTO getUserDTO(String login);
	Boolean isLoginSuccess(LoginDTO loginDTO);
	List<GameUser> findByPassword(String password);
	Boolean isRegisterUserValid(String login, String email);
	List<GameUser> findByEmail(String email);
	Boolean isAdd(GameUser user);
}
