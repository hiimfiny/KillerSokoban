package Killerproto;
import java.util.*;

/**
 * A jatekost reprezentalo osztaly
 */
public class Player
{
	/** A jatekos munkasai*/
	private List<Worker> workers=new ArrayList<Worker>();     
	/** A jatekos pontjai*/
    private int points;                     

    /**
     * A jatekos konstruktora
     */
    public Player() {
    	points=0;
    }

    /**
     * A jatekos pontszamait szamolo fuggveny
     */
    public void countPoints(){
        for (Worker w: workers) {
            points+=w.getPoints();
        }
    }
    
    /**
     * Visszaadja a jatekos pontszamat
     * @return jatekos pontszama
     */
    public int getPoints(){
        return points;
    }

    /**
     * Megadja, hogy hany munkasa maradt a jatekosnak
     * @return
     */
    public int size() {
    	return workers.size();
    }
    
    /**
     * Megvizsgalja, hogy meghalt-e a korben valamelyik munkas
     * @return meghalt-e valaki
     */
    public boolean kill() {
        for(Worker w:workers){         	
            if(w.getCurrentField().getThing()==null||w.getCurrentField().getThing().getChar()=='c'||w==null){
            	
                if(workers.size()==1 ||workers.contains(null)){Game.killed=true;}
                
                points+=w.getPoints();
                workers.remove(w);
                return true;
            }
        }
        return false;
    }

    /**
     * Hozzaad egy munkast a listahoz
     * @param w a hozzaadni kivant munkas
     */
    public void addWorker(Worker w) {
    	workers.add(w);
    }
    
    /**
     * Megadja, hogy hanyadik az adott munkas a jatekos listajaban
     * @param w Az adott munkas
     * @return a munkas helye
     */
    public int workerIndex(Worker w) {
    	return workers.indexOf(w);    	
    }

    /**
     * Kivalaszt egy munkast
     * @param i a munkas sorszama
     * @return a kivalasztott munkas
     */
    public Worker SelectWorker(int i){
       return workers.get(i);
    }
    


}
