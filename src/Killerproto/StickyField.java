package Killerproto;

public class StickyField extends Field
{
	
    public void Accept(Crate c, Direction d) {
    	c.ChangeWeight(this);
    	if(GetThing()!=null) {
    		GetThing().PushedBy(c, neighbors.get(d), d);
    	}
    	
    	if(GetThing()==null) {
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
