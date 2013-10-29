package org.mercs.merc;

import java.io.Serializable;
import org.merc.weapons.Weapon;


public interface IMerc extends Serializable {

	public int getAtk();
	public int getDef();
	public int getHP();
	public long getID();
	public int getExperiance();
	public String getName();
	public boolean isComp();
	public Weapon getWep();
	public int getRefresh();
	public int getAtkCounter();
	public void setAtkCounter(int i);
	
}
