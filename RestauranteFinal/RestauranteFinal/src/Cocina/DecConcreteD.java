package Cocina;

import Productos.Component;
import Productos.Producto;

/*
 * Clase para servir bebidas a platos de desayuno y almuerzo
 */

public class DecConcreteD extends Decorador{
	private Component comida4;
	
	public DecConcreteD(Componente componente){
		super(componente);
	}
	/**
     * Menus desayunos
     */
	public void menuDesayuno1(){
		super.menuDesayuno1();
		//String bebida = bebidasCalientes();
		String bebida = Restaurante.opB;
		this.comida4 = Producto.getBebidasCalientes().productos.stream().filter(p->p.name.equals(bebida)).findAny().get();
		precioPlato(comida4);
		System.out.println("  " + comida4.name + " seleccionado");
	}
	public void menuDesayuno2(){
		super.menuDesayuno2();
		//String bebida = bebidasCalientes();
		String bebida = Restaurante.opB;
		this.comida4 = Producto.getBebidasCalientes().productos.stream().filter(p->p.name.equals(bebida)).findAny().get();
		precioPlato(comida4);
		System.out.println("  " + comida4.name + " seleccionado");
	}
	public void menuDesayuno3(){
		super.menuDesayuno3();
		//String bebida = bebidasCalientes();
		String bebida = Restaurante.opB;
		this.comida4 = Producto.getBebidasCalientes().productos.stream().filter(p->p.name.equals(bebida)).findAny().get();
		precioPlato(comida4);
		System.out.println("  " + comida4.name + " seleccionado");
	}
	
	/**
     * Menus almuerzos
     */
    public void menuAlmuerzo1(){
    	super.menuAlmuerzo1();
    	//String bebida = bebidas();
    	String bebida = Restaurante.opB;
		this.comida4 = Producto.getBebidas().productos.stream().filter(p->p.name.equals(bebida)).findAny().get();
        precioPlato(comida4);
        System.out.println("  " + comida4.name + " seleccionado");
    }
    public void menuAlmuerzo2(){
    	super.menuAlmuerzo2();
    	//String bebida = bebidas();
    	String bebida = Restaurante.opB;
		this.comida4 = Producto.getBebidas().productos.stream().filter(p->p.name.equals(bebida)).findAny().get();
        precioPlato(comida4);
        System.out.println("  " + comida4.name + " seleccionado");
    }
    public void menuAlmuerzo3(){
    	super.menuAlmuerzo3();
    	//String bebida = bebidas();
    	String bebida = Restaurante.opB;
		this.comida4 = Producto.getBebidas().productos.stream().filter(p->p.name.equals(bebida)).findAny().get();
        precioPlato(comida4);
        System.out.println("  " + comida4.name + " seleccionado");
    }
}
