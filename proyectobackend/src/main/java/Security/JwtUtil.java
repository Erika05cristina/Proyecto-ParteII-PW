package Security;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import Dao.UserDao;
import Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.ejb.Stateless;

//Generar y validar los tokens JWT

@Stateless
public class JwtUtil {
	private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public JwtUtil() {
		// Imprimir clave secreta cuando se inicializa la clase
		System.out.println("Secret Key: " + Base64.getEncoder().encodeToString(SECRET_KEY.getEncoded()));
	}

	public SecretKey getSecretKey() {
		return SECRET_KEY;
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

//	public String generateToken(User user) {
//		Map<String, Object> claims = new HashMap<>();
//		return createToken(claims, user.getUs_email(), user.getUs_id());
//	}

// valor representa 10 horas en milisegundos
//    1000 milisegundos por segundo.
//    60 segundos por minuto.
//    60 minutos por hora.
//    10 horas.
//
//	private String createToken(Map<String, Object> claims, String subject, int i) {
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(SECRET_KEY)
//				.compact();
//	}
//
//	public Boolean validateToken(String token, User user) {
//		final String usernameFromToken = extractUsername(token);
//		return (usernameFromToken.equals(user.getUs_email()) && !isTokenExpired(token));
//	}
	public String generateToken(User user) {
	    Map<String, Object> claims = new HashMap<>();
	    claims.put("email", user.getUs_email());
	    claims.put("id", user.getUs_id());
	    return createToken(claims, user.getUs_email());
	}
	
	private String createToken(Map<String, Object> claims, String subject) {
	    return Jwts.builder()
	            .setClaims(claims)
	            .setSubject(subject)
	            .setIssuedAt(new Date(System.currentTimeMillis()))
	            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	            .signWith(SECRET_KEY)
	            .compact();
	}
	public Boolean validateToken(String token, User user) {
	    final Claims claims = extractAllClaims(token);
	    final String usernameFromToken = claims.get("email", String.class);
	    final String userIdFromToken = claims.get("id", String.class);
	    return (usernameFromToken.equals(user.getUs_email()) && userIdFromToken.equals(user.getUs_id()) && !isTokenExpired(token));
	}
	
	
}