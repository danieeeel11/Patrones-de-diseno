package creator;

public interface AbstractFactory {
	public IPersonaje crearPersonaje(String nombre, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas);
	public void genCarpeta(String nombre, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas);
	public void copyFile(String origen, String destino);
}
