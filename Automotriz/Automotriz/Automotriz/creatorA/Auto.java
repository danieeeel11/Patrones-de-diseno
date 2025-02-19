package creatorA;

public class Auto {
	public String nameAuto;
	public String marca;
	public String modelo;
	public String motor;
	public String transmision;
	public String rines;
	
	/*
	 * Metodos get
	 */
	public String getNameAuto() {
		return nameAuto;
	}
	public String getMarca() {
		return " - Marca: " + marca;
	}
	public String getModelo() {
		return " - Modelo: " + modelo;
	}
	public String getMotor() {
		return " - Motor: " + motor;
	}
	public String getTransmision() {
		return " - Transmision: " + transmision;
	}
	public String getRines() {
		return " - Rines: " + rines;
	}
	
	/*
	 * Metodos set
	 */
	public void setNameAuto(String nameAuto) {
		this.nameAuto = nameAuto;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
	public void setRines(String rines) {
		this.rines = rines;
	}
}
