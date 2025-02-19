package Observer;

public abstract class Observador {
	
	public Subject s;
	
	public Observador(Subject subject) {
		this.s = subject;
		subject.observadores.add(this);
	}
	
	public abstract void update();

}
