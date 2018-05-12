package Killerproto;



/**
 * A kapcsolot reprezentalo osztaly
 */
public class Switch extends Field{

	private SecretHole secretHole;          //A kapcsolohoz tartozo titkos lyuk

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
     * Egy lada lep a kapcsolora, es ez kinyitja a hozza tartozo titkos lyukat.
     * Ezen kivul ugy mukodik mint egy sima mezo
     * @param c A lada ami a mezore probal lepni
     * @param d Az irany amerre lep
     */
    public void Accept(Crate c, Direction d)
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
        if(secretHole!=null) {
        	secretHole.changeToTrue();
        	secretHole.setBackground(java.awt.Color.BLACK);
        }
    }


    /**
     * A munkas lekerul a kapcsolrol
     * @param w A munkas
     */
    public void Remove(Worker w) {
    	character='s';
    	setCurrentThing(null);
    }

    /**
     * A lada lekerul a kapcsolorol, es visszazarodik a titkos lyuk
     * @param c A lada
     */
    public void Remove(Crate c)
    {
        secretHole.changeToFalse();
        secretHole.setBackground(java.awt.Color.cyan);
        setCurrentThing(null);
    }

}
