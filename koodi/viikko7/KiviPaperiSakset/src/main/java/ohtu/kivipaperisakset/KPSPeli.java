/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author oce
 */
public abstract class KPSPeli {

    public void pelaa(Scanner scanner) {
        Tuomari tuomari = new Tuomari();
        String ekanSiirto;
        String tokanSiirto;
        while (true)  {
            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            if (!onkoOkSiirto(ekanSiirto)) {
                break;
            }
            tokanSiirto = siirto(ekanSiirto);
            System.out.println(tokanSiirto);
            if (!onkoOkSiirto(tokanSiirto)) {
                break;
            }
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
    
    protected abstract String siirto(String siirto);
}
