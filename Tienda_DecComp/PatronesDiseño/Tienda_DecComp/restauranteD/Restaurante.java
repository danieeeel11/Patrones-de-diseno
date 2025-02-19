package restauranteD;

import java.util.Scanner;

public class Restaurante {
	public void servicios(Scanner sc) {
		boolean salir = false;
		while(!salir){
			System.out.println("\n\nRESTAURANTE");
			System.out.println("  - Desayuno(1)\n  - Almuerzo(2)\n  - Cancelar(3)");
			System.out.print("¿Que servicio desea? ");
			int opc = sc.nextInt();
			switch(opc){
		       	case 1:
		       		servicioDesayuno(sc);
		       		break;
		       	case 2:
		       		servicioAlmuerzo(sc);
		       		break;
		       	case 3:
		       		System.out.println("SERVICIO RESTURANTE CANCELADO");
		       		salir=true;
		       		break;
		       	default:
		       		System.out.println("Digite una opcion valida");
       		}
	   	}
	}
	
	public void servicioDesayuno(Scanner sc) {
    	boolean salir = false;
		while(!salir){
			System.out.println("\n\nDESAYUNO");
			System.out.println("  - Huevos revueltos(1)\n  - Caldo(2)\n  - Cereal(3)\n  - Cancelar(4)");
			System.out.print("¿Que plato desea? ");
			int opc = sc.nextInt();
			Plato plato = new Plato();
			DecConcreteA d1 = new DecConcreteA(plato);
			DecConcreteB d2 = new DecConcreteB(d1);
			DecConcreteC d3 = new DecConcreteC(d2);
			switch(opc){
		       	case 1:
		       		d3.menuDesayuno1();
		       		d3.getPrecio();
		       		break;
		       	case 2:
			        d3.menuDesayuno2();
			        d3.getPrecio();
		       		break;
		       	case 3:
		       		d3.menuDesayuno3();
		       		d3.getPrecio();
		       		break;
		       	case 4:
		       		System.out.println("SERVICIO CANCELADO");
		       		salir=true;
		       		break;
		       	default:
		       		System.out.println("Digite una opcion valida");
       		}
	   	}
	}
	
	public void servicioAlmuerzo(Scanner sc) {
    	boolean salir = false;
		while(!salir){
			System.out.println("\n\nALMUERZO");
			System.out.println("  - Arroz con pollo(1)\n  - Pescado frito(2)\n  - Cerdo con garbanzo(3)\n  - Cancelar(4)");
			System.out.print("¿Que plato desea? ");
			int opc = sc.nextInt();
			Plato plato = new Plato();
			DecConcreteA d1 = new DecConcreteA(plato);
			DecConcreteB d2 = new DecConcreteB(d1);
			DecConcreteC d3 = new DecConcreteC(d2);
			switch(opc){
		       	case 1:
		       		d3.menuAlmuerzo1();
		       		d3.getPrecio();
		       		break;
		       	case 2:
			        d3.menuAlmuerzo2();
			        d3.getPrecio();
		       		break;
		       	case 3:
		       		d3.menuAlmuerzo3();
		       		d3.getPrecio();
		       		break;
		       	case 4:
		       		System.out.println("SERVICIO CANCELADO");
		       		salir=true;
		       		break;
		       	default:
		       		System.out.println("Digite una opcion valida");
       		}
	   	}
	}
}
