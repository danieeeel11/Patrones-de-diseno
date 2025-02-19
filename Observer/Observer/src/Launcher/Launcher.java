package Launcher;

import java.util.Scanner;

import Observer.Observable1;
import Observer.Observable2;
import Observer.ObserverConcreto1;
import Observer.ObserverConcreto2;
import Observer.ObserverConcreto3;

public class Launcher {

	public static void main(String[] args) {
		Observable1 o1 = new Observable1();
		Observable2 oInteger = new Observable2();
		
		ObserverConcreto1 oc1 = new ObserverConcreto1(o1);
		ObserverConcreto2 oc2 = new ObserverConcreto2(oInteger);
		ObserverConcreto3 oc3 = new ObserverConcreto3(o1);
		
		o1.setMyState("Hola mundo");
		oInteger.setNumero(555);
		
		o1.setMyState("Este es otro estado");
		
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		
		while(!input.equals("out")) {
			input = sc.nextLine();
			o1.setMyState(input);
		}
	}

}
