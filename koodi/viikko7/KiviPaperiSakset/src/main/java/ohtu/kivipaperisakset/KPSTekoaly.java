package ohtu.kivipaperisakset;

public class KPSTekoaly extends Peli {

    private IO io;
    private Tekoaly tekoaly;

    public KPSTekoaly(IO io) {

        this.io = io;
        this.tekoaly = new Tekoaly();
    }

    public String eka() {

        io.tulosta("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.lueSeuraava();
        return ekanSiirto;
    }

    public String toka() {

        String tokanSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
