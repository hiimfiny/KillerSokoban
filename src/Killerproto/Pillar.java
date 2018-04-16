package Killerproto;

public class Pillar implements Thing
{
	private Field current;
	private String character;

	public String getChar(){return character;}
	public void setChar(String v){this.character=v;}
    public void PushedBy(Thing t, Field f) {
    	
    }	

	@Override
	public void Enters(Field f) {
		// TODO Auto-generated method stub
		
	}


}
