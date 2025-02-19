package Observer;

import java.util.ArrayList;

public abstract class Subject {
	public ArrayList<Observador> observadores = new ArrayList<Observador>();
	
	public void add(Observador a) {
		observadores.add(a);
	}
	
	public void remove(Observador a) {
		observadores.remove(a);
	}
	
	public void notificar() {
		for (int i = 0; i < observadores.size(); i++) {
			observadores.get(i).update();
		}
	}
	
	public abstract String getState();
}
