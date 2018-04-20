package Killerproto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class WareHouse {
	List<Field> fields;
	List<Crate> crates;
	int size;
	Field[][] map;

	public int getSize() {
		return this.size;
	}

	public void readMap(String filename) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			String[] values;
			this.size = (Integer.parseInt(br.readLine()));
			
			//Field[][] temp = new Field[size][size];
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
								map[i - 7][j].setCurrentThing(new Pillar());
								break;
							case "7":
								map[i - 7][j].setCurrentThing(new Crate());
								break;
							case "8":
								map[i - 7][j].setCurrentThing(new Worker('1'));
								break;
							case "9":
								map[i - 7][j].setCurrentThing(new Worker('2'));
								break;
							case ".":
								map[i - 7][j].setCurrentThing(null);
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
								map[i][j] = new SecretHole();
								map[i][j].setChar(',');
								break;
							//A switch
							case "6":
								map[i][j] = new Switch();
								map[i][j].setChar('s');
								break;
						}
					}
					i++;
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("rip");
		}
	}

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
	
	public void neighbors() {
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