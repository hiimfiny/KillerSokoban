package Killerproto;

public class Worker implements Thing
{
	private Field current;
    private int power;
	private char character;

	public Worker(char c) {
		character=c;
		power=4;
	}
	public char getChar(){return character;}
	public void setChar(char c){this.character=c;}
	
	
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
	public void setTargetField(Field f){}
	public void Destroy() {
		current.Remove(this);
	}

}
