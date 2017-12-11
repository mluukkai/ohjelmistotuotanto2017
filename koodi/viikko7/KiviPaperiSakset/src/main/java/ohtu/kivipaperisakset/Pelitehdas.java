package ohtu.kivipaperisakset;

public class Pelitehdas {

    public Pelitehdas() {
    }

    public static KPSPeli luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPSPeli luoTekoalypeli() {
        return new KPSTekoaly();
    }

    public static KPSPeli luoParempiTekoalypeli() {
        return new KPSParempiTekoaly();
    }
}
