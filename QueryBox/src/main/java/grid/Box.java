package grid;

public class Box implements IBox {
	
	Box(double _ux, double _uy , double _lx, double _ly,double _ux2, double _uy2 , double _lx2, double _ly2){
		ux = _ux;
		uy = _uy;
		lx = _lx;
		ly = _ly;
		ux2 = _ux2;
		uy2 = _uy2;
		lx2 = _lx2;
		ly2 = _ly2;
	}
	
	Box(){}
	
	double ux,uy,lx,ly,ux2,uy2,lx2,ly2;
	
	public void setUpperX(double ux){
		this.ux = ux;
	}
	public void setUpperY(double uy){
		this.uy = uy;
	}
	public void setLowerX(double lx){
		this.lx = lx;
	}
	public void setLowerY(double ly){
		this.ly = ly;
	}
	
	public double getUpperX(){
		return ux;
	}
	public double getUpperY(){
		return uy;
	}
	public double getLowerX(){
		return lx;
	}
	public double getLowerY(){
		return ly;
	}
	
	public void setUpperX2(double ux){
		this.ux2 = ux;
	}
	public void setUpperY2(double uy){
		this.uy2 = uy;
	}
	public void setLowerX2(double lx){
		this.lx2 = lx;
	}
	public void setLowerY2(double ly){
		this.ly2 = ly;
	}
	
	public double getUpperX2(){
		return ux2;
	}
	public double getUpperY2(){
		return uy2;
	}
	public double getLowerX2(){
		return lx2;
	}
	public double getLowerY2(){
		return ly2;
	}
	
}
