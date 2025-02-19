package modelo;

import java.util.ArrayList;

public class FaseGrupos {
	private String grupo;
	private ArrayList<Pais> paises;
	
	public FaseGrupos(String grupo, ArrayList<Pais> paises) {
		super();
		this.grupo = grupo;
		this.paises = paises;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public ArrayList<Pais> getPaises() {
		return paises;
	}
	public void setPaises(ArrayList<Pais> paises) {
		this.paises = paises;
	}
}
