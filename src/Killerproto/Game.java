package Killerproto;
import java.util.*;

public class Game
{
	private WareHouse warehouse;
	private List<Player> players; 
	//Az a munk�s amelyik �ppen l�p
	private static  Worker actualWorker;
	//visszaadja az �ppen l�p� munk�st.
	public static Worker GetActualWorker() {
		return actualWorker;
	}
	public void SetActualWorker(Worker w) {
		actualWorker=w;
	}
	
    public void NewGame(){ };
    public void Play(){ };
    public void EndGame(){ };
    public void NextPlayer(){ };

}
