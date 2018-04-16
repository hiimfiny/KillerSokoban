package Killerproto;

public class Worker implements Thing
{
	private Field current;
    private int power;
	private String character;

	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}

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
