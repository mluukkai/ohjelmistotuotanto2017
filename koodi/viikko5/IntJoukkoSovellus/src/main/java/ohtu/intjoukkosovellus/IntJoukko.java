package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuTaulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int vapaaIndeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukuTaulukko = new int[KAPASITEETTI];
        for (int i = 0; i < lukuTaulukko.length; i++) {
            lukuTaulukko[i] = 0;
        }
        vapaaIndeksi = 0;
        this.kasvatusKoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukuTaulukko = new int[kapasiteetti];
        for (int i = 0; i < lukuTaulukko.length; i++) {
            lukuTaulukko[i] = 0;
        }
        vapaaIndeksi = 0;
        this.kasvatusKoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetin täytyy olla positiivinen "
                    + "ja kasvatuskoon täytyy olla postitiivinen");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        lukuTaulukko = new int[kapasiteetti];
        for (int i = 0; i < lukuTaulukko.length; i++) {
            lukuTaulukko[i] = 0;
        }
        vapaaIndeksi = 0;
        this.kasvatusKoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (vapaaIndeksi == 0) {
            lukuTaulukko[0] = luku;
            vapaaIndeksi++;
            return true;
        }
        return lisaaLukuTaulukkoonJosSeEiOleSiella(luku);
    }

    private boolean lisaaLukuTaulukkoonJosSeEiOleSiella(int luku) {
        if (!kuuluu(luku)) {
            lukuTaulukko[vapaaIndeksi] = luku;
            vapaaIndeksi++;
            if (vapaaIndeksi >= lukuTaulukko.length) {
                int[] valiTaulukko = new int[lukuTaulukko.length + kasvatusKoko];
                kopioiTaulukko(lukuTaulukko, valiTaulukko);
                lukuTaulukko = valiTaulukko;
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < vapaaIndeksi; i++) {
            if (luku == lukuTaulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int indeksi = -1;
        for (int i = 0; i < vapaaIndeksi; i++) {
            if (luku == lukuTaulukko[i]) {
                indeksi = i; //siis luku löytyy tuosta kohdasta :D
                lukuTaulukko[indeksi] = 0;
                break;
            }
        }

        return siirraLuvut(indeksi);
    }

    private boolean siirraLuvut(int indeksi) {
        if (indeksi != -1) {
            for (int j = indeksi; j < vapaaIndeksi - 1; j++) {
                int vanhaArvo = lukuTaulukko[j];
                lukuTaulukko[j] = lukuTaulukko[j + 1];
                lukuTaulukko[j + 1] = vanhaArvo;
            }
            vapaaIndeksi--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int getVapaaIndeksi() {
        return vapaaIndeksi;
    }

    @Override
    public String toString() {

        String tuloste = "{";
        for (int i = 0; i < vapaaIndeksi - 1; i++) {
            tuloste += lukuTaulukko[i];
            tuloste += ", ";
        }
        if (vapaaIndeksi != 0) {
            tuloste += lukuTaulukko[vapaaIndeksi - 1];
        }

        tuloste += "}";
        return tuloste;

    }

    public int[] luoTaulukko() {
        int[] taulukko = new int[vapaaIndeksi];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = lukuTaulukko[i];
        }
        return taulukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aTaulu = a.luoTaulukko();
        int[] bTaulu = b.luoTaulukko();
        lisaaTaulukkoJoukkoon(aTaulu, yhdisteJoukko);
        lisaaTaulukkoJoukkoon(bTaulu, yhdisteJoukko);
        return yhdisteJoukko;
    }

    private static void lisaaTaulukkoJoukkoon(int[] taulukko, IntJoukko joukko) {
        for (int i = 0; i < taulukko.length; i++) {
            joukko.lisaa(taulukko[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.luoTaulukko();
        int[] bTaulu = b.luoTaulukko();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkausJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkausJoukko;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.luoTaulukko();
        int[] bTaulu = b.luoTaulukko();
        lisaaTaulukkoJoukkoon(aTaulu, erotusJoukko);
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(i);
        }

        return erotusJoukko;
    }

}
