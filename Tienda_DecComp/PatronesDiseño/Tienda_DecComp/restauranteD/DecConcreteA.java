package restauranteD;

import tiendaD.Component;
import tiendaD.Tienda;

public class DecConcreteA extends Decorador{
	//Tienda t = new Tienda();
    private Component comida1;
 
    public DecConcreteA(Componente componente){
        super(componente);
    }
    /**
     * Menus desayunos
     */
    public void menuDesayuno1(){
        super.menuDesayuno1();
        this.comida1 = Tienda.getDesayuno().productos.stream().filter(p->p.name.equals("huevo")).findAny().get();
        precioPlato(comida1);
        System.out.println("  " + comida1.name + " fue cocinado");
    }
    public void menuDesayuno2(){
        super.menuDesayuno2();
        this.comida1 = Tienda.getBebidas().productos.stream().filter(p->p.name.equals("agua")).findAny().get();
        precioPlato(comida1);
        System.out.println("  " + comida1.name + " fue hervida");
    }
    public void menuDesayuno3(){
        super.menuDesayuno3();
        this.comida1 = Tienda.getBebidas().productos.stream().filter(p->p.name.equals("leche")).findAny().get();
        precioPlato(comida1);
        System.out.println("  " + comida1.name + " añadida al plato");
    }
    
    /**
     * Menus almuerzos
     */
    public void menuAlmuerzo1(){
        super.menuAlmuerzo1();
        this.comida1 = Tienda.getGranos().productos.stream().filter(p->p.name.equals("arroz")).findAny().get();
        precioPlato(comida1);
        System.out.println("  " + comida1.name + " fue preparado");
    }
    public void menuAlmuerzo2(){
        super.menuAlmuerzo2();
        this.comida1 = Tienda.getProteina().productos.stream().filter(p->p.name.equals("pescado")).findAny().get();
        precioPlato(comida1);
        System.out.println("  " + comida1.name + " fue frito");
    }
    public void menuAlmuerzo3(){
        super.menuAlmuerzo3();
        this.comida1 = Tienda.getProteina().productos.stream().filter(p->p.name.equals("cerdo")).findAny().get();
        precioPlato(comida1);
        System.out.println("  " + comida1.name + " fue cocinado");
    }

	@Override
	public void precioPlato(Component c) {
		super.precioPlato(c);
	}

	@Override
	public void getPrecio() {
		super.getPrecio();
	}
}
