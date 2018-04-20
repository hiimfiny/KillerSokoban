package Killerproto;

import java.util.*;


@SuppressWarnings("ALL")
public class Field {

	protected Map<Direction,Field> neighbors;
	private Thing currentThing;
	protected Crate targetCrate;
	private char character;

	public char getChar(){return character;}
	public void setChar(char c){this.character=c;}
	
	public Field() {
		neighbors=new HashMap<Direction,Field>();
	}

    public void Accept(Thing t,Direction d) {
    	
    }
    
        
    public void setCurrentThing(Thing t) {
    	currentThing = t;
    }
    
    //Neg�lni kell a Directiont, hogy tudjuk, melyik ir�nyban l�v� Fieldr�l kell t�r�lni az elemet.
    protected Direction negDirection(Direction d) {
    	switch(d) {
    	case Left:
    		return Direction.Right;
    	case Right:
    		return Direction.Left;
    	case Down:
    		return Direction.Up;
    	default:
    		return Direction.Down;
    		
    	}
    }
    
    public void Accept(Worker w,Direction d) {
    	if(currentThing!=null) {//Ha van valami a mez�n azt meg kell pr�b�lni tov�bbl�kni
    		currentThing.PushedBy(w, neighbors.get(d), d);
    	}
    	/*Ha a mez�n nincs semmi akkor a munk�s ott marad
    		pl elvileg ha ell�kt�k ami rajta volt �s az visszat�r akkor itt m�r nem lesz semmi*/
    	if(currentThing==null) {
    		currentThing=w;
    		//A munk�st t�r�lj�k az el�z� mez�j�r�l, ami az elenkez� ir�nyban van
    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(w);
    		}
    	}
    }
    
    public void Accept(Crate c, Direction d) {
    	//ugyanaz a gondolat mint az Accept(Worker,Direction)
    	if(currentThing!=null) {
    		currentThing.PushedBy(c, neighbors.get(d), d);
    	}
    	
    	if(currentThing==null) {
    		currentThing=c;
    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(c);
    		}
    		if(targetCrate==c) {
        		//A helyen van a lada juhuuu
        	}
    	}
    }
    
<<<<<<< HEAD
    
    public  Field getNeighbour(Direction d) {
    	return neighbors.get(d);
    }
    public void setNeighbour(Direction d, Field f) {
=======
    public  Field getNeighbour(Direction d) {
    	return neighbors.get(d);
    }
    public void setNeighnour(Direction d, Field f) {
>>>>>>> 39c7454615a44273fc8dca4bb6e61d264ba26b28
    	neighbors.put(d, f);
    }
    public void Remove(Thing t) {
    	character='.';
    	currentThing=null;
    }
    public Thing getThing() {
    	return currentThing;
    }

}
