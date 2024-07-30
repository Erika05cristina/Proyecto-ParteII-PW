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
		LendBook lendBook4 = new LendBook();

		ReturnBook returnBook = new ReturnBook();

		MyBooks myBooks1 = new MyBooks();
		MyBooks myBooks2 = new MyBooks();
		MyBooks myBooks3 = new MyBooks();

		Book book = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();

		User userAdmin = new User();
		User user = new User();
		User user2 = new User();

		// ---- Books Base ----
		book.setBoo_name("El perfume");
		book.setBoo_autor("Patrick Suskind");
		book.setBoo_category("Tragedia");
		book.setBoo_description(
				"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo).");
		book.setBoo_image(ImageData.perfume);
		book.setBoo_state(States.disponible);

		book2.setBoo_name("Harry Potter");
		book2.setBoo_autor("J. K. Rowling");
		book2.setBoo_category("Ficcion");
		book2.setBoo_description(
				"Harry Potter es una serie de novelas fantásticas escrita por la autora británica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.");
		book2.setBoo_image(ImageData.harryPotter);
		book2.setBoo_state(States.disponible);

		book3.setBoo_name("Romeo y Julieta");
		book3.setBoo_autor("William Shakeaspeare");
		book3.setBoo_category("Romance");
		book3.setBoo_description(
				"Romeo y Julieta ​ es una tragedia del dramaturgo inglés William Shakespeare. Cuenta la historia de dos jóvenes que, a pesar de la oposición de sus familiares, rivales entre sí, deciden casarse de forma secreta");
		book3.setBoo_image(ImageData.romeoJulieta);
		book3.setBoo_state(States.disponible);

		book4.setBoo_name("Odontología");
		book4.setBoo_autor("Doctor German");
		book4.setBoo_category("Medicina");
		book4.setBoo_description(
				"Durante los primeros dos años de la escuela de odontología, los estudiantes se enfocan en estudios de salón de clases y de laboratorio en ciencias de la salud y estomatología . Los cursos pueden incluir patología bucal, periodoncia, anestesia dental, ortodoncia, radiología y farmacología.");
		book4.setBoo_image(ImageData.odontologia);
		book4.setBoo_state(States.disponible);

		// |---- Users ----|

		userAdmin.setUs_name("Erika");
		userAdmin.setUs_lastname("Villa");
		userAdmin.setUs_cell("987452136");
		userAdmin.setUs_email("erivilla@gmail.com");
		userAdmin.setUs_password("erika123456");
		userAdmin.setUs_image(ImageData.userArt);
		userAdmin.setUs_admin(true);

		user.setUs_name("Jackson");
		user.setUs_lastname("Pearson");
		user.setUs_cell("0989621136");
		user.setUs_email("danharman@gmail.com");
		user.setUs_password("dani123456");
		user.setUs_image(ImageData.userBooks);
		user.setUs_admin(false);

		// ---- Insert Data ----

		this.bookDao.createBook(book);
		this.bookDao.createBook(book2);
		this.bookDao.createBook(book3);
		this.bookDao.createBook(book4);

		this.userDao.createUser(userAdmin);
		this.userDao.createUser(user);

	}

}
