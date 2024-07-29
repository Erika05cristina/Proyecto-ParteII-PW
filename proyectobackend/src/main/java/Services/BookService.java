package Services;

import java.util.List;

import Gestions.GestionBook;
import Model.Book;
import Model.MyBooks;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
public class BookService {

	@Inject
	private GestionBook gestionBook;

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) {
		try {
			
			if (book.getBoo_autor() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_category() == null || "Seleccione Categoria".equals(book.getBoo_category())) {
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();
			}

			if (book.getBoo_description() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_image() == null || "assets/img/selectImage.jpg".equals(book.getBoo_image()) || "".equals(book.getBoo_image()))
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_name() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			this.gestionBook.createBook(book);
			return Response.ok(book).status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();

		}
	}

	@GET
	@Produces("application/json")
	public List<Book> listBooks() {
		//***
		List<Book> books = gestionBook.listBooks();
		return books;
		//		return this.gestionBook.listBooks();
	}

	@GET
	@Path("category/{category}")
	@Produces("application/json")
	public List<Book> listBooksCategory(@PathParam("category") String category) {
		try {
//			return this.gestionBook.listBooks();
			return this.gestionBook.listBooksCategory(category);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GET
	@Path("name/{name}")
	@Produces("application/json")
	public List<Book> listBooksName(@PathParam("name") String name) {
		try {
			return this.gestionBook.listBooksName(name);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	
	@GET
	@Path("availability/{state}")
	@Produces("application/json")
	public List<Book> listBooksState(@PathParam("state") String state) {
		try {
			return this.gestionBook.listBooksState(state);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	@GET
	@Path("autor/{autor}")
	@Produces("application/json")
	public List<Book> listBooksAutor(@PathParam("autor") String autor) {
		try {
			return this.gestionBook.listBooksAutor(autor);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GET
	@Path("mb/{idUser}")
	@Produces("application/json")
	public List<Book> listBooks(@PathParam("idUser") int idUser) {
		try {

			return this.gestionBook.listBooksFromMyBooks(idUser);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
		

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Book book) {
		try {
			if (book.getBoo_id() == 0)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_autor() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_category() == null || "Seleccione Categoria".equals(book.getBoo_category())) {
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();
			}

			if (book.getBoo_description() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_image() == null || "assets/img/selectImage.jpg".equals(book.getBoo_image()) || "".equals(book.getBoo_image()))
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getBoo_name() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			this.gestionBook.updateBook(book);
			return Response.ok(book).status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

	@DELETE
	@Path("/{codigo}")
	public Response deleteBook(@PathParam("codigo") String codigo) {
		try {
			if (codigo == null | codigo.equals(""))
				return Response.status(400)
						.entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_EMPTY_FIELDS)).build();
			
			int isNumeric;
			try {
				isNumeric = Integer.parseInt(codigo);
			} catch (Exception e) {
				return Response.status(400)
						.entity(new Answord(Answord.PARAMETER_INVALID, Answord.MESSAGE_PARAMETER_INVALID)).build();
			}

			this.gestionBook.deleteBook(isNumeric);
			return Response.ok(codigo).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

}
