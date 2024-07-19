package Services;

public class Answord {

	private int codigo;
	private String mensaje;
	/**
	 * TODO Investigar que otros errores puedes colocar, para implementarlos en el
	 * serivce
	 */

	// Operación exitosa
	public static final int OK = 1;

	// Error general
	public static final int ERROR = 99;

	// Error de validación de datos
	public static final int VALIDATION_ERROR = 2;

	// Error de autenticación
	public static final int AUTHENTICATION_ERROR = 3;

	// Error de autorización
	public static final int AUTHORIZATION_ERROR = 4;

	// Error de lógica de negocio
	public static final int BUSINESS_ERROR = 5;

	// Error de recurso no encontrado
	public static final int NOT_FOUND_ERROR = 6;

	// Error interno del servidor
	public static final int INTERNAL_SERVER_ERROR = 500;

	public Answord(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
