package Gestions;

import java.util.List;

import Dao.LendBookDAO;
import Model.LendBook;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionLendBook {
	
	@Inject
	private LendBookDAO lendBookDAO;
	
	 public List<LendBook> getPendingReturns() {
	        return lendBookDAO.listPendingReturns();
	    }

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

	public List<LendBook> listLendBooks() {
		return this.lendBookDAO.listLendBook();
	}

	public LendBook searchLendBook(int id) throws Exception {
		LendBook lendBookFound = this.lendBookDAO.searchLendBook(id);

		if (lendBookFound == null)
			throw new Exception("Libro prestado no encontrado");
		return lendBookFound;
	}

}