
package ohtu.kivipaperisakset;

public class Pelitehdas {

    public Pelitehdas() {
    }
    
    public static KPSPeli luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public static KPSPeli tekoalyaVastaan() {
        return new KPSTekoaly();
    }
    
    public static KPSPeli vaikeaaTekoalyaVastaan() {
        return new KPSParempiTekoaly();
    }
}
