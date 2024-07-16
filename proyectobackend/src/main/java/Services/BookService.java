package Services;

import java.util.List;

import Gestions.GestionBook;
import Model.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
		return this.gestionBook.listBooks();
	}

	@GET
	@Path("/{category}")
	@Produces("application/json")
	public List<Book> listBooks(@PathParam("category") String category) {
		try {
			return this.gestionBook.listBooks();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
