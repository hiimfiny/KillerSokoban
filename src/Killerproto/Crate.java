package Killerproto;

public class Crate implements Thing
{
	private Field current;
    private Field target;
    private int weight;
    private char character;

    public Crate() {
        character = 'c';
    	weight =2;
    }

    public char getChar(){return character;}
    public void setChar(char c){this.character=c;}


    public void PushedBy(Crate c, Field f,Direction d) {
    	f.Accept(this,d);    	
    }
    public void PushedBy(Worker w, Field f, Direction d) {
    	
    	//Ellen�rizz�k, hogy a munk�snak van e ereje eltolni a l�d�t.
    	if(Game.GetActualWorker().GetPower()>weight) {
    	//if(true) {
    		f.Accept(this, d);
    		//Cs�kken a munk�s ereje a l�da s�ly�val.
    	//	Game.GetActualWorker().DecreasePower(weight);
    	}
    	else {
    		return;
    	}
    }
    
    public void ChangeWeight(StickyField sf) {
    	weight=5;
    	
    }
    public void ChangeWeight(SlipperyField sf) {
    	weight=1;
    	
    }
	@Override
	public void PushedBy(Thing t, Field f,Direction d) {
	}
	
	@Override
	public void Enters(Field f, Direction d) {
		f.Accept(this, d);
		
	}
	
	public void SetCurrent(Field f) {
		current=f;
	}

	




}
