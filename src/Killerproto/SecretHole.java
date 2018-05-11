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
            c = null;
            Field f= neighbors.get(negDirection(d));
            if(f!=null) {
                f.Remove(c);
            }
        }
        else
        {
            if(getThing()!=null)
            {
                getThing().PushedBy(c, neighbors.get(d), d);
            }
            if(getThing()==null) {
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
            w = null;
            Field f= neighbors.get(negDirection(d));
            if(f!=null) {
                f.Remove(w);
            }
        }
        else
        {
            if(getThing()!=null)
            {
                getThing().PushedBy(w, neighbors.get(d), d);
            }

            if(getThing()==null) {
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
    }

    /**
     * Kinyilik a titkos lyuk
     */
    public void changeToTrue() {
    	character='o';
        state = true;
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
        character=',';
    }
    
}
