package org.mercs.player;

import java.util.LinkedList;
import java.util.List;

import org.mercs.merc.IMerc;
import org.mercs.merc.Merc;

public class ComputerPlayer extends MercPlayer{
	
	private int experiance;
	private int gold;
	protected List<IMerc> ComputerMercs = new LinkedList<IMerc>();
	private Merc levelBoss;

	ComputerPlayer(List<Merc> mercs, int goldlevel, Merc boss){
		super();
		for(Merc merc : mercs){
			experiance += merc.getExperiance();
			gold +=  Math.abs(merc.getExperiance() % goldlevel);
		}
		levelBoss = boss;
		experiance += boss.getExperiance();
		gold +=  Math.abs(boss.getExperiance() % goldlevel);
		//sqwad[0] = 
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
