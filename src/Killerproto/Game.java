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
		actualWorker=w;
		
	}

	public void switchWorkers(){
		index = warehouse.getWorkers().indexOf(actualWorker);
		if(index==warehouse.getWorkers().size()-1){
			SetActualWorker(warehouse.getWorkers().get(index-1));
		    index--;
		}
		else {
            SetActualWorker(warehouse.getWorkers().get(index+1));
            index++;
        }
	}

    public void NewGame(){
        Player sanyi = new Player("Sanyi");
        players.add(sanyi);
        Player pali = new Player("Pali");
        players.add(pali);

    	warehouse=new WareHouse();
    	warehouse.readMap("testMap5.txt");

    	warehouse.neighbors();
    	graphic=new Graphics(this);
    	graphic.loadMap();
    	    	
    }
    public void Play(){ }
    public void EndGame(){ }
    public void NextPlayer(){ }

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
		loadMap(wh);
		wh.neighbors();

		/*
		while(!endMapRead) {
			end=false;
			loadMap(wh);		
			wh.neighbors();
			*/
		while(!Game.end&&!endMapRead) {
			//wh.showMap();
			g.graphic.showMap();
			g.GetActualWorker().getCurrentField().setEnabled(true);
			wh.readCommand();
		}
		}
	/**
	 * A tesztpalyak betolteset vegzi el
	 * @param wh A raktar ami a beolvasast es a kirajzolast vegzi
	 */
	public static void loadMap(WareHouse wh) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String command;
		try {
			switch(command = br.readLine()) {

				case "loadGame(TestMap1)":
					wh.readMap( "testMap1.txt");
					break;
				case "loadGame(TestMap2)":
					wh.readMap( "testMap2.txt");
					break;
				case "loadGame(TestMap3)":
					wh.readMap( "testMap3.txt");
					break;
				case "loadGame(TestMap4)":
					wh.readMap( "testMap4.txt");
					break;
				case "loadGame(TestMap5)":
					wh.readMap( "testMap5.txt");
					break;
				case "loadGame(TestMap6)":
					wh.readMap( "testMap6.txt");
					break;
				case "loadGame(TestMap7)":
					wh.readMap( "testMap7.txt");
					break;
				case "loadGame(TestMap8)":
					wh.readMap( "testMap8.txt");
					break;
				case "loadGame(TestMap9)":
					wh.readMap( "testMap9.txt");
					break;
				case "loadGame(TestMap10)":
					wh.readMap( "testMap10.txt");
					break;
				case "loadGame(TestMap11)":
					wh.readMap( "testMap11.txt");
					break;
				case "loadGame(TestMap12)":
					wh.readMap( "testMap12.txt");
					break;
				case "loadGame(TestMap13)":
					wh.readMap( "testMap13.txt");
					//A pályán lévő ládának beállitjuk a helyét
					wh.map[2][3].getThing().setTargetField(wh.map[2][4]);
					break;
				case "loadGame(TestMap14)":
					wh.readMap( "testMap14.txt");
					break;
				case "Exit":
					endMapRead=true;
					break;
				default:
					end=true;
					break;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

