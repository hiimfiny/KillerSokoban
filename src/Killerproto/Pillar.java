package Killerproto;

import java.awt.*;

/**
 * Az oszlopot reprezentalo osztaly
 */
public class Pillar implements Thing
{
	private Field current;				//A mezo amin az oszlop van
	private char character;				//Az oszlopot reprezentalo karakter

	/**
	 * Az oszlop kontruktora
	 */
	public Pillar(){
		character='#';
	}

	/**
	 * Az oszlopot reprezentalo karaktert kerdezi le
	 * @return Az oszlopot reprezentalo karakter
	 */
	public char getChar(){return character;}

		/**
	 * Az oszlopot reprezentalo karaktert allitja be
	 * @param c A karakter amit beallit
	 */
	public void setChar(char c){this.character=c;}

	/**
	 * Beallitja az oszlop jelenlegi mezojet az adott mezore
	 * @param f A mezo amit beallit
	 */
	@Override
	public void SetCurrent(Field f) {
		current=f;
		f.setBackground(Color.BLUE);
		f.setText("P");
	}

	/**
	 * Az oszlopot egy lada probalja ellokni, de nem tortenik semmi
	 * @param c A lada ami loki a falat
	 * @param f A mezo amire lokik
	 * @param d Az irany amerre lokik
	 */
    public void PushedBy(Crate c, Field f, Direction d) {
    	return;
    }

	/**
	 * Az oszlopot egy munkas probalja ellokni.
	 * Ha a munkas magatol probalta ellokni az oszlopot, akkor nem torenik semmi
	 * Ha a munkast valami mas lokte oda, akkor meghal
	 * @param w A munkas ami loki a falat
	 * @param f A mezo amire lokik
	 * @param d Az irany amerre lokik
	 */
    public void PushedBy(Worker w, Field f, Direction d) {
    	if(w==Game.GetActualWorker()) {
    		return;
    	}
    	else {
    		if(current.getNeighbour(current.negDirection(d))!=null) {
    			current.getNeighbour(current.negDirection(d)).Remove(w);
    			w=null;
    			}
    			
    	}
    }


	public void Enters(Field f,Direction d) {}
	public void setTargetField(Field f){}
	public void PushedBy(Thing t, Field f, Direction d) {}
	public void addPoints(int p){}
}
