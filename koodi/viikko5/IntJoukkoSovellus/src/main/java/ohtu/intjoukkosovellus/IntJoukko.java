package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuTaulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int vapaaIndeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this.lukuTaulukko = new int[KAPASITEETTI];
        for (int i = 0; i < this.lukuTaulukko.length; i++) {
            this.lukuTaulukko[i] = 0;
        }
        this.vapaaIndeksi = 0;
        this.kasvatusKoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        this.lukuTaulukko = new int[kapasiteetti];
        for (int i = 0; i < this.lukuTaulukko.length; i++) {
            this.lukuTaulukko[i] = 0;
        }
        this.vapaaIndeksi = 0;
        this.kasvatusKoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetin täytyy olla positiivinen");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon täytyy olla positiivinen");//heitin vaan jotain :D
        }
        this.lukuTaulukko = new int[kapasiteetti];
        for (int i = 0; i < this.lukuTaulukko.length; i++) {
            this.lukuTaulukko[i] = 0;
        }
        this.vapaaIndeksi = 0;
        this.kasvatusKoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (this.vapaaIndeksi == 0) {
            this.lukuTaulukko[0] = luku;
            this.vapaaIndeksi++;
            return true;
        }

        return lisaaOlemassaOlevaanTaulukkoon(luku);
    }

    public boolean lisaaOlemassaOlevaanTaulukkoon(int luku) {
        if (!kuuluu(luku)) {
            this.lukuTaulukko[this.vapaaIndeksi] = luku;
            this.vapaaIndeksi++;
            if (this.vapaaIndeksi >= this.lukuTaulukko.length) {
                int[] valiTaulukko = new int[this.lukuTaulukko.length + this.kasvatusKoko];
                kopioiTaulukko(this.lukuTaulukko, valiTaulukko);
                this.lukuTaulukko = valiTaulukko;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < this.vapaaIndeksi; i++) {
            if (luku == this.lukuTaulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int indeksi = -1;
        for (int i = 0; i < this.vapaaIndeksi; i++) {
            if (luku == this.lukuTaulukko[i]) {
                indeksi = i; //siis luku löytyy tuosta kohdasta :D
                this.lukuTaulukko[indeksi] = 0;
                break;
            }
        }

        return siirraLuvut(indeksi);
    }

    public boolean siirraLuvut(int indeksi) {
        if (indeksi != -1) {
            for (int j = indeksi; j < this.vapaaIndeksi - 1; j++) {
                int vanhaArvo = this.lukuTaulukko[j];
                this.lukuTaulukko[j] = this.lukuTaulukko[j + 1];
                this.lukuTaulukko[j + 1] = vanhaArvo;
            }
            this.vapaaIndeksi--;
            return true;
        } else {
            return false;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int getAlkioidenLkm() {
        return this.vapaaIndeksi;
    }

    @Override
    public String toString() {

        String tuloste = "{";
        for (int i = 0; i < this.vapaaIndeksi - 1; i++) {
            tuloste += this.lukuTaulukko[i];
            tuloste += ", ";
        }
        if (this.vapaaIndeksi > 0) {
            tuloste += this.lukuTaulukko[this.vapaaIndeksi - 1];
        }
        tuloste += "}";
        return tuloste;

    }

    public int[] luoTaulukko() {
        int[] taulukko = new int[this.vapaaIndeksi];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = this.lukuTaulukko[i];
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
