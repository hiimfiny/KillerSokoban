package Killerproto;

public class StickyField extends Field
{
	/*public void weightChange(Crate c) {
		c.ChangeWeight(this);
	}*/
	
    public void Accept(Crate c, Direction d) {
    	c.ChangeWeight(this);
    	if(getThing()!=null) {
    		getThing().PushedBy(c, neighbors.get(d), d);
    	}
    	
    	if(getThing()==null) {
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
    public void Remove(Thing t) {
        character='+';
        currentThing=null;
    }


}
