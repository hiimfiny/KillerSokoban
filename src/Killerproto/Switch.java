package Killerproto;

public class Switch extends Field{

    /**
     * ez a komment helye
     */
	private SecretHole secretHole;
	
    public void Accept(Crate c, Direction d)
    {
        Accept(c, d);
        secretHole.changeToTrue();
    }

    public void Remove()
    {
        secretHole.changeToFalse();
        Remove();

    }
}
