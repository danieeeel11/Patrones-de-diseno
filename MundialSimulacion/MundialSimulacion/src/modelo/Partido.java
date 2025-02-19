package modelo;

public class Partido {
	public String fase;
	public String equipo1;
	public String equipo2;
	public String resultado;
	public String ganador;
	
	
	/*
	 * Metodos get
	 */
	public String getFase() {
		return fase;
	}
	public String getEquipo1() {
		return equipo1;
	}
	public String getEquipo2() {
		return equipo2;
	}
	public String getResultado() {
		return resultado;
	}
	public String getGanador() {
		return ganador;
	}
	
	/*
	 * Metodos set
	 */
	public void setFase(String fase) {
		this.fase = fase;
	}
	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}
	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
}
