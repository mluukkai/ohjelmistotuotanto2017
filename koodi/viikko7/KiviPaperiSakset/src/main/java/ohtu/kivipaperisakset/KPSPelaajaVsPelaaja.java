package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String siirto(String siirto) {
        System.out.println("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}
