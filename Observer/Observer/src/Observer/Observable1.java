package Observer;

public class Observable1 extends Subject{
	
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
}
