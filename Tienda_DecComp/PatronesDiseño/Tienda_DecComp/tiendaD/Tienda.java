package tiendaD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tienda {
	ArrayList<String> pedido = new ArrayList<>();
	Map<String, Component> referencias = new HashMap<String, Component>();
	Map<String, Component> refRestaurante = new HashMap<String, Component>();
	Map<String, String> tipos = new HashMap<String, String>();
	
	static Composite frutas = new Composite();
	static Composite verduras = new Composite();
	static Composite granos = new Composite();
	static Composite snacks = new Composite();
	static Composite bebidas = new Composite();
	static Composite proteina = new Composite();
	static Composite carbohidratos = new Composite();
	static Composite desayuno = new Composite();
	
	
	public void productos() {
		//Composite tienda = new Composite();
        
//        Composite frutas = new Composite();
        Leaf manzana = new Leaf(900,"manzana");
        Leaf pera = new Leaf(800, "pera");
        Leaf mango = new Leaf(1200, "mango");
        Leaf banano = new Leaf(400, "banano");
        Leaf fresa = new Leaf(1500, "fresa");
        
        //Composite verduras = new Composite();
        Leaf tomate = new Leaf(1000, "tomate");
        Leaf lechuga = new Leaf(200, "lechuga");
        Leaf pepino = new Leaf(2000, "pepino");
        Leaf cilantro = new Leaf(3200, "cilantro");
        Leaf cebolla = new Leaf(300, "cebolla");
        
//        Composite granos = new Composite();
        Leaf frijoles = new Leaf(800, "frijoles");
        Leaf lentejas = new Leaf(900, "lentejas");
        Leaf garbanzo = new Leaf(1000, "garbanzo");
        Leaf arroz = new Leaf(1500, "arroz");
        Leaf avena = new Leaf(2500, "avena");
        
//        Composite snacks = new Composite();
        Leaf chocoramo = new Leaf(3000, "chocoramo");
        Leaf doritos = new Leaf(4000, "doritos");
        Leaf gansito = new Leaf(2500, "gansito");
        Leaf chitos = new Leaf(1500, "chitos");
        Leaf snickers = new Leaf(1700, "snickers");
        
//        Composite bebidas = new Composite();
        Leaf jugo = new Leaf(2000, "jugo");
        Leaf sprite = new Leaf(1500, "sprite");
        Leaf limonada = new Leaf(1500, "limonada");
        Leaf agua = new Leaf(900, "agua");
        Leaf leche = new Leaf(1500, "leche");
        
//        Composite proteina = new Composite();
        Leaf res = new Leaf(3000, "res");
        Leaf caballo = new Leaf(4000, "caballo");
        Leaf cerdo = new Leaf(2500, "cerdo");
        Leaf pollo = new Leaf(1500, "pollo");
        Leaf pescado = new Leaf(1700, "pescado");
        
//        Composite carbohidratos = new Composite();
        Leaf papa = new Leaf(3000, "papa");
        Leaf yuca = new Leaf(4000, "yuca");
        Leaf pasta = new Leaf(2500, "pasta");
        Leaf pan = new Leaf(1500, "pan");
        Leaf galletas = new Leaf(1700, "galletas");
        
        
        
        frutas.productos.add(manzana);
        frutas.productos.add(pera);
        frutas.productos.add(mango);
        frutas.productos.add(banano);
        frutas.productos.add(fresa);
        listado(frutas, "frutas","tienda");
        
        verduras.productos.add(tomate);
        verduras.productos.add(lechuga);
        verduras.productos.add(pepino);
        verduras.productos.add(cilantro);
        verduras.productos.add(cebolla);
        listado(verduras, "verduras","tienda");
        
        granos.productos.add(frijoles);
        granos.productos.add(lentejas);
        granos.productos.add(garbanzo);
        granos.productos.add(arroz);
        granos.productos.add(avena);
        listado(granos, "granos","tienda");
        
        snacks.productos.add(chocoramo);
        snacks.productos.add(doritos);
        snacks.productos.add(gansito);
        snacks.productos.add(chitos);
        snacks.productos.add(snickers);
        listado(snacks, "snacks","tienda");
        
        bebidas.productos.add(jugo);
        bebidas.productos.add(sprite);
        bebidas.productos.add(limonada);
        bebidas.productos.add(agua);
        bebidas.productos.add(leche);
        listado(bebidas, "bebidas","tienda");
        
        proteina.productos.add(res);
        proteina.productos.add(caballo);
        proteina.productos.add(cerdo);
        proteina.productos.add(pollo);
        proteina.productos.add(pescado);
        listado(proteina, "proteina","tienda");
        
        carbohidratos.productos.add(papa);
        carbohidratos.productos.add(yuca);
        carbohidratos.productos.add(pasta);
        carbohidratos.productos.add(pan);
        carbohidratos.productos.add(galletas);
        listado(carbohidratos, "carbohidratos","tienda");
        
	}
	
	public void productRestaurante() {
        
//        Composite desayuno = new Composite();
        Leaf huevo = new Leaf(400, "huevo");
        Leaf caldo = new Leaf(8000, "caldo");
        Leaf granola = new Leaf(3000, "granola");
        
        listado(frutas, "frutas","Restaurante");
        
        listado(verduras, "verduras","Restaurante");
        
        listado(granos, "granos","Restaurante");
        
        listado(bebidas, "bebidas","Restaurante");
        
        listado(proteina, "proteina","Restaurante");
        
        listado(carbohidratos, "carbohidratos","Restaurante");
        
        desayuno.productos.add(huevo);
        desayuno.productos.add(caldo);
        desayuno.productos.add(granola);
        listado(desayuno, "desayuno","Restaurante");
	}
	
	public void listado(Composite seccion, String tipo, String servicio) {
		//System.out.println(tipo);
		for (int i = 0; i < seccion.productos.size(); i++) {
			//System.out.println(tienda.productos.get(i).execute()); precio total de cada sector
			if(servicio.equals("Restaurante")) {
				refRestaurante.put(tipo.substring(0,1)  + (i+1), seccion.productos.get(i));
			}else {
				tipos.put(tipo.substring(0,1), tipo);
				//System.out.println("  " + tipo.substring(0,1)  + (i+1) + ". " + seccion.productos.get(i).name);
				referencias.put(tipo.substring(0,1)  + (i+1), seccion.productos.get(i));
			}
			
		}
		//System.out.println();
	}
	
	public void imprMenu(int opcion) {
		int cont=0;
		if(opcion == 1) {
			for (Map.Entry<String, Component> entry : referencias.entrySet()) {
				if(cont == 5) {
					cont = 0;
				}
				if(cont == 0) {
					System.out.println(tipos.get(entry.getKey().substring(0,1)));
				}
				System.out.println("  " + entry.getKey() + "=" + entry.getValue().name + " $" + entry.getValue().price);
				cont++;
			    //System.out.println("" + entry.getKey() + "=" + entry.getValue());
			}
		}else {
			for (Map.Entry<String, Component> entry : refRestaurante.entrySet()) {
				System.out.println("  " + entry.getKey() + "=" + entry.getValue().name + " $" + entry.getValue().price);
			    //System.out.println("" + entry.getKey() + "=" + entry.getValue());
			}
		}
		
	}
	
	public void generarPedido(ArrayList<String> pedidos) {
		System.out.println("\nResumen del pedido");
		Composite pedido = new Composite();
		for (Map.Entry<String, Component> entry : referencias.entrySet()) {
			for (int j = 0; j < pedidos.size(); j++) {
				if (pedidos.get(j).equals(entry.getKey())) {
					System.out.println("  " + entry.getKey() + "=" + entry.getValue().name + " $" + entry.getValue().price);
					pedido.productos.add(entry.getValue());
				}
			}
		    //System.out.println("" + entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("Total compra: $" + pedido.execute());
	}

	public static Composite getFrutas() {
		return frutas;
	}
	public static Composite getVerduras() {
		return verduras;
	}
	public static Composite getGranos() {
		return granos;
	}
	public static Composite getSnacks() {
		return snacks;
	}
	public static Composite getBebidas() {
		return bebidas;
	}
	public static Composite getProteina() {
		return proteina;
	}
	public static Composite getCarbohidratos() {
		return carbohidratos;
	}
	public static  Composite getDesayuno() {
		return desayuno;
	}
	
	
}
