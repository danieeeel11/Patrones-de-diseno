package CambioMoneda;

public class USDObservador extends Observador {

	private double valorCambio = 0.00021;
	
	public USDObservador(Subject sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void update() {		
		System.out.println("USD: " + (sujeto.getEstado() * valorCambio));
	}
}
