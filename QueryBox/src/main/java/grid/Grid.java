package grid;

import java.util.List;
import java.util.ArrayList;
import grid.Box;
import grid.Node;
import java.io.BufferedReader;
import java.io.FileWriter;


public class Grid implements IGrid {

	private List<Node> nodeList;
	private Box boundingBox;
	
	public Grid(){
		nodeList = new ArrayList<Node>();
		boundingBox = new Box();
	}
	
	public Grid(double _ux, double _uy, double _lx, double _ly,double _ux2, double _uy2, double _lx2, double _ly2){
		nodeList = new ArrayList<Node>();
		boundingBox = new Box(_ux,_uy,_lx,_ly,_ux2,_uy2,_lx2,_ly2);
	}
	
	public void findList(BufferedReader mapValues) throws Exception{
		String line;
		String[] xyv;
		Node temp = new Node();
		while(true)
		{
			line = mapValues.readLine();
			line = line != null ? line.trim() : "";
			if(line != null && line != ""){
				xyv = line.split(",");
			} else {
				break;
			} 
			if(xyv.length == 3){
				temp.setx(Double.parseDouble(xyv[0].trim()));
				temp.sety(Double.parseDouble(xyv[1].trim()));
				temp.setvalue(Double.parseDouble(xyv[2].trim()));
				if(boundingBox.getLowerX() <= temp.getx() && boundingBox.getUpperX() <= temp.getx() 
						&&  boundingBox.getLowerY() <= temp.gety() && boundingBox.getUpperY() >= temp.gety() && 
						boundingBox.getLowerX2() >= temp.getx() && boundingBox.getUpperX2() >= temp.getx() 
						&&  boundingBox.getLowerY2() <= temp.gety() && boundingBox.getUpperY2() >= temp.gety() ){
					addNodeToList(new Node(temp.getx(), temp.gety(),temp.getvalue()));
				}
			}
			
		}
		
	}
	
	public void setBoundingBox(Box box){
		this.boundingBox = box;
	}
	
	public void setBoundingBox(double _ux, double _uy, double _lx, double _ly,double _ux2, double _uy2, double _lx2, double _ly2){
		this.boundingBox =  new Box(_ux,_uy,_lx,_ly,_ux2,_uy2,_lx2,_ly2);
	}
	
	public void addNodeToList(Node node){
		if(this.nodeList == null){
			this.nodeList = new ArrayList<Node>();
		}
		this.nodeList.add(node);
	}
	
	public List<Node> getNodeList() {
		return nodeList;
	}
	
	public void writeOutList(FileWriter fw) throws Exception{
		
		if(fw != null){
			String line = "";
			for(Node item : nodeList){
				line = "";
				line = item.getx() +", "+ item.gety()+ ","+ item.getvalue() + " " + System.lineSeparator();
				fw.write(line);
			}
		fw.flush();
		}
		
	}
	
	
}
