package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import vista.Impresion;

public class Logica {
	static ArrayList<FaseGrupos> tablas = new ArrayList<>();
	static Map<String, Integer> puntosJugadores = new HashMap<>();
	public static Map<String, ArrayList<FaseGrupos>> tablasPuntos = new HashMap<>();
	/**
	 * Metodo generar partidos
	 * @param data
	 * @return
	 */
	public static ArrayList<Partido> genPartidos(ArrayList<String> data) {
		ArrayList<Partido> conjunto = new ArrayList<>();
		Mundial mundial = new Mundial();
		IBuilderPartido builderPartido = null;
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).contains("Grupos")) {
				builderPartido = new BuildFaseGrupos();
			}else if(data.get(i).contains("Octavos")) {
				builderPartido = new BuildOctavos();
			}else if(data.get(i).contains("Cuartos")) {
				builderPartido = new BuildCuartos();
			}else if(data.get(i).contains("Semis")) {
				builderPartido = new BuildSemis();
			}else if(data.get(i).contains("Tercero")) {
				builderPartido = new BuildCuartTercer();
			}else if(data.get(i).contains("Final")) {
				builderPartido = new BuildFinal();
			}
			mundial.setBuilderPartido(builderPartido);
			String[] info = data.get(i).split(",");
			mundial.builderPartido(info[0], info[1], info[2], info[3], info[4]);
			Partido partido = mundial.getPartido();
			conjunto.add(partido);
		}
		return conjunto;
	}
	/**
	 * Metodo generar tablas
	 */
	public static void generarTablas() {
		tablas.clear();
		FaseGrupos grupoA = new FaseGrupos("A",new ArrayList<>(Arrays.asList(new Pais("Qatar",0,0,0,0,0,0,0),
																		new Pais("Ecuador",0,0,0,0,0,0,0),
																		new Pais("Senegal",0,0,0,0,0,0,0),
																		new Pais("Netherlands",0,0,0,0,0,0,0))));
		FaseGrupos grupoB = new FaseGrupos("B",new ArrayList<>(Arrays.asList(new Pais("England",0,0,0,0,0,0,0),
																		new Pais("Iran",0,0,0,0,0,0,0),
																		new Pais("USA",0,0,0,0,0,0,0),
																		new Pais("Wales",0,0,0,0,0,0,0))));
		FaseGrupos grupoC = new FaseGrupos("C",new ArrayList<>(Arrays.asList(new Pais("Argentina",0,0,0,0,0,0,0),
																		new Pais("Saudi_Arabia",0,0,0,0,0,0,0),
																		new Pais("Mexico",0,0,0,0,0,0,0),
																		new Pais("Poland",0,0,0,0,0,0,0))));
		FaseGrupos grupoD = new FaseGrupos("D",new ArrayList<>(Arrays.asList(new Pais("France",0,0,0,0,0,0,0),
																		new Pais("Australia",0,0,0,0,0,0,0),
																		new Pais("Denmark",0,0,0,0,0,0,0),
																		new Pais("Tunisia",0,0,0,0,0,0,0))));
		FaseGrupos grupoE = new FaseGrupos("E",new ArrayList<>(Arrays.asList(new Pais("Spain",0,0,0,0,0,0,0),
																		new Pais("Costa_Rica",0,0,0,0,0,0,0),
																		new Pais("Germany",0,0,0,0,0,0,0),
																		new Pais("Japan",0,0,0,0,0,0,0))));
		FaseGrupos grupoF = new FaseGrupos("F",new ArrayList<>(Arrays.asList(new Pais("Belgium",0,0,0,0,0,0,0),
																		new Pais("Canada",0,0,0,0,0,0,0),
																		new Pais("Morocco",0,0,0,0,0,0,0),
																		new Pais("Croatia",0,0,0,0,0,0,0))));
		FaseGrupos grupoG = new FaseGrupos("G",new ArrayList<>(Arrays.asList(new Pais("Brazil",0,0,0,0,0,0,0),
																		new Pais("Serbia",0,0,0,0,0,0,0),
																		new Pais("Switzerland",0,0,0,0,0,0,0),
																		new Pais("Cameroon",0,0,0,0,0,0,0))));
		FaseGrupos grupoH = new FaseGrupos("H",new ArrayList<>(Arrays.asList(new Pais("Portugal",0,0,0,0,0,0,0),
																		new Pais("Ghana",0,0,0,0,0,0,0),
																		new Pais("Uruguay",0,0,0,0,0,0,0),
																		new Pais("South_Korea",0,0,0,0,0,0,0))));
		tablas.add(grupoA);
		tablas.add(grupoB);
		tablas.add(grupoC);
		tablas.add(grupoD);
		tablas.add(grupoE);
		tablas.add(grupoF);
		tablas.add(grupoG);
		tablas.add(grupoH);
	}
	/**
	 * Metodo ordenar tablas por puntos y goles de diferencia
	 * @param partidos
	 * @param jugador
	 */
	public static void ordenTablas(ArrayList<Partido> partidos, String jugador) {
		generarTablas();
		for (int i = 0; i < partidos.size(); i++) {
			int indexP = i;
			for (int j = 0; j < tablas.size(); j++) {
				if(tablas.get(j).getPaises().stream().filter(p->p.getPais().equals(partidos.get(indexP).ganador)).findAny().isPresent()){
					Partido partido = partidos.get(indexP);
					String ganador = partido.getGanador();
					String perdedor = "";
					int indW = tablas.get(j).getPaises().indexOf(tablas.get(j).getPaises().stream().filter(p->p.getPais().equals(ganador)).findAny().get());
					if(!partido.getGanador().equals(partido.getEquipo1())) {
						perdedor = partido.getEquipo1();
					}else {
						perdedor = partido.getEquipo2();
					}
					String auxP = perdedor;
					int indL = tablas.get(j).getPaises().indexOf(tablas.get(j).getPaises().stream().filter(p->p.getPais().equals(auxP)).findAny().get());
					//Ganador
					tablas.get(j).getPaises().get(indW).setW(tablas.get(j).getPaises().get(indW).getW() + 1);
					tablas.get(j).getPaises().get(indW).setPuntos(tablas.get(j).getPaises().get(indW).getPuntos() + 3);
					int n = 0;
					if(!partido.equipo1.equals(partido.getGanador())) {
						n = 1;
					}
					tablas.get(j).getPaises().get(indW).setGF(tablas.get(j).getPaises().get(indW).getGF() + calcularGoles(partido.resultado)[n]);
					if(n == 1) {
						n = 0;
					}else {
						n = 1;
					}
					tablas.get(j).getPaises().get(indW).setGA(tablas.get(j).getPaises().get(indW).getGA() + calcularGoles(partido.resultado)[n]);
					tablas.get(j).getPaises().get(indW).setGD(tablas.get(j).getPaises().get(indW).getGF() - tablas.get(j).getPaises().get(indW).getGA());
					//Perdedor
					tablas.get(j).getPaises().get(indL).setL(tablas.get(j).getPaises().get(indL).getL() + 1);
					n = 0;
					if(partido.equipo1.equals(partido.getGanador())) {
						n = 1;
					}
					tablas.get(j).getPaises().get(indL).setGF(tablas.get(j).getPaises().get(indL).getGF() + calcularGoles(partido.resultado)[n]);
					
					if(n == 1) {
						n = 0;
					}else {
						n = 1;
					}
					tablas.get(j).getPaises().get(indL).setGA(tablas.get(j).getPaises().get(indL).getGA() + calcularGoles(partido.resultado)[n]);
					tablas.get(j).getPaises().get(indL).setGD(tablas.get(j).getPaises().get(indL).getGF() - tablas.get(j).getPaises().get(indL).getGA());
				}
				// En caso de empate
				if(partidos.get(indexP).ganador.equals("NA")) {
					if(tablas.get(j).getPaises().stream().filter(p->p.getPais().equals(partidos.get(indexP).equipo1)).findAny().isPresent()){
						Partido partido = partidos.get(indexP);
						String equ1 = partido.equipo1;
						String equ2 = partido.equipo2;
						int ind1 = tablas.get(j).getPaises().indexOf(tablas.get(j).getPaises().stream().filter(p->p.getPais().equals(equ1)).findAny().get());
						int ind2 = tablas.get(j).getPaises().indexOf(tablas.get(j).getPaises().stream().filter(p->p.getPais().equals(equ2)).findAny().get());
						//Equipo1
						tablas.get(j).getPaises().get(ind1).setD(tablas.get(j).getPaises().get(ind1).getD() + 1);
						tablas.get(j).getPaises().get(ind1).setPuntos(tablas.get(j).getPaises().get(ind1).getPuntos() + 1);
						int n = 0;
						tablas.get(j).getPaises().get(ind1).setGF(tablas.get(j).getPaises().get(ind1).getGF() + calcularGoles(partido.resultado)[n]);
						tablas.get(j).getPaises().get(ind1).setGA(tablas.get(j).getPaises().get(ind1).getGA() + calcularGoles(partido.resultado)[n]);
						tablas.get(j).getPaises().get(ind1).setGD(tablas.get(j).getPaises().get(ind1).getGF() - tablas.get(j).getPaises().get(ind1).getGA());
						//Equipo2
						tablas.get(j).getPaises().get(ind2).setD(tablas.get(j).getPaises().get(ind2).getD() + 1);
						tablas.get(j).getPaises().get(ind2).setPuntos(tablas.get(j).getPaises().get(ind2).getPuntos() + 1);
						tablas.get(j).getPaises().get(ind2).setGF(tablas.get(j).getPaises().get(ind2).getGF() + calcularGoles(partido.resultado)[n]);
						tablas.get(j).getPaises().get(ind2).setGA(tablas.get(j).getPaises().get(ind2).getGA() + calcularGoles(partido.resultado)[n]);
						tablas.get(j).getPaises().get(ind2).setGD(tablas.get(j).getPaises().get(ind2).getGF() - tablas.get(j).getPaises().get(ind2).getGA());
					}
				}
			}
		}
		for (int i = 0; i < tablas.size(); i++) {
			Comparator<Pais> cPuntos = (pe1,pe2) -> Integer.compare(pe2.getPuntos(),pe1.getPuntos());
			Comparator<Pais> cGD = (pe1,pe2) -> Integer.compare(pe2.getGD(),pe1.getGD());
			tablas.get(i).getPaises().sort(cPuntos.thenComparing(cGD));
		}
		ArrayList<FaseGrupos> tabla = new ArrayList<>(tablas);
		tablasPuntos.put(jugador, tabla);
		tablas.clear();
	}
	/**
	 * Metodo calcular goles
	 * @param resultado
	 * @return
	 */
	public static int[] calcularGoles(String resultado) {
		String[] marcador = resultado.split("-");
		int[] num = new int[2];
		num[0] = Integer.parseInt(marcador[0]);
		num[1] = Integer.parseInt(marcador[1]);
		return num;
	}
	/**
	 * Metodo calcular puntaje de los jugadores
	 * @param real
	 * @param predicciones
	 */
	public static void cuentasPuntos(ArrayList<Partido> real, Map<String, ArrayList<Partido>> predicciones) {
		for (Map.Entry<String, ArrayList<Partido>> entry: predicciones.entrySet()) {
			int puntaje = 0;
			puntosJugadores.put(entry.getKey(), puntaje);
            for (int i = 0; i < entry.getValue().size(); i++) {
				if (entry.getValue().get(i).getResultado().equals(real.get(i).getResultado())) {
					puntaje = puntaje+10;
					puntosJugadores.put(entry.getKey(), puntaje);
				}
				if (entry.getValue().get(i).getGanador().equals(real.get(i).getGanador())) {
					puntaje = puntaje+5;
					puntosJugadores.put(entry.getKey(), puntaje);
				}else if (entry.getValue().get(i).getGanador().equals(real.get(i).getGanador()) && 
						real.get(i).getGanador().equals("NA")) {
					puntaje = puntaje+5;
					puntosJugadores.put(entry.getKey(), puntaje);
				}
				if (entry.getValue().get(i).getFase().equals("Octavos")) {
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo1())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo2())) {
							puntaje = puntaje+20;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo2())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo1())) {
							puntaje = puntaje+20;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
				}
				if (entry.getValue().get(i).getFase().equals("Cuartos")) {
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo1())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo2())) {
							puntaje = puntaje+25;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo2())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo1())) {
							puntaje = puntaje+25;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
				}
				if (entry.getValue().get(i).getFase().equals("Semis")) {
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo1())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo2())) {
							puntaje = puntaje+30;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo2())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo1())) {
							puntaje = puntaje+30;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
				}
				if (entry.getValue().get(i).getFase().equals("Final")) {
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo1())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo2())) {
							puntaje = puntaje+40;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo2())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo1())) {
							puntaje = puntaje+40;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getGanador().equals(real.get(i).getGanador())) {
						puntaje = puntaje+100;
						puntosJugadores.put(entry.getKey(), puntaje);
					}
					String subcampeonP = "";
					if (entry.getValue().get(i).getGanador().equals(entry.getValue().get(i).getEquipo1())) {
						subcampeonP = entry.getValue().get(i).getEquipo2();
					}else {
						subcampeonP = entry.getValue().get(i).getEquipo1();
					}
					String subcampeonR = "";
					if (real.get(i).getGanador().equals(real.get(i).getEquipo1())) {
						subcampeonR = real.get(i).getEquipo2();
					}else {
						subcampeonR = real.get(i).getEquipo1();
					}
					
					if (subcampeonR.equals(subcampeonP)) {
						puntaje = puntaje+80;
						puntosJugadores.put(entry.getKey(), puntaje);
					}
				}
				if (entry.getValue().get(i).getFase().equals("Tercero")) {
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo1())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo2())) {
							puntaje = puntaje+35;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getEquipo1().equals(real.get(i).getEquipo2())) {
						if (entry.getValue().get(i).getEquipo2().equals(real.get(i).getEquipo1())) {
							puntaje = puntaje+35;
							puntosJugadores.put(entry.getKey(), puntaje);
						}
					}
					if (entry.getValue().get(i).getGanador().equals(real.get(i).getGanador())) {
						puntaje = puntaje+60;
						puntosJugadores.put(entry.getKey(), puntaje);
					}
				}
			}
			for (int j = 0; j < tablasPuntos.get(entry.getKey()).size(); j++) {
				if(tablasPuntos.get(entry.getKey()).get(j).getPaises().get(0).equals(tablasPuntos.get("real").get(j).getPaises().get(0))){
					puntaje = puntaje+7;
					puntosJugadores.put(entry.getKey(), puntaje);
				}
				if(tablasPuntos.get(entry.getKey()).get(j).getPaises().get(1).equals(tablasPuntos.get("real").get(j).getPaises().get(1))){
					puntaje = puntaje+7;
					puntosJugadores.put(entry.getKey(), puntaje);
				}
			}
        }
	}
	/**
	 * Metodo ordenar puntajes de jugadores (ranking)
	 */
	public static void ordenarPuntajes() {
		List<Entry<String, Integer>> puntos = puntosJugadores.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();
		Impresion.imprPuntajes(puntos);
	}
}