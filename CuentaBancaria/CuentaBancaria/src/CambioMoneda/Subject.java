package CambioMoneda;

import java.util.ArrayList;


public class Subject {
	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	private double estado;

	public double getEstado() {
		return estado;
	}

	public void setEstado(double estado) {
		this.estado = estado;
		notificar();
	}

	public void agregar(Observador observador) {
		observadores.add(observador);
	}

	public void notificar() {
		//observadores.forEach(x -> x.update());
		for (int i = 0; i < observadores.size(); i++) {
			observadores.get(i).update();
		}
	}

}
