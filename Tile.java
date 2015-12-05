import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ifan on 03/12/2015.
 */
public class Tile extends JButton{

    private int m_XPosition;
    private int m_YPosition;
    private boolean m_IsHidden;
    private boolean m_IsDiffused;
    private boolean m_IsMine;
    private Color tileColor = Color.BLUE;

    public Tile(int xPos, int yPos, boolean isHidd, boolean isDiff){
        m_XPosition = xPos;
        m_YPosition = yPos;
        m_IsHidden = isHidd;
        m_IsDiffused = isDiff;
    }

    public void setXPosition(int xPos){
        m_XPosition = xPos;
    }

    /*class something  implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //JOptionPane.showMessageDialog(new JFrame(),"final product will reveal mine");
            revealAlgorithm = new RevealAlgorithm();
            revealAlgorithm.floodFill(getXPosition(), getYPosition());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

            //shapeOfTile = getShape();
            repaint();

        }

        @Override
        public void mouseExited(MouseEvent e) {

            repaint();
        }
    }*/

    public void setYPosition(int yPos){
        m_YPosition = yPos;
    }

    public void setIsHidden(boolean isHidd){
        m_IsHidden = isHidd;
    }

    public void setIsDiffused(boolean isDiff){
        m_IsDiffused = isDiff;
    }

    public void setM_IsMine(Boolean isMine)   {
        m_IsMine = isMine;
    }

    public int getXPosition(){
        return m_XPosition;
    }

    public int getYPosition(){
        return m_YPosition;
    }

    public boolean getIsHidden(){
        return m_IsHidden;
    }

    public boolean getIsDiffused(){
        return m_IsDiffused;
    }
    public boolean getIsMine(){
        return m_IsMine;
    }
    public Color getColor() {
        return tileColor;
    }


    public void paintComponent (Graphics graphics) {

        super.paintComponent(graphics);

        //graphics2D  = (Graphics2D) graphics.create();

    }
}
