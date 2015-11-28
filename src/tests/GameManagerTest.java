package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gamemanagement.gamelogic.GameManager;
import gameentities.GameObject;
import gameentities.PowerUp;

public class GameManagerTest {

	GameManager gm;
	List<GameObject> goList;
	
	@Before
	public void setUp() throws Exception {
		goList = new ArrayList<GameObject>();
		gm = new GameManager(goList);
		
		PowerUp p1 = new PowerUp(0, 0, 4, 4, null, true);
		PowerUp p2 = new PowerUp(0, 0, 4, 4, null, true);
		PowerUp p3 = new PowerUp(0, 0, 4, 4, null, true);
		PowerUp p4 = new PowerUp(0, 0, 4, 4, null, true);
		
		goList.add(p1);
		goList.add(p2);
		goList.add(p3);
		goList.add(p4);
		
		p1.destroy();
		p3.destroy();
		p4.destroy();  // Only one object should be left after removeDestroy() call
	}

	@Test
	public void testDeletionOfDestroyedObjects() {
		
		gm.removeDestroyed();
		
		assertEquals(1, goList.size());
	}

}
