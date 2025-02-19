package CambioMoneda;

public class MXObservador extends Observador{
	
	private double valorCambio = 0.0041;
	
	public MXObservador(Subject sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void update() {		
		System.out.println("MX: " + (sujeto.getEstado() * valorCambio));
	}
}
