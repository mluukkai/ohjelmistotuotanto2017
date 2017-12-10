package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private ArrayList<String> history = new ArrayList<>();

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        history.add(tuloskentta.getText());
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        if (ae.getSource() == plus) {
            sovellus.plus(arvo);
        } else if (ae.getSource() == miinus) {
            sovellus.miinus(arvo);
        } else if (ae.getSource() == nollaa) {
            sovellus.nollaa();
        } else if (ae.getSource() == undo) {
            tuloskentta.setText("" + history.get(history.size() - 2));
            undo.setEnabled(false);
        }

        if (ae.getSource() != undo) {
            int laskunTulos = sovellus.tulos();

            syotekentta.setText("");
            tuloskentta.setText("" + laskunTulos);
            if (laskunTulos == 0) {
                nollaa.setEnabled(false);
            } else {
                nollaa.setEnabled(true);
            }
            undo.setEnabled(true);
        }

    }

}
