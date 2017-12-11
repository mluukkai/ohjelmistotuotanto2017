package ohtu.kivipaperisakset;

import java.util.Scanner;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSPeli {
    
    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String siirto(String siirto, Scanner scanner) {
        tekoaly.asetaSiirto(siirto);
        System.out.print("Tietokone valitsi: ");
        return this.tekoaly.annaSiirto();
    }

}
