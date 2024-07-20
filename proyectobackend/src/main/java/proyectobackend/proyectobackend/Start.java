package proyectobackend.proyectobackend;

import Dao.BookDao;
import Model.Book;
import Model.LendBook;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Start {

	@Inject
	private BookDao daoBook;
	@Inject
	private LendBook daoLendBook;

	@PostConstruct
	public void init() {
		System.out.println("Hola mundo");

		LendBook lendBook = new LendBook();
		Book book = new Book();

		book.setBoo_id(0);
		book.setBoo_name("Sherlock");
		book.setBoo_autro("señor");
		book.setBoo_category("Misterio");
		book.setBoo_image(null);
		
		lendBook.setLenboo_id(0);
		lendBook.setLenboo_name("Sherlock");
		lendBook.setLenboo_category("Misterio");
		lendBook.setLenboo_date("mayo");
		lendBook.setLenboo_nameUser("Erika");
	}
	

}
