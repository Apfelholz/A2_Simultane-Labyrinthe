import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SyncronDixtra {
    boolean[][] one_wall_v;
    boolean[][] one_wall_h;
    boolean[][] one_pits;

    boolean[][] two_wall_v;
    boolean[][] two_wall_h;
    boolean[][] two_pits;

    int x;
    int y;

    Frame gaph;

    public SyncronDixtra(boolean[][] one_wall_v, boolean[][] one_wall_h, boolean[][] one_pits, boolean[][] two_wall_v, boolean[][] two_wall_h, boolean[][] two_pits, int x, int y){
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

        //->
        if (akk.lastDirection != 4){
            if(!one_wall_v[akk.one_x][akk.one_y] && !two_wall_v[akk.two_x][akk.two_y]){
                if (one_pits[akk.one_x+1][akk.one_y] && two_pits[akk.two_x+1][akk.two_y]){
                    options.add(new Frame(0, 0, 0, 0, akk, 2));
                }else if (two_pits[akk.two_x+1][akk.two_y]){
                    options.add(new Frame(akk.one_x+1, akk.one_y, 0, 0, akk, 2));
                }else if (one_pits[akk.one_x+1][akk.one_y]){
                    options.add(new Frame(0, 0, akk.two_x+1, akk.two_y, akk, 2));
                }else {
                    options.add(new Frame(akk.one_x+1, akk.one_y, akk.two_x+1, akk.two_y, akk, 2));
                }
            }else if(!two_wall_v[akk.two_x][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1)){
                if (two_pits[akk.two_x+1][akk.two_y]){
                    options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 2));
                }else {
                    options.add(new Frame(akk.one_x, akk.one_y, akk.two_x+1, akk.two_y, akk, 2));
                } 
            }else if (!one_wall_v[akk.one_x][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1)){
                if (one_pits[akk.one_x+1][akk.one_y]){
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 2));
                }else {
                    options.add(new Frame(akk.one_x+1, akk.one_y, akk.two_x, akk.two_y, akk, 2));
                }
            }
        }

        //<-
        if (akk.lastDirection != 2){
            if (akk.one_x > 0 && akk.two_x > 0){
                if (!one_wall_v[akk.one_x-1][akk.one_y] && !two_wall_v[akk.two_x-1][akk.two_y]){
                    if (one_pits[akk.one_x-1][akk.one_y] && two_pits[akk.two_x-1][akk.two_y]){
                        options.add(new Frame(0, 0, 0, 0, akk, 4));
                    }else if (one_pits[akk.one_x-1][akk.one_y]){
                        options.add(new Frame(0, 0, akk.two_x-1, akk.two_y, akk, 4));
                    }else if (two_pits[akk.two_x-1][akk.two_y]){
                        options.add(new Frame(akk.one_x-1, akk.one_y, 0, 0, akk, 4));
                    }else {
                        options.add(new Frame(akk.one_x-1, akk.one_y, akk.two_x-1, akk.two_y, akk, 4));
                    }
                } else if(!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1)){
                    if (one_pits[akk.one_x-1][akk.one_y]){
                        options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 4));
                    }else {
                        options.add(new Frame(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4));
                    }
                } else if(!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1)){
                    if (two_pits[akk.two_x-1][akk.two_y]){
                        options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 4));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4));
                    }
                }
            }else if(akk.one_x > 0){
                if(!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1)){
                    if (one_pits[akk.one_x-1][akk.one_y]){
                        options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 4));
                    }else {
                        options.add(new Frame(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4));
                    }
                }
            }else if(akk.two_x > 0){
                if(!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1)){
                    if (two_pits[akk.two_x-1][akk.two_y]){
                        options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 4));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4));
                    }
                }
            }
        }

        //↓
        if (akk.lastDirection != 1){
            if (!one_wall_h[akk.one_x][akk.one_y] && !two_wall_h[akk.two_x][akk.two_y]){
                if (one_pits[akk.one_x][akk.one_y+1] && two_pits[akk.two_x][akk.two_y+1]){
                    options.add(new Frame(0, 0, 0, 0, akk, 3));
                }else if (one_pits[akk.one_x][akk.one_y+1]){
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y+1, akk, 3));
                }else if (two_pits[akk.two_x][akk.two_y+1]){
                    options.add(new Frame(akk.one_x, akk.one_y+1, 0, 0, akk, 3));
                }else{
                    options.add(new Frame(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y+1, akk, 3));
                }
            }else if (!one_wall_h[akk.one_x][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1)){
                if (one_pits[akk.one_x][akk.one_y+1]){
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 3));
                }else{
                    options.add(new Frame(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y, akk, 3));
                }
            }else if (!two_wall_h[akk.two_x][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1)){
                if (two_pits[akk.two_x][akk.two_y+1]){
                    options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 3));
                }else{
                    options.add(new Frame(akk.one_x, akk.one_y, akk.two_x, akk.two_y+1, akk, 3));
                }
            }
        }

        //↑
        if (akk.lastDirection != 3){
            if (akk.one_y > 0 && akk.two_y > 0){
                if (!one_wall_h[akk.one_x][akk.one_y-1] && !two_wall_h[akk.two_x][akk.two_y-1]){
                    if (one_pits[akk.one_x][akk.one_y-1] && two_pits[akk.two_x][akk.two_y-1]){
                        options.add(new Frame(0, 0, 0, 0, akk, 1));
                    }else if (one_pits[akk.one_x][akk.one_y-1]){
                        options.add(new Frame(0, 0, akk.two_x, akk.two_y-1, akk, 1));
                    }else if (two_pits[akk.two_x][akk.two_y-1]){
                        options.add(new Frame(akk.one_x, akk.one_y-1, 0, 0, akk, 1));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y-1, akk, 1));
                    }
                }else if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == x-1 && akk.one_y == y-1)){
                    if (one_pits[akk.one_x][akk.one_y-1]){
                        options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 1));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1));
                    }
                }else if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == x-1 && akk.two_y == y-1)){
                    if (two_pits[akk.two_x][akk.two_y-1]){
                        options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 1));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1));
                    }
                }
            }else if (akk.one_y > 0){
                if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == x-1 && akk.one_y == y-1)){
                    if (one_pits[akk.one_x][akk.one_y-1]){
                        options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 1));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1));
                    }
                }
            }else if (akk.two_y > 0){
                if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == x-1 && akk.two_y == y-1)){
                    if (two_pits[akk.two_x][akk.two_y-1]){
                        options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 1));
                    }else {
                        options.add(new Frame(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1));
                    }
                }
            }
        }

        return options;
    }

    public String[] findInstructions(int one_x, int one_y, int two_x, int two_y){
        
        Frame akkFrame = new Frame(one_x, one_y, two_x, two_y, null, 0);

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
        ArrayList<String> Instructions = new ArrayList<>();
        while(true){
            if (f.lastDirection == 0){
                return Instructions.toArray(new String[0]);
            }else if (f.lastDirection == 1){
                Instructions.addLast("↑");
            }else if (f.lastDirection == 2){
                Instructions.addLast("→");
            }else if (f.lastDirection == 3){
                Instructions.addLast("↓");
            }else if (f.lastDirection == 4){
                Instructions.addLast("←");
            }
            f = f.dad;
        }
    }
}
