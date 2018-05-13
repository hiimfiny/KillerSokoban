package Killerproto;

public interface Thing
{
    public void PushedBy(Thing t, Field f,Direction d) ;
    public void PushedBy(Worker w, Field f,Direction d) ;
    public void PushedBy(Crate c, Field f,Direction d) ;
    public void Enters(Field f,Direction d) ;
    public char getChar();
    public void SetCurrent(Field f);
    //public void setTargetField(Field f);

}
