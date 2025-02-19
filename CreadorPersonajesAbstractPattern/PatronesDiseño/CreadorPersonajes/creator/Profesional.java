package creator;

public class Profesional extends IPersonaje{
	public Profesional(String nombre, Cabeza cabeza, AccesorioCabeza accCabeza, Dorso dorso, AccesorioDorso accDorso, Piernas piernas, AccesorioPiernas accPiernas) {
		super(nombre, cabeza, accCabeza, dorso, accDorso, piernas, accPiernas);
	}

	
	@Override
	public void eNombre() {
		super.eNombre();
		System.out.println(" Personaje: Profesional");
	}
	@Override
	public void eCabeza() {
		cabeza.eCabeza();
	}
	@Override
	public void eAccCabeza() {
		accCabeza.eAccCabeza();
	}
	@Override
	public void eDorso() {
		dorso.eDorso();
	}
	@Override
	public void eAccDorso() {
		accDorso.eAccDorso();
	}
	@Override
	public void ePiernas() {
		piernas.ePiernas();
	}
	@Override
	public void eAccPiernas() {
		accPiernas.eAccPiernas();
	}
}
