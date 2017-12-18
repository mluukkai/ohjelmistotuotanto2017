package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends Peli {

    private IO io;
    private TekoalyParannettu tekoaly;

    KPSParempiTekoaly(IO io) {

        this.io = io;
        this.tekoaly = new TekoalyParannettu(20);
    }

    @Override
    String eka() {

        io.tulosta("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.lueSeuraava();
        return ekanSiirto;
    }

    @Override
    String toka() {

        String tokanSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
