package org.mercs.player;

import java.util.LinkedList;
import java.util.List;

import org.mercs.merc.Merc;
import org.mercs.merc.IMerc;

public class PersonPlayer extends MercPlayer{
	private int gold;
	private int cash;
	private int maxcash;
	private String name;
	private long playerid;
	private int squCount = 0;
	protected List<IMerc> playerMercs = new LinkedList<IMerc>();
	
	PersonPlayer(Merc merc, String _name, long id){
		super(merc);
		name = _name;
		playerid = id;
		playerMercs.add(merc);
	}
	
	public int getGold(){
		return gold;
	}
	
	public int getCash(){
		return cash;
	}
	
	public long getPlayerID(){
		return playerid;
	}
	
	protected void addMercToSq(IMerc merc) throws Exception{
		if(!this.playerMercs.isEmpty() && this.playerMercs.contains(merc) && !alreadyInSqwad(merc)){
			this.sqwad[squCount % 4] = merc;
			updatesqucount();
		} else {
			throw new ArrayIndexOutOfBoundsException("Merc Does Not Exist in List");
		}
		setNewStats();
	}
	
	protected void removeMercFromSq(IMerc merc){
		if(!this.playerMercs.isEmpty() && this.playerMercs.contains(merc) && alreadyInSqwad(merc)){
			for(int i = 0; i < 4 && !this.playerMercs.isEmpty() ; ++i){
				if(sqwad[i] != null && sqwad[i].getID() == merc.getID()){
					sqwad[i] = null;
				}
			}
		}
		setNewStats();
	}
	
	protected void addMerc(IMerc merc){
		synchronized(playerMercs){
			this.playerMercs.add(merc);
		}
	}
	
	protected List getMercList(){
		return this.playerMercs;
	}
	
	protected IMerc[] getMercArray(){
		return this.playerMercs.toArray(new IMerc[playerMercs.size()]);
	}
	
	protected void removeMerc(IMerc merc){
		synchronized(playerMercs){
			if(!this.playerMercs.isEmpty() && this.playerMercs.contains(merc)){
				IMerc[] lmerc = playerMercs.toArray(new IMerc[playerMercs.size()]);
				for(int i =0 ; i < lmerc.length; ++i){
					if(lmerc[i].getID() == merc.getID()){
						this.playerMercs.remove(i);
						break;
					}
				}
				lmerc = null;
			}
		}
	}
	
	protected void updatesqucount(){
		this.squCount = squCount >= Integer.MAX_VALUE || squCount <= 0 ? 0 : Math.abs(squCount+1);
	}
	
	private void minussqucount(){
		this.squCount = squCount >= Integer.MAX_VALUE || squCount <= 0 ? 0 : Math.abs(squCount-1);
	}
}
