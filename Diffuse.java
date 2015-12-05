/**
 * Created by ifan on 04/12/2015.
 */
public class Diffuse {


    public void toggleDiffuseState(int x, int y)  {
        if (Board.getTile(x, y).getIsDiffused() == true)    {
            unDiffuseTile(x, y);
        } else  {
            diffuseTile(x, y);
        }
    }

    public void unDiffuseTile(int x, int y) {
        Board.getTile(x, y).setIsDiffused(false);
        Counter.decrementDiffuseCount();
    }

    public void diffuseTile(int x, int y)   {
        Board.getTile(x, y).setIsDiffused(true);
        Counter.incrementDiffusedCount();
    }
}
