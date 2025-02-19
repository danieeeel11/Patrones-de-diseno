package Cocina;

import Productos.Component;
import Productos.Producto;

/*
 * Clase para servir fruta a platos de desayuno y almuerzo
 */

public class DecConcreteE extends Decorador{
	private Component comida5;
	
	public DecConcreteE(Componente componente){
		super(componente);
	}
	
	/**
     * Menus desayunos
     */
	public void menuDesayuno1(){
		super.menuDesayuno1();
		//String fruta = frutas();
		String fruta = Restaurante.opF;
		this.comida5 = Producto.getFrutas().productos.stream().filter(p->p.name.equals(fruta)).findAny().get();
		precioPlato(comida5);
		System.out.println("  " + comida5.name + " seleccionado");
	}
	public void menuDesayuno2(){
		super.menuDesayuno2();
		//String fruta = frutas();
		String fruta = Restaurante.opF;
		this.comida5 = Producto.getFrutas().productos.stream().filter(p->p.name.equals(fruta)).findAny().get();
		precioPlato(comida5);
		System.out.println("  " + comida5.name + " seleccionado");
	}
	public void menuDesayuno3(){
		super.menuDesayuno3();
		//String fruta = frutas();
		String fruta = Restaurante.opF;
		this.comida5 = Producto.getFrutas().productos.stream().filter(p->p.name.equals(fruta)).findAny().get();
		precioPlato(comida5);
		System.out.println("  " + comida5.name + " seleccionado");
	}
	
	/**
     * Menus almuerzos
     */
    public void menuAlmuerzo1(){
    	super.menuAlmuerzo1();
    	//String fruta = frutas();
    	String fruta = Restaurante.opF;
		this.comida5 = Producto.getFrutas().productos.stream().filter(p->p.name.equals(fruta)).findAny().get();
        precioPlato(comida5);
        System.out.println("  " + comida5.name + " seleccionado");
    }
    public void menuAlmuerzo2(){
    	super.menuAlmuerzo2();
    	//String fruta = frutas();
    	String fruta = Restaurante.opF;
		this.comida5 = Producto.getFrutas().productos.stream().filter(p->p.name.equals(fruta)).findAny().get();
        precioPlato(comida5);
        System.out.println("  " + comida5.name + " seleccionado");
    }
    public void menuAlmuerzo3(){
    	super.menuAlmuerzo3();
    	//String fruta = frutas();
    	String fruta = Restaurante.opF;
		this.comida5 = Producto.getFrutas().productos.stream().filter(p->p.name.equals(fruta)).findAny().get();
        precioPlato(comida5);
        System.out.println("  " + comida5.name + " seleccionado");
    }
}
