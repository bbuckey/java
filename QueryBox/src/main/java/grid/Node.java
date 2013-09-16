package grid;

public class Node implements INode {

	private double x;
	private double y;
	private double value;

	public Node() {
		
	}
	
	public Node(double _x, double _y, double _value){
		x = _x;
		y = _y;
		value = _value;
			
	}
	
	public double getx() {
		return x;
	}

	public double gety() {
		return y;
	}

	public double getvalue() {
		return value;
	}

	public void setx(double x) {
		this.x = x;
	}

	public void sety(double y) {
		this.y = y;
	}

	public void setvalue(double value) {
		this.value = value;
	}
}
