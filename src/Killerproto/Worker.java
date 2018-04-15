package Killerproto;

public class Worker implements Thing
{
	private Field current;
    private int power;

    public void PushedBy(Crate c, Field f) {
    	
    }
    public void PushedBy(Worker w, Field f) {
    	
    }
	@Override
	public void PushedBy(Thing t, Field f) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Enters(Field f) {
		// TODO Auto-generated method stub
		
	}

}
