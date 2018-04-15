package Killerproto;

public class Crate implements Thing
{

	private Field current;
    private Field target;
    private int weight;
    public Crate() {
    	weight =2;
    }

    public void PushedBy(Crate c, Field f) {
    	
    }
    public void PushedBy(Worker w, Field f) {
    	
    }
    public void ChangeWeight(StickyField sf) {
    	weight=3;
    	
    }
    public void ChangeWeight(SlipperyField sf) {
    	weight=1;
    	
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
