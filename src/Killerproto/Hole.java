package Killerproto;

public class Hole extends Field {

    public void Accept(Crate c, Direction d) {
    	c = null;
    	Field f= neighbors.get(negDirection(d));
        if(f!=null) {
            f.Remove(c);
        }
    }
    public void Accept(Worker w, Direction d) {
    	w =null;
    	Field f= neighbors.get(negDirection(d));
        if(f!=null) {
            f.Remove(w);
        }
    }

}
