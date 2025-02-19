package Observer;

public class ObserverConcreto2 extends Observador{

	public ObserverConcreto2(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		String newState = this.s.getState();
		System.out.println("Estoy enviando por correo: " +  newState);
		
		int i = Integer.parseInt(newState);
		System.out.println("El numero convertido es: " + i);
	}
}
