package creatorA;

/**
 * Clase Director
 */
public class Automotriz {
	public IBuilderAuto builderAuto;
	
	public void setBuilderAuto(IBuilderAuto bAuto) {
		builderAuto = bAuto;
	}
	public Auto getAuto() {
		return builderAuto.getAuto();
	}
	public void builderAuto(String marca) {
		builderAuto.makeMarca(marca);
		builderAuto.makeModelo();
		builderAuto.makeMotor();
		builderAuto.makeTransmision();
		builderAuto.makeRines();
		builderAuto.factory.createHTML(getAuto());
	}
}
