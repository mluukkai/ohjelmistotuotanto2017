package ohtu.kivipaperisakset;

import java.util.HashMap;

public class Komennot {

    private HashMap<String, Peli> komennot;

    public Komennot(IO io) {

        komennot = new HashMap<>();
        komennot.put("a", new KPSPelaajaVsPelaaja(io));
        komennot.put("b", new KPSTekoaly(io));
        komennot.put("c", new KPSParempiTekoaly(io));
    }

    public HashMap<String, Peli> getKomennot() {

        return komennot;
    }

    public Peli valitsePeli(String nimi) {

        return komennot.get(nimi);
    }
}
