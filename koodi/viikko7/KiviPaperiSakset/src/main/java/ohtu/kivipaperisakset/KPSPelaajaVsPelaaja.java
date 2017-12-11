package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    private static Scanner scanner;

    @Override
    protected String siirto(String siirto, Scanner scanner) {
        scanner = scanner;
        System.out.println("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }

}
