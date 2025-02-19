package modelo;

public abstract class IBuilderPartido {
	public Partido partido;
	public Partido getPartido() {
		return partido;
	}
	public abstract void buildFase(String fase);
	public abstract void buildEquipo1(String equipo1);
	public abstract void buildEquipo2(String equipo2);
	public abstract void buildResultado(String resultado);
	public abstract void buildGanador(String ganador);
}