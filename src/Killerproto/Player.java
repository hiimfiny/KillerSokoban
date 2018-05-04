package Killerproto;
import java.util.*;

/**
 * A jatekost reprezentalo osztaly
 */
public class Player
{
	private List<Worker> workers;           //A jatekos munkasai
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
    public Player(){
        points=0;
    }

    public Worker SelectWorker(int i){
        Worker temp = new Worker('1');
        temp=workers.get(i);
        return temp;
    }
    public void MoveOn(Field f){};
    public void ActivateRound(){};


}
