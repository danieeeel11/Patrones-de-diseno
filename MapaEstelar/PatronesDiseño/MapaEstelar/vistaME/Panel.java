/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaME;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modeloME.Sectores;
import modeloME.Star;


public class Panel extends JPanel{
    //Lista de puntos
    private ArrayList<Star> estrellas = new ArrayList<>();
    private ArrayList<Sectores> sectores = new ArrayList<>();
    
    public Panel(){
        this.setSize(1320,950);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,1320, 950);
        g.setColor(new Color(37, 36, 64));
        g.fillRect(0, 0, 1320, 950);
        Image fondo;
        fondo = new ImageIcon("MapaEstelar/ImagenesME/fondo.jpg").getImage();
        g.drawImage(fondo, 0, 0, 1320, 950, this);
        
        setOpaque(false);
        //super.paint(g);
        //initComponents();
        g.setColor(Color.BLACK);
        
        //for (int i = 0; i < imgs.size(); i++) {
            //g.drawImage(imgs.get(i).getImg(), imgs.get(i).getX(), imgs.get(i).getY(), imgs.get(i).getDimx(), imgs.get(i).getDimy(), this);
        //}
        for (int i = 0; i < estrellas.size(); i++) {
            //g.setColor(Color.WHITE);
            g.drawImage(estrellas.get(i).getType().getImg(), estrellas.get(i).getX(), estrellas.get(i).getY(), estrellas.get(i).getWidth(), estrellas.get(i).getHigh(), this);
            //g.fillOval(estrellas.get(i).getX(), estrellas.get(i).getY(), estrellas.get(i).getWidth(), estrellas.get(i).getHigh());
            //g.drawString(String.valueOf(estrellas.get(i).getSoldados()), estrellas.get(i).getX()+10, estrellas.get(i).getY()+20);
        }
        for (int i = 0; i < sectores.size(); i++) {
        	g.setColor(Color.WHITE);
        	g.setFont(new Font("Times New Roman", Font.BOLD, 50));
			g.drawString(sectores.get(i).getName(), sectores.get(i).getX(), sectores.get(i).getY());
		}
    }
    
    
	public void setEstrellas(ArrayList<Star> estrellas) {
		this.estrellas = estrellas;
	}
	public ArrayList<Star> getEstrellas() {
		return estrellas;
	}
	public ArrayList<Sectores> getSectores() {
		return sectores;
	}
	public void setSectores(ArrayList<Sectores> sectores) {
		this.sectores = sectores;
	}
	
	
}
