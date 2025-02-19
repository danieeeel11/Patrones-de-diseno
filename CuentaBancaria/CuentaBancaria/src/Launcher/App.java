package Launcher;

import java.util.Scanner;

import CambioMoneda.ARGObservador;
import CambioMoneda.BRLObservador;
import CambioMoneda.MXObservador;
import CambioMoneda.Subject;
import CambioMoneda.USDObservador;
import CambioMoneda.YUANObservador;
import Cuenta_Proxy.Cuenta;
import Cuenta_Proxy.CuentaBancoDavivienda;
import Cuenta_Proxy.CuentaProxy;
import Cuenta_Proxy.ICuenta;

public class App {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void run(double money) {
		Subject subject = new Subject();

		new USDObservador(subject);
		new ARGObservador(subject);
		new YUANObservador(subject);
		new BRLObservador(subject);
		new MXObservador(subject);
		
		System.out.println("Al cambiar " + money + " cop puede obtener: ");
		subject.setEstado(money);

		
	}


	public static void Menu() {
		
		int idCuenta;
		String usuario;
		double money;
		int opt=0;
		
		ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoDavivienda());
		Cuenta c;
		System.out.print("Ingrese el numero de cuenta ---> ");
		idCuenta= sc.nextInt();
		System.out.print("ingrese el ususario de la cuenta ---> ");
		usuario= sc.next();
		System.out.print("Ingrese la cantidad de dinero inicial ---> ");
		money = sc.nextDouble();
		c = new Cuenta(idCuenta, usuario, money);
				

				
		//System.out.println("------------Saldo inicial------------");
		//run(cuentaProxy.mostrarSaldo(c));

		while (opt<6) {

			System.out.println("____________MENU____________");
			System.out.println("1. adicionar dinero a la cuenta");
			System.out.println("2. retirar  dinero de la cuenta");
			System.out.println("3. mostar el dinero de la cuenta");
			System.out.println("4. cambiar usuer de la cuenta");
			System.out.println("5. cambiar id de la cuenta");
			System.out.println("6. salir");
			opt= sc.nextInt();
			switch (opt) {
				case 1:
				System.out.print("Ingrese la cantidad de dinero a adicionar: ");
				double monto = sc.nextDouble();
				c = cuentaProxy.depositarDinero(c, monto);

				System.out.println();
				System.out.println("------------Saldo------------");

				System.out.print("El nuevo Saldo del usuario "+usuario+" es de ---> ");
				System.out.println(cuentaProxy.mostrarSaldo(c));
				System.out.println();
				
				run(cuentaProxy.mostrarSaldo(c));
			
				break;

				case 2:
				System.out.print("Ingrese la cantidad de dinero a retirar: ");
				double retiro = sc.nextDouble();

				if (retiro>cuentaProxy.mostrarSaldo(c)) {
					System.out.println("El saldo a retirar exede el dinero en cuenta");

					System.out.println();
					System.out.println("------------Saldo------------");
			
					System.out.print("Saldo del usuario "+usuario+" es de ---> ");
					System.out.println(cuentaProxy.mostrarSaldo(c));
					System.out.println();
					
					run(cuentaProxy.mostrarSaldo(c));
				}else{
					c = cuentaProxy.retirarDinero(c, retiro);;

					System.out.println();
					System.out.println("------------Saldo------------");

					System.out.print("El nuevo Saldo del usuario "+usuario+" es de ---> ");
					System.out.println(cuentaProxy.mostrarSaldo(c));
					System.out.println();
					
					run(cuentaProxy.mostrarSaldo(c));
				}
				
	
				break;

				case 3:

				System.out.println();
				System.out.println("------------Saldo------------");

				System.out.print("El Saldo del usuario "+usuario+" es de ---> ");
				System.out.println(cuentaProxy.mostrarSaldo(c));
				System.out.println();
				
				run(cuentaProxy.mostrarSaldo(c));
				break;

				case 4:
				System.out.print("Nuevo nombre de ususario ---> ");
				String nuevoNombre = sc.next();
				c.setUsuario(nuevoNombre);
				usuario= c.getUsuario();

				break;

				case 5:
				System.out.print("Nuevo id de de la cuenta es ---> ");
				int nuevoid = sc.nextInt();
				c.setIdCuenta(nuevoid);
				idCuenta = c.getIdCuenta();

				break;

				default:
					break;
			}
			
		}
	}
}
