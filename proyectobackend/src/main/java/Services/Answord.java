package Services;

public class Answord {

	private int codigo;
	private String mensaje;
	
	// Operación exitosa
	public static final int OK = 1;

	// Error general
	public static final int ERROR = 99;

	// Error de validación de datos
	public static final int VALIDATION_ERROR = 2;
	public static final String MESSAGE_VALIDATION_ERROR = "Campos vacios";

	// Error de autenticación
	public static final int AUTHENTICATION_ERROR = 3;

	// Error de autorización
	public static final int AUTHORIZATION_ERROR = 4;

	// Error de lógica de negocio
	public static final int BUSINESS_ERROR = 5;

	public static final int EMPTY_FIELDS = 6;
	public static final String MESSAGE_EMPTY_FIELDS = "Campo vacio";
	// Error de recurso no encontrado
	
	public static final int NOT_FOUND_ERROR = 7;
	public static final String MESSAGE_NOT_FOUND_ERROR = "No encontrado";
	
	//
	public static final int PARAMETER_INVALID = 8;
	public static final String MESSAGE_PARAMETER_INVALID = "Parametro invalido";
	

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
