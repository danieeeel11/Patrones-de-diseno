package vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lectura {
    private Scanner leer;
    public Lectura() {
    	this.leer = new Scanner(System.in);
    }
    /**
     * Metodo leer dato String
     * @return
     */
    public String leerString() {
    	String dato = leer.next();
        return dato;
    }
    /**
     * Metodo leer dato int
     * @return
     */
    public int leerInt() {
    	int dato = leer.nextInt();
    	return dato;
    }
    /**
     * Metodo lectura archivos txt
     * @param ruta
     * @return
     */
    public ArrayList<String> lecturaTxt(String ruta){
    	ArrayList<String> data = new ArrayList<>();
    	File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
			archivo = new File (ruta);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null) {
				data.add(linea);
			}
        }
        catch(Exception e){
        	e.printStackTrace();
        }finally{
        	try{                    
        		if( null != fr ){   
        			fr.close();     
        		}                  
        	}catch (Exception e2){ 
        		e2.printStackTrace();
        	}
    	}
    	return data;
    }
    /**
     * Metodo reconocer archivos de predicciones en carpeta
     * @return
     */
    public File[] archivosPredicciones() {
    	File carpeta = new File("./src/data"); 
    	File[] lista = carpeta.listFiles();
    	Arrays.sort(lista);
    	Impresion.imprCSL("\n Hay " +  lista.length + " elementos");
    	return lista;
    }
    /**
     * Metodo reconocer archivo de partidos reales en carpeta
     * @return
     */
    public File archivoReal() {
    	File carpeta = new File("./src/dataReal");
    	File[] lista = carpeta.listFiles();
    	Arrays.sort(lista);
    	return lista[0];
    }
    /**
     * Metodo reconocer archivo plantilla en carpeta
     * @return
     */
    public File archivoPlantilla() {
    	File carpeta = new File("./src/plantilla");
    	File[] lista = carpeta.listFiles();
    	Arrays.sort(lista);
    	return lista[0];
    }
}