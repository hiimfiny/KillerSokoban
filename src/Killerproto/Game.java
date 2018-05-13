package Killerproto;


import java.io.*;
import java.util.*;

/**
 * A jatekot reprezentalo osztaly
 */
public class Game
{
	Graphics graphic;
	public static boolean end=false;			//A jatek veget jelzo valtozo
	private WareHouse warehouse;				//A jatek raktara
	private List<Player> players = new ArrayList<Player>();				//A jatekot jatszo jatekosok
	private static  Worker actualWorker;		//A jelenleg aktiv munkas
	static boolean endMapRead=false;			//A beolvasas veget jelzo valtozo
	private List<Worker> workers = new ArrayList<>();
	private int index;
	private int player;

	/**
	 * A jelenleg aktiv munkast kerdezi le
	 * @return A jelenleg aktiv munkas
	 */
	public static Worker GetActualWorker() {
		return actualWorker;
	}

	
	public WareHouse getwh() {
		return warehouse;
	}

	/**
	 * A jelenleg aktiv munkast allitja be az adott munkasra
	 * @param w A munkas amit be akarunk allitani
	 */
	public static void SetActualWorker(Worker w) {
		if(actualWorker!=null) actualWorker.unselect();
		actualWorker=w;		
		actualWorker.select();
	}
	

	public void switchWorkers(){
		//index = warehouse.getWorkers().indexOf(actualWorker);
		index=players.get(player).workerIndex(actualWorker);
		if(index==1){
			SetActualWorker(players.get(player).SelectWorker(0));
		}
		else {
            SetActualWorker(players.get(player).SelectWorker(1));
		}
		/*if(index==warehouse.getWorkers().size()-1){
			SetActualWorker(warehouse.getWorkers().get(index-1));
		    index--;
		}
		else {
            SetActualWorker(warehouse.getWorkers().get(index+1));
            index++;
        }*/
	}
	public void initWorkers() {
		workers=warehouse.getWorkers();
		for(Worker w: workers) {
			if(w.getChar()=='1') {
				players.get(0).addWorker(w);
			}
			else players.get(1).addWorker(w);
		}
	}

    public void NewGame(){
        Player sanyi = new Player("Sanyi");
        players.add(sanyi);
        Player pali = new Player("Pali");
        players.add(pali);
        player=0;

    	warehouse=new WareHouse();
    	warehouse.readMap("Map.txt");
    	initWorkers();

    	warehouse.neighbors();
    	graphic=new Graphics(this);
    	graphic.loadMap();
    	    	
    }
    public void Play(){ }
    public void EndGame(){ }
    public void NextPlayer(){ 
    	if(player==1) player=0;
    	else player=1;
    	
    	actualWorker=players.get(player).SelectWorker(0);
    	warehouse.searchWorker();
    }

	public void menu() {
		graphic=new Graphics(this);
		graphic.showMenu();
	}
	/**
	 * A tesztelest vegzi
	 * @param args -
	 */
    public static void main(String args[]){
		WareHouse wh = new WareHouse();		
		Game g=new Game();
		g.menu();
		end=false;
				
		}
	/**
	 * A tesztpalyak betolteset vegzi el
	 * @param wh A raktar ami a beolvasast es a kirajzolast vegzi
	 */
	
	
	}

