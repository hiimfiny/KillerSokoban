package Killerproto;

public class SecretHole extends Hole {
    private boolean state;
    private Switch sw;

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
                setCurrentThing(c);

                Field f= neighbors.get(negDirection(d));
                if(f!=null) {
                    f.Remove(c);
                }
            }
        }
    }
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
                setCurrentThing(w);

                Field f= neighbors.get(negDirection(d));
                if(f!=null) {
                    f.Remove(w);
                }
            }
        }
    }

    public void changeToTrue()
    {
    	character='o';
        state = true;
        if(getThing()!=null)
        {
            Remove(getThing());
        }

    }

    public void changeToFalse( )
    {
        state = false;
        character=',';
    }
    
}
