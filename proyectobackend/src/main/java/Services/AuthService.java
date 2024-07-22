package Services;

import java.util.Optional;

import Model.AuthenticationRequest;
import Model.AuthenticationResponse;
import Model.User;
import Security.JwtUtil;
import Security.UserRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private JwtUtil jwtUtil;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAuthenticationToken(AuthenticationRequest authenticationRequest) {
        Optional<User> userOptional = userRepository.findByUsEmail(authenticationRequest.getUsername());
        if (userOptional.isPresent() && userOptional.get().getUs_password().equals(authenticationRequest.getPassword())) {
            User user = userOptional.get();
            final String jwt = jwtUtil.generateToken(user);
            return Response.ok(new AuthenticationResponse(jwt)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario o contraseña incorrectos").build();
        }
    }
}