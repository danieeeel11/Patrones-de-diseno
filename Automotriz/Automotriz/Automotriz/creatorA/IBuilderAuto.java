package creatorA;

public abstract class IBuilderAuto{
	public Auto auto;
	public AbstractFactory factory;
	
	public Auto getAuto() {
		return auto;
	}
	
	public abstract void makeMarca(String marca);
	public abstract void makeModelo();
	public abstract void makeMotor();
	public abstract void makeTransmision();
	public abstract void makeRines();
}