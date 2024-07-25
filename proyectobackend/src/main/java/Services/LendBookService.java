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

@Path(" ")
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
            if(lendBook == null) throw new Exception("Préstamo no encontrado");
            
            return lendBook;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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