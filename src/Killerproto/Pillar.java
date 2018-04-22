package Killerproto;

public class Pillar implements Thing
{
	private Field current;
	private char character;

	public Pillar(){
		character='#';

	}

	public char getChar(){return character;}
	public void setChar(char c){this.character=c;}
    public void PushedBy(Thing t, Field f, Direction d) {
    	
    }	
    
    public void PushedBy(Crate c, Field f, Direction d) {
    	return;
    }
    
    public void PushedBy(Worker w, Field f, Direction d) {
    	if(w==Game.GetActualWorker()) {
    		return;
    	}
    	else {
    		if(current.getNeighbour(current.negDirection(d))!=null)
    			current.getNeighbour(current.negDirection(d)).Remove(w);    		
    	}
    }

	@Override
	public void Enters(Field f,Direction d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetCurrent(Field f) {
		current=f;
		
	}


}
