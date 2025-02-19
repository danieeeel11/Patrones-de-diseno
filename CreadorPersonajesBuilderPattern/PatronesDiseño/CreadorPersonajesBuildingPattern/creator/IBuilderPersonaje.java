package creator;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public abstract class IBuilderPersonaje {
	public Personaje personaje;
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public abstract void buildNombre(String nombre);
	public abstract void buildTipo(String tipo);
	public abstract void buildCabeza(String head);
	public abstract void buildAccesorioCabeza(String accCabeza);
	public abstract void buildDorso(String dorso);
	public abstract void buildAccesorioDorso(String accDorso);
	public abstract void buildPiernas(String legs);
	public abstract void buildAccesorioPiernas(String accPiernas);
	
	public void genCarpeta(String nombre, String tipo, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas) {
		JOptionPane.showMessageDialog(null, "Elija la ubicacion donde desea guardar el personaje");
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showOpenDialog(file);
        File open = file.getSelectedFile();
        String path;
        if(open!=null){
        	path = open.getPath() + "\\" + nombre;
        	File directorio = new File(path);
            if(!directorio.exists()) {
                if(directorio.mkdirs()) {
                	JOptionPane.showMessageDialog(null, "Carpeta creada");
                }
                copyFile("./CreadorPersonajes/img"+ tipo +"/Cabeza_"+ head + ".png", path + "\\");
                if(!accCabeza.equals("Null")) {
                	if(accCabeza.contains(",")) {
						String[] accesorios = accCabeza.split(",");
						for (int i = 0; i < accesorios.length; i++) {
							copyFile("./CreadorPersonajes/imgAccCabeza/"+ accesorios[i] + ".png", path + "\\");
						}
					}else {
						copyFile("./CreadorPersonajes/imgAccCabeza/"+ accCabeza + ".png", path + "\\");
					}
                }
                copyFile("./CreadorPersonajes/img"+ tipo +"/Dorso_"+ dorso + ".png", path + "\\");
                if(!accDorso.equals("Null")) {
                	if(accDorso.contains(",")) {
                		String[] accesorios = accDorso.split(",");
                		for (int i = 0; i < accesorios.length; i++) {
                			copyFile("./CreadorPersonajes/imgAccDorso/"+ accesorios[i] + ".png", path + "\\");
                		}
                	}else {
                		copyFile("./CreadorPersonajes/imgAccDorso/"+ accDorso + ".png", path + "\\");
                	}
                }
                copyFile("./CreadorPersonajes/img"+ tipo +"/Piernas_"+ legs + ".png", path + "\\");
                if(!accPiernas.equals("Null")) {
                	if(accPiernas.contains(",")) {
                		String[] accesorios = accPiernas.split(",");
                		for (int i = 0; i < accesorios.length; i++) {
                			copyFile("./CreadorPersonajes/imgAccPiernas/"+ accesorios[i] + ".png", path + "\\");
                		}
                	}else {
                		copyFile("./CreadorPersonajes/imgAccPiernas/"+ accPiernas + ".png", path + "\\");
                	}
                }
            }
        }
	}
	public void copyFile(String origen, String destino) {
		try {
			File file = new File(origen);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			try {
				for(int readNum; (readNum = fis.read(buf)) != -1;) {
					bos.write(buf, 0, readNum);
				}
			}catch (IOException ex){
				System.err.println("Error");
			}
			byte[] bytes = bos.toByteArray();
			File newFile = new File(destino + file.getName());
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
			ImageIO.write(img, "png", newFile);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
