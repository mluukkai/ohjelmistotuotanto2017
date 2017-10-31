package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = () -> {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri", "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        return players;
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void testTeam() {
        stats.team("EDM").forEach((player) -> {
            assertTrue(player.getTeam().equals("EDM"));
        });
        stats.team("PIT").forEach((player) -> {
            assertTrue(player.getTeam().equals("PIT"));
        });

    }

    @Test
    public void testEveryoneFound() {
        readerStub.getPlayers().forEach((p) -> {
            assertFalse(stats.search(p.getName()) == null);
        });
    }

    @Test
    public void topScorersAreTop() {
        List<Player> top = stats.topScorers(3);

        assertTrue(top.get(0).getName() == readerStub.getPlayers().get(4).getName());
        assertTrue(top.get(1).getName() == readerStub.getPlayers().get(1).getName());
        assertTrue(top.get(2).getName() == readerStub.getPlayers().get(3).getName());
        assertTrue(top.size() == 3);
    }

    @Test
    public void topScorersWeirdParams() {
        List<Player> top = stats.topScorers(300);
        assertTrue(top.size() == 5);
        top = stats.topScorers(-300);
        assertTrue(top.size() == 0);
        top = stats.topScorers(0);
        assertTrue(top.size() == 0);
    }

    @Test
    public void testSearch() {
        assertEquals(readerStub.getPlayers().get(2).getName(), stats.search("Kurri").getName());
        assertEquals(readerStub.getPlayers().get(0).getName(), stats.search("Semenko").getName());
        assertEquals(readerStub.getPlayers().get(0).getName(), stats.search("Semen").getName());
        assertEquals(readerStub.getPlayers().get(2).getName(), stats.search("K").getName());
        assertTrue(stats.search("Sesmenko") == null);
        assertTrue(stats.search(null) == null);

    }
}
