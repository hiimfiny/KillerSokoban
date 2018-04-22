package Killerproto;

public class Switch extends Field{

    /**
     * ez a komment helye
     */
	private SecretHole secretHole;
	
	public void setSecret(SecretHole sh) {
		secretHole=sh;
	}
	
    public void Accept(Crate c, Direction d)
    {
        if(getThing()!=null)
        {
            getThing().PushedBy(c, neighbors.get(d), d);
        }

        if(getThing()==null) {
           // setCurrentThing(c);
        	currentThing=c;
        	character=c.getChar();
            Field f= neighbors.get(negDirection(d));
            if(f!=null) {            
                f.Remove(c);
            }
        }
        if(secretHole!=null) {
        	secretHole.changeToTrue();
        }
    }
    
    public void Remove(Worker w) {
    	character='s';
    	setCurrentThing(null);
    	
    }

    public void Remove(Crate c)
    {
        secretHole.changeToFalse();
        setCurrentThing(null);
               

    }
}
