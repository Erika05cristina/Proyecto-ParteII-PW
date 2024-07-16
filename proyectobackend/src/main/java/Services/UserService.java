package Services;

import java.util.List;

import Gestions.GestionUser;
import Model.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserService {
	@Inject
	private GestionUser gestionUser;

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		try {
			this.gestionUser.createUser(user);
			return Response.ok(user).status(200).build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") int id) {
		try {
			return this.gestionUser.searchUser(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@GET
	@Produces("application/json")
	public List<User> listUsers() {
		return this.gestionUser.listUsers();
	}

}
