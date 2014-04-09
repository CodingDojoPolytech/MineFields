import java.util.Scanner;

/**
 * Created by Loïc GAILLARD on 4/9/14.
 */
public class MineFieldsAlt {
    private int height;
    private int width;

    public char[] inputChars;
    public int[] grid;


    public MineFieldsAlt() {
        Scanner scanner = new Scanner(System.in);
        String dim = scanner.nextLine();

        setSize(dim);
        buildInputMap(scanner);

        makeGrid();

        System.out.println(convertGrid());
    }

    public void setSize(String input) {
        if(!input.matches("[1-9][0-9]* [1-9][0-9]*")) {
            throw new RuntimeException("bad format");
        }
        String s[] = input.split(" ");

        height = Integer.parseInt(s[0]);
        width = Integer.parseInt(s[1]);
    }

    public void buildInputMap(Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; ++i) {
            String line = scanner.nextLine().trim();

            if(!line.matches("[*.]{"+width+"}")) {
                throw new RuntimeException("bad format");
            }

            sb.append(line);
        }

        inputChars = sb.toString().toCharArray();
    }


    public void makeGrid() {
        grid = new int[height*width];
        for(int k = 0; k < height*width; ++k) {
            if(inputChars[k] != '*') continue;

            grid[k] = -1;
            for(int i = (k%width != 0)?-1:0; i < ((k%width != width-1)?2:1); ++i) {
                for(int j = (k>=width)?-1:0; j < ((k<width*(height-1))?2:1); ++j) {
                    int x = k+i+j*width;
                    if(x < 0 || x >= height*width) continue;
                    if(grid[x] == -1) continue;
                    ++grid[x];
                }
            }
        }
    }

    public String convertGrid() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height*width; ++i) {
            if(i > 0 && i%width == 0) {
                sb.append("\n");
            }

            if(grid[i] == -1) {
                sb.append("*");
            } else {
                sb.append(grid[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new MineFieldsAlt();
    }
}
