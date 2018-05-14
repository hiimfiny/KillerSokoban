package Killerproto;

/**
 * A jatek soran felmerulo dolgok interface,
 * Ezen dolgok a ladak, oszlopok, munkasok
 *  
 */
public interface Thing
{
    void PushedBy(Thing t, Field f,Direction d) ;
    void PushedBy(Worker w, Field f,Direction d) ;
    void PushedBy(Crate c, Field f,Direction d) ;
    void Enters(Field f,Direction d) ;
    char getChar();
    void SetCurrent(Field f);
    void addPoints(int p);
}
