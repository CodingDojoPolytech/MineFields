import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MineFieldTest {
	private MineField minefield;

	@Before
	public void initialize()
	{
		minefield = new MineField();
	}
	
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
	
	@Test
	public void construireGrilleTest()
	{
		assertNull(minefield.getMatrice());
		String[][] matrice = {{"."}};
		minefield.setSize("1 1");
		minefield.construireGrille(matrice);
		assertNotNull(minefield.getMatrice());
	}
	
	@Test
	public void getElementAt() {
		String[][] matrice = {{"*"}};
		minefield.setSize("1 1");
		minefield.construireGrille(matrice);
		
		assertEquals(-1, minefield.getElementAt(0,0));
	}
	
	@Test
	public void mapIsGood(){
		String[][] matrice = {{"b"}};
		assertEquals(false, minefield.mapIsGood(matrice));
	}
	@Test
	public void construireGrilleMines(){
		String[][] matrice = {{"*"}};
		minefield.setSize("1 1");
		minefield.construireGrille(matrice);
		assertEquals(-1,minefield.getElementAt(0,0));
	}
	
	@Test
	public void actualiserVoisins(){
		int[][] tabTest={{0,-1,0},{0,0,0},{0,0,0}};
		int[][] tabExpect={{1,-1,1},{1,1,1},{0,0,0}};
		minefield.setMatrice(tabTest);
		minefield.setSize("3 3");
		minefield.actualiserVoisins(0,1);
		assertEquals(1,minefield.getElementAt(0, 0));
		
	}
	
	@Test
	public void testToString() {
		String[][] matrice = {{".","*","."},{".",".","."},{".",".","."}};
		String result = "1*1\n111\n000";
		minefield.setSize("3 3");
		
		minefield.construireGrille(matrice);
		
		minefield.complete();
		System.out.println(minefield.toString());
		assertEquals(result, minefield.toString());
	}
	
	@Test
	public void constructorTest() {
		String[][] matrice = {{".","*","."},{".",".","."},{".",".","."}};
		String result = "1*1\n111\n000";
		MineField m = new MineField(matrice);
		assertEquals(result,m.toString());
	}
	
}
