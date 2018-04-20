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
				if(i>=size){
					for(int j=0;j<size;j++){

					}
				}
				for (int j = 0; j < size; j++) {
					switch(values[j]){
						//A sima field
						case "1":
							map[i][j].setChar('.');
							break;
						//A Slippery field
						case "2":
							map[i][j]=new SlipperyField();
							map[i][j].setChar('-');

							break;
						//A Slippery field
						case "3":
							map[i][j]=new StickyField();
							map[i][j].setChar('+');

							break;
						//A hole
						case "4":
							map[i][j]=new Hole();
							map[i][j].setChar('o');
							break;
						//A secret hole

						}

					}
					i++;

			}
			br.close();
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

	//Az input fájl karaktereinek dekódolása. Visszaadja azt a char-t amit meg kell jeleniteni a képernyőn
	public char decodeMap(String s){
		char ret = '.';
		switch(s){
			case "1":
				ret='.';
				break;
			case "2":
				ret='-';
				break;
			case "3":
				ret='+';
				break;
			case "4":
				ret='o';
				break;
			case "5":
				ret='°';
				break;
			case "6":
				ret='s';
				break;
		}
		return ret;
	}

	public char decodeThing(String s){
		char ret = '.';
		switch(s){
			case "0":
				ret='#';
				break;
			case "7":
				ret='c';
				break;
			case "8":
				ret='1';
				break;
			case "9":
				ret='2';
				break;
		}
		return ret;
	}


	public static void main(String args[]){
		WareHouse wh = new WareHouse();
		wh.readMap("testMap1.txt");
		wh.showMap();
	}
}