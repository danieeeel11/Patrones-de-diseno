/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaME;

import controladorME.Controler;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Ventana extends JFrame{
    private Controler c;
    private JLabel infoNumStars = new JLabel("<html>ESTRELLAS EN EL CIELO VISIBLE: <p><html>");
    private JLabel infoFlechas = new JLabel("<html>Presione las FLECHAS DEL TECLADO para mover el mapa<html>");
    //private JButton izquierda = new JButton("<-");
    //private JButton derecha = new JButton("->");
    //private JButton arriba = new JButton("^");
    //private JButton abajo = new JButton("v");
    private Panel panel = new Panel(); //Se crea panel y se inicializa

    
    public Ventana(){
        //establece el tamaño de la ventana emergente
        this.setBounds(250, 20, 1500, 1000);
        this.getContentPane().setBackground(new Color(37, 36, 64));
        //para cerrar la ventana cuando se oprime la x de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        //invoca los componentes para aparecer en la pantalla
        this.initComponents();
        this.key();
        this.setVisible(true);
    }
    
    private void initComponents(){
        this.panel.setBounds(150,0,1320,950);
        this.add(panel);
        
        //Font letra1= new Font("Niagara Solid",Font.CENTER_BASELINE,20);
        
        infoNumStars.setForeground(Color.WHITE);
        infoNumStars.setBounds(10, 50, 120, 60);
        this.add(infoNumStars);
        infoFlechas.setForeground(Color.WHITE);
        //infoLeft.setFont(letra1);
        infoFlechas.setBounds(10, 250, 120, 60);
        this.add(infoFlechas);
        
        /*this.izquierda.setBounds(10, 20, 120, 30);
        this.izquierda.setBackground(Color.BLACK);
        this.izquierda.setForeground(Color.WHITE);
        this.add(izquierda);
        
        this.derecha.setBounds(10, 80, 120, 30);
        this.derecha.setBackground(Color.BLACK);
        this.derecha.setForeground(Color.WHITE);
        this.add(derecha);
        
        this.arriba.setBounds(10, 140, 120, 30);
        this.arriba.setBackground(Color.BLACK);
        this.arriba.setForeground(Color.WHITE);
        this.add(arriba);
        
        this.abajo.setBounds(10, 200, 120, 30);
        this.abajo.setBackground(Color.BLACK);
        this.abajo.setForeground(Color.WHITE);
        this.add(abajo);*/
    }
    
    
    
    public JLabel getInfoNumStars() {
		return infoNumStars;
	}
	public void setInfoNumStars(String s) {
		this.infoNumStars.setText(s);
	}
	/*public JButton getIzquierda() {
		return izquierda;
	}
	public JButton getDerecha() {
		return derecha;
	}
	public JButton getArriba() {
		return arriba;
	}
	public JButton getAbajo() {
		return abajo;
	}*/

	//Recibe el controlador y se le entrega al boton
    public void setContoller(Controler cont){
        this.c=cont;
        //this.getIzquierda().addActionListener(this.c);
        //this.getDerecha().addActionListener(this.c);
        //this.getArriba().addActionListener(this.c);
        //this.getAbajo().addActionListener(this.c);
    }
    
    
    
    // Permitir al modelo acceder al panel
    public Panel getPanel(){
        return panel;
    }

    
    public void key() {
    	KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				c.keyEvent(KeyEvent.getKeyText(e.getKeyCode()));
				//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(KeyEvent.VK_ESCAPE==e.getKeyCode()){
				    int respuesta = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir?", "Confirmacion",JOptionPane.YES_NO_OPTION);
				    if (respuesta == JOptionPane.YES_NO_OPTION){
				    	System.exit(0);
				    }
			    }
			}
		};
		addKeyListener(listener);
		setFocusable(true);
    }
}
