package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {

    private IO io;

    KPSPelaajaVsPelaaja(IO io) {

        this.io = io;
    }

    @Override
    String eka() {

        io.tulosta("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.lueSeuraava();
        return ekanSiirto;
    }

    @Override
    String toka() {

        io.tulosta("Toisen pelaajan siirto: ");
        String tokanSiirto = io.lueSeuraava();
        return tokanSiirto;
    }
}
