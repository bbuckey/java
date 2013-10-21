package org.mercs.merc;

import java.io.Serializable;
import org.merc.weapons.Weapon;


public interface IMerc extends Serializable {

	public int getAtk();
	public int getDef();
	public int getHP();
	public long getID();
	public String getName();
	public boolean isComp();
	public Weapon getWep();
	
}
