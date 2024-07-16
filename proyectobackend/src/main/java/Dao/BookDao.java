package Dao;

import java.util.List;

import Model.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class BookDao {

	@PersistenceContext
	private EntityManager em;
	
	public void createBook(Book book) {
		try {
			em.persist(book);
		} catch (Exception e) {
	        e.printStackTrace();
			
		}
	}
	
	public void updateBook(Book book) {
		try {
			em.merge(book);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	public Book searchBook (int id) {
		try {
			return em.find(Book.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	public void deleteBook(int id) {
		try {
			Book bookDelete = this.searchBook(id);
			
			if (bookDelete == null) throw new Exception ("Libro no encontrado");			
			
			em.remove(bookDelete);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	public List<Book> listBooks(){
		String jpql = "SELECT c From Book c";
		Query query = em.createQuery(jpql, Book.class);
		
		return query.getResultList();
	}
	
	/**
	 * @description función para obtener un listado de libros segun la categoria pasada por el parametro
	 * @param category
	 * @return query
	 */
	public List<Book> listBooksCategories(String category){
		String jpql = "SELECT c FROM Book c WHERE c.boo_category = :category";		
		Query query = em.createQuery(jpql, Book.class);
		query.setParameter("category", category);
		
		return query.getResultList();
	}
}
