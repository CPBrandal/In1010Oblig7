import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Labyrint{
    int rad;
    int kol;
    Rute[][] rutene;
    public String aapninger;
    ArrayList <ArrayList<Tuppel>> endeligSti = new ArrayList<>();// potensielt [][]

    public Labyrint(String filnavn){
        this.lesFraFil(filnavn);
        this.settAlleNaboer();
    }

    public void lesFraFil(String filnavn){
        int teller = 0;
        try{
            File fil = new File("labyrinter/" + filnavn);
            try(Scanner scan = new Scanner(fil)){
                String[] storrelse = scan.nextLine().split(" ");
                rad = Integer.parseInt(storrelse[0]);
                kol = Integer.parseInt(storrelse[1]);
                rutene = new Rute[rad][kol];

                while(scan.hasNextLine()){
                    String[] biter = scan.nextLine().split("");
                    for(int i = 0; i < kol; i++){
                        if (biter[i].equals("#")){
                            rutene[teller][i] = new SortRute(teller, i, this);
                        } else if (biter[i].equals(".")){
                            if(teller == 0 || teller == rad-1 || i == 0 || i == kol-1){
                                rutene[teller][i] = new Aapning(teller, i, this);
                            } else {
                                rutene[teller][i] = new HvitRute(teller, i, this);
                            }
                        } else {
                            throw new IllegalArgumentException("Ugyldig input" + biter[i]); //Skal terminere programmet dersom det et ugyldig tall
                        }
                    }
                    teller++;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Finner ikke filen");
            System.exit(0); //Terminerer programmet dersom filen ikke finnes.
        }
    }

    public void 
    settNaboer(int rad, int kol){
        try{
            rutene[rad][kol].nord = rutene[rad-1][kol];
        } catch (IndexOutOfBoundsException e){

        }
        try{
            rutene[rad][kol].soer = rutene[rad+1][kol];
        } catch (IndexOutOfBoundsException e){

        }
        try{
            rutene[rad][kol].oest = rutene[rad][kol+1];
        } catch (IndexOutOfBoundsException e){

        }
        try{
            rutene[rad][kol].vest = rutene[rad][kol-1];
        } catch (IndexOutOfBoundsException e){

        }
    }

    public void settAlleNaboer(){
        for(int r = 0; r < rad; r++){
            for(int k = 0; k < kol; k++){
                settNaboer(r,k);
            }
        }
    }

    public void finnUtveiFra(int rad, int kol){
        aapninger = "";
        System.out.println("Utveier: ");
        ArrayList <Tuppel> tuppel = new ArrayList<>();
        rutene[rad][kol].finn(null, tuppel);
        System.out.println(this.toString());
        Rute.teller = 1;
    }

    public void settTellerTilNull(){
        for(int rd = 0; rd < rad; rd++){
            for(int kl = 0; kl < kol; kl++){
                rutene[rd][kl].tellerNull();
            }
        }
    }
    public void besoekTilFalse(){
        for(int rd = 0; rd < rad; rd++){
            for(int kl = 0; kl < kol; kl++){
                rutene[rd][kl].besoektFalse();
            }
        }
    }

    public Rute hentRute(int rad, int kol){
        return rutene[rad][kol];
    }

    public ArrayList<Tuppel> kortesteSti(){
        ArrayList<Tuppel> kortest = endeligSti.get(0);
        for(int l = 0; l < endeligSti.size(); l++){
            if(endeligSti.get(l).size() < kortest.size()){
                kortest = endeligSti.get(l);
            }
        }
        return kortest;
    }

    public String toString(){
        String streng = "Labyrint: \n";
        for(int r = 0; r < rad; r++){
            streng += "\n";
            for(int k = 0; k < kol; k++){
                if(rutene[r][k].toString().length() > 1){
                    streng += rutene[r][k].toString() + "  ";
                } else {
                    streng += rutene[r][k].toString() + "   ";
                }
            }
        }
        return streng;
    }
}