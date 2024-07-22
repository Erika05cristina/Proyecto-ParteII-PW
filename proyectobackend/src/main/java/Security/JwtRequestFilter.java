package Security;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import Model.User;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
@Priority(1)
public class JwtRequestFilter extends HttpFilter {

    @Inject
    private JwtUtil jwtUtil;

    @Inject
    private UserRepository userRepository;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwt);
            } catch (ExpiredJwtException e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expirado");
                return;
            }
        }
        // Imprimir la clave secreta para verificar que coincide
        System.out.println("Request Filter Secret Key: " + Base64.getEncoder().encodeToString(jwtUtil.getSecretKey().getEncoded()));

        if (username != null && request.getUserPrincipal() == null) {
            Optional<User> userDetails = userRepository.findByUsEmail(username);
            if (userDetails.isPresent() && jwtUtil.validateToken(jwt, userDetails.get())) {
                // Establecer la seguridad en el contexto de la aplicación si es necesario
//            	request.setAttribute("user", userDetails.get());
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}