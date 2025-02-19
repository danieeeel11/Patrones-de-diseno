package creator;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CreadorRobot implements AbstractFactory{
	//ArrayList<String> listaFile = new ArrayList<>();
	
	@Override
	public IPersonaje crearPersonaje(String nombre, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas) {
		Cabeza c = new Cabeza(head);
		AccesorioCabeza aC = new AccesorioCabeza(accCabeza);
		Dorso d = new Dorso(dorso);
		AccesorioDorso aD = new AccesorioDorso(accDorso);
		Piernas p = new Piernas(legs);
		AccesorioPiernas aP = new AccesorioPiernas(accPiernas);
		IPersonaje rob = new Robot(nombre,c,aC,d,aD,p,aP);
		genCarpeta(nombre, head, accCabeza, dorso, accDorso, legs, accPiernas);
		return rob;
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
                copyFile("./CreadorPersonajes/imgRobot/Cabeza_"+ head + ".png", path + "\\");
                if(!accCabeza.equals("Null")) {
                	copyFile("./CreadorPersonajes/imgAccCabeza/"+ accCabeza + ".png", path + "\\");
                }
                copyFile("./CreadorPersonajes/imgRobot/Dorso_"+ dorso + ".png", path + "\\");
                if(!accDorso.equals("Null")) {
                	copyFile("./CreadorPersonajes/imgAccDorso/"+ accDorso + ".png", path + "\\");
                }
                copyFile("./CreadorPersonajes/imgRobot/Piernas_"+ legs + ".png", path + "\\");
                if(!accPiernas.equals("Null")) {
                	copyFile("./CreadorPersonajes/imgAccPiernas/"+ accPiernas + ".png", path + "\\");
                }
                //copyFile("./CreadorPersonajes/imgRobot/Cabeza_C3PO.png", path + "\\");
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

	/*public void listaFiles() {
		listaFile.add("Cabeza_Terminator");
		listaFile.add("Cabeza_C3PO");
		listaFile.add("Cabeza_Robocop");
		listaFile.add("Dorso_Terminator");
		listaFile.add("Dorso_C3PO");
		listaFile.add("Dorso_Robocop");
		listaFile.add("Piernas_Terminator");
		listaFile.add("Piernas_C3PO");
		listaFile.add("Piernas_Robocop");
	}*/
	
	
}
