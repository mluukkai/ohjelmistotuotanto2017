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
 * @author twviiala
 */
public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;
    private int vanhaTulos;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tulos, JTextField syote) {
        this.sovellus = sovellus;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void suorita() {
        vanhaTulos = sovellus.tulos();
        sovellus.nollaa();

        asetaTekstikenttaTulos();
    }

    private void asetaTekstikenttaTulos() {
        this.tulos.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.setTulos(vanhaTulos);
        asetaTekstikenttaTulos();
    }

}
