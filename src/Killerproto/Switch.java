package Killerproto;

import java.awt.Color;

/**
 * A kapcsolot reprezentalo osztaly
 */
public class Switch extends Field{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A kapcsolohoz tartozo titkos lyuk
	 */
	private SecretHole secretHole;          

    /**
     * A kapcsolohoz tartozo titkos lyukat allitja be
     * @param sh A kapcsolohoz tartozo titkos lyuk
     */
	public void setSecret(SecretHole sh) {
		secretHole=sh;
		SetCurrent(this);
	}
    public void SetCurrent(Field f) {
       this.setBackground(java.awt.Color.GREEN);
    }
    
    /**
     * A munkas a mezore lep, es azon az adott iranyba mozog
     * @paaram w munkas
     * @param d a mozgas iranya
     */
    public void Accept(Worker w,Direction d) {
		if(currentThing!=null) {
    		currentThing.PushedBy(w, neighbors.get(d), d);
    	}
    	if(currentThing==null) {
    		if(w.getChar()=='1') this.setBackground(Color.RED);
    		else this.setBackground(Color.WHITE);
    		this.setText("W");
    		w.SetCurrent(this);
    		currentThing=w;
    		character='1';

    		Field f= neighbors.get(negDirection(d));
    		if(f!=null) {
    			f.Remove(w);
    		}
    	}
    }

    /**
     * Egy lada lep a kapcsolora, es ez kinyitja a hozza tartozo titkos lyukat.
     * Ezen kivul ugy mukodik mint egy sima mezo
     * @param c A lada ami a mezore probal lepni
     * @param d Az irany amerre lep
     */
    public void Accept(Crate c, Direction d)
    {
        if(getThing()!=null)
        {
            currentThing.PushedBy(c, neighbors.get(d), d);
        }

        if(getThing()==null) {
        	this.setBackground(java.awt.Color.YELLOW);
        	this.setText("C");
        	currentThing=c;
        	character=c.getChar();
            Field f= neighbors.get(negDirection(d));
            if(f!=null) {            
                f.Remove(c);
            }
        }
        if(secretHole!=null) {
        	secretHole.changeToTrue();
        	secretHole.setBackground(java.awt.Color.BLACK);
        }
    }
    
    public void Remove(Thing t) {
    	this.setBackground(Color.GREEN);
    	setCurrentThing(null);
    	this.setText("");
    	secretHole.changeToFalse();
    }


    /**
     * A munkas lekerul a kapcsolrol
     * @param w A munkas
     */
    public void Remove(Worker w) {
    	character='s';
    	this.setBackground(java.awt.Color.GREEN);
    	this.setText("");
    	setCurrentThing(null);
    }

    /**
     * A lada lekerul a kapcsolorol, es visszazarodik a titkos lyuk
     * @param c A lada
     */
    public void Remove(Crate c)
    {
    	this.setBackground(java.awt.Color.GREEN);
    	this.setText("");
        secretHole.changeToFalse();
        secretHole.setBackground(java.awt.Color.cyan);
        setCurrentThing(null);
    }

}
