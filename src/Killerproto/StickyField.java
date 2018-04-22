package Killerproto;

/**
 * A ragados mezot reprezentalo osztaly
 */
public class StickyField extends Field
{
	/**
	 * Egy lada a mezore kerul, es megno a sulya.
	 * Utana ugy viselkedik mint egy sima mezo.
	 * @param c A lada ami a mezore probal lepni
	 * @param d Az irany amerre lep
	 */
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
			if(this==c.getTargetField()) {
				System.out.println("A lada a helyen van!");
			}
    	}
    }

	/**
	 * Lekerul az adott thing a mezorol
	 * @param t A thing amit leszed a mezorol
	 */
    public void Remove(Thing t) {
        character='+';
        currentThing=null;
    }

}
