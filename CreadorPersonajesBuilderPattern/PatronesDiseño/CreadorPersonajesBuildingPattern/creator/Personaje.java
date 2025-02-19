package creator;

public class Personaje {
	public String nombre;
	public String tipo;
	public String cabeza;
	public String accCabeza;
	public String dorso;
	public String accDorso;
	public String piernas;
	public String accPiernas;
	
	/*
	 * Metodos get
	 */
	public String getNombre() {
		return "\nMi nombre es: " + nombre;
	}
	public String getTipo() {
		return " Personaje: " +  tipo;
	}
	public String getCabeza() {
		return " - Cabeza: " + cabeza;
	}
	public String getAccCabeza() {
		return " - Accesorio Cabeza: " + accCabeza;
	}
	public String getDorso() {
		return " - Dorso: " + dorso;
	}
	public String getAccDorso() {
		return " - Accesorio Dorso: " + accDorso;
	}
	public String getPiernas() {
		return " - Piernas: " + piernas;
	}
	public String getAccPiernas() {
		return " - Accesorio Piernas: " + accPiernas;
	}
	
	/*
	 * Metodos set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public void setAccCabeza(String accCabeza) {
		this.accCabeza = accCabeza;
	}
	public void setDorso(String dorso) {
		this.dorso = dorso;
	}
	public void setAccDorso(String accDorso) {
		this.accDorso = accDorso;
	}
	public void setPiernas(String piernas) {
		this.piernas = piernas;
	}
	public void setAccPiernas(String accPiernas) {
		this.accPiernas = accPiernas;
	}
	
	
}
