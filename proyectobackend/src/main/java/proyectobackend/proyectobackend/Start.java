package proyectobackend.proyectobackend;

import Dao.BookDao;
import Dao.LendBookDAO;
import Dao.MyBookDao;
import Dao.ReturnBookDAO;
import Dao.UserDao;
import Data.ImageData;
import Data.States;
import Model.Book;
import Model.LendBook;
import Model.MyBooks;
import Model.ReturnBook;
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
	
	@Inject
	private ReturnBookDAO returnBookDao;
	
	@Inject
	private MyBookDao myBookDao;

	@PostConstruct
	public void init() {
		System.out.println("Hola mundo");

		LendBook lendBook = new LendBook();
		LendBook lendBook2 = new LendBook();
		LendBook lendBook3 = new LendBook();
		
		ReturnBook returnBook = new ReturnBook();
		
		MyBooks myBooks1 = new MyBooks();
		MyBooks myBooks2 = new MyBooks();
		MyBooks myBooks3 = new MyBooks();
		
		Book book = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		
		User userAdmin = new User();
		User user = new User();	
		User user2 = new User();
				
//		otro usuario
//		my book  2 para usuario 1  y 1 para usuario 2 
//		otro libro
		
		// ---- Books ----
		//book.setBoo_id(1);
		book.setBoo_name("El perfume");
		book.setBoo_autor("Patrick Suskind");
		book.setBoo_category("Tragedia");
		book.setBoo_description("Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo).");
		book.setBoo_image(ImageData.perfume);
		book.setBoo_state(States.disponible);
		
		//book2.setBoo_id(2);
		book2.setBoo_name("Harry Potter");
		book2.setBoo_autor("J. K. Rowling");
		book2.setBoo_category("Ficcion");
		book2.setBoo_description("Harry Potter es una serie de novelas fantásticas escrita por la autora británica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.");
		book2.setBoo_image(ImageData.harryPotter);
		book2.setBoo_state(States.disponible);
		
		//book3.setBoo_id(3);
		book3.setBoo_name("Romeo y Julieta");
		book3.setBoo_autor("William Shakeaspeare");
		book3.setBoo_category("Romance");
		book3.setBoo_description("Romeo y Julieta ​ es una tragedia del dramaturgo inglés William Shakespeare. Cuenta la historia de dos jóvenes que, a pesar de la oposición de sus familiares, rivales entre sí, deciden casarse de forma secreta");
		book3.setBoo_image(ImageData.romeoJulieta);
		book3.setBoo_state(States.disponible);
		
		// |----  Users  ----|
		
		//userAdmin.setUs_id(1);
		userAdmin.setUs_name("Erika");
		userAdmin.setUs_lastname("Villa");
		userAdmin.setUs_cell("987452136");
		userAdmin.setUs_email("erivilla@gmail.com");
		userAdmin.setUs_password("erika123456");
		userAdmin.setUs_image(ImageData.userArt);
		userAdmin.setUs_admin(true);
		
		//user.setUs_id(2);
		user.setUs_name("Jackson");
		user.setUs_lastname("Pearson");
		user.setUs_cell("0989621136");
		user.setUs_email("danharman@gmail.com");
		user.setUs_password("dani123456");
		user.setUs_image(ImageData.userBooks);
		user.setUs_admin(false);
		
		//user2.setUs_id(3);
		user2.setUs_name("Sebastian");
		user2.setUs_lastname("Calle");
		user2.setUs_cell("09987254166");
		user2.setUs_email("sebascalle@gmail.com");
		user2.setUs_password("12323234343");
		user2.setUs_image(ImageData.userBooks);
		user2.setUs_admin(false);
		
		
		// ---- Lends ----
		
		//lendBook.setLenboo_id(1);
		lendBook.setLenboo_idBook(book2.getBoo_id());
		lendBook.setLenboo_nameBook(book2.getBoo_name());
		lendBook.setLenboo_category(book2.getBoo_category());
		lendBook.setLenboo_idUser(user2.getUs_id());
		lendBook.setLenboo_nameUser(user2.getUs_name());
		lendBook.setLenboo_inicial_date("05/07/2024");
		lendBook.setLenboo_limit_date("10/07/2024");
		
		//lendBook2.setLenboo_id(2);
		lendBook.setLenboo_idBook(book.getBoo_id());
		lendBook2.setLenboo_nameBook(book.getBoo_name());
		lendBook2.setLenboo_category(book.getBoo_category());
		lendBook.setLenboo_idUser(user2.getUs_id());
		lendBook2.setLenboo_nameUser(user2.getUs_name());
		lendBook2.setLenboo_inicial_date("05/07/2024");
		lendBook2.setLenboo_limit_date("10/07/2024");		
		
		//lendBook3.setLenboo_id(3);
		lendBook.setLenboo_idBook(book3.getBoo_id());
		lendBook3.setLenboo_nameBook(book3.getBoo_name());
		lendBook3.setLenboo_category(book3.getBoo_category());
		lendBook.setLenboo_idUser(user.getUs_id());
		lendBook3.setLenboo_nameUser(user.getUs_name());
		lendBook3.setLenboo_inicial_date("15/07/2024");
		lendBook3.setLenboo_limit_date("23/07/2024");
		
		
		// ---- Return -----
		//returnBook.setRetboo_id(1);
		returnBook.setRetboo_name(book2.getBoo_name());
		returnBook.setRetboo_nameUser(user.getUs_name());
		returnBook.setRetboo_category(book2.getBoo_category());
		returnBook.setRetboo_date("10/07/2024");
		
		// --- My Books ---
		//myBooks1.setMyBoo_id(1);
		myBooks1.setMyBoo_idBook(book2.getBoo_id());
		myBooks1.setMyBoo_idUser(user2.getUs_id());
		myBooks1.setMyBoo_inicial_date("05/07/2024");
		myBooks1.setMyBoo_limit_date("10/07/2024");
		myBooks1.setMyBoo_nameBook(book2.getBoo_name());
		myBooks1.setMyBoo_nameUser(user2.getUs_name());
		myBooks1.setMyBoo_stateBook(States.prestado);
		
		//myBooks2.setMyBoo_id(2);
		myBooks2.setMyBoo_idBook(book.getBoo_id());
		myBooks2.setMyBoo_idUser(user2.getUs_id());
		myBooks2.setMyBoo_inicial_date("05/07/2024");
		myBooks2.setMyBoo_limit_date("19/07/2024");
		myBooks2.setMyBoo_nameBook(book.getBoo_name());
		myBooks2.setMyBoo_nameUser(user2.getUs_name());
		myBooks2.setMyBoo_stateBook(States.prestado);
		
		//myBooks3.setMyBoo_id(3);
		myBooks3.setMyBoo_idBook(book3.getBoo_id());
		myBooks3.setMyBoo_idUser(user.getUs_id());
		myBooks3.setMyBoo_inicial_date("05/07/2024");
		myBooks3.setMyBoo_limit_date("13/07/2024");
		myBooks3.setMyBoo_nameBook(book3.getBoo_name());
		myBooks3.setMyBoo_nameUser(user.getUs_name());
		myBooks3.setMyBoo_stateBook(States.prestado);
		
		
		// ---- Insert Data ----
		
		this.bookDao.createBook(book);
		this.bookDao.createBook(book2);
		this.bookDao.createBook(book3);
		
		this.userDao.createUser(userAdmin);
		this.userDao.createUser(user);
		this.userDao.createUser(user2);
		
		this.lendBookDao.createLendBook(lendBook);
		this.lendBookDao.createLendBook(lendBook2);
		this.lendBookDao.createLendBook(lendBook3);
		
		this.returnBookDao.createReturnBook(returnBook);
		
		this.myBookDao.createMyBooks(myBooks1);
		this.myBookDao.createMyBooks(myBooks2);
		this.myBookDao.createMyBooks(myBooks3);
		
		
	}
	

}
