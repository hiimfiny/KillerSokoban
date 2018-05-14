package Killerproto;

import java.io.BufferedReader;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A raktarat reprezentalo ostaly
 */

public class WareHouse extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** A raktar merete*/
	protected int size;		
	/** A raktar mezoi*/
	public Field[][] map;			
	/** A palyan levo titkos lyuk*/
	private SecretHole secret;		
	/** A palyan levo switch*/
	private Switch sw;				
	/** Az aktualis munkas helye*/
	static int x,y;					
	/** A munkasok listaja*/
	private List<Worker> workers = new ArrayList<>();

/**
 * Visszaadja a raktar meretet
 * @return a raktar merete
 */
	public int getS() {
		return size;
		
	}
	/**
	 * 
	 * @return A munkasok listaja
	 */

	public List<Worker> getWorkers(){
		return workers;
	}
	/**
	 * Torli az i-edik munkast
	 * @param i a torlendo index
	 */
	public void removeAt(int i) {
		workers.remove(i);
	}

	/**
	 * Torli az adott munkast
	 * @param w az adott munkas
	 */
	public void removeWorker(Worker w){
		workers.remove(w);
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
							case "2":
								Worker w3=new Worker('2');
								workers.add(w3);
								map[i - size][j].setCurrentThing(w3);
								break;
							case "7":
								map[i - size][j].setCurrentThing(new Crate(2));
								map[i-size][j].addCrate();
								break;
							case "8":
								Worker w=new Worker('1');
								workers.add(w);
								map[i - size][j].setCurrentThing(w);
								x=i-size;
								y=j;
								break;
							case "9":
								Worker w2 = new Worker('2');
								map[i - size][j].setCurrentThing(w2);
								workers.add(w2);
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
							case "t":
								map[i][j].setTarget();
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
	 * Megkeresi az epp aktualis jatekost
	 */
	public void searchWorker() {
		x=-1;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++)
			{
				if(map[i][j].actualHere()) {
					x=i;
					y=j;
				}
					
			}
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