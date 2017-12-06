package ohtu;

public class Sovelluslogiikka {
 
    private int tulos;

    public Sovelluslogiikka() {
        this.tulos = 0;
    }
    
    
 
    public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
    
    public void setTulos(int tulos) {
        this.tulos = tulos;
    }
}