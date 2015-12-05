import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class GameWindow extends JFrame {
    public final int TEXT_FIELD_WIDTH = 15;
    private JTextField m_NameTF;
    private JTextField m_NumOfTilesTF;
    private JTextField m_NumOfMinesTF;
    private JButton m_ConfirmJB;

    public JTextField getNameTF() {
        return m_NameTF;
    }

    public final boolean setNameTF(JTextField nameTF) {
        m_NameTF = nameTF;
        return true;
    }

    public JTextField getNumOfTilesTF() {
        return m_NumOfTilesTF;
    }

    public final boolean setNumOfTilesTF(JTextField numOfTilesTF) {
        m_NumOfTilesTF = numOfTilesTF;
        return true;
    }

    public JTextField getNumOfMinesTF() {
        return m_NumOfMinesTF;
    }

    public final boolean setNumOfMinesTF(JTextField numOfMinesTF) {
        m_NumOfMinesTF = numOfMinesTF;
        return true;
    }

    public JButton getConfirmJB() {
        return m_ConfirmJB;
    }

    public final boolean setConfirmJB(JButton confirmJB) {
        m_ConfirmJB = confirmJB;
        return true;
    }

    public GameWindow() {

        super("Kablewie!");
        this.setLayout(new FlowLayout()); // set frame layout

        /** construct textfield with TEXT_FIELD_WIDTH columns */
        //Time t = new Time();
        this.setNameTF(new JTextField("Enter name", TEXT_FIELD_WIDTH));
        this.setNumOfTilesTF(new JTextField("Enter number of Tiles", TEXT_FIELD_WIDTH));
        this.setNumOfMinesTF(new JTextField("Enter number of Mines", TEXT_FIELD_WIDTH));
        this.setConfirmJB(new JButton("Confirm"));
        //this.setNameTF().setText("sda");
        //this.setNameTF().setText(t.getTimeElapsed());
        /** add textField1 to JFrame */
        //do{
        //this.add(this.getNumOfTilesTF());
        this.add(this.getNameTF());
        this.add(this.getNumOfTilesTF());
        this.add(this.getNumOfMinesTF());
        GameWindowHandler handler = new GameWindowHandler();
        //this.getNameTF().addActionListener( handler );
        this.getNameTF().addMouseListener(handler);
        //this.getNumOfTilesTF().addActionListener( handler );
        this.getNumOfTilesTF().addMouseListener(handler);
        //this.getNumOfMinesTF().addActionListener( handler );
        this.getNumOfMinesTF().addMouseListener(handler);
        getConfirmJB().addActionListener(handler);
        this.setVisible(false);
        //this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        //}while(Game.isGameRunning(true));
    }

    private class GameWindowHandler implements ActionListener, MouseListener {

        /**
         * Process textfield events.
         * The actionPerformed() method is defined in the
         * ActionListener interface.
         */
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == getNameTF()) {
                getNameTF().setText("");
            }
            if (e.getSource() == getNumOfTilesTF()) {
                getNumOfTilesTF().setText("");
            }
            if (e.getSource() == getNumOfMinesTF()) {
                getNumOfMinesTF().setText("");
            }
          /*if(e.getSource() == getNameTF()){
      		getNameTF().setText("");
      	}*/
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }


        public void actionPerformed(ActionEvent event) {

            /** local testing variable */
            //boolean test = true;
            /** Declare string to display */
            String string = "";
            String name = "";
            int numberOfTiles = 0;
            int numberOfMines = 0;
            //while (numberOfMines == 0) {
                try {
                    numberOfMines = Integer.parseInt(getNumOfMinesTF().getText());
                    numberOfTiles = Integer.parseInt(getNumOfTilesTF().getText());
                    GameSetup setup = new GameSetup(name, numberOfTiles, numberOfMines, true);
                    String test = "Name: " + setup.getName() + "\nNumOfTiles: " + setup.getNumberOfTiles();
                    JOptionPane.showMessageDialog(null, test);
                } catch (InputMismatchException e) {
                    JOptionPane.showMessageDialog(new JFrame(), "ex1 not an int");
                } catch (NumberFormatException e)   {
                    JOptionPane.showMessageDialog(new JFrame(), "ex2 not an int");
                }
            //}

            //if (test) {
            //    System.out.println("TextFieldFrameProper::actionPerformed()");
            //System.out.println("event is: " + event.toString() );
            //}
            /**
             * User pressed Enter in JTextField textField1.
             * When that event happens, this method is called.
             */

            //string = String.format( "textField1: %s", event.getActionCommand() );

        }
    }
}

/**
 * User pressed Enter in JTextField textField2
 */