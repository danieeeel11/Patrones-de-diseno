package creatorA;

import java.util.Scanner;

public class Cliente {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Cliente c = new Cliente();
		System.out.print("---- CREADOR DE AUTOS----");
		c.menu();
	}
	public void menu() {
		boolean salir = false;
		
		while(!salir){
			System.out.println("\n\n5 marcas de autos para elegir:");
			buildMarca bMarca = new buildMarca();
			System.out.println("  - " + bMarca.marcas.get(0) + "(1)\n  - " + bMarca.marcas.get(1) + "(2)\n  - " + bMarca.marcas.get(2) + "(3)\n  - " + bMarca.marcas.get(3) 
				+ "(4)\n  - " + bMarca.marcas.get(4) + "(5)\n  - Salir(6)");
			System.out.print("¿Que marca desea elegir? ");
			int opc = sc.nextInt();
		    String marca = "";
			
			Automotriz director = null;
			IBuilderAuto builderAuto = null;
			switch(opc){
		       	case 1:
		       		director = new Automotriz();
		       		builderAuto = new BuilderChevrolet();
		       		director.setBuilderAuto(builderAuto);
		       		marca = "Chevrolet";
		       		break;
		       	case 2:
		       		director = new Automotriz();
		       		builderAuto = new BuilderRenault();
		       		director.setBuilderAuto(builderAuto);
		       		marca = "Renault";
		       		break;
		       	case 3:
		       		director = new Automotriz();
		       		builderAuto = new BuilderHyundai();
		       		director.setBuilderAuto(builderAuto);
		       		marca = "Hyundai";
		       		break;
		       	case 4:
		       		director = new Automotriz();
		       		builderAuto = new BuilderMazda();
		       		director.setBuilderAuto(builderAuto);
		       		marca = "Mazda";
		       		break;
		       	case 5:
		       		director = new Automotriz();
		       		builderAuto = new BuilderFord();
		       		director.setBuilderAuto(builderAuto);
		       		marca = "Ford";
		       		break;
		       	case 6:
		       		System.out.println("HAS SALIDO DEL CREADOR DE AUTOS");
		       		salir=true;
		       		break;
		       	default:
		       		System.out.println("Digite una opcion valida");
       		}
			if(opc<6) {
				director.builderAuto(marca);
				Auto auto = director.getAuto();
				
				System.out.println(auto.getMarca());
				System.out.println(auto.getModelo());
				System.out.println(auto.getMotor());
				System.out.println(auto.getTransmision());
				System.out.println(auto.getRines());
				
				System.out.println("\n-------------------------------");
			}
			
	   	}
	}
}
