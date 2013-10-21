package org.merc.weapons;

import java.util.UUID;

public class Weapon {
	
	private int plusHP;
	private int plusATK;
	private int plusRefresh;
	private int plusDef;
	private long wepid;
	private UUID guid;
	
	Weapon(int php, int patk, int pr, int pdef, long id){
		plusHP = php;
		plusATK = patk;
		plusRefresh = pr;
		plusDef = pdef;
		guid = UUID.randomUUID();
		wepid = id;
		;}
	
	public void setWepid(long id){
		this.wepid = id;
	}
	
	public void setPlushp(int id){
		this.plusHP = id;
	}
	
	public void setPlusatk(int id){
		this.plusATK = id;
	}
	
	public void setPlusref(int id){
		this.plusRefresh = id;
	}
	
	public void setPlusdef(int id){
		this.plusDef = id;
	}
	
	
	public long getWepid(){
		return this.wepid;
	}
	
	public int getPlushp(){
		return this.plusHP;
	}
	
	public int getPlusatk(){
		return this.plusATK;
	}
	
	public int getPlusref(){
		return this.plusRefresh;
	}
	
	public int getPlusdef(){
		return this.plusDef;
	}
	
	public String getStringGuid(){
		return this.guid.toString();
	}
	
	public UUID getGUID(){
		return this.guid;
	}
	
}
