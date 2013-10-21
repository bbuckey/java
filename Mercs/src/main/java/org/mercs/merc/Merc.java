package org.mercs.merc;

import org.mercs.merc.IMerc;
import org.merc.weapons.Weapon;

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
	private Weapon wep;
	private long id;
	private boolean comp;
	private int refresh;
	private UUID guid;
	private int experiance;
	
	/**
	 * this is the base class for a merc
	 * @param _id the id for the merc
	 * @param _hp total hp of merc
	 * @param _atk total attack of merc
	 * @param _def total def of merc
	 * @param _name name of merc
	 * @param _comp is the merc is a computer merc or a player
	 */
	Merc(long _id, int _hp, int _atk, int _def, String _name, boolean _comp, int _experiance){
		hp = _hp;
	atk = _atk;
	def = _def;
	id = _id;
	name = _name;
	comp = _comp;
	refresh = 0;
	experiance = _experiance;
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
	
	public void setWep(Weapon _name){
		this.wep = _name;
	}
	
	public Weapon getWep(){
		return this.wep;
	}
	
	
	public void setAtk(int _name){
		this.atk = _name;
	}
	
	public void setHP(int _name){
		this.hp = _name;
	}
	
	public void setDef(int _name){
		this.def = _name;
	}
	
	public boolean isComp(){
		return comp;
	}
	
	public void setRefresh(int _refresh){
		this.refresh = _refresh;
	}

	public long getID() {
		return id;
	}
	
	public int getAtk(){
		if(wep != null){
			return atk + wep.getPlusatk();
		} else {
			return atk;
		}
	}
	
	public int getHP(){
		if(wep != null){
			return hp + wep.getPlushp();
		} else {
			return hp;
		}
	}
	
	public int getRefresh(){
		if(wep != null){
			return refresh + wep.getPlusref();
		} else {
			return refresh;
		}
	}
	
	public int getDef(){
		if(wep != null){
			return def + wep.getPlusdef();
		} else {
			return def;
		}
	}
	
	public int getExperiance(){
		return this.experiance;
	}
	
	public void setExperance(int exp){
		experiance = exp;
	}
}
