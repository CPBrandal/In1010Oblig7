import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

public class GuiLabyrint {
    int rad;
    int kol;
    private Kontroll kontroll;
    private JFrame vindu;
    private JPanel panel, top, bunn;
    private JLabel losninger;
    private JButton nullstill;
private JButton[][] ruter;

    class trykkePaaRute implements ActionListener{
        int rad;
        int kol;
        trykkePaaRute(int r, int k){
            rad = r;
            kol = k;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            fargeleggeRuter();
            kontroll.nullstillListe();
            kontroll.finnUtvei(rad, kol);
            leggTilAapninger(kontroll.lab.aapninger);
            //rekkefølge(); //For å se hvilken rekkefølge den kjører
            kontroll.nullstillTeller();
            kontroll.nullstillBesoekt();
            fargeleggSti();
        }
    }

    class nullstill implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            fargeleggeRuter();
            leggTilAapninger("");
            nullstillKnapper();
            kontroll.nullstillTeller();
            kontroll.nullstillListe();
        }
    }

    GuiLabyrint(Kontroll kon, int rad, int kol){
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e){
            System.exit(1);
        }
        kontroll = kon;
        this.rad = rad;
        this.kol = kol;
        ruter = new JButton[rad][kol];

        vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel(new BorderLayout());
        vindu.add(panel);

        top = new JPanel(new BorderLayout());
        panel.add(top, BorderLayout.NORTH);

        nullstill = new JButton("Nullstill");
        nullstill.addActionListener(new nullstill());
        top.add(nullstill, BorderLayout.EAST);

        losninger = new JLabel("Aapninger i labyrinten: ");
        top.add(losninger, BorderLayout.WEST);

        bunn = new JPanel();
        bunn.setLayout(new GridLayout(rad, kol));
        panel.add(bunn, BorderLayout.CENTER);

        for(int r = 0; r < rad; r++){
            for(int k = 0; k < kol; k++){
                JButton knapp = new JButton("");
                ruter[r][k] = knapp;
                knapp.addActionListener(new trykkePaaRute(r, k));
                bunn.add(knapp);
            }
        }

    vindu.pack();
    vindu.setSize(1100, 900);
    vindu.setLocationRelativeTo(null);
    vindu.setVisible(true);
    this.fargeleggeRuter();
    }

    public void fargeleggeRuter(){
        for(int r = 0; r < rad; r++){
            for(int k = 0; k < kol; k++){
                if(kontroll.lab.rutene[r][k].tegn().equals("#")){
                    ruter[r][k].setBackground(Color.BLACK);
                } else {
                    ruter[r][k].setBackground(Color.WHITE);
                }
            }
        }
    }

    public void leggTilAapninger(String aapning){
        losninger.setText("Aapninger i labyrinten: " + aapning);
    }

    public void nullstillKnapper(){
        for(int r = 0; r < rad; r++){
            for(int k = 0; k < kol; k++){
                    ruter[r][k].setText("");
            }
        }
    }

    public void fargeleggSti(){
        for(Tuppel p : kontroll.markerKortesteUtvei()){
            ruter[p.rad][p.kol].setBackground(Color.MAGENTA);
        }
    }

    public void rekkefølge(){
        for(int r = 0; r < rad; r++){
            for(int k = 0; k < kol; k++){
                if(!kontroll.lab.rutene[r][k].toString().equals("#")){
                    ruter[r][k].setText(kontroll.lab.rutene[r][k].toString());
                    //kontroll.lab.rutene[r][k].tellerNull(); //Setter alle tellerne til
                }
            }
        }
    }
}
