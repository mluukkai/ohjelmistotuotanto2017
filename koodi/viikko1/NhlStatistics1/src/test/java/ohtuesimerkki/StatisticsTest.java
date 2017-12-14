/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author mcparni
 */
public class StatisticsTest {
	
	Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
			players.add(new Player("Sidney Crosby", "PIT", 36, 68));
            players.add(new Player("Ryan Getzlaf", "ANA", 31, 56));
            players.add(new Player("Claude Giroux", "PHI", 28, 58));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
	
	@Test
    public void testaaLoytyykoPelaaja() {
		Player player = stats.search("Sidney Crosby");
        assertEquals("Sidney Crosby", player.getName());
		Player player2 = stats.search("Jorma");
		assertEquals(null, player2);
		
    }
	
	@Test
    public void testaaLoytyykoJoukkue() {
		String teamName = "PIT";
		List<Player> players = stats.team(teamName);
		int count = players.size();
		assertNotEquals(0,count);
	}
	
	@Test
    public void parhaatMaalintekijat() {
		List<Player> player = stats.topScorers(0);
		int count = player.size();
		assertNotEquals(0,count);
	}
	
}
