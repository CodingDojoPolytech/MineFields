import static org.junit.Assert.*;

import org.junit.Test;


public class MineFieldTest {

	
	@Test
	public void size(){
		
		MineField mine = new MineField();
		mine.setSize("4 3");
		assertEquals(new Integer(3), mine.getHeigth());
		assertEquals(new Integer(4), mine.getWidth());
		
	}
}
