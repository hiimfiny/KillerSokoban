package Killerproto;

import java.io.BufferedReader;
import javax.swing.*;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * A raktarat reprezentalo ostaly
 */
public class WareHouse extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int size;						//A raktar merete
	public Field[][] map;					//A raktar mezoi
	private SecretHole secret;		//A tesztben szereplo titkos lyuk
	private Switch sw;				//A tesztben szereplo kapcsolo
	static int x,y;					//A kijelolt munkas koordinataja

	public int getS() {
		return size;
		
	}
	
	/**
	 * A fajlolvasast kezelo fuggveny
	 * Vegigmegy a fajl sorain, es letrehozza a mezoket, majd vegigmegy a thingeken is es beallitja azokat
	 * @param filename A beolvasando fajl neve
	 */
	public void readMap(String filename) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			String[] values;
			this.size = (Integer.parseInt(br.readLine()));
			this.map=new Field[size][size];
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					this.map[i][j]=new Field();
				}
			}
			int i=0;
			while ((line = br.readLine()) != null) {
				values = line.split(",");
				if (i >= size) {
					for (int j = 0; j < size; j++) {
						switch (values[j]) {
							case "0":
								map[i - size][j].setCurrentThing(new Pillar());
								break;
							case "7":
								map[i - size][j].setCurrentThing(new Crate(2));
								break;
							case "8":
								Worker w=new Worker('1');
								Game.SetActualWorker(w);
								map[i - 7][j].setCurrentThing(w);
								x=i-size;
								y=j;
								break;
							case "9":
								map[i - size][j].setCurrentThing(new Worker('2'));
								break;
							case "n":
								map[i-size][j].setCurrentThing(new Crate(6));
								break;
							case ".":
								map[i - size][j].setCurrentThing(null);
								break;
						}
					}
					i++;
				} else {
					for (int j = 0; j < size; j++) {
						switch (values[j]) {
							//A sima field
							case "1":
								map[i][j].setChar('.');
								break;
							//A Slippery field
							case "2":
								map[i][j] = new SlipperyField();
								map[i][j].setChar('-');

								break;
							//A Slippery field
							case "3":
								map[i][j] = new StickyField();
								map[i][j].setChar('+');
								break;
							//A hole
							case "4":
								map[i][j] = new Hole();
								map[i][j].setChar('o');
								break;
							//A secret hole
							case "5":
								secret=new SecretHole();
								map[i][j] = secret;
								map[i][j].setChar(',');
								break;
							//A switch
							case "6":
								sw=new Switch();
								map[i][j] = sw;
								map[i][j].setChar('s');
								break;
						}
					}
					i++;
				}
			}
			br.close();
			if(secret!=null)
				if(sw!=null) {
					secret.setSwitch(sw);
					sw.setSecret(secret);
				}
		} catch (IOException e) {
			System.out.println("rip");
		}
	}

	/**
	 * Kirajzolja a raktarat
	 */
	public void showMap() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(map[i][j].getThing()==null)
					System.out.print(map[i][j].getChar());
				else
					System.out.print(map[i][j].getThing().getChar());
			}
			System.out.print("\n");
		}
		
	}

	/**
	 * Megkeresi az epp aktualis jatekost
	 */
	public void searchWorker() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++)
			{
				if(map[i][j].getChar()=='1') {
					x=i;
					y=j;
				}
					
			}
		}
	}

	/**
	 * A parancsok beolvasasat vegzi
	 */
	public void readCommand(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String command=br.readLine();
			
			switch(command) {
			case "moveRight":
				Game.GetActualWorker().Enters(map[x][y+1], Direction.Right);
				searchWorker();
				break;
			case "moveLeft":
				Game.GetActualWorker().Enters(map[x][y-1],Direction.Left);
				searchWorker();
				break;
			case "moveUp":
				Game.GetActualWorker().Enters(map[x-1][y],Direction.Up);
				searchWorker();
				break;
			case "moveDown":
				Game.GetActualWorker().Enters(map[x+1][y],Direction.Down);
				searchWorker();
				break;
			case "exit":
				Game.end=true;
			}
		}catch(Exception e) {
			System.out.println("Exception: warehouse.readCommand()");
		}
	}

	/**
	 * Beallitja minden mezo minden szomszedjat
	 */
	public void neighbors() {
		//Beallitjuk a palya szeleinek szomszedait
		for(int i=0;i<size;i++) {
			map[i][0].setNeighbour(Direction.Right, map[i][1]);
			map[0][i].setNeighbour(Direction.Down, map[1][i]);
			map[i][size-1].setNeighbour(Direction.Left, map[i][size-2]);
			map[size-1][i].setNeighbour(Direction.Up, map[size-2][i]);
		}
		//A palya belsejen is beallitjuk a szomszedokat
		for(int i=1;i<size-1;i++) {
			for(int j=1;j<size-1;j++) {
				map[i][j].setNeighbour(Direction.Up, map[i-1][j]);
				map[i][j].setNeighbour(Direction.Down, map[i+1][j]);
				map[i][j].setNeighbour(Direction.Left, map[i][j-1]);
				map[i][j].setNeighbour(Direction.Right, map[i][j+1]);
			}
		}
	}

}