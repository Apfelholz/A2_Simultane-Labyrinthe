import java.util.ArrayList;

public class SyncronDixtra {
    boolean[][] one_wall_v;
    boolean[][] one_wall_h;
    int[] one_pits;

    boolean[][] two_wall_v;
    boolean[][] two_wall_h;
    int[] two_pits;

    int x;
    int y;

    knoten gaph;

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

    private ArrayList<Integer[]> getOptions(knoten akk){
        ArrayList<Integer[]> options = new ArrayList<>();

        //! implement the locic to get the Options for movment in the to mases

        return options;
    }

    public String[] findInstructions(int one_x, int one_y, int two_x, int two_y){
        
        gaph = new knoten(0, 0, 0, 0);
        gaph = buildGaph(gaph);

        //! add the Dixtra Part
    }

    private knoten buildGaph(knoten k){
        ArrayList<Integer[]> cords = getOptions(k);

        for (Integer[] c : cords){
            knoten child = new knoten(c[0], c[1], c[2], c[3]);
            buildGaph(child);
            k.addChild(child);
        }

        return k;
    }
}
