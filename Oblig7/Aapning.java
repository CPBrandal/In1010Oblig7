import java.util.ArrayList;

public class Aapning extends HvitRute {
    //aapning er definert som en hvit rute med mindre enn 4 naboer.
    String tegn = "*";
    int tell = 0;
    int losningsnr = 0;

    public Aapning(int rad, int kol, Labyrint lab){
        super(rad, kol, lab);
    }

    @Override
    public void finn(Rute fra, ArrayList <Tuppel> tuppel){
        this.besoekt = true;
        String sti = "Utvei: ";
        ArrayList<Tuppel> ferdigSti = new ArrayList<>(tuppel);
       
        tell = teller;
        System.out.println("(" + this.radNr + "," +this.kolNr+")");
        teller++;
        this.lab.aapninger += " " + koordinater() + " ";

        Tuppel t = new Tuppel(radNr, kolNr);
        ferdigSti.add(t);
        for(Tuppel tup : ferdigSti){
            sti += tup.toString() + " -> ";
        }
        // sti.replace(" -> ", "");
        System.out.println(sti);
        if(!lab.endeligSti.contains(ferdigSti)){
            lab.endeligSti.add(ferdigSti);    
        }
        this.besoekt = false;
        // for(Tuppel tup : ferdigSti){
        //     lab.hentRute(tup.rad, tup.kol).besoektFalse();
        // }
    }

    @Override
    public void tellerNull(){
        this.tell = 0;
    }

    @Override
    public String tegn(){
        return tegn;
    }

    public String koordinater(){
        return "(" + this.radNr + "," + this.kolNr + ")";
    }

    @Override
    public String toString(){
        return Integer.toString(tell);
    }
}
