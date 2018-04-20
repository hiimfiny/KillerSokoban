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
        Accept(c,d);
        }
    }
    public void Accept(Worker w,Direction d)
    {
        if(state)
        {
            w = null;
        }
        else
        {
            Accept(w,d);
        }
    }

    public void changeToTrue()
    {

        state = true;

    }

    public void changeToFalse( )
    {
        state = false;
    }
    
}
