package Domain;

public class Gerente extends Persona {

		String tipo = "Soy un gerente";
		
		public Gerente(String nombre, String usuario, String contrasena, String tipo) {
			super(nombre, usuario, contrasena);
			this.tipo = tipo;
		}
		public Gerente() {

		}
}
