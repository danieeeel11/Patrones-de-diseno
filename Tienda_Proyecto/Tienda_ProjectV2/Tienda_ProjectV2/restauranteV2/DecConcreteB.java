package restauranteV2;

import tiendaV2.Component;
import tiendaV2.Tienda;

public class DecConcreteB extends Decorador{
	private Component comida2;
	
	public DecConcreteB(Componente componente){
		super(componente);
	}
	
	/**
     * Menus desayunos
     */
	public void menuDesayuno1(){
		super.menuDesayuno1();
		this.comida2 = Tienda.getCarbohidratos().productos.stream().filter(p->p.name.equals("pan")).findAny().get();
		precioPlato(comida2);
		System.out.println("  " + comida2.name + " a�adido al plato");
	}
	public void menuDesayuno2(){
		super.menuDesayuno2();
		this.comida2 = Tienda.getCarbohidratos().productos.stream().filter(p->p.name.equals("papa")).findAny().get();
		precioPlato(comida2);
		System.out.println("  " + comida2.name + " pelada, cocinada y a�adida al plato");
	}
	public void menuDesayuno3(){
		super.menuDesayuno3();
		this.comida2 = Tienda.getDesayuno().productos.stream().filter(p->p.name.equals("granola")).findAny().get();
		precioPlato(comida2);
		System.out.println("  " + comida2.name + " a�adida al plato");
	}
	
	/**
     * Menus almuerzos
     */
    public void menuAlmuerzo1(){
        super.menuAlmuerzo1();
        this.comida2 = Tienda.getProteina().productos.stream().filter(p->p.name.equals("pollo")).findAny().get();
        precioPlato(comida2);
        System.out.println("  " + comida2.name + " cocinado, picado en pedazos y a�adido al plato");
    }
    public void menuAlmuerzo2(){
        super.menuAlmuerzo2();
        this.comida2 = Tienda.getCarbohidratos().productos.stream().filter(p->p.name.equals("papa")).findAny().get();
        precioPlato(comida2);
        System.out.println("  " + comida2.name + " pelada, picada, frita y a�adida al plato");
    }
    public void menuAlmuerzo3(){
        super.menuAlmuerzo3();
        this.comida2 = Tienda.getGranos().productos.stream().filter(p->p.name.equals("garbanzo")).findAny().get();
        precioPlato(comida2);
        System.out.println("  " + comida2.name + " cocinados y a�adidos al plato");
    }
  
	@Override
	public void getPrecio() {
		super.getPrecio();
	}

}