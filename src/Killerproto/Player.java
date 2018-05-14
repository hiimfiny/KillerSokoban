package Killerproto;
import java.util.*;

/**
 * A jatekost reprezentalo osztaly
 */
public class Player
{
	private List<Worker> workers=new ArrayList<Worker>();           //A jatekos munkasai
    private String Name;                    //A jatekos neve
    private int number;
    private int points;                     //A jatekos pontszama

    /**
     * A jatekos konstruktora
     */
    public Player(String name) {
    	Name=name;
    	points=0;
    }

    public void countPoints(){
        for (Worker w: workers) {
            points+=w.getPoints();
        }
    }
    public int getPoints(){
        return points;
    }

    public int size() {
    	return workers.size();
    }
    
    
    public boolean kill() {
        for(Worker w:workers){    
        	System.out.println(workers);        	
            if(w.getCurrentField().getThing()==null||w.getCurrentField().getThing().getChar()=='c'||w==null){
            	
                if(workers.size()==1 ||workers.contains(null)){Game.killed=true;}
                
                points+=w.getPoints();
                workers.remove(w);
                System.out.println(workers.size());
                return true;
            }
        }
        return false;
    }


    public void addWorker(Worker w) {
    	workers.add(w);
    }
    
    public int workerIndex(Worker w) {
    	return workers.indexOf(w);    	
    }

    public Worker SelectWorker(int i){
       return workers.get(i);
    }
    public void MoveOn(Field f){};
    public void ActivateRound(){};


}
