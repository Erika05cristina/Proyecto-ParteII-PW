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
	
	/**
	 * @describe El cliente del mes para el reporte
	 * 
	 */
	public List<Object[]> getClientOfTheMonth(int currentMonth) {
	String sql = 
//		"SELECT l.lenboo_idUser, l.lenboo_nameUser, COUNT(l.lenboo_idUser) AS book_count "
//				+ "FROM Bib_LendBook l "
//				+ "WHERE EXTRACT(MONTH FROM TO_DATE(l.lenboo_inicial_date, 'DD-MM-YYYY')) = :currentMonth "
//				+ "GROUP BY l.lenboo_idUser, l.lenboo_nameUser " + "ORDER BY book_count DESC";
		
		"SELECT l.retboo_iduser, l.retboo_nameuser, COUNT(l.retboo_iduser) AS book_count "
		+ "	FROM bib_returnbook l "
		+ "	WHERE EXTRACT(MONTH FROM TO_DATE(l.retboo_date, 'DD-MM-YYYY')) = :currentMonth "
		+ "	                GROUP BY l.retboo_iduser, l.retboo_nameuser "
		+ "	                 ORDER BY book_count DESC";
	
		Query query = em.createNativeQuery(sql);
		query.setParameter("currentMonth", currentMonth);
		query.setMaxResults(1);
		return query.getResultList();
	}

	private int getMonth() {
		return java.time.LocalDate.now().getMonthValue(); // Devuelve el mes actual como número entero
	}
}
