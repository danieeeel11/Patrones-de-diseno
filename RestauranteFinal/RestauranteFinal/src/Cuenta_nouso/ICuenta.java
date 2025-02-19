package Cuenta_nouso;

import java.util.ArrayList;

public interface ICuenta {

	Cuenta recargarCuenta(Cuenta cuenta, double monto);
	Cuenta pagarPedido(Cuenta cuenta, double monto);
	double mostrarSaldo(Cuenta cuenta);
	void crearCuenta();
}