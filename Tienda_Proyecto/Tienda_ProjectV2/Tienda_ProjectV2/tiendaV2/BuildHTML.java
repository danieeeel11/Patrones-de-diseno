package tiendaV2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

public class BuildHTML {
	static int cont = 1;
	ArrayList<String> imagenes = new ArrayList<>();
	public int precioTotal = 0;
	
	public void CrearHTML(Component alimento) {
		String a = System.getProperty("user.dir")+ "\\Tienda_ProjectV2\\imagenes\\"+alimento.name+".jpg";
		
		imagenes.add("<img src= " + (char)34 + a +(char)34 
			    + " width=" + (char)34 + "300" + (char)34 +  " heigh=" + (char)34 + "150" + (char)34 +"/>" 
			    + (char)34 + alimento.name + (char)34 + ": $" + alimento.price + (char)34 + "<br>");
	}
		

	public void generarHtml() {
		StringBuilder ayuda = new StringBuilder();
		for (int i = 0; i < imagenes.size(); i++) {
			String img = "<br>" + imagenes.get(i);
			ayuda.append(img);
		}
		ayuda.append("<h1>Total de su pedido: $" + precioTotal + "</h1>");

		String k = "<html>"
				//+ "<head><meta charset="+(char)34+"UTF-8"+(char)34+">"
                //+"<meta name="+(char)34+"viewport"+(char)34+ " content=" +(char)34+ "width=device-width, initial-scale=1.0"+(char)34+">"
        		+"<title>DiagramacionHTML</title></head>"
				+"<body>"
				+"<div align="+(char)34+"center"+(char)34+">"
				+ "<h1> SU PEDIDO </h1>"
				+ ayuda 
				+"</div>"
				+ "</body>"
				+ "</html>";
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			String localLanguage = "";
			if(Locale.getDefault().getLanguage().equals("en")) {
				localLanguage = "Downloads";
			}else {
				localLanguage = "Downloads";
			}
			String dirSave = System.getProperty("user.home") + "\\"+ localLanguage + "\\";
			fichero =new FileWriter(dirSave + "pedido" + cont +".html");
			cont++;
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
