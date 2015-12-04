import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by ifan on 24/11/2015.
 */


public class Boardclass extends JFrame {


    private static TempMine boardTile[] [];
    private final static int BOARD_SIZE = 10;


    public Boardclass() {

        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        boardTile = new TempMine [BOARD_SIZE] [BOARD_SIZE];
        for (int i = 1; i < BOARD_SIZE; i++)    {
            for (int j = 1; j < BOARD_SIZE; j++)    {
                makingBoard(i, j);
            }

        }
        setVisible(true);

    }

    public static int getBOARD_SIZE()  {
        return BOARD_SIZE;
    }

    public static void main (String[] args) {
        Boardclass boardclass = new Boardclass();

    }
    public void makingBoard(int x, int y)    {
        add(boardTile [x] [y] = new TempMine(x, y));
    }

    public static TempMine getTile(int x, int y)   {
        return boardTile [x] [y];
    }
}
class TempMine extends JPanel {

    private Graphics2D graphics2D;
    private Shape shapeOfTile = new Rectangle2D.Double(20, 20, 20, 20);
    private  Boolean revealed = false;
    private int xCoord, yCoord;
    private RevealAlgorithm revealAlgorithm;
    private Color clr = Color.CYAN;


    TempMine(int x, int y)  {
        setCoords(x, y);
        addMouseListener(new something());
    }

    TempMine()  {
        super();
    }

    public void revealTile()    {
        revealed = true;
    }

    public Boolean isRevealed() {
        return revealed;
    }

    public void setCoords(int xCoord, int yCoord) {
        this.yCoord = yCoord;
        this.xCoord = xCoord;
    }

    public void setRectangle()  {
        shapeOfTile = new Rectangle2D.Double(20, 20, 20, 20);

    }
    public void setEllipse()  {
        shapeOfTile = new Ellipse2D.Double(20, 20, 20, 20);

    }

    public void changeColorRed()    {
        clr = Color.RED;
    }

    public Shape getShape()  {
        return shapeOfTile;
    }
    class something  implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //JOptionPane.showMessageDialog(new JFrame(),"final product will reveal mine");
            revealAlgorithm = new RevealAlgorithm();
            revealAlgorithm.floodFill(xCoord, yCoord);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

            setEllipse();
            //shapeOfTile = getShape();
            repaint();

        }

        @Override
        public void mouseExited(MouseEvent e) {
            setRectangle();
            shapeOfTile = getShape();
            repaint();
        }

    }

    public void paintComponent (Graphics graphics) {

        super.paintComponent(graphics);

        graphics2D  = (Graphics2D) graphics.create();

        graphics2D.setColor(clr);
        graphics2D.fill(shapeOfTile);

        graphics2D.dispose();
    }

}
