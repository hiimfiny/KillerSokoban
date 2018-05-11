package Killerproto;

import java.awt.Color;

/**
 * A munkast reprezentalo osztaly
 */
public class Worker implements Thing
{
	private Field current;			//A mezo amin a munkas epp all
    private int power;				//A munkas ereje
	private char character;		//A munkast reprezentalo karakter

	/**
	 * A munkas konstruktora
	 * @param c A karakter ami a munkas karaktere lesz
	 */
	public Worker(char c) {
		character=c;
		power=4;

	}

	/**
	 * A munkas karakteret keredezi le
	 * @return A munkas karaktere
	 */
	public char getChar(){return character;}

	/**
	 * A munkas karakteret allitja be az adott karakterre
	 * @param c A karakter
	 */
	public void setChar(char c){this.character=c;}

	/**
	 * A munkas jelenlegi mezojet allitja be
	 * @param f A mezo amit beallit
	 */
	public void SetCurrent(Field f) {
		current=f;
		f.setBackground(Color.RED);
		f.setText("W");
	}

	/**
	 * A munkas erejet keredezi le
	 * @return A munkas ereje
	 */
	public int GetPower() {return power;}

	/**
	 * Egy lada eltolja a munkast
	 * @param c A lada ami eltolja
	 * @param f A mezo amire eltolja
	 * @param d Az irany amerre eltolja
	 */
    public void PushedBy(Crate c, Field f,Direction d) {
    	f.Accept(this, d);
    }

	/**
	 * Egy munkas eltolja a munkast. Ha az aktualis jatekos tolja, akkor nem torenik semmi.
	 * @param w A munkas aki eltolja
	 * @param f A mezo amire eltolja
	 * @param d Az irany amerre eltolja
	 */
    public void PushedBy(Worker w, Field f, Direction d) {
    	if(Game.GetActualWorker()==w) {
    		return;
    	}
    	else {
    		f.Accept(this, d);
    	}
    }

	/**
	 * A munkas mezore lepeset kezeli
	 * @param f A mezo amire lep
	 * @param d Az irany amerre lep
	 */
	@Override
	public void Enters(Field f,Direction d) {
		f.Accept(this, d);
	}


	public void PushedBy(Thing t, Field f,Direction d) {}
	public void setTargetField(Field f){}
	public void Destroy() {
		current.Remove(this);
	}

}
