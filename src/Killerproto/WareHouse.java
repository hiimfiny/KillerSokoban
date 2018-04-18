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
			this.map=new Field[7][7];
			for(int i=0;i<7;i++){
				for(int j=0;j<7;j++){
					this.map[i][j]=new Field();
				}
			}
			while ((line = br.readLine()) != null) {
				values = line.split(",");
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 7; j++) {
						this.map[i][j].setChar(values[j]);
						//temp[i][j].setChar(values[j]);
					}
				}
			}
			br.close();
			//this.map=temp;
			/*
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(temp[i][j].getChar());
				}
				System.out.print("\n");
			}
			*/

		} catch (IOException e) {
			System.out.println("rip");
		}
	}

	public void showMap() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j].getChar());
			}
			System.out.print("\n");
		}
	}
	public static void main(String args[]){
		WareHouse wh = new WareHouse();
		wh.readMap("testMap1.txt");
		wh.showMap();
	}
}