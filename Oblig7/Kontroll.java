import java.util.ArrayList;

public class Kontroll {
    Labyrint lab;
    int rad;
    int kol;
    GuiLabyrint gui;

    public Kontroll(String filnavn){
        lab = new Labyrint(filnavn);
        rad = lab.rad;
        kol = lab.kol;
        gui = new GuiLabyrint(this, rad, kol);
    }

    public ArrayList<Tuppel> markerKortesteUtvei(){
        return lab.kortesteSti();
    }

    public void nullstillBesoekt(){
        lab.besoekTilFalse();
    }

    public void nullstillTeller(){
        lab.settTellerTilNull();
    }

    public void nullstillListe(){
        lab.endeligSti.clear();
    }

    public void finnUtvei(int r, int k){
        lab.finnUtveiFra(r, k);
    }
}
