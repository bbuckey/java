package tabstract;

import java.util.List;
import java.util.ArrayList;

public class ActionEnumType{
	
	private List<ActionEnumType.ActionEnum> enumList = new ArrayList<ActionEnumType.ActionEnum>();
	
	public ActionEnumType(){
		enumList.add(new ActionEnumType.ActionEnum("defaultAction",0));
	}
	
	public ActionEnumType(String _name, int weight){
		enumList.add(new ActionEnumType.ActionEnum("defaultAction",0));
		ActionEnumType.ActionEnum addThisAction = new ActionEnumType.ActionEnum(_name,weight);
		synchronized(enumList){
			enumList.add(addThisAction);
		}
	}
	
	public void addActionEnum(String _name, int weight){
		ActionEnumType.ActionEnum addThisAction = new ActionEnumType.ActionEnum(_name,weight);
		synchronized(enumList){
			enumList.add(addThisAction);
		}
	}
	
	public ActionEnum getEnumActionType(String _name){
		synchronized(enumList){
		if(!enumList.isEmpty()){
			for(ActionEnum e : enumList){
				if(_name.equalsIgnoreCase(e.getName())){
					return e;
				}
			}
		}
		}
		return new ActionEnumType.ActionEnum("defaultAction",0);
	}
	
	public ActionEnum getEnumActionType(int weight){
		synchronized(enumList){
		if(!enumList.isEmpty()){
			for(ActionEnum e : enumList){
				if(e.getWeight() == weight){
					return e;
				}
			}
		}
		}
		return new ActionEnumType.ActionEnum("defaultAction",0);
	}
	
	protected class ActionEnum{
		
		private String value;
		private int weight;
		
		private ActionEnum(String _value, int _weight)
		{
			value = _value;
			weight = _weight;
		}
		
		public String getName(){
			return value;
		}
		
		public int getWeight(){
			return weight;
		}
		
	}
	
}

/*public enum ActionEvents {

defaultAction("defaultAction",0),
averageFileSize("averageFileSize",1);


private String theEvent;
private int weight;

ActionEvents(String _events,int _weight){
	theEvent = _events;
	weight = _weight;
}

public int getWeight(){
	return weight;
}

public void setWeight(int _weight){
	this.weight = _weight;
}

public Enum addNewEnum(String _enum, )

}
*/