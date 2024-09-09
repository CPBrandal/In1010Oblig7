import java.util.ArrayList;

public class SortRute extends Rute {
    String tegn = "#";

    public SortRute(int rad, int kol, Labyrint lab){
        super(rad, kol, lab);
    }

    @Override
    public void finn(Rute fra, ArrayList <Tuppel> tuppel){
        return;
    }

    @Override
    public String toString(){
        return tegn;
    }

    @Override
    public String tegn(){
        return tegn;
    }
}
