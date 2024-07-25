package Dao;

import java.util.List;

import Model.Book;
import Model.MyBooks;
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
			//**
			Book book = em.find(Book.class, id);
			return book;
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
		String jpql = "SELECT b From Book b";
		//***
	    System.out.println("Executing JPQL query: " + jpql); // Imprime el query en consola

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
	
	/**
	 * @description función para obtener un listado de libros segun el nombre pasada por el parametro
	 * @param name
	 * @return query
	 */
	public List<Book> listBooksName(String name){
		String jpql = "SELECT c FROM Book c WHERE c.boo_name = :name";		
		Query query = em.createQuery(jpql, Book.class);
		query.setParameter("name", name);
		
		return query.getResultList();
	}
	
	/**
	 * @description función para obtener un listado de libros segun el autor pasada por el parametro
	 * @param name
	 * @return query
	 */
	public List<Book> listBooksAutor(String autor){
		String jpql = "SELECT c FROM Book c WHERE c.boo_autor = :autor";		
		Query query = em.createQuery(jpql, Book.class);
		query.setParameter("autor", autor);
		
		return query.getResultList();
	}
	
	
	/**
	 * @description función para obtener un listado de libros segun el estado pasada por el parametro
	 * @param name
	 * @return query
	 */
	public List<Book> listBooksState(String state){
		String jpql = "SELECT c FROM Book c WHERE c.boo_state = :state";		
		Query query = em.createQuery(jpql, Book.class);
		query.setParameter("state", state);
		
		return query.getResultList();
	}
	
	
	public List<Book> listBookFromMyBook(int idUser){		
		String jpql = "SELECT b FROM Book b, MyBooks mb " + "WHERE mb.myBoo_idBook = b.boo_id "
				+ "AND mb.myBoo_idUser = :idUser";
		
		Query query = em.createQuery(jpql, MyBooks.class);
		query.setParameter("idUser", idUser);
		
		return query.getResultList();

	}
}
