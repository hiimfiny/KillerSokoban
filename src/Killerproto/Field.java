package Killerproto;

import java.util.Map;


@SuppressWarnings("ALL")
public class Field {

	protected Map<Direction,Field> neighbors;
	private Thing currentThing;
	protected Crate targetCrate;
	protected String character;

	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}

    public void Accept(Thing t,Direction d) {
    	
    }
    
        
    public void setCurrentThing(Crate c) {
    	currentThing = c;
    }
    
    //Negalni kell a Directiont, hogy tudjuk, melyik iranyban levo Fieldre kell tolni az elemet.
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
    	if(currentThing!=null) {//Ha van valami a mezon azt meg kell probalni tovabb lokni
    		currentThing.PushedBy(w, neighbors.get(d), d);
    	}
    	/*Ha a mezon nincs semmi akkor a munkas ott marad
    		pl elvileg ha elloktuk ami rajta volt es az visszater akkor itt mar nem lesz semmi*/
    	if(currentThing==null) {
    		currentThing=w;
    		character="*";
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
    		character="c";
    		
    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(c);
    		}
    		if(targetCrate==c) {
        		//A helyen van a lada juhuuu
        	}
    	}
    }
    
    public  Field GetNeighbour(Direction d) {
    	return neighbors.get(d);
    }
    public void SetNeighnour(Direction d, Field f) {
    	neighbors.put(d, f);
    }
    public void Remove(Thing t) {
    	currentThing=null;
    	character=".";
    }
    public Thing GetThing() {
    	return currentThing;
    }

}
