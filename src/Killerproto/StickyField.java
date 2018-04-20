package Killerproto;

public class StickyField extends Field
{
	
    public void Accept(Crate c, Direction d) {
    	c.ChangeWeight(this);
    	if(getCurrentThing()!=null) {
    		getCurrentThing().PushedBy(c, neighbors.get(d), d);
    	}
    	
    	if(getCurrentThing()==null) {
    		setCurrentThing(c);
    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(c);
    		}
    		if(targetCrate==c) {
        		//A helyen van a lada juhuuu
        	}
    	}
    }


}
