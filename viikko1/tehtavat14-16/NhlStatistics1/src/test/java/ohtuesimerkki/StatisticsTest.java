
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchLoytaaPelaajanKunSeOnOlemassa() {
        assertNotNull(stats.search("Kurr"));
    }
    
    @Test
    public void searchPalauttaaNullKunPelaajaaEiOle() {
        assertNull(stats.search("Ankka"));
    }
    
    @Test
    public void teamLoytaaOikeanMaaranPelaajia() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void topScorersPalauttaaHalutunMaaranPelaajia() {
        assertEquals(4, stats.topScorers(4).size());
    }
}
