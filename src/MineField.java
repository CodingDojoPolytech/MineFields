import java.util.Arrays;

public class MineField {

	private Integer	heigth;
	private Integer	width;
	private int[][]	matrice;

	public int[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeigth() {
		return heigth;
	}

	public MineField() {

	}

	public void setSize(String size) {
		if (size.matches("[1-9][0-9]* [1-9][0-9]*")) {
			String[] split = size.split(" ");
			this.width = Integer.parseInt(split[0]);
			this.heigth = Integer.parseInt(split[1]);
		} else {
			throw new RuntimeException("bad format");
		}
		// this.width = Integer.parseInt(size.charAt(0)+"");
		// this.heigth = Integer.parseInt(size.charAt(2)+"");
	}

	public void construireGrille(String[][] matrice) {
		this.matrice = new int[matrice.length][];
		// this.matrice = Arrays.copyOf(matrice, matrice.length);
		for (int i = 0; i < this.getWidth(); i++) {
			this.matrice[i] = new int[matrice[i].length];
			for (int j = 0; j < this.getHeigth(); j++) {
				if ("*".equals(matrice[i][j])) {
					this.matrice[i][j] = -1;
				} else {
					this.matrice[i][j] = 0;
				}
			}
		}

	}

	public int getElementAt(int rows, int cols) {
		return matrice[rows][cols];
	}

	public boolean mapIsGood(String[][] matrice) {
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				if (!matrice[i][j].equals(".") && !matrice[i][j].equals("*")) {
					return false;
				}
			}
		}
		return true;

	}

	public void actualiserVoisins(int i, int j) {
		if (matrice[i][j] != -1)
			return;

		for (int x = -1; x < 2; x++) {
			if (i + x >= 0 && i + x < this.width) {
				for (int y = -1; y < 2; y++) {
					if (j + y >= 0 && j + y < this.heigth)
						if (matrice[i + x][j + y] != -1) {
							matrice[i + x][j + y]++;
						}
				}
			}
		}
	}
	
	public void complete() {
		for(int y = 0; y < heigth; ++y) {
			for(int x = 0; x < width; ++x) {
				actualiserVoisins(x, y);
			}
		}
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int y = 0; y < heigth; ++y) {
			for(int x = 0; x < width; ++x) {
				if(matrice[y][x] == -1) sb.append("*");
				else sb.append(matrice[y][x]);
			}
			if(y!= (heigth-1))
				sb.append("\n");
		}
		
		return sb.toString();
	}
}
