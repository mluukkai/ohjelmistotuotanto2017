/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author oce
 */
public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tulos = tuloskentta;
        this.syote = syotekentta;
    }

    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(this.syote.getText()));
        this.tulos.setText(""+sovellus.tulos());
    }

}
