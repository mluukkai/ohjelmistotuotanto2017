package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String siirto(String siirto, Scanner scanner) {
        System.out.print("Tietokone valitsi: ");
        return tekoaly.annaSiirto();
    }
}