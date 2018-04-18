package Killerproto;

import java.util.Map;


public class Field {

	private Map<Direction,Field> neighbors;
	private Thing currentThing;
	private Crate targetCrate;
	private String character;

	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}

    public void Accept(Thing t,Direction d) {
    	
    }
    
    public void Accept(Worker w,Direction d) {
    	if(currentThing!=null) {//Ha van valami a mez�n azt meg kell pr�b�lni tov�bbl�kni
    		currentThing.PushedBy(w, neighbors.get(d), d);
    	}
    	/*Ha a mez�n nincs semmi akkor a munk�s ott marad
    		pl elvileg ha ell�kt�k ami rajta volt �s az visszat�r akkor itt m�r nem lesz semmi*/
    	if(currentThing==null) {
    		currentThing=w;
    	}
    }
    
    public void Accept(Crate c, Direction d) {
    	//ugyanaz a gondolat mint az Accept(Worker,Direction)
    	if(currentThing!=null) {
    		currentThing.PushedBy(c, neighbors.get(d), d);
    	}
    	
    	if(currentThing==null) {
    		currentThing=c;
    		if(targetCrate==c) {
        		//A helyen van a lada juhuuu
        	}
    	}
    }
    
    public  Field GetNeighbour(Direction d) {
    	return neighbors.get(d);
    }
    public void SetNeighnour(Direction d, Field f) {
    	
    }
    public void Remove(Thing t) {
    	
    }
    public Thing GetThing() {
    	return currentThing;
    }

}
