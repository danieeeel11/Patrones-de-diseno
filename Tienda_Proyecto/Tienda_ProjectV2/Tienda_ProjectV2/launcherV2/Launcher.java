
package launcherV2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import restauranteV2.Restaurante;
import tiendaV2.Component;
import tiendaV2.Tienda;

/**
 *
 * @author golden
 */
public class Launcher {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Tienda tienda = new Tienda();
        tienda.productos();
        tienda.productRestaurante();
        menu(tienda);
    }
    
    public static void menu(Tienda tienda) {
	    boolean salir = false;
        while(!salir){
            System.out.println("\n\nTIENDA EL BUENDIA (Proyecto final v2):");
            System.out.println("¿Que servicio desea? ");
            System.out.println("  - Tienda(1)\n  - Restaurante(2)\n  - Salir(3)");
            int opc = sc.nextInt();
            switch(opc){
                case 1:
                	tienda.imprMenu(1);
                    System.out.println("Ingrese la clave del producto que desea: ");
                    boolean finPedido = false;
                    ArrayList<String> listaPedidos = new ArrayList<>();
                    while(finPedido!=true) {
                        String pedido = sc.next();
                        boolean productFind = false;
                        for (Map.Entry<String, Component> entry : Tienda.referencias.entrySet()) {
                        	if(entry.getKey().equals(pedido)) {
                        		productFind = true;
                        	}
                        }
                        if(productFind == false) {
                        	System.out.println(" Ingrese un producto disponible");
                        }else {
                        	System.out.print(" ¿Algo mas? (Y o N): " );
                        	listaPedidos.add(pedido);
                        	String seguir = sc.next();
	                        if(seguir.equals("N") || seguir.equals("n")) {
	                            finPedido = true;
	                        }
                        }
                    }
                    tienda.generarPedido(listaPedidos);
                break;
                case 2:
                    Restaurante restaurante = new Restaurante();
                    restaurante.servicios(sc);
                    break;
                case 3:
                    System.out.println("HAS SALIDO DE LA TIENDA");
                    salir=true;
                    break;
                default:
                    System.out.println("Digite una opcion valida");
            }
        }
    }
}