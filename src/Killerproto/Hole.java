package Killerproto;

import java.awt.*;

/**
 * A lyukat reprezentalo osztaly
 */
public class Hole extends Field {

    /**
     * Egy lada lyukba eseset valostija meg. Ha a lada a lyukba esett akkor eltunik a palyarol
     * @paramc A lada ami a lyukba lep
     * @paramd Az irany amerre lep
     */
	public boolean actualHere() {
		return false;
	}

    public Hole(){
        SetCurrent();
    }


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

    	Field f= neighbors.get(negDirection(d));
        if(f!=null) {
            f.Remove(w);
        }      
        w.SetCurrent(this);
        this.setBackground(Color.BLACK);
        this.setText("");
        w =null;
       

    }
    
    

}
