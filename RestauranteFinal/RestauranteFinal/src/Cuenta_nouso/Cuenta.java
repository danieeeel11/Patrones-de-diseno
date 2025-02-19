package Cuenta_nouso;

public class Cuenta {
    private int idCuenta;
    private int idCliente;
	private String usuario;
	private double saldoInicial;

	public Cuenta(int idCuenta, int idCliente, String usuario, double saldoInicial) {
		this.idCuenta = idCuenta;
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.saldoInicial = saldoInicial;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	} 
}
