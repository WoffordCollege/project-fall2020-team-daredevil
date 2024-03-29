package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class PlayerTest {

	Player p;
	private Player p1 = new Player();
    private Player p2 = new Player();
    private Player[] players;

	@Before
	public void setup() {
		p = new Player();
		players = new Player[] {p1, p2};
	}
	
	@Test
	public void testgetPCards() {
		assertThat(p.getPCards(1), is(0));
	}
	
	@Test
	public void testsetPCards() {
		p.setPCards(1);
		assertThat(p.getPCards(0), is(1));
	}
	
	@Test
	public void testgetCoins() {
		assertThat(p.getCoins(), is(3));
	}
	
	@Test
	public void testsetCoins() {
		assertThat(p.getCoins(), is(3));
		p.setCoins(1);
		assertThat(p.getCoins(), is(4));
	}
	
	@Test
	public void testCardActivationBothPlayers() {
		String a = "";
	
		a = a + "Wheat Field activated for Player 1\n" + 
			"Wheat Field activated for Player 2\n";
	
		assertThat(p.cardActivation(1, players), is(a));
	}
	
	
	@Test
	public void testCardActivationPlayer1() {
		String b = "";
	
		players[0].setPCards(1);
		assertThat(players[0].getPCards(1), is(1));
		assertThat(players[0].getPCards(2), is(0));
		b = b + "Ranch activated for Player 1\n";
	
		
		assertThat(players[1].getPCards(1), is(0));
		assertThat(p.cardActivation(2, players), is(b));
		
	}
	
	
	@Test
	public void testCardActivationPlayer2() {
		String c = "";
	
		players[1].setPCards(1);
		assertThat(players[1].getPCards(1), is(1));
		assertThat(players[1].getPCards(2), is(0));
		c = c + "Ranch activated for Player 2\n";
	
		assertThat(players[0].getPCards(1), is(0));
		assertThat(p.cardActivation(2, players), is(c));
	}

}