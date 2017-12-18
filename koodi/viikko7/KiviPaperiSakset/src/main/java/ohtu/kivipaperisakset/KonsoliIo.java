package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIo implements IO {

    private Scanner lukija;

    public KonsoliIo() {

        this.lukija = new Scanner(System.in);
    }

    @Override
    public void tulosta(String s) {
        System.out.println(s);
    }

    @Override
    public String lueSeuraava() {

        return lukija.nextLine();
    }

}
