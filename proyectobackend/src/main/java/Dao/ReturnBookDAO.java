package Dao;

import java.util.List;

import Model.ReturnBook;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ReturnBookDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void createReturnBook(ReturnBook returnBook) {
		try {
			em.persist(returnBook);
		} catch (Exception e) {
	        e.printStackTrace();			
		}
	}
	
	public void updateReturnBook(ReturnBook returnBook) {
		try {
			em.merge(returnBook);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	public ReturnBook searchReturnBook (int id) {
		try {
			return em.find(ReturnBook.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	public List<ReturnBook> listReturnBook(){
		String jpql = "SELECT c From ReturnBook c";
		Query query = em.createQuery(jpql, ReturnBook.class);
		
		return query.getResultList();
	}
}
