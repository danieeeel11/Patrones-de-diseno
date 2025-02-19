package CambioMoneda;

public class ARGObservador extends Observador{
	
	private double valorCambio = 0.033;
	
	public ARGObservador(Subject sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void update() {		
		System.out.println("ARG: " + (sujeto.getEstado() * valorCambio));
	}
}
