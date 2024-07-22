package Services;

import java.util.List;

import Gestions.GestionMyBook;
import Model.MyBooks;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mybooks")
public class MyBookService {
	@Inject
	private GestionMyBook gestionMyBook;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(MyBooks book) {
		try {
			if (book.getMyBoo_id() == 0)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getMyBoo_idBook() == 0)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getMyBoo_idUser() == 0) 
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();			

			if (book.getMyBoo_nameBook() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getMyBoo_nameUser() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (book.getMyBoo_stateBook() == null || "Disponible".equals(book.getMyBoo_stateBook())) {
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();}

			this.gestionMyBook.createMyBook(book);
			return Response.ok(book).status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();

		}
	}

	@GET
	@Produces("application/json")
	public List<MyBooks> listBooks() {
		return this.gestionMyBook.listMyBooks();
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

			this.gestionMyBook.deleteMyBook(isNumeric);
			return Response.ok(codigo).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

}