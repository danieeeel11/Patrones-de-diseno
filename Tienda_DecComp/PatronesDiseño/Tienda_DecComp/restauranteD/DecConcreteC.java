package restauranteD;

import tiendaD.Component;
import tiendaD.Tienda;

public class DecConcreteC extends Decorador{
	private Component comida3;
	
	public DecConcreteC(Componente componente){
		super(componente);
	}
	
	/**
     * Menus desayunos
     */
	public void menuDesayuno1(){
		super.menuDesayuno1();
		this.comida3 = Tienda.getCarbohidratos().productos.stream().filter(p->p.name.equals("galletas")).findAny().get();
		precioPlato(comida3);
		System.out.println("  " + comida3.name + " añadido al plato");
	}
	public void menuDesayuno2(){
		super.menuDesayuno2();
		this.comida3 = Tienda.getVerduras().productos.stream().filter(p->p.name.equals("cilantro")).findAny().get();
		precioPlato(comida3);
		System.out.println("  " + comida3.name + " añadido al plato");
	}
	public void menuDesayuno3(){
		super.menuDesayuno3();
		this.comida3 = Tienda.getFrutas().productos.stream().filter(p->p.name.equals("banano")).findAny().get();
		precioPlato(comida3);
		System.out.println("  " + comida3.name + " añadido al plato");
	}
	
	/**
     * Menus almuerzos
     */
    public void menuAlmuerzo1(){
        super.menuAlmuerzo1();
        this.comida3 = Tienda.getGranos().productos.stream().filter(p->p.name.equals("lentejas")).findAny().get();
        precioPlato(comida3);
        System.out.println("  " + comida3.name + " cocinadas y añadidas al plato");
    }
    public void menuAlmuerzo2(){
        super.menuAlmuerzo2();
        this.comida3 = Tienda.getGranos().productos.stream().filter(p->p.name.equals("frijoles")).findAny().get();
        precioPlato(comida3);
        System.out.println("  " + comida3.name + " cocinados y añadidos al plato");
    }
    public void menuAlmuerzo3(){
        super.menuAlmuerzo3();
        this.comida3 = Tienda.getVerduras().productos.stream().filter(p->p.name.equals("tomate")).findAny().get();
        precioPlato(comida3);
        System.out.println("  " + comida3.name + " cortado en rodajas y añadidos al plato");
    }
	@Override
	public void getPrecio() {
		super.getPrecio();
	}
}
