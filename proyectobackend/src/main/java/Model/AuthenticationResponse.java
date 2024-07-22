package Model;

public class AuthenticationResponse {
	
	private String jwt;

	// Constructor por defecto
	public AuthenticationResponse() {
	}

	// Constructor con parámetros
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	// Getters y setters
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}