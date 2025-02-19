/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorME;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import modeloME.MapaEstelar;
import vistaME.Ventana;

public class Controler {
///implements ActionListener{
    private MapaEstelar modelo;
    private Ventana vista;
    public Controler(MapaEstelar modelo, Ventana v){
        this.modelo = modelo;
        this.vista = v;
        this.vista.setContoller(this);
    }
    
    public void keyEvent(String key) {
    	if(key.equals("Up")) {
    		modelo.movUp(key);
    	}else if(key.equals("Down")) {
    		modelo.movDown(key);
    	}else if(key.equals("Left")) {
    		modelo.movLeft(key);
    	}else if(key.equals("Right")) {
    		modelo.movRight(key);
    	}
    }
    
    /*@Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("<-")){
    		modelo.info();
        }
    }*/
}

