package Dao;

import java.util.List;

import Model.Book;
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

	public MyBooks searchMyBooks(int id) {
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

			if (bookDelete == null)
				throw new Exception("Libro no encontrado");

			em.remove(bookDelete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MyBooks> listAllMyBooks() {
		String jpql = "SELECT mb From MyBooks mb";
		Query query = em.createQuery(jpql, MyBooks.class);

		return query.getResultList();
	}

	public List<MyBooks> listMyBooks(int idUser) {
		String jpql = "SELECT mb FROM MyBooks mb, Book b " + "WHERE mb.myBoo_idBook = b.boo_id "
				+ "AND mb.myBoo_idUser = :idUser";

		Query query = em.createQuery(jpql, MyBooks.class);
		query.setParameter("idUser", idUser);

		return query.getResultList();
	}

//	  public List<MyBooks> listOverdueBooks() {
//	        String jpql = "SELECT mb FROM MyBooks mb WHERE FUNCTION('TO_DATE', mb.myBoo_limit_date, 'DD/MM/YYYY') <= CURRENT_DATE";
//	        Query query = em.createQuery(jpql, MyBooks.class);
//	        return query.getResultList();
//	    }
//	  
	  public List<MyBooks> listOverdueBooks(int idUser) {
	        String jpql ="SELECT mb FROM MyBooks mb WHERE FUNCTION('TO_DATE', mb.myBoo_limit_date, 'DD/MM/YYYY') <= CURRENT_DATE AND myBoo_idUser = :idUser";
	        Query query = em.createQuery(jpql, MyBooks.class);
	        query.setParameter("idUser", idUser);
	        return query.getResultList();
	    }

}
