import java.awt.*;
import java.awt.print.Book;

/**
 * Created by ifan on 03/12/2015.
 */
public class Mine extends Tile{

    private Color mineColor = Color.red;
    private static Boolean allMinesHidden = true;

    public Mine(int xPos, int yPos, boolean isHidd, boolean isDiff){
        super(xPos, yPos, isHidd, isDiff);
        createMine();
        addMouseListener(new Player());
    }

    public void createMine()   {
        super.setM_IsMine(true);
    }

    public static void revealAllMines() {
        allMinesHidden = false;
    }

    public void paintComponent(Graphics graphics)    {
        super.paintComponent(graphics);
        if (getIsHidden())  {
            //graphics.setColor(getColor());
        }
        if (getIsDiffused() && getIsHidden())    {
            Color diffusedTile = Color.yellow;
            graphics.setColor(diffusedTile);
            graphics.fillRect(20,20,20,20);
        }
        if (!getIsHidden() ) {
            mineColor = Color.red;
            graphics.setColor(mineColor);
            graphics.fillRect(0,0,100,100);
        }
        //graphics.fillRect(0, 0 , 100, 100);
    }
}
