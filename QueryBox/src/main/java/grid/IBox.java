package grid;

public interface IBox {
	void setUpperX(double ux);
	void setUpperY(double uy);
	void setLowerX(double lx);
	void setLowerY(double ly);
	
	double getUpperX();
	double getUpperY();
	double getLowerX();
	double getLowerY();
}
