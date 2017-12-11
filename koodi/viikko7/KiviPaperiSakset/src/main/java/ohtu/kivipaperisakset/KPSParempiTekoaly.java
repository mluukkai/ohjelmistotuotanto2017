package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPSPeli {

    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String siirto(String siirto) {
        this.tekoaly.asetaSiirto(siirto);
        System.out.print("Tietokone valitsi: ");
        return this.tekoaly.annaSiirto();
    }
}
