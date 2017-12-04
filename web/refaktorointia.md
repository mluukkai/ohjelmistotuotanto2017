Esimerkkiratkaisuja viikon 5 refaktorointitehtäviin

## IntJoukko

Eräs ratkaisu seuraavassa

```java
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, 
                            OLETUSKASVATUS = 5;  

    private int kasvatuskoko;    
    private int alkioidenLkm;  
    private int[] joukko;      
  
    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        validoiParametrit(kapasiteetti, kasvatuskoko);

        joukko = new int[kapasiteetti];
        for (int i = 0; i < joukko.length; i++) {
            joukko[i] = 0;
        }

        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    private void validoiParametrit(int kapasiteetti, int kasvatuskoko1) throws IndexOutOfBoundsException {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko1 < 0) {
            throw new IndexOutOfBoundsException("kasvatuskoko ei saa olla negatiivinen");
        }
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        
        if (eiTilaa()) {
            kasvataTalukkoa();
        }
        
        joukko[alkioidenLkm] = luku;
        alkioidenLkm++;

        return true;
    }

    public int paikka(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean kuuluu(int luku) {
        return paikka(luku) != -1;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }

        tiivistaAlkaenKohdasta(paikka(luku));
        alkioidenLkm--;

        return true;
    }

    private boolean eiTilaa() {
      return alkioidenLkm % joukko.length == 0;
    }

    private void tiivistaAlkaenKohdasta(int paikka) {
        for (int i = paikka; i < alkioidenLkm - 1; i++) {
            joukko[i] = joukko[i + 1];
        }
    }

    private void kasvataTalukkoa() {
        int[] uusi = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(joukko, uusi);
        joukko = uusi;
    }
        
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
            String tuotos = "";
            
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += joukko[i] + ", ";
            }
            
            tuotos += alkioidenLkm > 0 ? joukko[alkioidenLkm - 1] : "";

            return "{" + tuotos + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        
        for (int luku : a.toIntArray()) {
            yhdiste.lisaa(luku);
        }
        
        for (int luku : b.toIntArray()) {
            yhdiste.lisaa(luku);
        }
        
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        
        for (int luku : a.toIntArray()) {
             if ( b.kuuluu(luku)) {
                leikkaus.lisaa(luku);
            }               
        }
          
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();

        for (int luku : a.toIntArray()) {
             if ( !b.kuuluu(luku)) {
                erotus.lisaa(luku);
            }               
        }        
        
        return erotus;
    }

}
```

Muutama huomio:
* Useissa näkemissäni ratkaisuissa oli unohdettu hyödyntää yksinkertaisimmissa konstruktoreissa kaksiparametrista konstruktoria
* Metodit _kuuluu_ ja _posta_ joutuvat molemmat etsimään löytyykö tietty alkio jokuosta. Yhteinen logiikka kannattaa eristää metodiin, yllä nimeltään _paikka_, joka etsii tietyn alkion paikan taulukosta.
* Joukko-operaatioiden toteuttamisessa kannattaa huomioida se, että joukkojen metodi _toIntArray_ mahdollistaa alkioiden iteroimisen 'for each'-tyylillä. Näin vältytään ikävältä indeksittäiseltä taulukon läpikäynniltä.

## Tennis

Tennis tarjoaa kenties suuremman mahdollisuuden erilaisia perusteltuja refaktorointeja kuin IntJoukko. Alla eräs versio:

```java
package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private final String player1;
    private final String player2;
    private Map<Integer, String> numberToScore = new HashMap<>();
    
    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        numberToScore.put(0, "Love");
        numberToScore.put(1, "Fifteen");
        numberToScore.put(2, "Thirty");
        numberToScore.put(3, "Forty");
    }

    public void wonPoint(String player) {
        if (player.equals(player1)) {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }

    public String getScore() {
        if (isEven()) {
            return evenScore();
        } else if (isPossibleWin()) {
            return possibleWinScore();
        }

        return leadScore();
    }

    private boolean isEven() {
        return score1 == score2;
    }

    private boolean isPossibleWin() {
        return score1 >= 4 || score2 >= 4;
    }
    
    private String evenScore() {  
        if ( score1>3) {
            return "Deuce";
        }
        return numberToScore.get(score1)+"-All";
    }
    
    private String possibleWinScore() {
        String better = score1 > score2 ? player1 : player2;
        String result =  Math.abs(score1 - score2) > 1 ?  "Win for" : "Advantage";
        
        return result + " "+ better;
    }
    
    private String leadScore() {
        return numberToScore.get(score1)+"-"+numberToScore.get(score2);
    }    
}

```
