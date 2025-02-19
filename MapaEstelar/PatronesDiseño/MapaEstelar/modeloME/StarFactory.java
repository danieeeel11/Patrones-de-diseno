package modeloME;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class StarFactory {
	public static Map<String, StarType> mapa = new HashMap<>();
	
	public static StarType getStarType(String name, Image img) {
		StarType type = mapa.get(name);
		if(type == null) {
			type = new StarType(name, img);
			mapa.put(name, type);
		}
		return type;
	}
}
