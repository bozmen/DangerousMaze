package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import gameentities.Character;
import gameentities.PowerUp;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
	
	Character c;

	@Before
	public void setUp() {
		c = new Character(0, 0, 50, 50, null, true); 
		c.setInitialPoint(new Point(0,0));
	}
	
	/*
	 * Verifies that if a character overlaps with given 
	 * point in the screen that it actually overlaps.
	 */
	@Test
	public void testContains() {
		Point p = new Point(25, 25);
		
		boolean isContained = c.contains(p);
		assertTrue(isContained);
	}
	
	/*
	 * Verifies that if a character overlaps with given 
	 * point in the screen that it actually does not
	 * overlap.
	 */
	@Test
	public void testNotContains() {
		Point p = new Point(75, 75);
		
		boolean isContained = c.contains(p);
		assertFalse(isContained);
	}
	
	/*
	 * Verifies that setSize() method updates the Character
	 * model with proper values.
	 */
	@Test
	public void testSetProperSize() {
		c.setSize(100, 100);
		
		assertEquals(100, c.getHeight());
		assertEquals(100, c.getWidth());
	}
	
	/*
	 * Verifies that setSize() method DOES NOT update the 
	 * Character model with wrong values (negative).
	 */
	@Test
	public void testSetWrongSize() {
		c.setSize(-43, -2);
		
		assertEquals(50, c.getHeight());   // It's height is same with its initial height.
		assertEquals(50, c.getWidth());    // It's width is same with its initial width.
	}
	
	/*
	 * Verifies that moveTo() method works properly.
	 */
	@Test
	public void testMoveTo() {
		int x = 54;
		int y = 87;
		c.moveTo(x, y);
		
		assertEquals(x, c.getX());
		assertEquals(y, c.getY());
	}
	
	/*
	 * Verifies that attaching a powerup works properly
	 * by counting the powerups the Character currently has.
	 */
	@Test
	public void testPowerUpAttach() {
		PowerUp p1 = new PowerUp(0, 0, 4, 4, null, true);
		PowerUp p2 = new PowerUp(0, 0, 4, 4, null, true);
		PowerUp p3 = new PowerUp(0, 0, 4, 4, null, true);
		
		c.attachPowerUp(p1);
		c.attachPowerUp(p2);
		c.attachPowerUp(p3);
		
		List<PowerUp> powerUps = c.getPowerUps();
		
		assertEquals(3, powerUps.size());
	}
	
	/*
	 * Verifies if update() method of character properly
	 * updates the light of the character
	 */
	@Test
	public void testCharacterUpdateLight() {
		int x = 70;
		int y = 19;
		c.moveTo(x, y);
		c.update();
		
		int lightX = c.getLight().getX();
		int lightY = c.getLight().getY();
		
		assertEquals(x, lightX);
		assertEquals(y, lightY);
	}
	
	/*
	 * Verifies if update() method of character properly
	 * updates the powerups (durations)
	 */
	@Test
	public void testUpdateDurationOfPowerUps() {
		PowerUp p1 = new PowerUp(0, 0, 4, 4, null, true); // initial duration is 500
		
		c.attachPowerUp(p1);
		c.update(); // this activates the powerup
		c.update(); // this decreases the duration of powerup by one tick
		
		assertEquals(499, p1.getDuration());
	}
	
	/*
	 * Verifies if update() method of character properly
	 * updates the powerups (deletions)
	 */
	@Test
	public void testUpdateDeletionOfPowerUps() {
		PowerUp p1 = new PowerUp(0, 0, 4, 4, null, true);
		
		p1.setDuration(0);     // this should be destroyed after an update
		c.attachPowerUp(p1);
		c.update();
		
		assertEquals(0, c.getPowerUps().size());
	}

	

}