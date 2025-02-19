package creator;

public class Director {
	public IBuilderPersonaje builderPersonaje;
	
	public void setBuilderPersonaje(IBuilderPersonaje bPersonaje) {
		builderPersonaje = bPersonaje;
	}
	public Personaje getPersonaje() {
		return builderPersonaje.getPersonaje();
	}
	public void builderPersonaje(String nombre, String tipo, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas) {
		builderPersonaje.genCarpeta(nombre, tipo, head, accCabeza, dorso, accDorso, legs, accPiernas);
		builderPersonaje.buildNombre(nombre);
		builderPersonaje.buildTipo(tipo);
		builderPersonaje.buildCabeza(head);
		builderPersonaje.buildAccesorioCabeza(accCabeza);
		builderPersonaje.buildDorso(dorso);
		builderPersonaje.buildAccesorioDorso(accDorso);
		builderPersonaje.buildPiernas(legs);
		builderPersonaje.buildAccesorioPiernas(accPiernas);
	}
}
