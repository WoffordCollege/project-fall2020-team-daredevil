package edu.wofford.machiwoco; //change to class file

import org.junit.*;
//import static org.hamcrest.MatchersAssert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;


public class EstablishmentTest {
	
	private Establishment e;
	
	@Before
	public void setup() {
		e = new Establishment("Wheat Field", 1, "blue", "wheat");
	}
	
	@Test
	public void testConstructor() {
		//assertThat('N', is(e.effectModifier));
		//assertThat(Establishment.W.color(), is(Establishment.Color.Blue));
	}
	
	@Test
	public void testGetName() {
		assertThat(e.getName(), is("Wheat Field"));
	}
	
	@Test
	public void testGetCost() {
		assertThat(e.getCost(), is(1));
	}
	
	@Test
	public void testGetColor() {
		assertThat(e.getColor(), is("blue"));
	}
	
	@Test
	public void testGetIcon() {
		assertThat(e.getIcon(), is("wheat"));
	}
	
	@Test
	public void testGetActivation() {
		assertThat(e.getActivation(), is(""));
	}
	
	@Test
	public void testGetEffectType() {
		assertThat(e.getEffectType(), is(0));
	}
	
	@Test
	public void testGetEffectTarget() {
		assertThat(e.getEffectTarget(), is(0));
	}
	
	@Test
	public void testGetEffectAmount() {
		assertThat(e.getEffectAmount(), is(0));
	}
	
	@Test
	public void testGetEffectModType() {
		assertThat(e.getEffectModType(), is(0));
	}
	
	@Test
	public void testGetEffectModifier() {
		assertThat(e.getEffectModifier(), is('N'));
	}
	
	@Test
	public void testSetEffect() {
//		"effect": {
//			"type": "receive",
//			"target": "bank",
//			"amount": 1,
//			"modifierType": "none",
//			"modifier": "none"
//		}

		e.setEffect(0, 0, 1, 0, 'N');
		assertThat(e.getEffectType(), is(0));
		assertThat(e.getEffectTarget(), is(0));
		assertThat(e.getEffectAmount(), is(1));
		assertThat(e.getEffectModType(), is(0));
		assertThat(e.getEffectModifier(), is('N'));
	}

	@Test
	public void testSetName() {
		e.setName("Wheat Field");
		assertThat(e.getName(), is("Wheat Field"));
	}

	@Test
	public void testSetCost() {
		e.setCost(0);
		assertThat(e.getCost(), is(0));
	}

	@Test
	public void testSetColor() {
		e.setColor("blue");
		assertThat(e.getColor(), is("blue"));
	}
}