/**
 * Created by ifan on 02/12/2015.
 */
public class RevealAlgorithm {


    public static void floodFill(int x, int y) {
        if (0 <= x && x <= Board.getBOARD_SIZE() - 1 && 0 <= y && y <= Board.getBOARD_SIZE() - 1)   {       //Boardclass.getBOARD_SIZE()
            if (Board.getTile(x, y) != null)  {
                if (revealCheckOne(x, y)) {
                    Board.getTile(x, y).setIsHidden(false);
                    //Board.getTile(x, y).changeColorRed();
                    Board.getTile(x, y).repaint();
                    if (revealCheckTwo(x, y)) {
                        floodFill(x, y + 1);
                        floodFill(x + 1, y);
                        floodFill(x, y - 1);
                        floodFill(x - 1, y);
                    }
                }
            } else {
                return;
            }
            return;
        }
    }

    public static Boolean revealCheckOne(int x, int y)   {
        return (Board.getTile(x, y).getIsHidden()&& !Board.getTile(x, y).getIsMine() && !Board.getTile(x, y).getIsDiffused());
    }

    public static Boolean revealCheckTwo(int x, int y)  {
        Square square = (Square) Board.getTile(x, y);
        return (square.getNumOfMinesAdjacent() == 0);
    }
}
