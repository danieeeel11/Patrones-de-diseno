package Observer;

public class Observable2 extends Subject{
	
	private int numero = 0;	
	private String myState = "";
	
	@Override
	public String getState() {
		return getMyState();
	}

	public String getMyState() {
		return myState;
	}
	public void setMyState(String myState) {
		this.myState = myState;
		notificar();
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
		setMyState(numero + "");
	}
	
	
}
