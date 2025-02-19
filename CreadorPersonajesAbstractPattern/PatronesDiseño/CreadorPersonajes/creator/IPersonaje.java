package creator;

public abstract class IPersonaje {
	public String nombre;
	public Cabeza cabeza;
	public AccesorioCabeza accCabeza;
	public Dorso dorso;
	public AccesorioDorso accDorso;
	public Piernas piernas;
	public AccesorioPiernas accPiernas;
	
	public IPersonaje(String nombre, Cabeza cabeza, AccesorioCabeza accCabeza, Dorso dorso, AccesorioDorso accDorso, Piernas piernas, AccesorioPiernas accPiernas) {
		this.nombre = nombre; 
		this.cabeza = cabeza;
		this.accCabeza = accCabeza;
		this.dorso = dorso;
		this.accDorso = accDorso;
		this.piernas = piernas;
		this.accPiernas = accPiernas;
	}
	
	public void eNombre() {
		System.out.println("\nMi nombre es: " + nombre);
	}
	public void eCabeza() {
		cabeza.eCabeza();
	}
	public void eAccCabeza() {
		accCabeza.eAccCabeza();
	}
	public void eDorso() {
		dorso.eDorso();
	}
	public void eAccDorso() {
		accDorso.eAccDorso();
	}
	public void ePiernas() {
		piernas.ePiernas();
	}
	public void eAccPiernas() {
		accPiernas.eAccPiernas();
	}
}
