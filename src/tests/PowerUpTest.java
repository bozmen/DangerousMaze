package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import gameentities.Character;
import gameentities.PowerUp;
import gameentities.powerups.*;

import org.junit.Before;
import org.junit.Test;

public class PowerUpTest {

	Character c;

	@Before
	public void setUp() {
		c = new Character(0, 0, 50, 50, null, true); 
		c.setInitialPoint(new Point(0,0));
	}
	
	/*
	 * Verifies that Enlarge powerup works propery 
	 * (doubling the size of the character model)
	 */
	@Test
	public void testEnlargePowerUp() {
		Enlarge en = new Enlarge(0, 0, 4, 4, null, true);
		
		int beforeHeight = c.getHeight();
		int beforeWidth  = c.getWidth();
		c.attachPowerUp(en);
		en.activate();
		int afterHeight = c.getHeight();
		int afterWidth = c.getWidth();
		
		assertEquals(beforeHeight*2, afterHeight);
		assertEquals(beforeWidth*2, afterWidth);
	}
	
	/*
	 * Verifies that Enlarge powerup works propery 
	 * (deactivate)
	 */
	@Test
	public void testEnlargeDeactivate() {
		Enlarge en = new Enlarge(0, 0, 4, 4, null, true);
		
		int beforeHeight = c.getHeight();
		int beforeWidth  = c.getWidth();
		c.attachPowerUp(en);
		en.activate();
		en.deactivate();
		int afterHeight = c.getHeight();
		int afterWidth = c.getWidth();
		
		assertEquals(beforeHeight, afterHeight);
		assertEquals(beforeWidth, afterWidth);
	}
	
	/*
	 * Verifies that Shrink powerup works properly 
	 * (halving the size of the character model)
	 */
	@Test
	public void testShrinkPowerUp() {
		Shrink sh = new Shrink(0, 0, 4, 4, null, true);
		
		int beforeHeight = c.getHeight();
		int beforeWidth  = c.getWidth();
		c.attachPowerUp(sh);
		sh.activate();
		int afterHeight = c.getHeight();
		int afterWidth = c.getWidth();
		
		assertEquals(beforeHeight/2, afterHeight);
		assertEquals(beforeWidth/2, afterWidth);
	}
	
	/*
	 * Verifies that Shrink powerup works properly 
	 * (deactivate)
	 */
	@Test
	public void testShrinkDeactivate() {
		Shrink sh = new Shrink(0, 0, 4, 4, null, true);
		
		int beforeHeight = c.getHeight();
		int beforeWidth  = c.getWidth();
		c.attachPowerUp(sh);
		sh.activate();
		sh.deactivate();
		int afterHeight = c.getHeight();
		int afterWidth = c.getWidth();
		
		assertEquals(beforeHeight, afterHeight);
		assertEquals(beforeWidth, afterWidth);
	}

	/*
	 * Verifies that LightExpand powerup doubles the
	 * radius of the Light
	 */
	@Test
	public void testLightExpandPowerUp() {
		LightExpand le = new LightExpand(0, 0, 4, 4, null, true);
		
		int beforeRadius = c.getLight().getRadius();

		c.attachPowerUp(le);
		le.activate();
		
		int afterRadius = c.getLight().getRadius();
		
		assertEquals(beforeRadius*2, afterRadius);
	}
	
	/*
	 * Verifies that LightExpand powerup doubles the
	 * radius of the Light
	 */
	@Test
	public void testLightExpandDeactivate() {
		LightExpand le = new LightExpand(0, 0, 4, 4, null, true);
		
		int beforeRadius = c.getLight().getRadius();

		c.attachPowerUp(le);
		le.activate();
		le.deactivate();
		
		int afterRadius = c.getLight().getRadius();
		
		assertEquals(beforeRadius, afterRadius);
	}

	/*
	 * Verifies that LightNarrow PowerUp halves the
	 * radius of the Light
	 */
	@Test
	public void testLightNarrowPowerUp() {
		LightNarrow ln = new LightNarrow(0, 0, 4, 4, null, true);
		
		int beforeRadius = c.getLight().getRadius();

		c.attachPowerUp(ln);
		ln.activate();
		
		int afterRadius = c.getLight().getRadius();
		
		assertEquals(beforeRadius/2, afterRadius);
	}
	
	/*
	 * Verifies that LightNarrow powerup halves the
	 * radius of the Light (deactivate)
	 */
	@Test
	public void testLightNarrowDeactivate() {
		LightNarrow ln = new LightNarrow(0, 0, 4, 4, null, true);
		
		int beforeRadius = c.getLight().getRadius();

		c.attachPowerUp(ln);
		ln.activate();
		ln.deactivate();
		
		int afterRadius = c.getLight().getRadius();
		
		assertEquals(beforeRadius, afterRadius);
	}

	/*
	 * Verifies that Unstoppable powerup makes
	 * the character invulnerable
	 */
	@Test
	public void testUnstoppablePowerUp() {
		Unstoppable un = new Unstoppable(0, 0, 4, 4, null, true);
		
		c.attachPowerUp(un);
		un.activate();
		
		assertTrue(c.isInvulnerable());
	}	
	
	/*
	 * Verifies that Unstoppable powerup makes
	 * the character invulnerable
	 */
	@Test
	public void testUnstoppableDeactivate() {
		Unstoppable un = new Unstoppable(0, 0, 4, 4, null, true);
		
		c.attachPowerUp(un);
		un.activate();
		un.deactivate();
		
		assertFalse(c.isInvulnerable());
	}
}
