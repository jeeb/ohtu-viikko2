package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jeeb on 23.3.2014.
 */
public class StatisticsTest {

    Statistics stats;

    // Stub reader to make the tests not need networking
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void initializeStatistics() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void testGettingPlayers() {
        List<Player> derplist = readerStub.getPlayers();

        assertFalse(derplist.isEmpty());
        assertTrue(derplist.size() == 5);
    }

    @Test
    public void testFindingAvailablePlayer() {
        Player player = stats.search("Kurri");

        assertNotNull(player);
    }

    @Test
    public void testFindingUnavailablePlayer() {
        Player player = stats.search("Le Doge");

        assertNull(player);
    }

    @Test
    public void testGettingAvailableTeam() {
        List<Player> derplist = stats.team("EDM");

        assertTrue(derplist.size() == 3);
    }

    @Test
    public void testGettingTopScorers() {
        int this_many = 5;

        // seems to return n+1 players, thus five
        List<Player> derplist = stats.topScorers(this_many - 1);

        assertTrue(derplist.size() == this_many);

        // correct order for top five scorers
        String[] derpnames = {"Gretzky", "Lemieux", "Yzerman", "Kurri", "Semenko"};

        int i = 0;
        for(Player player : derplist) {
            assertTrue(player.getName() == derpnames[i]);
            i++;
        }
    }
}
