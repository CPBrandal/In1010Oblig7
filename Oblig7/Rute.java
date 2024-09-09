import java.util.ArrayList;

abstract public class Rute {
    String tegn = "";
    int radNr;
    int kolNr;
    Labyrint lab;
    Rute nord = null;
    Rute soer = null;
    Rute oest = null;
    Rute vest = null;
    public int tell = 0;
    static int teller = 1;
    boolean besoekt = false;

    public Rute(int radNr, int kolNr, Labyrint labyrint){
        this.radNr = radNr;
        this.kolNr = kolNr;
        lab = labyrint;

    }


    public void finn(Rute fra, ArrayList <Tuppel> tuppel){
        try{
            if(nord != fra){
                nord.finn(this, tuppel);
                System.out.println("j");
            }
            if(soer != fra){
                soer.finn(this, tuppel);
                System.out.println("c");
            }
            if(oest != fra){
                oest.finn(this, tuppel);
                System.out.println("b");
            }
            if(vest != fra){
                vest.finn(this, tuppel);
                System.out.println("a");
            }
        } catch (NullPointerException e){

        }
    }

    public void besoektFalse(){
        this.besoekt = false;
    }

    public void tellerNull(){
        this.tell = 0;
    }

    public String tegn(){
        return tegn;
    }

    public String toString(){
        return "Rad: " + radNr + "Kol: " + kolNr + "Labyrint: " +  lab;
    }
}
