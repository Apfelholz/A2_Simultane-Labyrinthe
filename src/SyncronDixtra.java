import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SyncronDixtra {
    boolean[][] one_wall_v;
    boolean[][] one_wall_h;
    int[] one_pits;

    boolean[][] two_wall_v;
    boolean[][] two_wall_h;
    int[] two_pits;

    int x;
    int y;

    Frame gaph;

    public SyncronDixtra(boolean[][] one_wall_v, boolean[][] one_wall_h, int[] one_pits, boolean[][] two_wall_v, boolean[][] two_wall_h, int[] two_pits, int x, int y){
        this.one_wall_v = one_wall_v;
        this.one_wall_h = one_wall_h;
        this.one_pits = one_pits;

        this.two_wall_v = two_wall_v;
        this.two_wall_h = two_wall_h;
        this.two_pits = two_pits;

        this.x = x;
        this.y = y;
    }

    private Queue<Frame> getOptions(Frame akk){
        Queue<Frame> options = new LinkedList<>();

        //! implement the locic to get the Options for movment in the to mases

        return options;
    }

    public String[] findInstructions(int one_x, int one_y, int two_x, int two_y){
        
        Frame akkFrame = new Frame(0, 0, 0, 0);
        
        //gaph = buildGaph(gaph);

        Queue<Frame> options = new LinkedList<>();
        options.add(akkFrame);

        while(true){
            akkFrame = options.poll();
            
            if(akkFrame.one_x == x && akkFrame.one_y == y && akkFrame.two_x == x && akkFrame.two_y == y){
                return getInstructions(akkFrame);
            }

            options.addAll(getOptions(akkFrame));
        }
    }

    private String[] getInstructions(Frame f){
        //! implemet getting the Instruktens from the final frame
    }
}
