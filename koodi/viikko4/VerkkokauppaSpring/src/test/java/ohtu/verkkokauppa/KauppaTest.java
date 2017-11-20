package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Varasto varasto;
    Kauppa kauppa;
    PankkiInt pankki;
    ViitegeneraattoriInt viitegeneraattori;

    @Before
    public void setUp() {
        varasto = mock(Varasto.class);
        pankki = mock(Pankki.class);
        viitegeneraattori = mock(Viitegeneraattori.class);
        kauppa = new Kauppa(varasto, pankki, viitegeneraattori);
    }

    @Test
    public void kaupanTilimaksuaKutsuttu() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Pera", "0700123123");

        verify(pankki).tilisiirto("Pera", 5, "0700123123", "33333-44455", 2);
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
        kauppa.tilimaksu("Jori", "666");

        verify(pankki).tilisiirto("Jori", 7, "666", "33333-44455", 6);
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
        kauppa.tilimaksu("Pera", "0700123123");

        verify(pankki).tilisiirto("Pera", 5, "0700123123", "33333-44455", 2);
    }

    @Test
    public void aloitaAsiointiNollaa() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Pera", "0700123123");

        verify(pankki).tilisiirto("Pera", 5, "0700123123", "33333-44455", 2);
        when(viitegeneraattori.uusi()).thenReturn(6);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Jori", "666");
        verify(pankki).tilisiirto("Jori", 6, "666", "33333-44455", 2);
    }
    
    @Test
    public void uusiViite() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Pera", "0700123123");

        verify(pankki).tilisiirto("Pera", 5, "0700123123", "33333-44455", 2);
        when(viitegeneraattori.uusi()).thenReturn(89);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Jori", "666");
        verify(pankki).tilisiirto("Jori", 89, "666", "33333-44455", 2);
        
        when(viitegeneraattori.uusi()).thenReturn(90);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("Jori", "666");
        verify(pankki).tilisiirto("Jori", 90, "666", "33333-44455", 4);
    }
    
    @Test
    public void koristaPoisto() {
        when(viitegeneraattori.uusi()).thenReturn(5);
        when(varasto.saldo(2)).thenReturn(25);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Kalia", 2));
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.poistaKorista(2);
        kauppa.tilimaksu("Pera", "0700123123");

        verify(pankki).tilisiirto("Pera", 5, "0700123123", "33333-44455", 0);
    }
}
