package restauranteV2;

import tiendaV2.Component;

public abstract class Decorador extends Componente{
    private Componente componente;
 
    public Decorador(Componente componente){
        this.componente = componente;
    }

    
	@Override
	public void getPrecio() {
		componente.getPrecio();
	}
	public void precioPlato(Component c) {
		componente.precioPlato(c);
	}
	public void menuDesayuno1(){
        componente.menuDesayuno1();
    }
    public void menuDesayuno2(){
        componente.menuDesayuno2();
    }
    public void menuDesayuno3(){
        componente.menuDesayuno3();
    }
    public void menuAlmuerzo1(){
        componente.menuAlmuerzo1();
    }
    public void menuAlmuerzo2(){
        componente.menuAlmuerzo2();
    }
    public void menuAlmuerzo3(){
        componente.menuAlmuerzo3();
    }
}
