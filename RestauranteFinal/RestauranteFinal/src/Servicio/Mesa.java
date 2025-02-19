package Servicio;

import java.util.ArrayList;

public class Mesa {
	private int numero;
	private Mesero mesero;
	private ArrayList<String> orden;
	
	public Mesa(int numero, Mesero mesero, ArrayList<String> orden) {
		super();
		this.numero = numero;
		this.mesero = mesero;
		this.orden = orden;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Mesero getMesero() {
		return mesero;
	}

	public void setMesero(Mesero mesero) {
		this.mesero = mesero;
	}

	public ArrayList<String> getOrden() {
		return orden;
	}

	public void setOrden(ArrayList<String> orden) {
		this.orden = orden;
	}
}
