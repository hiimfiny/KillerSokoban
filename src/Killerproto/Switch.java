package Killerproto;

public class Switch extends Field{

    /**
     * ez a komment helye
     */
	private SecretHole secretHole;
	
    public void Accept(Crate c, Direction d)
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
        secretHole.changeToTrue();
    }

    public void Remove()
    {
        secretHole.changeToFalse();
        setCurrentThing(null);

    }
}
