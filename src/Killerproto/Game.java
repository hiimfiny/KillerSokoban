package Killerproto;

import java.util.*;

/**
 * A jatekot reprezentalo osztaly
 */
public class Game
{
	/** A grafikaert felos objektum*/
	Graphics graphic;
	public static boolean end=false;	
	/** A raktararuhaz*/
	private WareHouse warehouse;				
	/** A jatekosok listaja*/
	private List<Player> players = new ArrayList<Player>();	
	/** Az aktualis munkas*/
	private static  Worker actualWorker;	
	/** Meghalt-e valamelyik jatekos?*/
	static boolean killed=false;		
	/** A munkasok listaja*/
	private List<Worker> workers = new ArrayList<>();
	/** A munkas indexe*/
	private int index;
	/**A jatekos indexe*/
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

	/**
	 * Megszamolja a jatek soran szerzett pontokat
	 */
	public void countPoints(){
		for (Player p: players) {
			p.countPoints();
		}
	}
	public int getPoints(int index){
		return players.get(index).getPoints();
	}


	/**
	 * Az aktualis jatekost valtja
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
	 * A munkasok beallitasa a jatekosokhoz
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

	/**
	 * Megnezi, hogy meghalt-e valaki a korben
	 * @return megtortent a halal vagy sem
	 */
	public boolean kill(){
		boolean p1= players.get(0).kill();
		boolean p2= players.get(1).kill();
		return (p1||p2);
	}

	/**
	 * Letrehoz egy uj jatekot
	 */
    public void NewGame(){
        Player sanyi = new Player();
        players.add(sanyi);
        Player pali = new Player();
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
   /**
    * Atvalt a kovetkezo jatekosra
    */
    public void NextPlayer(){ 
    	
    	if(player==1) player=0;
    	else player=1;
    	if(players.get(player).size()>0) {
    	SetActualWorker(players.get(player).SelectWorker(0));
    	warehouse.searchWorker();}
    }
    /**
     * Elinditja a jatek menujet
     */
	public void menu() {
		graphic=new Graphics(this);
		graphic.showMenu();
	}
	/**
	 *A jatek main fuggvenye, innen indul a jatek
	 * @param args -
	 */
    public static void main(String args[]){	
		Game g=new Game();
		g.menu();
		end=false;				
		}
	
	}

