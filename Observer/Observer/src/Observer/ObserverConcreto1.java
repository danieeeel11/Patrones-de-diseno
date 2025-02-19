package Observer;

public class ObserverConcreto1 extends Observador{

	public ObserverConcreto1(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		String newState = this.s.getState();
		System.out.println("Estoy mostrando por pantalla: " + newState);
	}
	
}
