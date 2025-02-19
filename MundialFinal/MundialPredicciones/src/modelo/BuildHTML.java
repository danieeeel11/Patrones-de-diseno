package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

public class BuildHTML {
	private static BuildHTML instance;
	public static BuildHTML getInstance() {
		if(instance==null) {
			instance = new BuildHTML();
		}
		return instance;
	}
	/**
	 * Metodo generar html para pronosticos y reales
	 * @param array
	 */
	public void generarHtml(ArrayList<String> array) {
		StringBuilder ayuda = new StringBuilder();
		String usuario = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			ayuda.append(array.get(i));
		}
		String titulo = "<h1> Predicciones "+usuario+"</h1>";
		String color = "background-color: rgb(255,153,153);";
		if(usuario.equals("real")) {
			titulo = "<h1>Resultado "+usuario+"</h1>";
			color = "background-color: rgb(153,255,153);";
		}
		String k = "<html>"
				+"<body style=" + (char)34 +color+ (char)34 + ">"
        		+"<title>Resultados</title></head>"
				+"<body>"
				+"<div align="+(char)34+"center"+(char)34+">"
				+ titulo
				+ ayuda 
				+"</div>"
				+ "</body>"
				+ "</html>";
		guardarHtml(k,"partidos",usuario);
	}
	/**
	 * Metodo generar html para puntajes
	 * @param array
	 */
	public void generarPuntajes(ArrayList<String> array) {
		StringBuilder ayuda = new StringBuilder();
		for (int i = 0; i < array.size(); i++) {
			ayuda.append(array.get(i));
		}
		String color = "background-color: rgb(255,255,153);";
		String titulo = "<h1> POSICIONES </h1>";
		String k = "<html>"
				+"<body style=" + (char)34 +color+ (char)34 + ">"
        		+"<title>Resultados</title></head>"
				+"<body>"
				+"<div align="+(char)34+"center"+(char)34+">"
				+ titulo
				+ ayuda 
				+"</div>"
				+ "</body>"
				+ "</html>";
		guardarHtml(k,"puntajes","");
	}
	/**
	 * Metodo para guardar archivo html
	 * @param k
	 * @param tipo
	 * @param usuario
	 */
	public void guardarHtml(String k, String tipo, String usuario) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			String localLanguage = "";
			if(Locale.getDefault().getLanguage().equals("en")) {
				localLanguage = "Downloads";
			}else {
				localLanguage = "Descargas";
			}
			String dirSave = System.getProperty("user.home") + "/"+ localLanguage + "/";
			String nombreArchivo = "";
			if(tipo.equals("puntajes")) {
				nombreArchivo = "Puntajes";
				fichero =new FileWriter(dirSave+nombreArchivo+".html");
			}else {
				nombreArchivo = "Prediccion_";
				if(usuario.equals("real")) {
					nombreArchivo = "Resultado_";
				}
				fichero =new FileWriter(dirSave+nombreArchivo+usuario+".html");
			}
			pw =new PrintWriter(fichero);
			pw.println(k);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != fichero) {
					fichero.close();
				} 
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}