/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloME;


import vistaME.Ventana;

/**
 *
 * @author User
 */
public class Star {
    private int x;
    private int y;
    private int width; //ancho
    private int high; //alto
    private StarType type;
    
	public Star(int x, int y, int width, int high, StarType type) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.high = high;
		this.type = type;
	}
	
	public void draw(Ventana ventana) {
		type.draw(ventana);
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public StarType getType() {
		return type;
	}
	public void setType(StarType type) {
		this.type = type;
	}

    
}
