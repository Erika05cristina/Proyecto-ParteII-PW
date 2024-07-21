package proyectobackend.proyectobackend;

import Dao.BookDao;
import Dao.LendBookDAO;
import Dao.UserDao;
import Data.ImageData;
import Model.Book;
import Model.LendBook;
import Model.User;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Start {

	@Inject
	private BookDao bookDao;
	
	@Inject
	private UserDao userDao;
	
	@Inject
	private LendBookDAO lendBookDao;

	@PostConstruct
	public void init() {
		System.out.println("Hola mundo");

		LendBook lendBook = new LendBook();
		
		Book book = new Book();
		Book book2 = new Book();
		
		User userAdmin = new User();
		User user = new User();
		User user2 = new User();
				
		// ---- Books ----
		book.setBoo_id(1);
		book.setBoo_name("El perfume");
		book.setBoo_autor("Patrick Suskind");
		book.setBoo_category("Tragedia");
		book.setBoo_description("Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo).");
		book.setBoo_image(ImageData.perfume);
		
		book2.setBoo_id(2);
		book2.setBoo_name("Harry Potter");
		book2.setBoo_autor("J. K. Rowling");
		book2.setBoo_category("Ficcion");
		book2.setBoo_description("Harry Potter es una serie de novelas fantásticas escrita por la autora británica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.");
		book2.setBoo_image(ImageData.perfume);
		
		// |---- Users ----|
		
		userAdmin.setUs_id(1);
		userAdmin.setUs_name("Erika");
		userAdmin.setUs_lastname("Villa");
		userAdmin.setUs_cell("987452136");
		userAdmin.setUs_email("erivilla@gmail.com");
		userAdmin.setUs_password("erika123456");
		userAdmin.setUs_image(ImageData.userArt);
		userAdmin.setUs_admin(true);
		
		user.setUs_id(2);
		user.setUs_name("Jackson");
		user.setUs_lastname("Pearson");
		user.setUs_cell("0989621136");
		user.setUs_email("danharman@gmail.com");
		user.setUs_password("dani123456");
		user.setUs_image(ImageData.userBooks);
		user.setUs_admin(false);
		
		
		// ---- Lends ----
		
		// ---- Insert Data ----
		
		this.bookDao.createBook(book);
		this.bookDao.createBook(book2);
		
		this.userDao.createUser(userAdmin);
		this.userDao.createUser(user);
		
		
	}
	

}
