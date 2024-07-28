package Gestions;

import java.util.ArrayList;
import java.util.List;

import Dao.LendBookDAO;
import Model.LendBook;
import Model.TopBooks;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionLendBook {
	
	@Inject
	private LendBookDAO lendBookDAO;
	
	public LendBook getLendBook(int id) throws Exception {
		LendBook lendBookFound = this.lendBookDAO.searchLendBook(id);

		if (lendBookFound == null)
			throw new Exception("Dato no existente");

		return lendBookFound;
	}

	public void createLendBook(LendBook lendBook) throws Exception {
		if (lendBook == null)
			throw new Exception("Libro prestado vacío");

		this.lendBookDAO.createLendBook(lendBook);
	}
	

	public void updateLendBook(LendBook lendBook) throws Exception {
		if (lendBook == null)
			throw new Exception("Libro prestado vacío");

		this.lendBookDAO.updateLendBook(lendBook);
	}
	
	
	
	public void deleteLendBook(int id) throws Exception {
		if(id == 0) throw new Exception("Id no valido");
		
		this.lendBookDAO.deleteLendBook(id);
	}
	

	public List<LendBook> listLendBooks() {
		return this.lendBookDAO.listLendBook();
	}

	
	public LendBook searchLendBook(int id) throws Exception {
		LendBook lendBookFound = this.lendBookDAO.searchLendBook(id);

		if (lendBookFound == null)
			throw new Exception("Libro prestado no encontrado");
		return lendBookFound;
	} 
	
	
	public LendBook searchLendBookByIdBook(int idBook, int idUser) throws Exception {
		LendBook lendBookFound = this.lendBookDAO.getLendBookByIdBook(idBook, idUser);
		
		if(lendBookFound == null) throw new Exception("Libro no econtrado");
		
		return lendBookFound;
	}
	
	
	public List<Object[]> getMostReadBooksByMonth() {
        return (List<Object[]>) this.lendBookDAO.getMostReadBooksByMonth();
    }
	
	 public List<Object[]> getClientOfTheMonth() {
	        int currentMonth = getMonth();
	        return lendBookDAO.getClientOfTheMonth(currentMonth);
	    }

	private int getMonth() {
		return java.time.LocalDate.now().getMonthValue(); // Devuelve el mes actual como número entero
	}
	
	public List<TopBooks> getMostReadBooksByMonthDTO() {
        List<Object[]> results = this.lendBookDAO.getMostReadBooksByMonth();
        List<TopBooks> mostReadBooks = new ArrayList<>();

        for (Object[] result : results) {
            String bookName = (String) result[0];
            Long count = (Long) result[1];
            mostReadBooks.add(new TopBooks(bookName, count));
        }

        return mostReadBooks;
    }


}