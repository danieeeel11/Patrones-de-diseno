package Productos;

public class Leaf extends Component{
	private String name;
    public Leaf(int price, String name){
        super(price, name);
    }
    @Override
    public int execute() {
        return price;
    }
	public String getName() {
		return name;
	}
    
}
