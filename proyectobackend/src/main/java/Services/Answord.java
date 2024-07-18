package Services;

public class Answord {

	private int codigo;
	private String mensaje;
	/**
	 * TODO Investigar que otros errores puedes colocar, para implementarlos en el serivce
	 */
	public static int OK = 1;
	public static int ERROR = 99;
	
	
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
