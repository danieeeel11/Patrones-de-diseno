package Launcher;

import java.util.Scanner;

import CambioMoneda.ARGObservador;
import CambioMoneda.BRLObservador;
import CambioMoneda.MXObservador;
import CambioMoneda.Subject;
import CambioMoneda.USDObservador;
import CambioMoneda.YUANObservador;

public class App {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Ingrese la cantidad a averiguar el cambio de moneda: ");
		int money = sc.nextInt();
		run(money);
	}
	
	public static void run(int money) {
		Subject subject = new Subject();

		new USDObservador(subject);
		new ARGObservador(subject);
		new YUANObservador(subject);
		new BRLObservador(subject);
		new MXObservador(subject);
		
		System.out.println("Al cambiar " + money + " cop puede obtener: ");
		subject.setEstado(money);
	}
}
