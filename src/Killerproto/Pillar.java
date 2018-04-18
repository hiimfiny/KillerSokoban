package Killerproto;

public class Pillar implements Thing
{
	private Field current;
	private String character;

	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}
    public void PushedBy(Thing t, Field f, Direction d) {
    	
    }	
    
    public void PushedBy(Crate c, Field f, Direction d) {
    	return;
    }
    
    public void PushedBy(Worker w, Field f, Direction d) {
    	if(w.GetSelected()) {
    		return;
    	}
    	else {
    		
    	}
    }

	@Override
	public void Enters(Field f,Direction d) {
		// TODO Auto-generated method stub
		
	}


}
