package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Logica {
	
	static ArrayList<FaseGrupos> tablas = new ArrayList<>();
	
	/**
	 * 
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
			//conjunto.add(new ArrayList<>(Arrays.asList(data.get(i).split(","))));
			//conjunto = new ArrayList<>(Arrays.asList(data.get(i).split(",")));
		}
		return conjunto;
	}
	
	public static void imprP(ArrayList<Partido> partidos) {
		System.out.println("Fase\tEquipo1\t\tEquipo2\t\tResultado\tGanador");
		for (int i = 0; i < partidos.size(); i++) {
			System.out.print(partidos.get(i).fase);
			System.out.print("\t" + partidos.get(i).equipo1);
			String esp = "\t";
			if(partidos.get(i).equipo1.length() <= 7) {
				esp += "\t";
			}
			System.out.print(esp + partidos.get(i).equipo2);
			esp = "\t";
			if(partidos.get(i).equipo2.length() <= 7) {
				esp += "\t";
			}
			System.out.print(esp + partidos.get(i).resultado);
			System.out.print("\t\t" + partidos.get(i).ganador);
			System.out.println();
		}
	}
	
	public static void generarTablas() {
		//ArrayList<Pais> grupoB = new ArrayList<>(Arrays.asList();
		tablas.clear();
		
		FaseGrupos grupoA = new FaseGrupos("A",
											new ArrayList<>(Arrays.asList(new Pais("Qatar",0,0,0,0,0,0,0),
																		new Pais("Ecuador",0,0,0,0,0,0,0),
																		new Pais("Senegal",0,0,0,0,0,0,0),
																		new Pais("Netherlands",0,0,0,0,0,0,0))));
		FaseGrupos grupoB = new FaseGrupos("B",
											new ArrayList<>(Arrays.asList(new Pais("England",0,0,0,0,0,0,0),
																		new Pais("Iran",0,0,0,0,0,0,0),
																		new Pais("USA",0,0,0,0,0,0,0),
																		new Pais("Wales",0,0,0,0,0,0,0))));
		FaseGrupos grupoC = new FaseGrupos("C",
											new ArrayList<>(Arrays.asList(new Pais("Argentina",0,0,0,0,0,0,0),
																		new Pais("Saudi_Arabia",0,0,0,0,0,0,0),
																		new Pais("Mexico",0,0,0,0,0,0,0),
																		new Pais("Poland",0,0,0,0,0,0,0))));
		FaseGrupos grupoD = new FaseGrupos("D",
											new ArrayList<>(Arrays.asList(new Pais("France",0,0,0,0,0,0,0),
																		new Pais("Australia",0,0,0,0,0,0,0),
																		new Pais("Denmark",0,0,0,0,0,0,0),
																		new Pais("Tunisia",0,0,0,0,0,0,0))));
		FaseGrupos grupoE = new FaseGrupos("E",
											new ArrayList<>(Arrays.asList(new Pais("Spain",0,0,0,0,0,0,0),
																		new Pais("Costa_Rica",0,0,0,0,0,0,0),
																		new Pais("Germany",0,0,0,0,0,0,0),
																		new Pais("Japan",0,0,0,0,0,0,0))));
		FaseGrupos grupoF = new FaseGrupos("F",
											new ArrayList<>(Arrays.asList(new Pais("Belgium",0,0,0,0,0,0,0),
																		new Pais("Canada",0,0,0,0,0,0,0),
																		new Pais("Morocco",0,0,0,0,0,0,0),
																		new Pais("Croatia",0,0,0,0,0,0,0))));
		FaseGrupos grupoG = new FaseGrupos("G",
											new ArrayList<>(Arrays.asList(new Pais("Brazil",0,0,0,0,0,0,0),
																		new Pais("Serbia",0,0,0,0,0,0,0),
																		new Pais("Switzerland",0,0,0,0,0,0,0),
																		new Pais("Cameroon",0,0,0,0,0,0,0))));
		FaseGrupos grupoH = new FaseGrupos("H",
											new ArrayList<>(Arrays.asList(new Pais("Portugal",0,0,0,0,0,0,0),
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
	
	public static void ordenTablas(ArrayList<Partido> partidos) {
		generarTablas();
		for (int i = 0; i < partidos.size(); i++) {
			int indexP = i;
			for (int j = 0; j < tablas.size(); j++) {
				//int indexTabla = tablas.get(j).getPaises().size();
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
			//tablas.get(i).getPaises().sort((o1,o2) -> o2.getPuntos()-o1.getPuntos());
			Comparator<Pais> cPuntos = (pe1,pe2) -> Integer.compare(pe2.getPuntos(),pe1.getPuntos());
			Comparator<Pais> cGD = (pe1,pe2) -> Integer.compare(pe2.getGD(),pe1.getGD());
			tablas.get(i).getPaises().sort(cPuntos.thenComparing(cGD));
		}
		
		
	}
	
	public static void imprTablas() {
		System.out.println("\tFASE DE GRUPOS\n");
		for (int i = 0; i < tablas.size(); i++) {
			System.out.println("            Grupo " + tablas.get(i).getGrupo());
			System.out.println("\t\tPais\t\tW\tD\tL\tGF\tGA\tGD\tPuntos");
			for (int j = 0; j < tablas.get(i).getPaises().size(); j++) {
				System.out.print("\t\t" + tablas.get(i).getPaises().get(j).getPais());
				String esp = "\t";
				if(tablas.get(i).getPaises().get(j).getPais().length() <= 7) {
					esp += "\t";
				}
				System.out.print(esp + tablas.get(i).getPaises().get(j).getW());
				System.out.print("\t" + tablas.get(i).getPaises().get(j).getD());
				System.out.print("\t" + tablas.get(i).getPaises().get(j).getL());
				System.out.print("\t" + tablas.get(i).getPaises().get(j).getGF());
				System.out.print("\t" + tablas.get(i).getPaises().get(j).getGA());
				System.out.print("\t" + tablas.get(i).getPaises().get(j).getGD());
				System.out.print("\t" + tablas.get(i).getPaises().get(j).getPuntos());
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void generarFaseEliminatoria(ArrayList<Partido> partidos) {
		System.out.println("\tFASE DE ELIMINACION\n");
		//System.out.println("OCTAVOS                   CUARTOS                   SEMIS\n");
		System.out.printf("\t%26s%26s%26s%26s%26s", "OCTAVOS", "CUARTOS", "SEMIS", "TERCER LUGAR",  "FINAL\n");
		System.out.println();
		int o = 0;
		int c = 8;
		int s = 12;
		int t = 14;
		int f = 15;
		
		System.out.printf("\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		System.out.println();
		System.out.printf("\n\t%26s%26s%26s%26s%26s", "", "", partidos.get(s).equipo1 + "-" + partidos.get(s).equipo2, "", "");
		System.out.println();
		s=s+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", partidos.get(f).equipo1 + "-" + partidos.get(f).equipo2);
		o=o+1;
		f=f+0;
		System.out.println();
		System.out.println();
		System.out.printf("\n\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", partidos.get(t).equipo1 + "-" + partidos.get(t).equipo2, "");
		o=o+1;
		t=t+0;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		System.out.println();
		System.out.printf("\n\t%26s%26s%26s%26s%26s", "", "", partidos.get(s).equipo1 + "-" + partidos.get(s).equipo2, "", "");
		System.out.println();
		s=s+0;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+0;
		System.out.printf("\n\t%26s%26s%26s%26s%26s", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		c=c+0;
		System.out.println("\n\n\tPOSICIONES\n");
		String campeon = partidos.get(f).ganador;
		String subcampeon = "";
		if(partidos.get(f).ganador.equals(partidos.get(f).equipo1)) {
			subcampeon = partidos.get(f).equipo2;
		}else {
			subcampeon = partidos.get(f).equipo1;
		}
		String tercero = partidos.get(t).ganador;
		System.out.println("            1. " + campeon + " - CAMPEON\n            2. " + subcampeon + " - SUBCAMPEON\n            3. " + tercero + " - TERCER LUGAR\n");
	}
	
	/**
	 * o = 0;
		c = 8;
		s = 12;
		t = 14;
		f = 15;
		
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2);
		System.out.println("                      " + partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2);
		o=o+1;
		c=c+1;
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2);
		o=o+1;
		
		System.out.println("                                              " + partidos.get(s).equipo1 + "-" + partidos.get(s).equipo2);
		s=s+1;
		
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2);
		System.out.println("                      " + partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2);
		o=o+1;
		c=c+1;
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2 + "                                                                  " + partidos.get(f).equipo1 + "-" + partidos.get(f).equipo2 + "    FINAL \n");
		o=o+1;
		f=f+0;
		
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2 + "                                                                  " + partidos.get(t).equipo1 + "-" + partidos.get(t).equipo2 + "    TERCER LUGAR");
		System.out.println("                      " + partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2);
		o=o+1;
		c=c+1;
		t=t+0;
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2);
		o=o+1;
		
		
		System.out.println("                                              " + partidos.get(s).equipo1 + "-" + partidos.get(s).equipo2);
		s=s+0;
		
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2);
		System.out.println("                      " + partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2);
		o=o+1;
		c=c+0;
		System.out.println(partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2);
		o=o+0;
	 * 
	 * /
	
	/**
	 * StringBuilder octavos = new StringBuilder();
		StringBuilder cuartos = new StringBuilder();
		StringBuilder semis = new StringBuilder();
		StringBuilder tercero = new StringBuilder();
		StringBuilder Final = new StringBuilder();
		for (int i = 0; i < partidos.size(); i++) {
			if(partidos.get(i).getFase().equals("Octavos")) {
				octavos.append(partidos.get(i).getEquipo1() + "-" + partidos.get(i).getEquipo2() + "  ");
			}else if (partidos.get(i).getFase().equals("Cuartos")) {
				cuartos.append(partidos.get(i).getEquipo1() + "-" + partidos.get(i).getEquipo2() + "  ");
			}else if (partidos.get(i).getFase().equals("Semis")) {
				semis.append(partidos.get(i).getEquipo1() + "-" + partidos.get(i).getEquipo2() + "  ");
			}else if (partidos.get(i).getFase().equals("Tercero")) {
				tercero.append(partidos.get(i).getEquipo1() + "-" + partidos.get(i).getEquipo2() + "  ");
			}else if (partidos.get(i).getFase().equals("Final")) {
				Final.append(partidos.get(i).getEquipo1() + "-" + partidos.get(i).getEquipo2() + "  ");
			}
		}
		
		int numEspCuartos = Math.round((octavos.length()/2)-(cuartos.length()/2));
		int numEspSemis = Math.round((numEspCuartos + (cuartos.length()/2))-(semis.length()/2));
		int numEspTercero = Math.round((numEspSemis + (semis.length()/2))-(tercero.length()/2));
		int numEspFinal = Math.round((numEspSemis + (semis.length()/2))-(Final.length()/2));
		String espCuartos = "" + String.format("%0" + (numEspCuartos-1) + "d", 0);
		String espSemis = "" + String.format("%0" + (numEspSemis-2) + "d", 0);
		String espTercero = "" + String.format("%0" + (numEspTercero-3) + "d", 0);
		String espFinal = "" + String.format("%0" + (numEspFinal-3) + "d", 0);
		espCuartos = espCuartos.replace("0", " ");
		espSemis = espSemis.replace("0", " ");
		espTercero = espTercero.replace("0", " ");
		espFinal = espFinal.replace("0", " ");		
		
		System.out.println(octavos + "\n" + espCuartos + cuartos + "\n" + espSemis + semis + "\n" + espTercero + tercero + "\n" + espFinal + Final);
	 */
	
	
	/**
	 * 
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
}
