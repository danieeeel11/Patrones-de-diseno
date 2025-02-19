
package tiendaD;

public abstract class Component {
	public String name;
    public int price;
    
    public Component(int price, String name){
        this.price=price;
        this.name=name;
    }
    public abstract int execute();
}
