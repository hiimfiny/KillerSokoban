package Killerproto;

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
	static boolean killed=false;			
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
		if (w != null) {
			actualWorker = w;
			actualWorker.select();
		}
	}

	public void countPoints(){
		for (Player p: players) {
			p.countPoints();
		}
	}
	public int getPoints(int index){
		return players.get(index).getPoints();
	}


	/**
	 * játékos váltás
	 */
	public void switchWorkers(){
		index=players.get(player).workerIndex(actualWorker);
		if(index==1){
			actualWorker.unselect();
			SetActualWorker(players.get(player).SelectWorker(0));
		}
		else if(players.get(player).size()>1) {
			actualWorker.unselect();
            SetActualWorker(players.get(player).SelectWorker(1));
		}
		
	}

	/**
	 * munkások játékoshoz beállítása
	 */
	public void initWorkers() {
		workers=warehouse.getWorkers();
		for(Worker w: workers) {
			if(w.getChar()=='1') {
				players.get(0).addWorker(w);
			}
			else players.get(1).addWorker(w);
		}
	}

	public boolean kill(){
		boolean p1= players.get(0).kill();
		boolean p2= players.get(1).kill();
		return (p1||p2);
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
    	SetActualWorker(workers.get(0));
    	warehouse.searchWorker();
    	    	
    }
    public void Play(){ }
    public void EndGame(){ }
    public void NextPlayer(){ 
    	
    	if(player==1) player=0;
    	else player=1;
    	System.out.println(players.get(player).size());
    	if(players.get(player).size()>0) {
    	SetActualWorker(players.get(player).SelectWorker(0));
    	warehouse.searchWorker();}
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
		Game g=new Game();
		g.menu();
		end=false;
				
		}
	/**
	 * A tesztpalyak betolteset vegzi el
	 * @param wh A raktar ami a beolvasast es a kirajzolast vegzi
	 */
	
	
	}

