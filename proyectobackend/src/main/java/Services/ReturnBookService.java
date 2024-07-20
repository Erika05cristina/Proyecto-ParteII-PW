package Services;

import java.util.List;

import Gestions.GestionReturnBook;
import Model.ReturnBook;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/returnbooks")
public class ReturnBookService {

    @Inject
    private GestionReturnBook gestionReturnBook;

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReturnBook(ReturnBook returnBook) {
        try {
            this.gestionReturnBook.createReturnBook(returnBook);
            return Response.ok(returnBook).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
        }
    }

    @GET
    @Produces("application/json")
    public List<ReturnBook> listReturnBooks() {
        return this.gestionReturnBook.listReturnBooks();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getReturnBook(@PathParam("id") int id) {
        try {
            ReturnBook returnBook = this.gestionReturnBook.searchReturnBook(id);
            if (returnBook != null) {
                return Response.ok(returnBook).build();
            } else {
                return Response.status(404).entity(new Answord(Answord.NOT_FOUND_ERROR, "ReturnBook no encontrado")).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
        }
    }

    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReturnBook(ReturnBook returnBook) {
        try {
            this.gestionReturnBook.updateReturnBook(returnBook);
            return Response.ok(returnBook).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
        }
    }

 
}