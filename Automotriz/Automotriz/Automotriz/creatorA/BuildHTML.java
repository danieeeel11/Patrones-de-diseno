package creatorA;

import java.io.FileWriter;
import java.io.PrintWriter;

public class BuildHTML {
	private static BuildHTML instance;
	
	public static BuildHTML getInstance() {
		if(instance==null) {
			instance=new BuildHTML();
		}
		return instance;
	}
	
	public void createHTML(Auto auto) {
		String dirMarca = System.getProperty("user.dir")+ "\\Automotriz\\img" + auto.marca + "\\logo.png";
		String dirModelo = System.getProperty("user.dir")+ "\\Automotriz\\img" + auto.marca + "\\" + auto.modelo +".jpg";
		String dirMotor = System.getProperty("user.dir")+ "\\Automotriz\\img" + auto.marca + "\\" + auto.motor +".png";
		String dirTransmision = System.getProperty("user.dir")+ "\\Automotriz\\img" + auto.marca + "\\" + auto.transmision +".png";
		String dirRines = System.getProperty("user.dir")+ "\\Automotriz\\img" + auto.marca + "\\" + auto.rines +".png";
		
		String impMarca = "<img src= " + (char)34 + dirMarca +(char)34 
			    + " width=" + (char)34 + "300" + (char)34 +  " heigh=" + (char)34 + "150" + (char)34 +"/>" 
			    + (char)34 + " Marca: " + auto.marca + (char)34 + "<br>";
		String impModelo = "<img src= " + (char)34 + dirModelo +(char)34 
			    + " width=" + (char)34 + "300" + (char)34 +  " heigh=" + (char)34 + "150" + (char)34 +"/>" 
			    + (char)34 + " Modelo: " + auto.modelo + (char)34 + "<br>";
		String impMotor = "<img src= " + (char)34 + dirMotor +(char)34 
			    + " width=" + (char)34 + "300" + (char)34 +  " heigh=" + (char)34 + "150" + (char)34 +"/>" 
			    + (char)34 + " Motor: " + auto.motor + (char)34 + "<br>";
		String impTransmision = "<img src= " + (char)34 + dirTransmision +(char)34 
			    + " width=" + (char)34 + "300" + (char)34 +  " heigh=" + (char)34 + "150" + (char)34 +"/>" 
			    + (char)34 + " Transimision: " + auto.transmision + (char)34 + "<br>";
		String impRines = "<img src= " + (char)34 + dirRines +(char)34 
			    + " width=" + (char)34 + "300" + (char)34 +  " heigh=" + (char)34 + "150" + (char)34 +"/>" 
			    + (char)34 + " Rines: " + auto.rines + (char)34 + "<br>";
		
		String k = "<html>"
				+"<body style=" + (char)34 + "background-color:gray;" + (char)34 + ">"
				+ "<div style="+(char)34+"text-align: center;"+(char)34+">"
				+ "<font face="+(char)34+"baskerville"+(char)34+" size="+(char)34+"20"+(char)34+">AUTOMOTRIZ</font><br>"
				+ "<h1>" + auto.marca + " - " + auto.modelo + "</h1>"
				+ "<br>" + impMarca
				+ "<br>" + impModelo
				+ "<br>" + impMotor
				+ "<br>" + impTransmision
				+ "<br>" + impRines
				+ "</body>"
				+ "</html>";
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			String dirSave = System.getProperty("user.home") + "\\Downloads\\";
			fichero =new FileWriter(dirSave + "Auto" + auto.marca + "_" + auto.modelo +".html");
			//fichero =new FileWriter("D:\\Perfil\\Desktop\\imagenesAutos\\prueba.html");
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
