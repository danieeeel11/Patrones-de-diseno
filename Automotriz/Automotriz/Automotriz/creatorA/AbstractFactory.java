package creatorA;

import java.util.Random;
import java.util.Scanner;

public abstract class AbstractFactory {
	
	public Scanner sc = new Scanner(System.in);
	public Random r = new Random();
	
	public abstract String createMarca(String marca);
	public abstract String createModelo();
	public abstract String createMotor();
	public abstract String createTransmision();
	public abstract String createRines();
	
	public void createAuto(String marca) {
		createMarca(marca);
		createModelo();
		createMotor();
		createTransmision();
		createRines();
	}
	
	public void createHTML(Auto auto) {
		BuildHTML.getInstance().createHTML(auto);
		//buildHTML.createHTML(auto);
	}
}
