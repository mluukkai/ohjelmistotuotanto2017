package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPSPeli {

    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String siirto(String siirto) {
        System.out.print("Tietokone valitsi: ");
        return tekoaly.annaSiirto();
    }
}