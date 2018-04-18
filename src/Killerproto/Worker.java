package Killerproto;

public class Worker implements Thing
{
	private Field current;
    private int power;
	private String character;
	boolean selected;

	public Worker() {
		selected=false;
		power=4;
	}
	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}
	public boolean GetSelected() {return selected;}
	
	public int GetPower() {return power;}

    public void PushedBy(Crate c, Field f,Direction d) {
    	f.Accept(this, d);
    	
    }
    public void PushedBy(Worker w, Field f, Direction d) {
    	if(w.selected) {
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
		selected=true;
		f.Accept(this, d);
		selected=false;		
	}
	
	public void SetCurrent(Field f) {
		current=f;
	}
	public void Destroy() {
		current.Remove(this);
	}

}
