package ohtu.kivipaperisakset;

public abstract class Peli {

    Tuomari tuomari;

    public Peli() {

        this.tuomari = new Tuomari();
    }

    void pelaa() {

        String ekanSiirto = eka();
        String tokanSiirto = toka();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tilanne() + "\n");
            ekanSiirto = eka();
            tokanSiirto = toka();
        }

        System.out.println(lopeta());

    }

    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    String tilanne() {

        return tuomari.toString();
    }

    abstract String eka();

    abstract String toka();

    public String lopeta() {

        return "\n" + "Kiitos!\n" + tilanne();
    }
}
