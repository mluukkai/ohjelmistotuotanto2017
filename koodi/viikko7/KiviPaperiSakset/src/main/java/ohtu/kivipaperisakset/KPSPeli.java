package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {

    private static Scanner scanner;

    public void pelaa(Scanner scanner) {
        scanner = scanner;

        Tuomari tuomari = new Tuomari();

        while (true) {

            System.out.println("Ensimmäisen pelaajan siirto: ");
            String ekanSiirto = scanner.nextLine();
            if (!onkoOkSiirto(ekanSiirto)) {
                break;
            }

            String tokanSiirto = siirto(ekanSiirto, scanner);
            System.out.println(tokanSiirto);
            if (!onkoOkSiirto(tokanSiirto)) {
                break;
            }
            System.out.println();
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String siirto(String siirto, Scanner scanner);
}
