package modeloME;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistaME.Ventana;

public class MapaEstelar {
	private Ventana ventana = null;
    public MapaEstelar(Ventana v){
        this.ventana=v;
    }
	private ArrayList<Star> estrellas = new ArrayList<>();
	static int num = 1;
	
	static int mov = 10;
	
	/**
	 * Metodo que pregunta cuantas estrellas desea el usuario al inicio de la ejecucion
	 * @return
	 */
	public Integer inicial() {
    	JFrame jFrame = new JFrame();
    	String s = null;
    	boolean can = false;
    	int numStar = 0;
        while(!can){
        	s = JOptionPane.showInputDialog(jFrame, "¿Cuantas estrellas quiere en el cielo?");
        	numStar = Integer.valueOf(s);
            if(numStar <= 0){
                JOptionPane.showMessageDialog(null, "Ingrese un numero de estrellas valido");
            }else{
            	can = true;
            }
        }
        //ventana.setInfoNumStars(ventana.getInfoNumStars().getText() + numStar);
        return numStar;
    }
	/**
	 * Metodo para crear los objetos de las estrellas al inicio de la ejecucion
	 */
	public void creator() {
		int cantidad = inicial();
		Random r = new Random();
		for (int i = 0; i < cantidad; i++) {
			String name = "star" + num;
			String pathStar = "MapaEstelar/ImagenesME/star" + (r.nextInt(5)+1) + ".png";
			Image img = new ImageIcon(pathStar).getImage();
			//int x = r.nextInt(1320)+1;
			int x = r.nextInt(2320)+1;
			//int y = r.nextInt(950)+1;
			int y = r.nextInt(1950)+1;
			int widthR = r.nextInt(20-5+1)+5;
			int highR = r.nextInt(20-5+1)+5;
			createStars(x, y, widthR, highR, name, img);
			num++;
		}
		int x = 1;
		int y = 60;
		int sector = 1;
		for (int i = 0; i < 3; i++) {
			ventana.getPanel().getSectores().add(new Sectores("Sector " + sector, x , y));
			sector++;
			ventana.getPanel().getSectores().add(new Sectores("Sector " + sector, x , (y+970)));
			sector++;
			x = x+779;
		}
		ventana.getPanel().repaint();
		actInfo();
	}
	/**
	 * Metodo para crear las estrellas al inicio de la ejecucion
	 * @param x
	 * @param y
	 * @param width
	 * @param high
	 * @param name
	 * @param img
	 */
	public void createStars(int x, int y, int width, int high, String name, Image img) {
		StarType type = StarFactory.getStarType(name, img);
		Star star = new Star(x, y, width, high, type);
		estrellas.add(star);
		actualizar(star);
	}
	
	public void movLeft(String key) {
		//System.out.println("key=" + key);
		for (int i = 0; i < ventana.getPanel().getEstrellas().size() ; i++) {
			//movCirc((ventana.getPanel().getEstrellas().get(i).getX() - mov), 2320);
			//ventana.getPanel().getEstrellas().get(i).setX(ventana.getPanel().getEstrellas().get(i).getX() - mov);
			ventana.getPanel().getEstrellas().get(i).setX(movCirc((ventana.getPanel().getEstrellas().get(i).getX() - mov), 2320));
		}
		for (int i = 0; i < ventana.getPanel().getSectores().size(); i++) {
			ventana.getPanel().getSectores().get(i).setX(movCirc((ventana.getPanel().getSectores().get(i).getX() - mov), 2320));
		}
		ventana.getPanel().repaint();
		actInfo();
	}
	public void movRight(String key) {
		for (int i = 0; i < ventana.getPanel().getEstrellas().size() ; i++) {
			//ventana.getPanel().getEstrellas().get(i).setX(ventana.getPanel().getEstrellas().get(i).getX() + mov);
			ventana.getPanel().getEstrellas().get(i).setX(movCirc((ventana.getPanel().getEstrellas().get(i).getX() + mov), 2320));
		}
		for (int i = 0; i < ventana.getPanel().getSectores().size(); i++) {
			ventana.getPanel().getSectores().get(i).setX(movCirc((ventana.getPanel().getSectores().get(i).getX() + mov), 2320));
		}
		ventana.getPanel().repaint();
		actInfo();
	}
	public void movUp(String key) {
		for (int i = 0; i < ventana.getPanel().getEstrellas().size() ; i++) {
			//ventana.getPanel().getEstrellas().get(i).setY(ventana.getPanel().getEstrellas().get(i).getY() - mov);
			ventana.getPanel().getEstrellas().get(i).setY(movCirc((ventana.getPanel().getEstrellas().get(i).getY() - mov), 1950));
		}
		for (int i = 0; i < ventana.getPanel().getSectores().size(); i++) {
			ventana.getPanel().getSectores().get(i).setY(movCirc((ventana.getPanel().getSectores().get(i).getY() - mov), 1950));
		}
		ventana.getPanel().repaint();
		actInfo();
	}
	public void movDown(String key) {
		for (int i = 0; i < ventana.getPanel().getEstrellas().size() ; i++) {
			//ventana.getPanel().getEstrellas().get(i).setY(ventana.getPanel().getEstrellas().get(i).getY() + mov);
			ventana.getPanel().getEstrellas().get(i).setY(movCirc((ventana.getPanel().getEstrellas().get(i).getY() + mov), 1950));
		}
		for (int i = 0; i < ventana.getPanel().getSectores().size(); i++) {
			ventana.getPanel().getSectores().get(i).setY(movCirc((ventana.getPanel().getSectores().get(i).getY() + mov), 1950));
		}
		ventana.getPanel().repaint();
		actInfo();
	}
	
	public Integer movCirc(int pos, int limit) {
		if(pos > limit) {
			pos = pos - limit;
		}
		if(pos<1) {
			pos = limit + pos;
		}
		return pos;
	}
	
	public void actInfo() {
		int starCieloVisible = 0;
		for (int i = 0; i < ventana.getPanel().getEstrellas().size() ; i++) {
			if(ventana.getPanel().getEstrellas().get(i).getY() <= 950 && ventana.getPanel().getEstrellas().get(i).getY() >= 0) {
				if(ventana.getPanel().getEstrellas().get(i).getX() <= 1320 && ventana.getPanel().getEstrellas().get(i).getX() >= 0) {
					starCieloVisible++;
				}
			}
		}
		//JOptionPane.showMessageDialog(null,"Hay " + starCieloVisible + " estrellas en el cielo visible");
		ventana.setInfoNumStars(ventana.getInfoNumStars().getText().substring(0, (ventana.getInfoNumStars().getText().indexOf(":") + 1)) + " <p><html>" + starCieloVisible);
	}
	
	/**
	 * Metodo para actualizar las estrellas en el panel
	 * @param star
	 */
	public void actualizar(Star star) {
		ventana.getPanel().setEstrellas(estrellas);
		star.draw(ventana);
		//ventana.getPanel().repaint();
	}
}
