package Gestions;

import java.util.List;

import Dao.ReturnBookDAO;
import Model.ReturnBook;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionReturnBook {
	 @Inject
	    private ReturnBookDAO returnBookDAO;

	    public ReturnBook getReturnBook(int id) throws Exception {
	        ReturnBook searchReturnBookFound = this.returnBookDAO.searchReturnBook(id);
	        
	        if (searchReturnBookFound == null) throw new Exception("Libro devuelto no existente");
	        
	        return searchReturnBookFound;
	    }

	    public void createReturnBook(ReturnBook returnBook) throws Exception {
	        if (returnBook == null) throw new Exception("Libro devuelto vacío");
	        
	        this.returnBookDAO.createReturnBook(returnBook);
	    }

	    public void updateReturnBook(ReturnBook returnBook) throws Exception {
	        if (returnBook == null) throw new Exception("Libro devuelto vacío");
	        
	        this.returnBookDAO.updateReturnBook(returnBook);
	    }

	    public List<ReturnBook> listReturnBooks() {
	        return this.returnBookDAO.listReturnBook();
	    }

	    public ReturnBook searchReturnBook(int id) throws Exception {
	        ReturnBook returnBookFound = this.returnBookDAO.searchReturnBook(id);
	        
	        if (returnBookFound == null) throw new Exception("Libro devuelto no encontrado");
	        
	        return returnBookFound;
	    }
	    
		/**
		 * @describe El cliente del mes para el reporte
		 * 
		 */	    
	    public List<Object[]> getClientOfTheMonth() {
	        int currentMonth = getMonth();
	        return returnBookDAO.getClientOfTheMonth(currentMonth);
	    }

	private int getMonth() {
		return java.time.LocalDate.now().getMonthValue(); // Devuelve el mes actual como número entero
	}

	
}
