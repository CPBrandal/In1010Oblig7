public class Tuppel{
    int rad;
    int kol;

    Tuppel(int rad, int kol){
        this.rad = rad;
        this.kol = kol;
    }

    public String toString(){
        return "(" + rad + "," + kol + ")";
    }
}