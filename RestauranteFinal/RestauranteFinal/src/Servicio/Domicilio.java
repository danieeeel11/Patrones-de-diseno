package Servicio;

import java.util.ArrayList;

public class Domicilio {
	private int numero;
	private Domiciliario domiliciario;
	private ArrayList<String> orden;
	private String direccion;
	public Domicilio(int numero, Domiciliario domiliciario, ArrayList<String> orden, String direccion) {
		super();
		this.numero = numero;
		this.domiliciario = domiliciario;
		this.orden = orden;
		this.direccion = direccion;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Domiciliario getDomiliciario() {
		return domiliciario;
	}
	public void setDomiliciario(Domiciliario domiliciario) {
		this.domiliciario = domiliciario;
	}
	public ArrayList<String> getOrden() {
		return orden;
	}
	public void setOrden(ArrayList<String> orden) {
		this.orden = orden;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
