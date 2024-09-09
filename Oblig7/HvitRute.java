import java.util.ArrayList;

public class HvitRute extends Rute {
    String tegn = ".";
    int tell = 0;

    public HvitRute(int rad, int kol, Labyrint lab){
        super(rad, kol, lab);
    }

    @Override
    public void finn(Rute fra, ArrayList <Tuppel> tuppel){
        this.besoekt = true;
        ArrayList<Tuppel> nySti = new ArrayList<>(tuppel);
        tell = teller;
        teller++;
        Tuppel t = new Tuppel(radNr, kolNr);
        nySti.add(t);

        try{
            if(nord != fra && nord.besoekt != true){
                nord.finn(this, nySti);
            }
            if(soer != fra && soer.besoekt != true){
                soer.finn(this, nySti);
            }
            if(oest != fra && oest.besoekt != true){
                oest.finn(this, nySti);
            }
            if(vest != fra && vest.besoekt != true){
                vest.finn(this, nySti);
            }
        } catch (NullPointerException e){

        }
    }

    @Override
    public void tellerNull(){
        this.tell = 0;
    }

    @Override
    public String tegn(){
        return tegn;
    }

    @Override
    public String toString(){
        return Integer.toString(tell);
    }
}
