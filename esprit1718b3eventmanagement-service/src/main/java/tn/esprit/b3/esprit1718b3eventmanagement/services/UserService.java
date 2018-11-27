package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		super(User.class);
	}

	@Override
	public User login(String login, String password) {
		
		User user = null;
		try {
		user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.password=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}	
		return user;	
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteUser(User user) {

		entityManager.remove(entityManager.merge(user));
	}

	@Override
	public void updateUser(User user) {

		entityManager.merge(user);
	}

	@Override
	public User findById(int idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public User findUserByLogin(String login) {
		return entityManager.createQuery("select u from User u where u.login=?1", User.class).setParameter(1, login)
				.getSingleResult();
	}
	
	@Override
	public User findUserByEmail(String email) {
		return entityManager.createQuery("select u from User u where u.email=?1", User.class).setParameter(1, email)
				.getSingleResult();
	}

	@Override
	public List<User> getAllUser() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public List<User> getUserByfirstLastName(String first) {
		return entityManager.createQuery("SELECT t FROM User t WHERE t.firstName || t.lastName LIKE  '%' || :first || '%' ", User.class)
				 .setParameter("first",first)
				 .getResultList();		
	}
	
	
}
