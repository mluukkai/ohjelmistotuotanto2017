package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Varasto varasto;
    Kauppa kauppa;
    PankkiInt pankki;
    Viitegeneraattori viitegeneraattori;

    @Before
    public void setUp() {
        varasto = mock(Varasto.class);
        pankki = mock(Pankki.class);
        viitegeneraattori = mock(Viitegeneraattori.class);

        kauppa = new Kauppa(varasto, pankki, viitegeneraattori);
    }

//    @Test
//    public void kortiltaEiVelotetaJosRahaEiRiita() {
//        when(kortti.getSaldo()).thenReturn(4);
//        kassa.ostaLounas(kortti);
//
//        verify(kortti, times(1)).getSaldo();
//        verify(kortti, times(0)).osta(anyInt());
//    }
    @Test
    public void kaupanTilimaksunKutsuTesti() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Pertti", "8008");
        verify(pankki).tilisiirto("Pertti", 5, "8008", "33333-44455", 2);

    }

    @Test
    public void kaupanTilimaksuaKutsuttuKahdellaEriTuotteella() {
        when(viitegeneraattori.uusi()).thenReturn(7);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.saldo(3)).thenReturn(12);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "Kalliimpi kalia", 4));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("Jortikka", "8008135");

        verify(pankki).tilisiirto("Jortikka", 7, "8008135", "33333-44455", 6);
    }

    @Test
    public void kaupanTilimaksuaKutsuttuKahdellaSamallaTuotteella() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(2, "Kalliimpi kalia", 4));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("Pertti", "8008");

        verify(pankki).tilisiirto("Pertti", 5, "8008", "33333-44455", 2);
    }
    
    @Test
    public void asioinninAlussaNollaa() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Pertti", "8008");
        
        verify(pankki).tilisiirto("Pertti", 5, "8008", "33333-44455", 2);
        when(viitegeneraattori.uusi()).thenReturn(6);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Jortikka", "8008135");
        
        verify(pankki).tilisiirto("Jortikka", 6, "8008135", "33333-44455", 2);
        
    }
    
    @Test
    public void uusiViitenumero() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Pertti", "8008");
        
        verify(pankki).tilisiirto("Pertti", 5, "8008", "33333-44455", 2);
        when(viitegeneraattori.uusi()).thenReturn(6);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Jortikka", "8008135");
        
        verify(pankki).tilisiirto("Jortikka", 6, "8008135", "33333-44455", 2);
        when(viitegeneraattori.uusi()).thenReturn(7);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Jortikka", "8008135");
        
        verify(pankki).tilisiirto("Jortikka", 7, "8008135", "33333-44455", 2);
    }
    
    @Test
    public void poistaKorista() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.poistaKorista(2);
        kauppa.tilimaksu("Pertti", "8008");
        
        verify(pankki).tilisiirto("Pertti", 5, "8008", "33333-44455", 0);
    }

}
