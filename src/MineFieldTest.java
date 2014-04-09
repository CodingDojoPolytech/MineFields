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
	
	@Test
	public void sizeUpToNine() {
		MineField m = new MineField();
		m.setSize("99 2");
		assertEquals(new Integer(2), m.getHeigth());
		assertEquals(new Integer(99), m.getWidth());
	}

	@Test(expected=RuntimeException.class)
	public void sizeStringPourrie() {
		MineField m = new MineField();
		m.setSize(" 99 2");
	}
}
