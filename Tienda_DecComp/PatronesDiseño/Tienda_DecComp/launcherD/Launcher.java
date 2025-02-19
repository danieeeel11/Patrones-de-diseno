/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package launcherD;

import java.util.ArrayList;
import java.util.Scanner;

import restauranteD.Restaurante;
import tiendaD.Tienda;

/**
 *
 * @author golden
 */
public class Launcher {
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Tienda t = new Tienda();
        //Generar menus
        t.productos();
        t.productRestaurante();
        //System.out.println(t.getDesayuno().productos.get(0).name);
        //
        //System.out.println(t.getFrutas().productos.get(0).name);
        menu(t);
    }
    
    public static void menu(Tienda t) {
    	boolean salir = false;
		while(!salir){
			System.out.println("\n\nTIENDA EL BUENDIA:");
			System.out.println("  - Tienda(1)\n  - Restaurante(2)\n  - Salir(3)");
			System.out.print("¿Que servicio desea? ");
			int opc = sc.nextInt();
			switch(opc){
		       	case 1:
		       		t.imprMenu(1);
		       		System.out.println("¿Que productos quiere?");
		            boolean finPedido = false;
		            ArrayList<String> listaPedidos = new ArrayList<>();
		            while(finPedido!=true) {
		            	String pedido = sc.next();
		            	listaPedidos.add(pedido);
		            	System.out.print(" ¿Algo mas? (Y o N): " );
		            	String seguir = sc.next();
		            	if(seguir.equals("N") || seguir.equals("n")) {
		            		finPedido = true;
		            	}
		            }
		            t.generarPedido(listaPedidos);
		       		break;
		       	case 2:
		       		Restaurante r = new Restaurante();
		       		r.servicios(sc);
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
