package creator;

public class AccesorioCabeza {
	public String accesorio;

	public AccesorioCabeza(String accesorio) {
		super();
		this.accesorio = accesorio;
	}
	
	public void eAccCabeza() {
		if(!accesorio.equals("Null")) {
			System.out.println(" - Accesorio Cabeza: " + accesorio);
		}
	}
}
