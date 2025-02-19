package CambioMoneda;

import java.util.ArrayList;


public class Subject {
	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	private int estado;

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
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
