package creator;

public class AccesorioPiernas {
	public String accesorio;

	public AccesorioPiernas(String accesorio) {
		super();
		this.accesorio = accesorio;
	}
	
	public void eAccPiernas() {
		if(!accesorio.equals("Null")) {
			System.out.println(" - Accesorio Piernas: " + accesorio);
		}
	}
}
