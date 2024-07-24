package Dao;

import java.util.List;

import Model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void createUser(User user) {
		try {
			em.persist(user);
		} catch (Exception e) {
			// TODO: handle exception
	        e.printStackTrace();
		}		
	}
	
	public void updateUser(User user) {
		try {
			em.merge(user);
		} catch (Exception e) {
			// TODO: handle exception
	        e.printStackTrace();
		}
	}
	
	/**
	 * @description funcion para buscar al usuario por su "EMAIL" y no por su id
	 * @param email
	 * @return User | null
	 */
	public User searchEmailUser(String email) {
		try {
			String jpql = "SELECT u FROM User u WHERE u.us_email = :email";
			Query query = em.createQuery(jpql, User.class);
			query.setParameter("email", email);
			
			return (User) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}		
	}
	
	public User searchNameUser(String username) {
		try {
			String jpql = "SELECT u FROM User u WHERE u.us_username = :username";
			Query query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			
			return (User) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User searchIdUser(int id) {
		try {
			return em.find(User.class, id);
		} catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
	}
	
	public void deleteUser(int id) {
		try {
			User userDelete = this.searchIdUser(id);
			if(userDelete == null) throw new Exception ("Usuario no encontrado");
			
			em.remove(em);
		} catch (Exception e) {			
	        e.printStackTrace();
		}
	}
	
	public List<User> listUsers(){
		String jpql = "SELECT u FROM User u";
		//***
	    System.out.println("Executing JPQL query: " + jpql); // Imprime el query en consola
		Query query = em.createQuery(jpql, User.class);
		
		return query.getResultList();
	}
}
