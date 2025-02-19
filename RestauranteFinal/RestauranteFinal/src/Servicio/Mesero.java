package Servicio;

import java.util.Arrays;
//import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Mesero {
	private String id;
	private String nombre;
	Map<String, String> meseros = Arrays.stream(new String[][]{
        {"1", "Juan"},
        {"2", "Carlos"},
        {"3", "Jeronimo"},
        {"4", "Andrea"}
    }).collect(Collectors.toMap(keyMapper -> keyMapper[0],
                            valueMapper -> valueMapper[1]));
	//= new HashMap<>();
	//=
    
	
	public Mesero(String id) {
		super();
		this.id = id;
		this.nombre = meseros.entrySet().stream().filter(entry -> id.equals(entry.getKey())).findFirst().map(Map.Entry::getValue).orElse(null);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}