import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ifan on 04/12/2015.
 */
public class Player implements MouseListener{

    private RevealAlgorithm revealAlgorithm;
    private Diffuse diffuse;


    @Override
    public void mouseClicked(MouseEvent e) {
        Tile t = (Tile) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON3)    {
            diffuse = new Diffuse();
            diffuse.toggleDiffuseState(t.getXPosition(),t.getYPosition());
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            revealAlgorithm = new RevealAlgorithm();
            revealAlgorithm.floodFill(t.getXPosition(), t.getYPosition());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
