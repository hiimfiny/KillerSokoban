package Killerproto;

import java.awt.*;

/**
 * A titkos lyukat reprezentalo osztaly
 */
public class SecretHole extends Hole {
    private boolean state;              //A lyuk allapota
    private Switch sw;                  //A lyukhoz tartozo kapcsolo

    /**
     * Beallitja a lyukhoz tartozo kapcsolot
     * @param s A lyukhoz tartozo kapcsolo
     */
    public void setSwitch(Switch s) {
    	sw=s;
    }
    
    public SecretHole() {
    	state=false;
    	this.setBackground(Color.cyan);
    }
    
    public boolean actualHere() {
		if(state) return false;
		if(Game.GetActualWorker()==null) return false;
		if(Game.GetActualWorker()==currentThing) return true;
		else return false;
	}


    /**
     * Egy lada titkus lyukra lepeset kezeli.
     * Ha zarva van akkor ugy mukodik mint egy mezo
     * Ha nyitva van akkor pedig mint egy lyuk
     * @param c A lada ami a titkos lyukba lep
     * @param d Az irany amerre lep
     */
    public void  Accept(Crate c, Direction d)
    {
        if(state)
        {
            
            Field f= neighbors.get(negDirection(d));
            if(f!=null) {
                f.Remove(c);
            }
            c = null;
        }
        else
        {
            if(getThing()!=null)
            {
                getThing().PushedBy(c, neighbors.get(d), d);
            }
            if(getThing()==null) {
            	this.setBackground(Color.YELLOW);
            	this.setText("c");
            	currentThing=c;
            	character=c.getChar();
                Field f= neighbors.get(negDirection(d));
                if(f!=null) {
                    f.Remove(c);
                }
            }
        }
    }

    /**
     * Egy lada titkus lyukra lepeset kezeli.
     * Ha zarva van akkor ugy mukodik mint egy mezo
     * Ha nyitva van akkor pedig mint egy lyuk
     * @param w A munkas ami a titkos lyukra lepni
     * @param d Az irany amerre lep
     */
    public void Accept(Worker w,Direction d)
    {
        if(state)
        {
           
            Field f= neighbors.get(negDirection(d));
            if(f!=null) {
                f.Remove(w);
            }
            w = null;
        }
        else
        {
            if(getThing()!=null)
            {
                getThing().PushedBy(w, neighbors.get(d), d);
            }

            if(getThing()==null) {
            	if(w.getChar()=='1') this.setBackground(Color.RED);
            	else this.setBackground(Color.WHITE);
            	this.setText("W");
                currentThing=w;
                character=w.getChar();

                Field f= neighbors.get(negDirection(d));
                if(f!=null) {
                    f.Remove(w);
                }
            }
        }
    }

    /**
     * Lekerul az adott thing a titkos lyukrol
     * @param t A thing amit leszed a mezorol
     */
    public void Remove(Thing t) {
    	character=',';
    	currentThing=null;
    	this.setBackground(Color.cyan);
    	this.setText("");
    }

    /**
     * Kinyilik a titkos lyuk
     */
    public void changeToTrue() {
    	character='o';
        state = true;
        setBackground(Color.BLACK);
        if(getThing()!=null)
        {
            Remove(getThing());
        }
    }

    /**
     * Bezarodik a titkos lyuk
     */
    public void changeToFalse( ) {
        state = false;
        setBackground(Color.cyan);
        this.setText("");
        character=',';
    }
    
}
