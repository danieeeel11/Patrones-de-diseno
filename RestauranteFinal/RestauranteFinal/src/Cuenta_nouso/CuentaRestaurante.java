package Cuenta_nouso;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaRestaurante implements ICuenta {
	
	public static ArrayList<Cuenta> cuentasClientes =new ArrayList<Cuenta>();
	static Scanner sc =new Scanner(System.in);

	@Override
	public Cuenta recargarCuenta(Cuenta cuenta, double monto) {
		double saldoActual = cuenta.getSaldoInicial() + monto;
		cuenta.setSaldoInicial(saldoActual);
		System.out.println("Saldo actual: " + cuenta.getSaldoInicial());
		return cuenta;
	}

	@Override
	public Cuenta pagarPedido(Cuenta cuenta, double monto) {
		double saldoActual = cuenta.getSaldoInicial() - monto;
		cuenta.setSaldoInicial(saldoActual);
		System.out.println("Saldo actual: " + cuenta.getSaldoInicial());
		return cuenta;
	}

	@Override
	public double mostrarSaldo(Cuenta cuenta) {
		return cuenta.getSaldoInicial();
	}

	@Override
	public void crearCuenta() {
		System.out.print("Ingrese su id:");
		int id = sc.nextInt();
		System.out.print("Ingrese su nombre:");
		String nombre = sc.next();
		cuentasClientes.add(new Cuenta(cuentasClientes.size()+1, id, nombre, 0));
		
	}

}

