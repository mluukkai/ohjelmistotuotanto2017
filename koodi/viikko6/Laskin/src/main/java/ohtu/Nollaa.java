package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private int viimeisinArvo;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {

        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.viimeisinArvo = 0;
    }

    @Override
    public void suorita() {
        try {
            viimeisinArvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }

        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {

        tuloskentta.setText("" + viimeisinArvo);
        viimeisinArvo = 0;
    }

}
