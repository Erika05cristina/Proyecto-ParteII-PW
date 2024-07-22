package Dao;

import java.util.List;

import Model.MyBooks;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MyBookDao {
	@PersistenceContext
	private EntityManager em;
	
	public void createMyBooks(MyBooks book) {
		try {
			em.persist(book);
		} catch (Exception e) {
	        e.printStackTrace();
			
		}
	}
	
	public void updateMyBooks(MyBooks book) {
		try {
			em.merge(book);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	public MyBooks searchMyBooks (int id) {
		try {
			return em.find(MyBooks.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	public void deleteMyBooks(int id) {
		try {
			MyBooks bookDelete = this.searchMyBooks(id);
			
			if (bookDelete == null) throw new Exception ("Libro no encontrado");			
			
			em.remove(bookDelete);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	public List<MyBooks> listMyBooks(){
		String jpql = "SELECT c From MyBooks c";
		Query query = em.createQuery(jpql, MyBooks.class);
		
		return query.getResultList();
	}
	
	
	

}
