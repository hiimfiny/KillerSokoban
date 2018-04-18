package Killerproto;

public class Worker implements Thing
{
	private Field current;
    private int power;
	private String character;

	public Worker() {
		
		power=4;
	}
	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}
	
	
	public int GetPower() {return power;}
	public void DecreasePower(int d) {power-=d;}

    public void PushedBy(Crate c, Field f,Direction d) {
    	f.Accept(this, d);
    	
    }
    public void PushedBy(Worker w, Field f, Direction d) {
    	if(Game.GetActualWorker()==w) {
    		return;
    	}
    	else {
    		f.Accept(this, d);
    	}
    }
	@Override
	public void PushedBy(Thing t, Field f,Direction d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Enters(Field f,Direction d) {		
		f.Accept(this, d);
				
	}
	
	public void SetCurrent(Field f) {
		current=f;
	}
	public void Destroy() {
		current.Remove(this);
	}

}
