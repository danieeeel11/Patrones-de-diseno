package CambioMoneda;

public class BRLObservador extends Observador{
	
	private double valorCambio = 0.0011;
	
	public BRLObservador(Subject sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	}
	
	@Override
	public void update() {		
		System.out.println("BRL: " + (sujeto.getEstado() * valorCambio));
	}
}
