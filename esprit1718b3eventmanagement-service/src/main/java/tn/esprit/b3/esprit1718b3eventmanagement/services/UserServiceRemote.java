package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {
	
	public User login(String login, String password);
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User findById(int idUser);
	public User findUserByLogin(String login);
	public List<User> getAllUser();
	public List<User> getUserByfirstLastName(String first);
	User findUserByEmail(String email);
	
}
