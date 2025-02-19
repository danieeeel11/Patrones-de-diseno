package Observer;

public class ObserverConcreto3 extends Observador{
	
	public ObserverConcreto3(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		String newState = this.s.getState();
		System.out.println("Estoy guardando en disco: " + newState);
	}
	
	
}
