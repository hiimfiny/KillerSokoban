package Killerproto;

import java.awt.*;

/**
 * A lyukat reprezentalo osztaly
 */
public class Hole extends Field {

    /**
     * Egy lada lyukba eseset valostija meg. Ha a lada a lyukba esett akkor eltunik a palyarol
     * @param c A lada ami a lyukba lep
     * @param d Az irany amerre lep
     */
    public void SetCurrent() {
        this.setBackground(Color.black);
    }
    public void Accept(Crate c, Direction d) {
    	c = null;
    	Field f= neighbors.get(negDirection(d));
        if(f!=null) {
            f.Remove(c);
        }
    }

    /**
     * A munkas lyukba eseset valositja meg. Ha egy munkas a lyukba esett akkor eltunik a palyarol
     * @param w A munkas ami a mezore probal lepni
     * @param d Az irany amerre lep
     */
    public void Accept(Worker w, Direction d) {
    	w =null;
    	Field f= neighbors.get(negDirection(d));
        if(f!=null) {
            f.Remove(w);
        }
    }
    
    

}
