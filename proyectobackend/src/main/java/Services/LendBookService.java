package Services;

import java.util.List;

import Gestions.GestionLendBook;
import Model.LendBook;
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
    public Response getLendBook(@PathParam("id") int id) {
        try {
            LendBook lendBook = this.gestionLendBook.searchLendBook(id);
            if (lendBook != null) {
                return Response.ok(lendBook).build();
            } else {
                return Response.status(404).entity(new Answord(Answord.NOT_FOUND_ERROR, "LendBook no encontrado")).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
        }
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
  
}