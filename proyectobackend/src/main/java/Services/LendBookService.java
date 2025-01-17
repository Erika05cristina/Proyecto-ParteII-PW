package Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Gestions.GestionLendBook;
import Model.LendBook;
import Model.TopBooks;
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

@Path("/lendbooks")
public class LendBookService {

	@Inject
	private GestionLendBook gestionLendBook;

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createLendBook(LendBook lendBook) {
		try {
			this.gestionLendBook.createLendBook(lendBook);
			return Response.ok(lendBook).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

	@GET
	@Produces("application/json")
	public List<LendBook> listLendBooks() {
		return this.gestionLendBook.listLendBooks();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public LendBook getLendBook(@PathParam("id") int id) {
		try {
			LendBook lendBook = this.gestionLendBook.searchLendBook(id);
			if (lendBook == null)
				throw new Exception("Préstamo no encontrado");

			return lendBook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/book/{idBook}/user/{idUser}")
	@Produces("application/json")
	public LendBook getLendBookByBookId(@PathParam("idBook") String bookId, @PathParam("idUser") String userId) {
		try {
			int idBook = Integer.valueOf(bookId);
			int idUser = Integer.valueOf(userId);

			LendBook lendBook = this.gestionLendBook.searchLendBookByIdBook(idBook, idUser);

			if (lendBook == null)
				throw new Exception("Préstamo no encontrado");

			return lendBook;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/top-books")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TopBooks> getMostReadBooksByMonth() {
		return this.gestionLendBook.getMostReadBooksByMonthDTO();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLendBook(LendBook lendBook) {
		try {
			this.gestionLendBook.updateLendBook(lendBook);
			return Response.ok(lendBook).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response deleteLendBook(@PathParam("id") String id) {
		try {
			int idUser = Integer.valueOf(id);

			this.gestionLendBook.deleteLendBook(idUser);
			return Response.status(200).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}



}