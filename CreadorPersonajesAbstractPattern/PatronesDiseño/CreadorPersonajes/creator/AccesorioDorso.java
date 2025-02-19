package creator;

public class AccesorioDorso {
	public String accesorio;

	public AccesorioDorso(String accesorio) {
		super();
		this.accesorio = accesorio;
	}
	
	public void eAccDorso() {
		if(!accesorio.equals("Null")) {
			System.out.println(" - Accesorio Dorso: " + accesorio);
		}
	}
}
