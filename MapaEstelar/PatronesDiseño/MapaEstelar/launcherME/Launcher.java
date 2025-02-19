package launcherME;

import controladorME.Controler;
import modeloME.MapaEstelar;
import vistaME.Ventana;

public class Launcher {

	public static void main(String[] args) {
		// el new llama un metodo de la clase Ventana
        Ventana v = new Ventana();
        MapaEstelar a = new MapaEstelar(v);
        a.creator();
        //if(v.getPanel().getPaises().isEmpty()){
            //a.generarPaisesYVecinos();
        //}
        Controler c = new Controler(a,v);
	}

}
