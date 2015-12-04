import java.awt.*;

/**
 * Created by ifan on 03/12/2015.
 */
public class Mine extends Tile{

    private Color mineColor = Color.red;

    public Mine(int xPos, int yPos, boolean isHidd, boolean isDiff){
        super(xPos, yPos, isHidd, isDiff);
        createMine();
        addMouseListener(new Player());
    }

    public void createMine()   {
        super.setM_IsMine(true);
    }

    public void paintComponent(Graphics graphics)    {
        super.paintComponent(graphics);
        if (getIsHidden())  {
            graphics.setColor(getColor());
        }
        if (getIsDiffused() && getIsHidden())    {
            Color diffusedTile = Color.yellow;
            graphics.setColor(diffusedTile);
        }
        if (!getIsHidden()) {
            mineColor = Color.green;
            graphics.setColor(mineColor);
        }
        graphics.fillRect(20, 20, 20, 20);
    }
}
