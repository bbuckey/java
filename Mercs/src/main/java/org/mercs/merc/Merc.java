package org.mercs.merc;

import org.mercs.merc.IMerc;

import java.util.UUID;
// TO-DO ADD HANDLER FOR ID TO MAKE SURE THE MAX ID IS NEVER HIT IF SO THEN SWITCH TO GUID
public class Merc implements IMerc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2990239236664430771L;

	private String name;
	private int hp;
	private int atk;
	private int def;
	//private Weapon wep;
	private long id;
	private boolean comp;
	private int refresh;
	private UUID guid;
	
	/**
	 * this is the base class for a merc
	 * @param _id the id for the merc
	 * @param _hp total hp of merc
	 * @param _atk total attack of merc
	 * @param _def total def of merc
	 * @param _name name of merc
	 * @param _comp is the merc is a computer merc or a player
	 */
	Merc(long _id, int _hp, int _atk, int _def, String _name, boolean _comp){
		hp = _hp;
	atk = _atk;
	def = _def;
	id = _id;
	name = _name;
	comp = _comp;
	refresh = 0;
	guid = UUID.randomUUID();
	}
	
	public long getMercID(){
		return id;
	}
	
	public void setName(String _name){
		this.name = _name;
	}
	
	public String getName(){
		return this.name;
	}
	
//	public void setWep(String _name){
	//	this.wep = _name;
//	}
	
//	public Weapon getWep(){
	//	return this.wep;
//	}
	
	
	public void setAtk(int _name){
		this.atk = _name;
	}
	
	public int getAtk(){
		return this.atk;
	}
	
	
	public void setHP(int _name){
		this.hp = _name;
	}
	
	public int getHP(){
		return this.hp;
	}
	
	
	public void setDef(int _name){
		this.def = _name;
	}
	
	public int getDef(){
		return this.def;
	}
	
	public boolean isComp(){
		return comp;
	}
	
	public void setRefresh(int _refresh){
		this.refresh = _refresh;
	}
	
	public int getRefresh(){
		return this.refresh;
	}


	public long getID() {
		return id;
	}
	
	
	
}
