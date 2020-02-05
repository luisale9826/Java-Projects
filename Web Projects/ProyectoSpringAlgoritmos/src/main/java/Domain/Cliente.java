package Domain;

public class Cliente extends Persona{

	String tipo = "Soy un cliente";
	
	public Cliente(String nombre, String usuario, String contrasena, String tipo) {
		super(nombre, usuario, contrasena);
		this.tipo = tipo;
	}
	public Cliente() {

	}
	
	
}
