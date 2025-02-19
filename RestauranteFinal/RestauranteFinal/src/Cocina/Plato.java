package Cocina;

import java.util.ArrayList;

import Html.BuildHTML;
import Productos.Component;
import Productos.Composite;

public class Plato extends Componente{
	ArrayList<Component> partesPlato = new ArrayList<>();
	
	public void precioPlato(Component c) {
		partesPlato.add(c);
	}
	public void getPrecio() {
		Composite c = new Composite(); 
		for (int i = 0; i < partesPlato.size(); i++) {
			c.productos.add(partesPlato.get(i));
		}
		System.out.println("Precio del plato: $" + c.execute());
		genHtml(c);
	}
	public void genHtml(Composite c) {
		//BuildHTML html = new BuildHTML();
		for (int i = 0; i < partesPlato.size(); i++) {
			BuildHTML.getInstance().CrearHTML(partesPlato.get(i));
		}
		BuildHTML.getInstance().precioTotal = c.execute();
		BuildHTML.getInstance().generarHtml();
	}
    public void menuDesayuno1(){
        System.out.println("Desayuno: huevos revueltos");
    }
    public void menuDesayuno2(){
        System.out.println("Desayuno: caldo");
    }
    public void menuDesayuno3(){
        System.out.println("Desayuno: cereal");
    }
    public void menuAlmuerzo1(){
        System.out.println("Almuerzo: arroz con pollo");
    }
    public void menuAlmuerzo2(){
        System.out.println("Almuerzo: pescado frito");
    }
    public void menuAlmuerzo3(){
        System.out.println("Almuerzo: cerdo con garbanzo");
    }
}
