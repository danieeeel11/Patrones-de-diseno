package restauranteD;

import java.util.ArrayList;

import tiendaD.Component;
import tiendaD.Composite;

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
        System.out.println("ALmuerzo: arroz con pollo");
    }
	public void menuAlmuerzo2(){
        System.out.println("ALmuerzo: pescado frito");
    }
	public void menuAlmuerzo3(){
        System.out.println("ALmuerzo: cerdo con garbanzo");
    }
}
