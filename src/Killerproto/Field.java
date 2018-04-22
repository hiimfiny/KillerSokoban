package Killerproto;

import java.util.*;
@SuppressWarnings("ALL")
/**
 * A mezot reprezentalo osztaly
 */
public class Field {

	protected Map<Direction,Field> neighbors;			//Az adott mezo szomszedjait tarolja
	protected Thing currentThing;						//Az adott mezon levo
	protected char character;							//A mezot reprezentalo karakter

	/**
	 * A mezo konstruktora
	 */
	public Field() {
		neighbors=new HashMap<Direction,Field>();
	}

	/**
	 * A mezot reprezentalo karakter lekerdezese
	 * @return A mezot reprezentalo karakter
	 */
	public char getChar(){return character;}

	/**
	 * A mezot reprezentalo karaktert allitja be
	 * @param c A mezot reprezentalo karakter
	 */
	public void setChar(char c){this.character=c;}

	/**
	 * A mezon levo thing-et allitja be
	 * @param t A mezon levo thing
	 */
	public void setCurrentThing(Thing t) {
    	currentThing = t;
    	if(t!=null) t.SetCurrent(this);
    }

	/**
	 * A jelenlegi mezo adott iranyaban levo szomszedjat kerdezi le
	 * @param d Az irany ami feloli szomszedot keressuk
	 * @return Az irany feloli szomszedos mezo
	 */
	public Field getNeighbour(Direction d) {
		return neighbors.get(d);
	}

	/**
	 * Beallitja az adott mezot az adott iranyu szomszednak
	 * @param d Az irany ami feloli szomszed lesz a mezo
	 * @param f A mezo amit szomszednak allit be
	 */
	public void setNeighbour(Direction d, Field f) {
		neighbors.put(d, f);
	}

	/**
	 * A mezon levo thing-et kerdezi le
	 * @return A mezon levo aktualis thing
	 */
	public Thing getThing() {
		return currentThing;
	}

	/**
	 * Az iranyokat forditja meg, hogy a sikeres lepes utan a remove el tudja tuntetni a rajta levo thing-et
	 * @param d Az irany amit meg akarunk forditani
	 * @return A megforditott irany
	 */
	public Direction negDirection(Direction d) {
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

	/**
	 * A mezore probal lepni egy munkas.
	 * Ha a mezon volt valamilyen thing, akkor ezt megprobalja tovabblokni.
	 * Ha nem volt akkor siman tovabblep a munkas, es az elozo mezorol removeoljuk
	 * @param w A munkas ami a mezore probal lepni
	 * @param d Az irany amerre lep
	 */
    public void Accept(Worker w,Direction d) {
		if(currentThing!=null) {
    		currentThing.PushedBy(w, neighbors.get(d), d);
    	}
    	if(currentThing==null) {
    		currentThing=w;
    		character='1';

    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(w);
    		}
    	}
    }

	/**
	 * A mezore probal lepni egy lada.
	 * Ha a mezon volt valamilyen thing, akkor ezt megprobalja tovabblokni.
	 * Ha nem volt akkor siman tovabblep a munkas, es az elozo mezorol removeoljuk.
	 * Az eltolas utan ellenorzi, hogy az uj mezo a lada cel mezoje-e.
	 * @param c A lada ami a mezore probal lepni
	 * @param d Az irany amerre lep
	 */
	public void Accept(Crate c, Direction d) {
    	if(currentThing!=null) {
    		currentThing.PushedBy(c, neighbors.get(d), d);
    	}
    	if(currentThing==null) {
    		currentThing=c;
    		character='c';
    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(c);
    		}
    		if(this==c.getTargetField()) {
    			System.out.println("A lada a helyen van!");
        	}
    	}
    }

	/**
	 * Leszedi a mezorol az adott thing-et
	 * @param t A thing amit leszed a mezorol
	 */
    public void Remove(Thing t) {
        character='.';
        currentThing=null;
    }

	public void Accept(Thing t,Direction d) {}


}
