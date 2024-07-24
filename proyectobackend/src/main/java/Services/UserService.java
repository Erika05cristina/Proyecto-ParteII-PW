package Services;

import java.util.List;
import java.util.Optional;

import Gestions.GestionUser;
import Model.User;
import Security.JwtUtil;
import Security.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserService {
	@Inject
	private GestionUser gestionUser;
	
	@Inject
    private JwtUtil jwtUtil;

    @Inject
    private UserRepository userRepository;

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {	
		
		try {
			if (user.getUs_id() == 0)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_name() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_lastname() == null) {
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();
			}

			if (user.getUs_cell() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_email() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_password() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR)).build();
			
			if (user.getUs_image() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR)).build();
			
			if (user.getUs_admin() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR)).build();
			
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
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/email/{email}")
	@Produces("application/json")
	public User getUserForEmail(@PathParam("email") String email) {
		try {
			if(email == null)
				return null;
			return this.gestionUser.searchEmailUser(email);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

//	@GET
//	@Produces("application/json")
//	public List<User> listUsers() {
//		return this.gestionUser.listUsers();
//	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(User user) {
		try {
			if (user.getUs_id() == 0)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_name() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_lastname() == null) {
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();
			}

			if (user.getUs_cell() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_email() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR))
						.build();

			if (user.getUs_password() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR)).build();
			
			if (user.getUs_image() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR)).build();
			
			if (user.getUs_admin() == null)
				return Response.status(400).entity(new Answord(Answord.EMPTY_FIELDS, Answord.MESSAGE_VALIDATION_ERROR)).build();
			
			this.gestionUser.updateUser(user);
			return Response.ok(user).status(200).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(503).entity(new Answord(Answord.ERROR, "Error en BD")).build();
		}
	}

	@GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo(@HeaderParam("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            try {
                String username = jwtUtil.extractUsername(token);
                Optional<User> userOptional = userRepository.findByUsEmail(username);
                
                if (userOptional.isPresent()) {
                    return Response.ok(userOptional.get()).build();
                } else {
                    return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
                }
                
            } catch (ExpiredJwtException e) {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Token expired").build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error processing request").build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Authorization header is missing or invalid").build();
        }
    }
}
