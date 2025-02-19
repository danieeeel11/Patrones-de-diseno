package modeloME;

import java.awt.Image;

import vistaME.Ventana;

public class StarType {
	private String name;
	private Image img;

	public StarType(String name, Image img) {
		this.name = name;
		this.img = img;
	}
	
	public void draw(Ventana ventana) {
		ventana.getPanel().repaint();
	}

	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
