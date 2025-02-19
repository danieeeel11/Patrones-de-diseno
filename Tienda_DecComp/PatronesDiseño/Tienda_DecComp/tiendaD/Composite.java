
package tiendaD;

import java.util.ArrayList;

/**
 *
 * @author golden
 */
public class Composite extends Component {
 
    public Composite(int price, String name){
        super(price,name);
    }
    
    public Composite(){
        super(0,"");
    }
    public ArrayList<Component> productos = new ArrayList<>();
    
    public int execute(){
        price =0;
        for (int i = 0; i < productos.size(); i++) {
            price = price + productos.get(i).execute();
            
        }
        return price;
    }
}