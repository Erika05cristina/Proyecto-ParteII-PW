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
	
	/**
	 * @describe Top 5 libros mas leidos para el reporte
	 * 
	 */
	    public List<Object[]> getMostReadBooksByMonth() {
	        String jpql = "SELECT l.lenboo_nameBook, COUNT(l.lenboo_idBook) " +
	                      "FROM LendBook l " +
	                      "GROUP BY l.lenboo_nameBook " +
	                      "ORDER BY COUNT(l.lenboo_idBook) DESC";
	        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
	        query.setMaxResults(5);
	        return query.getResultList();
	    }
	
	
	public List<LendBook> listPendingReturns() {
        String jpql = "SELECT lb FROM LendBook lb WHERE lb.returnDate IS NULL";
        TypedQuery<LendBook> query = em.createQuery(jpql, LendBook.class);
        return query.getResultList();
    }
}
