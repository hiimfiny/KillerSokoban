package Killerproto;

public class SecretHole extends Hole {
    private boolean state;
    private Switch sw;

    public void  Accept(Crate c, Direction d)
    {
        if(state)
        {
            c = null;
        }
        else
        {
            if(GetThing()!=null)
            {
                GetThing().PushedBy(c, neighbors.get(d), d);
            }

            if(GetThing()==null) {
                setCurrentThing(c);

                Field f= neighbors.get(negDirection(d));
                if(f!=null) {
                    f.Remove(c);
                }
            }
        }
    }
    public void accept(Worker w,Direction d)
    {
        if(state)
        {
            w = null;
        }
        else
        {
            if(GetThing()!=null)
            {
                GetThing().PushedBy(w, neighbors.get(d), d);
            }

            if(GetThing()==null) {
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

        state = true;
        if(GetThing()!=null)
        {
            Remove(GetThing());
        }

    }

    public void changeToFalse( )
    {
        state = false;
    }
    
}
