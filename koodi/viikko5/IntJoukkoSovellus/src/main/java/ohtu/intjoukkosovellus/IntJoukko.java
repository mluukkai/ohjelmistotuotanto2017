package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko = OLETUSKASVATUS;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        alustaLukuJono();
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti > 0) {
            ljono = new int[kapasiteetti];
            alustaLukuJono();
        }

    }

    public void alustaLukuJono() {
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//error
        }
        ljono = new int[kapasiteetti];
        alustaLukuJono();
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaLuku(int luku) {

        int eiOle = 0;
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        }

        if (!etsi(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                int[] taulukkoOld = new int[ljono.length];
                taulukkoOld = ljono;
                kopioiTaulukko(ljono, taulukkoOld);
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }
            return true;
        }
        return false;
    }

    public boolean etsi(int luku) {

        for (int i : ljono) {
            if (luku == i) {
                return true;
            }
        }

        return false;
    }

    public boolean poista(int luku) {
        
        for (int i : ljono) {
            if(i == luku){
                i = 0;
            }
        }
        
        
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                ljono[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = ljono[j];
                ljono[j] = ljono[j + 1];
                ljono[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i];
                tuotos += ", ";
            }
            tuotos += ljono[alkioidenLkm - 1] + "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaaLuku(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaaLuku(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }

        return z;
    }

}
