package Killerproto;
import java.io.*;
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
	public static void SetActualWorker(Worker w) {
		actualWorker=w;
	}



    public void NewGame(){ };
    public void Play(){ };
    public void EndGame(){ };
    public void NextPlayer(){ };
    
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
				break;
			case "loadGame(TestMap14)":
				wh.readMap( "testMap14.txt");
				break;
		
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


    public static void main(String args[]){
		WareHouse wh = new WareHouse();
		loadMap(wh);		
		wh.neighbors();
		//Game.SetActualWorker(wh.map[5][5].getThing());
		/*if(wh.map[5][5].getThing()!=null)
			wh.map[5][4].getThing().Enters(wh.map[4][4],Direction.Up);
		if(wh.map[4][4]!=null) wh.map[4][4].getThing().Enters(wh.map[4][3], Direction.Left);*/
		wh.showMap();
		
	}
}
