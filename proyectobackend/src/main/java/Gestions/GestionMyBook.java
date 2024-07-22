package Gestions;

import java.util.List;

import Dao.MyBookDao;
import Model.MyBooks;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionMyBook {
	@Inject
	private MyBookDao myBookDao;
	public MyBooks getMyBook(int id) throws Exception {
		MyBooks bookFound = this.myBookDao.searchMyBooks(id);
		
		if(bookFound == null) throw new Exception("Libro no existente");
		
		return bookFound;
	}
	
	public void createMyBook(MyBooks book) throws Exception{
		if (book == null) throw new Exception ("Libro vacio");
		
		this.myBookDao.createMyBooks(book);
	}
	
	public void updateMyBook(MyBooks book) throws Exception {
		if (book == null) throw new Exception ("Libro vacio");
		
		this.myBookDao.updateMyBooks(book);
	}
	
	public List<MyBooks> listMyBooks(){
		return this.myBookDao.listMyBooks();
	}
	
	
	
	
	public MyBooks searchMyBook(int id) throws Exception{
		MyBooks bookFound = this.myBookDao.searchMyBooks(id);
		
		if(bookFound == null) throw new Exception("Libro no encontrado") ;
			return bookFound;
		
	}
	
	public void deleteMyBook (int id)throws Exception{
		MyBooks book = myBookDao.searchMyBooks(id);
		if(book == null) throw new Exception("Libro no existe");
		
		
		myBookDao.deleteMyBooks(id);
		
	}
	
	
}