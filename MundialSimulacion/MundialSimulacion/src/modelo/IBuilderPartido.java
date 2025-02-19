package modelo;

/*import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;*/

public abstract class IBuilderPartido {
	public Partido partido;
	public Partido getPartido() {
		return partido;
	}
	
	public abstract void buildFase(String fase);
	public abstract void buildEquipo1(String equipo1);
	public abstract void buildEquipo2(String equipo2);
	public abstract void buildResultado(String resultado);
	public abstract void buildGanador(String ganador);
	
	/*public void genCarpeta(String nombre, String tipo, String head, String accCabeza, String dorso, String accDorso, String legs, String accPiernas) {
		JOptionPane.showMessageDialog(null, "Elija la ubicacion donde desea guardar el personaje");
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showOpenDialog(file);
        File open = file.getSelectedFile();
        String path;
        if(open!=null){
        	//path = open.getPath() + "\\" + nombre; -> para windows
        	path = open.getPath() + "/" + nombre;
        	File directorio = new File(path);
            if(!directorio.exists()) {
                if(directorio.mkdirs()) {
                	JOptionPane.showMessageDialog(null, "Carpeta creada");
                }
                //copyFile("./src/img"+ tipo +"/Cabeza_"+ head + ".png", path + "\\"); -> para windows
                copyFile("./src/img"+ tipo +"/Cabeza_"+ head + ".png", path + "/");
                if(!accCabeza.equals("Null")) {
                	if(accCabeza.contains(",")) {
						String[] accesorios = accCabeza.split(",");
						for (int i = 0; i < accesorios.length; i++) {
							//copyFile("./src/imgAccCabeza/"+ accesorios[i] + ".png", path + "\\"); -> para windows
							copyFile("./src/imgAccCabeza/"+ accesorios[i] + ".png", path + "/");
						}
					}else {
						//copyFile("./src/imgAccCabeza/"+ accCabeza + ".png", path + "\\"); -> para windows
						copyFile("./src/imgAccCabeza/"+ accCabeza + ".png", path + "/");
					}
                }
                //copyFile("./src/img"+ tipo +"/Dorso_"+ dorso + ".png", path + "\\"); -> para windows
                copyFile("./src/img"+ tipo +"/Dorso_"+ dorso + ".png", path + "/");
                if(!accDorso.equals("Null")) {
                	if(accDorso.contains(",")) {
                		String[] accesorios = accDorso.split(",");
                		for (int i = 0; i < accesorios.length; i++) {
                			//copyFile("./src/imgAccDorso/"+ accesorios[i] + ".png", path + "\\"); -> para windows
                			copyFile("./src/imgAccDorso/"+ accesorios[i] + ".png", path + "/");
                		}
                	}else {
                		//copyFile("./src/imgAccDorso/"+ accDorso + ".png", path + "\\"); -> para windows
                		copyFile("./src/imgAccDorso/"+ accDorso + ".png", path + "/");
                	}
                }
                //copyFile("./src/img"+ tipo +"/Piernas_"+ legs + ".png", path + "\\"); -> para windows
                copyFile("./src/img"+ tipo +"/Piernas_"+ legs + ".png", path + "/");
                if(!accPiernas.equals("Null")) {
                	if(accPiernas.contains(",")) {
                		String[] accesorios = accPiernas.split(",");
                		for (int i = 0; i < accesorios.length; i++) {
                			//copyFile("./src/imgAccPiernas/"+ accesorios[i] + ".png", path + "\\"); -> para windows
                			copyFile("./src/imgAccPiernas/"+ accesorios[i] + ".png", path + "/");
                		}
                	}else {
                		//copyFile("./src/imgAccPiernas/"+ accPiernas + ".png", path + "\\"); -> para windows
                		copyFile("./src/imgAccPiernas/"+ accPiernas + ".png", path + "/");
                	}
                }
            }
        }
	}*/
	/*public void copyFile(String origen, String destino) {
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
	}*/
}
