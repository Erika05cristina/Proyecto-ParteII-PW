package Dao;

import java.util.List;

import Model.LendBook;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class LendBookDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void createLendBook(LendBook lendBook) {
		try {
			em.persist(lendBook);
		} catch (Exception e) {
	        e.printStackTrace();			
		}
	}
	
	public void updateLendBook(LendBook lendBook) {
		try {
			em.merge(lendBook);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	public LendBook searchLendBook (int id) {
		try {
			return em.find(LendBook.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	public List<LendBook> listLendBook(){
		String jpql = "SELECT c From LendBook c";
		Query query = em.createQuery(jpql, LendBook.class);
		
		return query.getResultList();
	}
	
	public List<LendBook> listPendingReturns() {
        String jpql = "SELECT lb FROM LendBook lb WHERE lb.returnDate IS NULL";
        TypedQuery<LendBook> query = em.createQuery(jpql, LendBook.class);
        return query.getResultList();
    }
}
