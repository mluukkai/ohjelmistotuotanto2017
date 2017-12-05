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
public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;
    private int vanhaTulos;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tulos = tuloskentta;
        this.syote = syotekentta;
    }

    @Override
    public void suorita() {
        this.vanhaTulos = sovellus.tulos();
        try {
        sovellus.miinus(Integer.parseInt(this.syote.getText()));
        } catch (Exception e) {
            
        }
        this.tulos.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.setTulos(vanhaTulos);
        this.tulos.setText(""+this.vanhaTulos);
    }
}
