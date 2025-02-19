package modelo;

public class BuildCuartos extends IBuilderPartido{
	
	public BuildCuartos() {
		super.partido = new Partido();
	}
	
	@Override
	public void buildFase(String fase) {
		partido.setFase(fase);
	}
	
	@Override
	public void buildEquipo1(String equipo1) {
		partido.setEquipo1(equipo1);
	}

	@Override
	public void buildEquipo2(String equipo2) {
		partido.setEquipo2(equipo2);
	}

	@Override
	public void buildResultado(String resultado) {
		partido.setResultado(resultado);
	}

	@Override
	public void buildGanador(String ganador) {
		partido.setGanador(ganador);
	}
}
