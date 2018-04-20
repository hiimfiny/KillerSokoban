package Killerproto;
import java.util.*;

public class Player
{
	private List<Worker> workers;
    private String Name;
    private int number;
    private int points;

    public Player(){
        points=0;
    }

    public void Select (Worker w){};
    public Worker SelectWorker(int i){
        Worker temp = new Worker();
        temp=workers.get(i);
        return temp;
    }
    public void MoveOn(Field f){};
    public void ActivateRound(){};


}
