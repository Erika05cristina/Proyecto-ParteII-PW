package Gestions;

import java.util.List;

import Dao.UserDao;
import Model.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUser {

	@Inject
	private UserDao userDao;
	
	public void createUser(User user) throws Exception{
		if(user == null) throw new Exception ("Error al crear el usuario");
		
		this.userDao.createUser(user);
	}
	
	public void updateUser(User user) throws Exception {
		if(user == null) throw new Exception ("Error al modificar el usuario");
		
		this.userDao.updateUser(user);		
	}
	
	public User searchEmailUser(String email) throws Exception {
		User userFound = this.userDao.searchEmailUser(email);
		
		if(userFound == null) throw new Exception ("Usuario no encontrado");
		
		return userFound;
	}
	
	public User searchUser(int id) throws Exception {
		User userFound = this.userDao.searchIdUser(id);
		
		if(userFound == null) throw new Exception ("Usuario no encontrado");
		
		return userFound;
	}	
	
	public List<User>listUsers(){
		return this.userDao.listUsers();
	}
	
}
