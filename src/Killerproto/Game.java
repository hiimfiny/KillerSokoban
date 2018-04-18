package Killerproto;
import java.util.*;

public class Game
{
	private WareHouse warehouse;
	private List<Player> players; 
	//Az a munkás amelyik éppen lép
	private static  Worker actualWorker;
	//visszaadja az éppen lépõ munkást.
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
