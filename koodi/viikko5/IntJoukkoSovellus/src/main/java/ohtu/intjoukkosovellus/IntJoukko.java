package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int kapasiteetti;
    private int kasvatuskoko;
    private int[] luvut;
    private int alkioita;

    public IntJoukko() {

        this.kapasiteetti = 5;
        alustaJoukko(kapasiteetti);
        alkioita = 0;
        this.kasvatuskoko = 5;
    }

    public IntJoukko(int kapasiteetti) {

        this.kapasiteetti = kapasiteetti;
        alustaJoukko(kapasiteetti);
        alkioita = 0;
        this.kasvatuskoko = 5;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {

        this.kapasiteetti = kapasiteetti;
        alustaJoukko(kapasiteetti);
        alkioita = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public void alustaJoukko(int kapasiteetti) {

        if (kapasiteetti < 0) {
            return;
        }

        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            luvut[alkioita] = luku;
            alkioita++;
            kasvata();
            return true;
        }
        return false;
    }

    public void kasvata() {

        if (alkioita == luvut.length) {
            int[] taulukkoOld = luvut;
            int[] uusi = kopioiTaulukko(luvut, taulukkoOld);
            luvut = new int[alkioita + kasvatuskoko];
            luvut = kopioiTaulukko(taulukkoOld, luvut);
        }
    }

    public boolean kuuluu(int luku) {

        for (int i = 0; i < alkioita; i++) {
            if (luku == luvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {

        int kohta = -1;
        for (int i = 0; i < alkioita; i++) {
            if (luku == luvut[i]) {
                kohta = i;
                break;
            }
        }
        if (kohta == -1) {
            return false;
        } else {
            siirräLukuja(kohta);
            return true;
        }
    }

    public void siirräLukuja(int kohta) {

        for (int j = kohta; j < alkioita - 1; j++) {
            luvut[j] = luvut[j + 1];
        }
        alkioita--;
    }

    private int[] kopioiTaulukko(int[] vanha, int[] uusi) {

        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
        return uusi;
    }

    public int getAlkioita() {
        return alkioita;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioita; i++) {
            tuotos += luvut[i];
            if (i != alkioita - 1) {
                tuotos += ", ";
            }
        }
        return tuotos + "}";
    }

    public int[] kokonaislukutaulukko() {
        int[] taulu = new int[alkioita];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        
        IntJoukko joukko = new IntJoukko();
        int[] aTaulu = a.kokonaislukutaulukko();
        int[] bTaulu = b.kokonaislukutaulukko();

        for (int i = 0; i < aTaulu.length; i++) {
            joukko.lisaa(aTaulu[i]);
            if (i < bTaulu.length) {
                joukko.lisaa(bTaulu[i]);
            }
        }
        return joukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {

        IntJoukko joukko = new IntJoukko();
        int[] aTaulu = a.kokonaislukutaulukko();
        int[] bTaulu = aTaulu;
        
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    joukko.lisaa(bTaulu[j]);
                }
            }
        }
        return joukko;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {

        IntJoukko joukko = new IntJoukko();
        int[] aTaulu = a.kokonaislukutaulukko();
        int[] bTaulu = aTaulu;
        
        for (int i = 0; i < aTaulu.length; i++) {
            joukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            joukko.poista(i);
        }

        return joukko;
    }

}
