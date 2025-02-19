package modelo;

public class Mundial {
	public IBuilderPartido builderPartido;
	
	public void setBuilderPartido(IBuilderPartido bPartido) {
		builderPartido = bPartido;
	}
	public Partido getPartido() {
		return builderPartido.getPartido();
	}
	public void builderPartido(String fase, String equipo1, String equipo2, String resultado, String ganador) {
		builderPartido.buildFase(fase);
		builderPartido.buildEquipo1(equipo1);
		builderPartido.buildEquipo2(equipo2);
		builderPartido.buildResultado(resultado);
		builderPartido.buildGanador(ganador);
	}
}