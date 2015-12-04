import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by ifan on 03/12/2015.
 */
public class Board extends JFrame {
    private final static int BOARD_SIZE = 10;
    private static Tile boardTile[][];
    private Random rnd = new Random();
    private int numOfBombs = 10;


    public Board() {

        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boardTile = new Tile[BOARD_SIZE][BOARD_SIZE];
        placeMines();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                makingBoard(i, j);

            }
        }
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        for (int i = 0; i <= BOARD_SIZE - 1; i++) {
            for (int j = 0; j <= BOARD_SIZE - 1; j++) {
                if (getTile(i, j) != null) {
                    System.out.println("tile is not null");
                    if (!getTile(i, j).getIsMine()) {
                        System.out.println("tile is not a mine");
                        if (i != BOARD_SIZE -1) {
                            System.err.println(i + " " + j);
                            giveSquaresValues(i + 1, j, i, j);
                        }
                        if (i != BOARD_SIZE -1 && j != BOARD_SIZE -1) {
                            giveSquaresValues(i + 1, j + 1, i, j);
                        }
                        if (j != BOARD_SIZE -1) {
                            giveSquaresValues(i, j + 1, i, j);
                        }
                        if (i != 0 && j != BOARD_SIZE -1) {
                            giveSquaresValues(i - 1, j + 1, i, j);
                        }
                        if (i != 0) {
                            giveSquaresValues(i - 1, j, i, j);
                        }
                        if (i != 0 && j != 0) {
                            giveSquaresValues(i - 1, j - 1, i, j);
                        }
                        if (j != 0) {
                            giveSquaresValues(i, j - 1, i, j);
                        }
                        if (i != BOARD_SIZE -1 && j != 0) {
                            giveSquaresValues(i + 1, j - 1, i, j);
                        }
                    }
                }
            }
        }
        setVisible(true);

    }

    public static int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    public static void main(String[] args) {
        Board board = new Board();

    }

    public void giveSquaresValues(int x, int y, int z, int a) {
        System.out.println("checking surrounding tiles");
        if (getTile(x, y) != null) {
            System.out.println("checking if any are mines");
            if (getTile(x, y).getIsMine()) {
                Square s = (Square) getTile(z, a);
                s.increaseMineCount();
                s.repaint();
                System.out.println("updating mine");
            }
        }
    }

    public static Tile getTile(int x, int y) {
        return boardTile[x][y];
    }

    public void placeMines() {
        for (int i = 0; i < numOfBombs; i++) {

            int x = rnd.nextInt(BOARD_SIZE);
            int y = rnd.nextInt(BOARD_SIZE);
            if (getTile(x, y) == null) {
                boardTile[x][y] = new Mine(x, y, true, false);
                System.out.println("making mine" + x + " " + y);
            } else {
                i--;
            }
        }
    }

    public void makingBoard(int x, int y) {
        if (getTile(x, y) == null) {
            add(boardTile[x][y] = new Square(x, y, true, false, 0));
            System.out.println("making and adding square" + x + " " + y);
        } else {
            add(getTile(x, y));
            System.out.println("adding mine " + x + y);
        }
    }
}
