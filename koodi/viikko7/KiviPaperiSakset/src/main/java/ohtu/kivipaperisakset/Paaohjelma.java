package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static Pelitehdas pelitehdas = new Pelitehdas();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            KPSPeli peli;
            if (vastaus.endsWith("a")) {
                peli = pelitehdas.luoKaksinpeli();
            } else if (vastaus.endsWith("b")) {
                peli = pelitehdas.tekoalyaVastaan();
            } else if (vastaus.endsWith("c")) {
                peli = pelitehdas.vaikeaaTekoalyaVastaan();
            } else {
                break;
            }
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            System.out.println("");
            peli.pelaa(scanner);
        }

    }
}
