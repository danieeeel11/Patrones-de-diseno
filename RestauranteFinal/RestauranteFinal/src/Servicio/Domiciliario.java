package Servicio;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Domiciliario {
	private String id;
	private String nombre;
	Map<String, String> domiciliarios = Arrays.stream(new String[][]{
        {"1", "Lucas"},
        {"2", "Andrea"},
        {"3", "Juan"},
        {"4", "Camila"}
    }).collect(Collectors.toMap(keyMapper -> keyMapper[0],
                            valueMapper -> valueMapper[1]));
	//= new HashMap<>();
	//=
    
	
	public Domiciliario(String id) {
		super();
		this.id = id;
		this.nombre = domiciliarios.entrySet().stream().filter(entry -> id.equals(entry.getKey())).findFirst().map(Map.Entry::getValue).orElse(null);
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
