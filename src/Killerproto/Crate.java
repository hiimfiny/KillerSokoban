package Killerproto;

/**
 * A lada osztalyt reprezentalja
 */
public class Crate implements Thing
{
	private Field current;			//A field amin a lada van
    private Field target;			//A field ahova a ladának el kell érnie
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
	}

	/**
	 * A lada cel mezojet allitja be
	 * @param f a mezo ahova a ladat el kell juttatni
	 */
	public void setTargetField(Field f) {target=f;}

	/**
	 * Lekerdezi a lada cel mezojet
	 * @return a lada cel mezoje
	 */
	public Field getTargetField() {return target;}

	/**
	 * Egy lada eltol egy masikat
	 * @param c A lada ami a jelenlegi ladat eltolja
	 * @param f A field ahova a jelenlegi ladat eltoljak
	 * @param d Az irany amerre a ladat eltoljak
	 */
    public void PushedBy(Crate c, Field f,Direction d) {
    	f.Accept(this,d);    	
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
    	if(Game.GetActualWorker().GetPower()>weight) {
    		f.Accept(this, d);
    	}
    	else {
    		System.out.println("Push failed");
    		return;
    	}
    }

	/**
	 * A lada sulyanak megnovelese, ha ragados mezore erkezik
	 * @param sf A ragados mezo amire erkezik
	 */
	public void ChangeWeight(StickyField sf) {
    	weight=5;
    	System.out.println("Crates weight increased");
    }

	/**
	 * A lada sulyanak csokkentese, ha csuszos mezore erkezik
	 * @param sf A csuszos mezo amire erkezik
	 */
	public void ChangeWeight(SlipperyField sf) {
    	weight=1;
    	System.out.println("Crates weight decreased");
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


}
