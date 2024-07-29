package Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    @GET
	@Path("/top-client")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientOfTheMonth() {
		try {
			List<Object[]> results = gestionReturnBook.getClientOfTheMonth();

			if (results.isEmpty()) {
				return Response.status(Response.Status.NOT_FOUND).entity("No se encontró cliente para el mes actual")
						.build();
			}

			Object[] clientData = results.get(0);
			int clientId = (int) clientData[0];
			String clientName = (String) clientData[1];
			Long count = (Long) clientData[2];

			Map<String, Object> response = new HashMap<>();
			response.put("clientId", clientId);
			response.put("clientName", clientName);
			response.put("count", count);

			return Response.ok(response).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener el cliente del mes")
					.build();
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