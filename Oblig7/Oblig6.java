import java.util.Scanner;

public class Oblig6 {
    public static void main(String[] args) {

        Labyrint lab = new Labyrint(args[0]);
        Scanner scan = new Scanner(System.in);
        boolean i = true;
        while(i){
            System.out.println("Skriv inn koordinater <rad> <kolonne>: (-1 for aa avslutte)");
            String svar = scan.nextLine();
            String biter[] = svar.split(" ");
            if(!biter[0].equals("-1")){
                try{
                Integer.parseInt(biter[0]);
                Integer.parseInt(biter[1]);
            } catch (IllegalArgumentException e){
                System.out.println("Ugyldig input, et tall må tastes inn!");
                svar = scan.nextLine();
                biter = svar.split(" ");
            }
            }
            if(svar.equals("-1")){
                i = false;
            } else if (Integer.parseInt(biter[0]) >= lab.rad || Integer.parseInt(biter[0]) < 0) {
                System.out.println("Ugyldig input");
            } else if (Integer.parseInt(biter[1]) >= lab.kol || Integer.parseInt(biter[1]) < 0) {
                System.out.println("Ugyldig input");
            } else {
                lab.finnUtveiFra(Integer.parseInt(biter[0]), Integer.parseInt(biter[1]));
            }
        }
    }
}
