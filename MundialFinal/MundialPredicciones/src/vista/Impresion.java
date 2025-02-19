package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import modelo.BuildHTML;
import modelo.FaseGrupos;
import modelo.Logica;
import modelo.Partido;

public class Impresion {
	public static ArrayList<String> plantilla = new ArrayList<>();
	/**
     * Imprimir con salto de linea
     * @param msg
     */
    public static void imprCSL(String msg) {
    	System.out.println(msg);
    }    
    /**
     * Imprimir sin salto de linea
     * @param msg
     */
    public static void imprSSL(String msg) {
    	System.out.print(msg);
    }
    //Arreglo con el contenido del html
	static ArrayList<String> arreglo =new ArrayList<>();
	/**
	 * Metodo imprimir tablas
	 * @param jugador
	 */
	public static void imprTablas(String jugador) {
		arreglo.add(jugador);
		ArrayList<FaseGrupos> tabla = Logica.tablasPuntos.get(jugador);
		imprCSL("\tFASE DE GRUPOS\n");
		for (int i = 0; i < tabla.size(); i++) {
			imprFrTabla("CSL", "            ", "Grupo " + tabla.get(i).getGrupo());
			imprCSL("\t\tPais\t\tW\tD\tL\tGF\tGA\tGD\tPuntos");
			for (int j = 0; j < tabla.get(i).getPaises().size(); j++) {
				imprFrTabla("SSL", "\t\t", tabla.get(i).getPaises().get(j).getPais());
				String esp = "\t";
				if(tabla.get(i).getPaises().get(j).getPais().length() <= 7) {
					esp += "\t";
				}
				imprFrTabla("SSL", esp, tabla.get(i).getPaises().get(j).getW()+"");
				imprFrTabla("SSL", "\t", tabla.get(i).getPaises().get(j).getD()+"");
				imprFrTabla("SSL", "\t", tabla.get(i).getPaises().get(j).getL()+"");
				imprFrTabla("SSL", "\t", tabla.get(i).getPaises().get(j).getGF()+"");
				imprFrTabla("SSL", "\t", tabla.get(i).getPaises().get(j).getGA()+"");
				imprFrTabla("SSL", "\t", tabla.get(i).getPaises().get(j).getGD()+"");
				imprFrTabla("SSL", "\t", tabla.get(i).getPaises().get(j).getPuntos()+"");
				imprCSL("");
			}
			imprCSL("");
		}	
	}
	/**
	 * Metodo imprimir fase eliminatoria
	 * @param partidos
	 */
	public static void generarFaseEliminatoria(ArrayList<Partido> partidos) {
		imprCSL("\tFASE DE ELIMINACION\n");
		imprFormatoTabla("", "", "OCTAVOS", "CUARTOS", "SEMIS", "TERCER LUGAR",  "FINAL\n");
		imprCSL("");
		int o = 0;
		int c = 8;
		int s = 12;
		int t = 14;
		int f = 15;
		imprFormatoTabla("ambos", "", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		imprFormatoTabla("ambos", "\n", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+1;
		imprFormatoTabla("ambos", "\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		imprCSL("");
		imprFormatoTabla("ambos", "\n", "", "", partidos.get(s).equipo1 + "-" + partidos.get(s).equipo2, "", "");
		imprCSL("");
		s=s+1;
		imprFormatoTabla("ambos", "\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		imprFormatoTabla("ambos", "\n", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+1;
		imprFormatoTabla("ambos", "\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", partidos.get(f).equipo1 + "-" + partidos.get(f).equipo2);
		o=o+1;
		imprCSL("");
		imprCSL("");
		imprFormatoTabla("ambos", "\n\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", partidos.get(t).equipo1 + "-" + partidos.get(t).equipo2, "");
		o=o+1;
		imprFormatoTabla("ambos", "\n", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		c=c+1;
		imprFormatoTabla("ambos", "\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		imprCSL("");
		imprFormatoTabla("ambos", "\n", "", "", partidos.get(s).equipo1 + "-" + partidos.get(s).equipo2, "", "");
		imprCSL("");
		imprFormatoTabla("ambos" ,"\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		o=o+1;
		imprFormatoTabla("ambos", "\n", "", partidos.get(c).equipo1 + "-" + partidos.get(c).equipo2, "", "", "");
		imprFormatoTabla("ambos", "\n", partidos.get(o).equipo1 + "-" + partidos.get(o).equipo2, "", "", "", "");
		imprCSL("\n\n\tPOSICIONES\n");
		String campeon = partidos.get(f).ganador;
		String subcampeon = "";
		if(partidos.get(f).ganador.equals(partidos.get(f).equipo1)) {
			subcampeon = partidos.get(f).equipo2;
		}else {
			subcampeon = partidos.get(f).equipo1;
		}
		String tercero = partidos.get(t).ganador;
		imprCSL("            1. " + campeon + " - CAMPEON\n            2. " + subcampeon + " - SUBCAMPEON\n            3. " + tercero + " - TERCER LUGAR\n");
		arreglo.add("1. "+campeon);
		arreglo.add("2. "+subcampeon);
		arreglo.add("3. "+tercero);
		plantillaHTML(arreglo);
		arreglo.clear();
	}
	/**
	 * Metodo formato de impresion tablas, fase de grupos
	 * @param salto
	 * @param format
	 * @param dato
	 */
	public static void imprFrTabla(String salto, String format, String dato) {
		if(salto.equals("CSL")) {
			imprCSL(format+dato);
		}else {
			imprSSL(format+dato);
		}
		arreglo.add(dato);
	}
	/**
	 * Metodo formato de impresion de tabla por consola, fase de eliminacion
	 * @param tipo
	 * @param saltos
	 * @param oct
	 * @param cuart
	 * @param sem
	 * @param terc
	 * @param fin
	 */
	public static void imprFormatoTabla(String tipo, String saltos, String oct, String cuart, String sem, String terc, String fin) {
		System.out.printf(saltos+"\t%26s%26s%26s%26s%26s",oct,cuart,sem,terc,fin);
		if(tipo.equals("ambos")) {
			if(!oct.equals("")) {
				arreglo.add(oct);
			}
			if(!cuart.equals("")) {
				arreglo.add(cuart);
			}
			if(!sem.equals("")) {
				arreglo.add(sem);
			}
			if(!terc.equals("")) {
				arreglo.add(terc);
			}
			if(!fin.equals("")) {
				arreglo.add(fin);
			}
		}
	}
	/**
	 * Metodo para imprimir puntajes
	 * @param puntos
	 */
	public static void imprPuntajes(List<Entry<String, Integer>> puntos) {
		int aux = 1;
		ArrayList<String> arreglo = new ArrayList<>();
		for (Entry<String, Integer> entry : puntos) {
			imprCSL(aux+". "+entry.getKey()+" = "+entry.getValue());
			arreglo.add("<br><br>"+aux+". "+entry.getKey()+" = "+entry.getValue());
			aux++;
		}
		BuildHTML.getInstance().generarPuntajes(arreglo);
	}
	/**
	 * Metodo generar plantilla html
	 * @param arreglo
	 */
	public static void plantillaHTML(ArrayList<String> arreglo) {
		int cont = 0;
		ArrayList<String> aux = new ArrayList<>();
		for (int i = 0; i < plantilla.size(); i++) {
			aux.add(plantilla.get(i));
			if(plantilla.get(i).contains("__")) {
				aux.set(i,plantilla.get(i).replace("__", arreglo.get(cont)));
				cont++;
			}
		}
		BuildHTML.getInstance().generarHtml(aux);
	}
}