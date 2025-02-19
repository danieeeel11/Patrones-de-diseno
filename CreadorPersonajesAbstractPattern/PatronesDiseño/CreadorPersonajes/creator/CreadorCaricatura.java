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

public class CreadorCaricatura implements AbstractFactory{
	@Override
	public IPersonaje crearPersonaje(String nombre, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas) {
		Cabeza c = new Cabeza(head);
		AccesorioCabeza aC = new AccesorioCabeza(accCabeza);
		Dorso d = new Dorso(dorso);
		AccesorioDorso aD = new AccesorioDorso(accDorso);
		Piernas p = new Piernas(legs);
		AccesorioPiernas aP = new AccesorioPiernas(accPiernas);
		IPersonaje cari = new Caricatura(nombre,c,aC,d,aD,p,aP);
		genCarpeta(nombre, head, accCabeza, dorso, accDorso, legs, accPiernas);
		return cari;
	}

	@Override
	public void genCarpeta(String nombre, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas) {
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
                copyFile("./CreadorPersonajes/imgCaricatura/Cabeza_"+ head + ".png", path + "\\");
                if(!accCabeza.equals("Null")) {
                	copyFile("./CreadorPersonajes/imgAccCabeza/"+ accCabeza + ".png", path + "\\");
                }
                copyFile("./CreadorPersonajes/imgCaricatura/Dorso_"+ dorso + ".png", path + "\\");
                if(!accDorso.equals("Null")) {
                	copyFile("./CreadorPersonajes/imgAccDorso/"+ accDorso + ".png", path + "\\");
                }
                copyFile("./CreadorPersonajes/imgCaricatura/Piernas_"+ legs + ".png", path + "\\");
                if(!accPiernas.equals("Null")) {
                	copyFile("./CreadorPersonajes/imgAccPiernas/"+ accPiernas + ".png", path + "\\");
                }
            }
        }
	}
	
	@Override
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
