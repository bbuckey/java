package org.mercs.player;

import org.mercs.merc.IMerc;
import org.mercs.merc.Merc;
import java.util.List;
import java.util.LinkedList;
import java.util.UUID;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

//TO-DO ADD HANDLER FOR ID TO MAKE SURE THE MAX ID IS NEVER HIT IF SO THEN SWITCH TO GUID
abstract class MercPlayer {

	private int totalHP;
	private int totalATK;
	private int totalDef;
	private int totalRefresh;
	private boolean computer;
	protected IMerc[] sqwad = new Merc[4];
	private UUID playerguid;
	private volatile Date recovery;
	
	protected MercPlayer(){
		sqwad[0] = null;
		sqwad[1] = null;
		sqwad[2] = null;
		sqwad[3] = null;
		playerguid = UUID.randomUUID();
		recovery = GregorianCalendar.getInstance(Locale.getDefault()).getTime();
		computer = false;
	}
	
	protected MercPlayer(Merc merc){
		sqwad[0] = merc;
		sqwad[1] = null;
		sqwad[2] = null;
		sqwad[3] = null;
		playerguid = UUID.randomUUID();
		recovery = GregorianCalendar.getInstance(Locale.getDefault()).getTime();
		computer = false;
	}
	
	protected MercPlayer( Merc[] mercs){
		for(int i = 0; i < mercs.length; i++){
			sqwad[i] = mercs[i];
		}
		computer = true;
	}
	
	protected Date getRecovery(){
		return recovery;
	}
	
	protected void setRecovery(Date _recovery){
		this.recovery = _recovery;
	}
	
	
	protected String getPlayerguid(){
		return playerguid.toString();
	}
	
	protected IMerc[] getsqwad(){
		return sqwad;
	}
	
	protected boolean alreadyInSqwad(IMerc merc){
		
		for(int i = 0; i < 4; ++i){
			if(sqwad[i] != null && sqwad[i].getID() == merc.getID()){
				return true;
			}
		}
		
		return false;
		
	}
	
	public int getTotalHP(){
		this.totalHP = 0;
		for(int i = 0; i < 4 ; ++i){
			if(sqwad[i] != null){
				this.totalHP += sqwad[i].getHP();
			}
		}
		
		return totalHP;
	}
	
	public int getTotalDEF(){
		this.totalDef = 0;
		for(int i = 0; i < 4 ; ++i){
			if(sqwad[i] != null){
				this.totalDef += sqwad[i].getDef();
			}
		}
		
		return totalDef;
	}
	
	public int getTotalATK(){
		this.totalATK = 0;
		for(int i = 0; i < 4  ; ++i){
			if(sqwad[i] != null){
				this.totalATK += sqwad[i].getAtk();
			}
		}
		
		return totalATK;
	}
	
	public int getTotalRefresh(){
		this.totalRefresh = 0;
		for(int i = 0; i < 4  ; ++i){
			if(sqwad[i] != null){
				this.totalRefresh += sqwad[i].getRefresh();
			}
		}
		
		return totalRefresh;
	}
	
	
	protected void setNewStats(){
		this.totalHP = 0;
		this.totalDef = 0;
		this.totalATK = 0;
		this.totalRefresh = 0;
		for(int i = 0; i < 4 ; ++i){
			if(sqwad[i] != null){
				this.totalHP += sqwad[i].getHP();
				this.totalDef += sqwad[i].getDef();
				this.totalATK += sqwad[i].getAtk();
				this.totalRefresh += sqwad[i].getRefresh();
			}
		}
	}
}
