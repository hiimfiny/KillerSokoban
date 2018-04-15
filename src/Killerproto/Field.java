package Killerproto;

import java.util.Map;


public class Field {

	private Map<Direction,Field> neighbors;
	private Thing currentThing;
	private Crate targetCrate;

    public void Accept(Thing t,Direction d) {
    	
    }
    public  Field GetNeighbour(Direction d) {
    	return null;
    }
    public void SetNeighnour(Direction d, Field f) {
    	
    }
    public void Remove(Thing t) {
    	
    }
    public Thing GetThing() {
    	return null;
    }

}
