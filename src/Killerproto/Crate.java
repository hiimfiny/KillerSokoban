package Killerproto;

public class Crate implements Thing
{

	private Field current;
    private Field target;
    private int weight;
    private String character;

    public Crate() {
        weight =2;
    }

    public String getChar(){return character;}
    public void setChar(String v){this.character=v;}


    public void PushedBy(Crate c, Field f,Direction d) {
    	f.Accept(this,d);    	
    }
    public void PushedBy(Worker w, Field f, Direction d) {
    	//Ellenõrizzük, hogy a munkásnak van e ereje eltolni a ládát.
    	if(Game.GetActualWorker().GetPower()>weight) {
    		f.Accept(this, d);
    		//Csökken a munkás ereje a láda súlyával.
    		Game.GetActualWorker().DecreasePower(weight);
    	}
    	else {
    		return;
    	}
    }
    
    public void ChangeWeight(StickyField sf) {
    	weight=3;
    	
    }
    public void ChangeWeight(SlipperyField sf) {
    	weight=1;
    	
    }
	@Override
	public void PushedBy(Thing t, Field f,Direction d) {}
	
	@Override
	public void Enters(Field f, Direction d) {
		f.Accept(this, d);
		
	}
	
	public void SetCurrent(Field f) {
		current=f;
	}




}
