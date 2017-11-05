/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void hakuOnnistuu() {
        Player player = stats.search("Lemieux");
        assertEquals("Lemieux", player.getName());
    }

    @Test
    public void hakuEpaonnistuu() {
        Player player = stats.search("Hasek");
        assertEquals(null, player);
    }

    @Test
    public void oikeanKokoinenLista() {
        List<Player> joukkueenpelaajat = stats.team("EDM");
        assertEquals(3, joukkueenpelaajat.size());
        List<Player> joukkueenpelaajat2 = stats.team("PIT");
        assertEquals(1, joukkueenpelaajat2.size());
    }

    @Test
    public void oikeaPelaajaListalla() {
        List<Player> joukkueenpelaajat = stats.team("DET");
        assertEquals(stats.search("Yzerman"), joukkueenpelaajat.get(0));
    }

 
//    @Test
//    public void oikeanKokoinenScorerLista() {
//        assertEquals(2, stats.topScorers(2).size());
//    }

    @Test
    public void oikeaParasScoraaja() {
        List<Player> scoraajat = stats.topScorers(3);
        assertEquals(stats.search("Gretzky"), scoraajat.get(0));
    }

}
