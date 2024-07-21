package Gestions;

import java.util.List;

import Dao.BookDao;
import Model.Book;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionBook {
	
	@Inject
	private BookDao bookDao;
	
	public Book getBook(int id) throws Exception {
		Book bookFound = this.bookDao.searchBook(id);
		
		if(bookFound == null) throw new Exception("Libro no existente");
		
		return bookFound;
	}
	
	public void createBook(Book book) throws Exception{
		if (book == null) throw new Exception ("Libro vacio");
		
		this.bookDao.createBook(book);
	}
	
	public void updateBook(Book book) throws Exception {
		if (book == null) throw new Exception ("Libro vacio");
		
		this.bookDao.updateBook(book);
	}
	
	public List<Book> listBooks(){
		return this.bookDao.listBooks();
	}
	
	
	public List<Book> listBooksCategory(String category){
		return this.bookDao.listBooksCategories(category);
	}
	
	
	public Book searchBook(int id) throws Exception{
		Book bookFound = this.bookDao.searchBook(id);
		
		if(bookFound == null) throw new Exception("Libro no encontrado") ;
			return bookFound;
		
	}
	
	public void deleteBook (int id)throws Exception{
		Book book = bookDao.searchBook(id);
		if(book == null) throw new Exception("Libro no existe");
		
		
			bookDao.deleteBook(id);
		
	}
	
	
}
