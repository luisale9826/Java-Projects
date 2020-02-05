package Domain;

public class Persona {

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
		
	}
	
		
	public Persona(String nombre, String usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public Persona() {

	}

	private String nombre;
	private String usuario;
	private String contrasena;
	
	
}
