package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {

        IO io = new KonsoliIo();
        Komennot komennot = new Komennot(io);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            String vastaus = io.lueSeuraava();
            if (!komennot.getKomennot().containsKey(vastaus)) {
                break;
            } else {
                komennot.valitsePeli(vastaus).pelaa();
            }
        }
    }
}
