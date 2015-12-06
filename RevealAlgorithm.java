/**
 * @file RevealAlgorithm.java
 * @author ifan
 * @date  02/12/2015.
 * @see Player
 *
 * Reveals all tiles and will perform recursivly on tiles adjacent to mines and will reveal all mines upon hitting a mine.
 */
public class RevealAlgorithm {

    /**
     *
     * @param x where x is the x coordinate
     * @param y where y is the y coordinate
     */
    public static void floodFill(int x, int y) {
        if (0 <= x && x <= Board.getBOARD_SIZE() - 1
                && 0 <= y && y <= Board.getBOARD_SIZE() - 1)   {       //Boardclass.getBOARD_SIZE()
            if (Board.getTile(x, y) != null)  {
                if (revealCheckOne(x, y)) {
                    Board.getTile(x, y).setIsHidden(false);
                    Board.getTile(x, y).setEnabled(false);
                    Counter.incrementRevealedTileCount();
                    Counter.setTileRemainingCount(Board.getBOARD_SIZE());
                    System.out.println(Counter.getReveleadTileCount());
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

    /**
     *
     * @param x where x is the x coordinate
     * @param y where y is the y coordinate
     * @return
     */
    public static Boolean revealCheckOne(int x, int y)   {
        return (Board.getTile(x, y).getIsHidden()&& !Board.getTile(x, y).getIsMine()
                && !Board.getTile(x, y).getIsDiffused());
    }

    /**
     *
     * @param x where x is the x coordinate
     * @param y where y is the y coordinate
     * @return
     */
    public static Boolean revealCheckTwo(int x, int y)  {
        Square square = (Square) Board.getTile(x, y);
        return (square.getNumOfMinesAdjacent() == 0);
    }

    /**
     *
     * @param x where x is the x coordinate
     * @param y where y is the y coordinate
     */
    public void ifMine(int x, int y) {
        if (!Board.getTile(x, y).getIsDiffused())   {
        Board.getTile(x, y).setIsHidden(false);
        for (int i = 0; i < Board.getBOARD_SIZE(); i++) {
            for (int j = 0; j < Board.getBOARD_SIZE(); j++) {
                if (Board.getTile(i, j).getIsMine()) {
                    Board.getTile(i, j).setIsHidden(false);
                    Board.getTile(i, j).setEnabled(false);
                    Board.getTile(i, j).repaint();
                }
            }
            }
        }
    }
}
