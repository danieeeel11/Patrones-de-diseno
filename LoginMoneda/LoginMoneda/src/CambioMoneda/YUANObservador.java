package CambioMoneda;

public class YUANObservador extends Observador{

	private double valorCambio = 0.0015;
	
	public YUANObservador(Subject sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void update() {		
		System.out.println("YUAN: " + (sujeto.getEstado() * valorCambio));
	}
}
