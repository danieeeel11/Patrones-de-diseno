package vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//import modelo.Partido;

/**
 * 
 * @author danielvelasquez
 *
 */
public class EyS {
    private Scanner leer;
	
    public EyS() {
    	this.leer = new Scanner(System.in);
    }
	
    public String leerString() {
    	String dato = leer.next();
        /*try {
            dato=leer.nextInt();
        }catch (Exception e){
            System.out.println("El dato ingresado no es un numero");
            dato=0;
        }*/
        return dato;
    }
    
    public int leerInt() {
    	int dato = leer.nextInt();
    	return dato;
    }
    /**
     * Imprimir con salto de linea
     * @param msg
     */
    public void imprCSL(String msg) {
    	System.out.println(msg);
    }    
    /**
     * Imprimir sin salto de linea
     * @param msg
     */
    public void imprSSL(String msg) {
    	System.out.print(msg);
    }
    
    public ArrayList<String> lecturaTxt(String ruta){
    	ArrayList<String> data = new ArrayList<>();
    	File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
        	// Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File (ruta);
			   
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null) {
				//data.add(new Partido());
				data.add(linea);
			}
        }
        catch(Exception e){
        	e.printStackTrace();
        }finally{
        	// En el finally cerramos el fichero, para asegurarnos
        	// que se cierra tanto si todo va bien como si salta 
        	// una excepcion.
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
    
    public File[] archivosPredicciones() {
    	File carpeta = new File("./src/data"); 
    	File[] lista = carpeta.listFiles();
    	Arrays.sort(lista);
    	System.out.println("\n Hay " +  lista.length + " elementos");
    	/*for (int i = 0; i < lista.length; i++) {
    		System.out.println(lista[i]);
		}*/
    	return lista;
    }
    
    public File archivoReal() {
    	File carpeta = new File("./src/dataReal");
    	File[] lista = carpeta.listFiles();
    	Arrays.sort(lista);
    	return lista[0];
    }
}
