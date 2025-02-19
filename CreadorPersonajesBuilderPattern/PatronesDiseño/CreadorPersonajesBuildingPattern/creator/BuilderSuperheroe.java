package creator;

public class BuilderSuperheroe extends IBuilderPersonaje{
	
	public BuilderSuperheroe() {
		super.personaje = new Personaje();
	}
	
	@Override
	public void buildNombre(String nombre) {
		personaje.setNombre(nombre);
	}
	
	@Override
	public void buildTipo(String tipo) {
		personaje.setTipo(tipo);
	}

	@Override
	public void buildCabeza(String head) {
		personaje.setCabeza(head);
	}

	@Override
	public void buildAccesorioCabeza(String accCabeza) {
		personaje.setAccCabeza(accCabeza);
	}

	@Override
	public void buildDorso(String dorso) {
		personaje.setDorso(dorso);
	}

	@Override
	public void buildAccesorioDorso(String accDorso) {
		personaje.setAccDorso(accDorso);
	}

	@Override
	public void buildPiernas(String legs) {
		personaje.setPiernas(legs);
	}

	@Override
	public void buildAccesorioPiernas(String accPiernas) {
		personaje.setAccPiernas(accPiernas);
	}

}
