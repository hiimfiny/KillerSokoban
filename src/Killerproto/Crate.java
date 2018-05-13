package Killerproto;

import java.awt.Color;

/**
 * A lada osztalyt reprezentalja
 */
public class Crate implements Thing
{
	private Field current;			//A field amin a lada van
    private int weight;				//A lada sulya
    private char character;			//A ladat reprezentali karakter
    
	/**
	 * A lada konstruktora
	 * @param i - A lada sulyat allitja be
	 */
    public Crate(int i) {
        character = 'c';
    	weight =i;
    }

	/**
	 * Lekerdezi a lada karakteret
	 * @return a lada karaktere
	 */
	public char getChar(){return character;}

	/**
	 * Beallitja a lada karakteret
	 * @param c a karakter amire a lada karakteret allitja
	 */
    public void setChar(char c){this.character=c;}

	/**
	 * A lada jelenlegi mezojet allitja be
	 * @param f a jelenlegi mezo
	 */
	public void SetCurrent(Field f) {
	current=f;
	f.setBackground(Color.YELLOW);
	f.setText("C");
}
	/**
	 * Egy lada eltol egy masikat
	 * @param c A lada ami a jelenlegi ladat eltolja
	 * @param f A field ahova a jelenlegi ladat eltoljak
	 * @param d Az irany amerre a ladat eltoljak
	 */
    public void PushedBy(Crate c, Field f,Direction d) {
    	int change=0;
    	if(Game.GetActualWorker().GetPower()>=weight) {
    		change=weight;
    		Game.GetActualWorker().setPower(-1*change);
    		f.Accept(this, d);
    	}
    	else {
    		return;
    	}
    	Game.GetActualWorker().setPower(change);  	
    }

	/**
	 * Egy munkas eltol egy ladat.
	 * Az eltolas elott meg kell vizsgalni, hogy a munkas eleg eros-e ahhoz, hogy eltolja a ladat.
	 * Ha igen akkor megprobalja arrebblokni a ladat, ha nem akkor helyben marad
	 * @param w A ladat eltolo munkas
	 * @param f A mezo amire tolni akarja a ladat
	 * @param d Az irany amerrol tolni akarja a ladat
	 */
    public void PushedBy(Worker w, Field f, Direction d) {
    	int change=0;
    	if(Game.GetActualWorker().GetPower()>=weight) {
    		change=weight;
    		Game.GetActualWorker().setPower(-1*change);
    		f.Accept(this, d);
    	}
    	else {
    		return;
    	}
    	Game.GetActualWorker().setPower(change);
    }

	/**
	 * A lada sulyanak megnovelese, ha ragados mezore erkezik
	 * @param sf A ragados mezo amire erkezik
	 */
	public void ChangeWeight(StickyField sf) {
    	weight=3;
    }
	
	public void ChangeWeight(Field f) {
		weight=2;
	}

	/**
	 * A lada sulyanak csokkentese, ha csuszos mezore erkezik
	 * @param sf A csuszos mezo amire erkezik
	 */
	public void ChangeWeight(SlipperyField sf) {
    	weight=0;
    }

	/**
	 * Egy lada mezore "lepese"
	 * @param f A mezo amire lep
	 * @param d Az irany amerrol lep
	 */
	@Override
	public void Enters(Field f, Direction d) {
		f.Accept(this, d);
	}

	@Override
	public void PushedBy(Thing t, Field f,Direction d) {}
	public void addPoints(int p){}


}
