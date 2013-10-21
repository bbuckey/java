package org.mercs.player;

import org.mercs.merc.IMerc;
import org.mercs.merc.Merc;

public class ComputerPlayer extends MercPlayer{
	
	private int experiance;
	private int gold;

	ComputerPlayer(Merc[] mercs, int goldlevel){
		super(mercs);
		for(int i = 0; i < mercs.length; i++){
			experiance += mercs[i].getExperiance();
			gold +=  Math.abs(mercs[i].getExperiance() % goldlevel);
		}
	}
	
	public int getGold(){
		return gold;
	}
	
	public int getExperiance(){
		return experiance;
	}
	
	protected void removeMercFromSq(IMerc merc){
			for(int i = 0; i < 4; ++i){
				if(sqwad[i] != null && sqwad[i].getID() == merc.getID()){
					sqwad[i] = null;
				}
			}
	}
	
}
