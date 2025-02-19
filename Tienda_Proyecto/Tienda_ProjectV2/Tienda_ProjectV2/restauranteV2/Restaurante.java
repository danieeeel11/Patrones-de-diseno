package restauranteV2;

import java.util.Scanner;

public class Restaurante {
	public void servicios(Scanner sc) {
        boolean salir = false;
        while(!salir){
            System.out.println("\n\nRESTAURANTE");
            System.out.println("  - Desayuno(1)\n  - Almuerzo(2)\n  - Cancelar(3)");
            System.out.println("¿Que servicio desea? ");
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
                System.out.println("¿Que plato desea? ");
                int opc = sc.nextInt();
                Plato plato = new Plato();
                DecConcreteA d1 = new DecConcreteA(plato);
                DecConcreteB d2 = new DecConcreteB(d1);
                DecConcreteC d3 = new DecConcreteC(d2);
                
                //DecConcreteD d4 = new DecConcreteD(d3);
                //DecConcreteE d5 = new DecConcreteE(d4);
                String opB = "";
                String opF = "";
                switch(opc){
	                case 1:
	                	opB = opcional(sc,"bebida");
	                	opF = opcional(sc,"fruta");
	                	genOpcional(opB, opF, d3, "desayuno", 1);
	                    break;
	                case 2:
	                	opB = opcional(sc,"bebida");
	                	opF = opcional(sc,"fruta");
	                	genOpcional(opB, opF, d3, "desayuno", 2);
	                    break;
	                case 3:
	                	opB = opcional(sc,"bebida");
	                	opF = opcional(sc,"fruta");
	                	genOpcional(opB, opF, d3, "desayuno", 3);
	                    break;
	                case 4:
	                    System.out.println("SERVICIO CANCELADO");
	                    salir=true;
	                    break;
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
                //DecConcreteD d4 = new DecConcreteD(d3);
                //DecConcreteE d5 = new DecConcreteE(d4);
                String opB = "";
                String opF = "";
                switch(opc){
                case 1:
                	opB = opcional(sc,"bebida");
                	opF = opcional(sc,"fruta");
                	genOpcional(opB, opF, d3, "almuerzo", 1);
                    break;
                case 2:
                	opB = opcional(sc,"bebida");
                	opF = opcional(sc,"fruta");
                	genOpcional(opB, opF, d3, "almuerzo", 2);
                    break;
                case 3:
                	opB = opcional(sc,"bebida");
                	opF = opcional(sc,"fruta");
                	genOpcional(opB, opF, d3, "almuerzo", 3);
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
	
	public String opcional(Scanner sc, String op) {
		System.out.print("¿Desea alguna " + op + "? Si(Y) No(N): ");
		String opcion = sc.next();
		boolean valido = false;
		while(valido != true) {
			if(opcion.equals("Y") || opcion.equals("y")) {
				opcion = "Y";
				valido = true;
			}else if(opcion.equals("N") || opcion.equals("n")){
				valido = true;
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
		return opcion;
	}
	public void genOpcional(String opB, String opF, DecConcreteC d3, String comida ,int caso) {
		if(opB.equals("Y") || opB.equals("y")) {
			DecConcreteD d4 = new DecConcreteD(d3);
			if(opF.equals("Y")) {
				DecConcreteE d5 = new DecConcreteE(d4);
				if(comida.equals("desayuno")) {
					if(caso == 1) {
						d5.menuDesayuno1();
					}else if(caso == 2) {
						d5.menuDesayuno2();
					}else {
						d5.menuDesayuno3();
					}
				}else {
					if(caso == 1) {
						d5.menuAlmuerzo1();
					}else if(caso == 2) {
						d5.menuAlmuerzo2();
					}else {
						d5.menuAlmuerzo3();
					}
				}
				d5.getPrecio();
			}else {
				if(comida.equals("desayuno")) {
					if(caso == 1) {
						d4.menuDesayuno1();
					}else if(caso == 2) {
						d4.menuDesayuno2();
					}else {
						d4.menuDesayuno3();
					}
				}else {
					if(caso == 1) {
						d4.menuAlmuerzo1();
					}else if(caso == 2) {
						d4.menuAlmuerzo2();
					}else {
						d4.menuAlmuerzo3();
					}
				}
				d4.getPrecio();
			}
		}else {
			if(opF.equals("Y")) {
				DecConcreteE d5 = new DecConcreteE(d3);
				if(comida.equals("desayuno")) {
					if(caso == 1) {
						d5.menuDesayuno1();
					}else if(caso == 2) {
						d5.menuDesayuno2();
					}else {
						d5.menuDesayuno3();
					}
				}else {
					if(caso == 1) {
						d5.menuAlmuerzo1();
					}else if(caso == 2) {
						d5.menuAlmuerzo2();
					}else {
						d5.menuAlmuerzo3();
					}
				}
				d5.getPrecio();
			}else {
				if(comida.equals("desayuno")) {
					if(caso == 1) {
						d3.menuDesayuno1();
					}else if(caso == 2) {
						d3.menuDesayuno2();
					}else {
						d3.menuDesayuno3();
					}
				}else {
					if(caso == 1) {
						d3.menuAlmuerzo1();
					}else if(caso == 2) {
						d3.menuAlmuerzo2();
					}else {
						d3.menuAlmuerzo3();
					}
				}
				d3.getPrecio();
			}
		}
	}
}
