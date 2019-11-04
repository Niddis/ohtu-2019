package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
        
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
        
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
    stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajaLoytyyListasta() {
        Player pelaaja = stats.search("Kurri");
        
        assertEquals("Kurri", pelaaja.getName());
    }
    
    @Test
    public void pelaajaaEiLoydyListalta() {
        Player pelaaja = stats.search("Koivu");
        
        assertEquals(null, pelaaja);
    }
    
    @Test
    public void joukkueessaOikeaMaaraPelaajia() {
        List<Player> joukkue = stats.team("EDM");
        
        assertEquals(3, joukkue.size());
    }
    
    @Test
    public void joukkueessaOikeatPelaajat() {
        List<Player> joukkue = stats.team("PIT");
        
        assertEquals("Lemieux", joukkue.get(0).getName());
    }
    
    @Test
    public void topScorersPalauttaaOikeanMaaranPelaajia() {
        List<Player> pelaajat = stats.topScorers(3);
        
        assertEquals(3, pelaajat.size());
    }
    
    @Test
    public void topScorersPalauttaaOikeatPelaajat() {
        List<Player> pelaajat = stats.topScorers(1);
        
        assertEquals("Gretzky", pelaajat.get(0).getName());
    }
}
