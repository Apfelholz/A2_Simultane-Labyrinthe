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

    boolean[][][][] knownFrames;

    public SyncronDixtra(boolean[][] one_wall_v, boolean[][] one_wall_h, boolean[][] one_pits, boolean[][] two_wall_v, boolean[][] two_wall_h, boolean[][] two_pits, int x, int y){
        this.one_wall_v = one_wall_v;
        this.one_wall_h = one_wall_h;
        this.one_pits = one_pits;

        this.two_wall_v = two_wall_v;
        this.two_wall_h = two_wall_h;
        this.two_pits = two_pits;

        this.x = x;
        this.y = y;

        knownFrames = new boolean[x][y][x][y];
    }

    private Queue<Frame> getOptions(Frame akk){
        Queue<Frame> options = new LinkedList<>();

        //->
        if (akk.lastDirection != 4){
            if(!one_wall_v[akk.one_x][akk.one_y] && !two_wall_v[akk.two_x][akk.two_y]){
                if (one_pits[akk.one_x+1][akk.one_y] && two_pits[akk.two_x+1][akk.two_y]){
                    if (!knownFrames[0][0][0][0]) {
                        options.add(new Frame(0, 0, 0, 0, akk, 2, 2, 2));
                        knownFrames[0][0][0][0] = true;
                    }
                } else if (two_pits[akk.two_x+1][akk.two_y]) {
                    if (!knownFrames[akk.one_x+1][akk.one_y][0][0]) {
                        options.add(new Frame(akk.one_x+1, akk.one_y, 0, 0, akk, 2, 2, 2));
                        knownFrames[akk.one_x+1][akk.one_y][0][0] = true;
                    }
                } else if (one_pits[akk.one_x+1][akk.one_y]) {
                    if (!knownFrames[0][0][akk.two_x+1][akk.two_y]) {
                        options.add(new Frame(0, 0, akk.two_x+1, akk.two_y, akk, 2, 2, 2));
                        knownFrames[0][0][akk.two_x+1][akk.two_y] = true;
                    }
                } else {
                    if (!knownFrames[akk.one_x+1][akk.one_y][akk.two_x+1][akk.two_y]) {
                        options.add(new Frame(akk.one_x+1, akk.one_y, akk.two_x+1, akk.two_y, akk, 2, 2, 2));
                        knownFrames[akk.one_x+1][akk.one_y][akk.two_x+1][akk.two_y] = true;
                    }
                }
            } else if (!two_wall_v[akk.two_x][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1) && akk.two_lastDirection != 4) {
                if (two_pits[akk.two_x+1][akk.two_y]) {
                    if (!knownFrames[akk.one_x][akk.one_y][0][0]) {
                        options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 2, akk.one_lastDirection, 2));
                        knownFrames[akk.one_x][akk.one_y][0][0] = true;
                    }
                } else {
                    if (!knownFrames[akk.one_x][akk.one_y][akk.two_x+1][akk.two_y]) {
                        options.add(new Frame(akk.one_x, akk.one_y, akk.two_x+1, akk.two_y, akk, 2, akk.one_lastDirection, 2));
                        knownFrames[akk.one_x][akk.one_y][akk.two_x+1][akk.two_y] = true;
                    }
                }
            } else if (!one_wall_v[akk.one_x][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1) && akk.one_lastDirection != 4) {
                if (one_pits[akk.one_x+1][akk.one_y]) {
                    if (!knownFrames[0][0][akk.two_x][akk.two_y]) {
                        options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 2, 2, akk.two_lastDirection));
                        knownFrames[0][0][akk.two_x][akk.two_y] = true;
                    }
                } else {
                    if (!knownFrames[akk.one_x+1][akk.one_y][akk.two_x][akk.two_y]) {
                        options.add(new Frame(akk.one_x+1, akk.one_y, akk.two_x, akk.two_y, akk, 2, 2, akk.two_lastDirection));
                        knownFrames[akk.one_x+1][akk.one_y][akk.two_x][akk.two_y] = true;
                    }
                }
            }
        }

        //<-
        if (akk.lastDirection != 2){
            if (akk.one_x > 0 && akk.two_x > 0){
            if (!one_wall_v[akk.one_x-1][akk.one_y] && !two_wall_v[akk.two_x-1][akk.two_y]){
                if (one_pits[akk.one_x-1][akk.one_y] && two_pits[akk.two_x-1][akk.two_y]){
                if (!knownFrames[0][0][0][0]) {
                    options.add(new Frame(0, 0, 0, 0, akk, 4, 4, 4));
                    knownFrames[0][0][0][0] = true;
                }
                } else if (one_pits[akk.one_x-1][akk.one_y]){
                if (!knownFrames[0][0][akk.two_x-1][akk.two_y]) {
                    options.add(new Frame(0, 0, akk.two_x-1, akk.two_y, akk, 4, 4, 4));
                    knownFrames[0][0][akk.two_x-1][akk.two_y] = true;
                }
                } else if (two_pits[akk.two_x-1][akk.two_y]){
                if (!knownFrames[akk.one_x-1][akk.one_y][0][0]) {
                    options.add(new Frame(akk.one_x-1, akk.one_y, 0, 0, akk, 4, 4, 4));
                    knownFrames[akk.one_x-1][akk.one_y][0][0] = true;
                }
                } else {
                if (!knownFrames[akk.one_x-1][akk.one_y][akk.two_x-1][akk.two_y]) {
                    options.add(new Frame(akk.one_x-1, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, 4, 4));
                    knownFrames[akk.one_x-1][akk.one_y][akk.two_x-1][akk.two_y] = true;
                }
                }
            } else if (!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1) && akk.one_lastDirection != 2){
                if (one_pits[akk.one_x-1][akk.one_y]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y]) {
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection));
                    knownFrames[0][0][akk.two_x][akk.two_y] = true;
                }
                } else {
                if (!knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y]) {
                    options.add(new Frame(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection));
                    knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y] = true;
                }
                }
            } else if (!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1) && akk.two_lastDirection != 2){
                if (two_pits[akk.two_x-1][akk.two_y]){
                if (!knownFrames[akk.one_x][akk.one_y][0][0]) {
                    options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 4, akk.one_lastDirection, 4));
                    knownFrames[akk.one_x][akk.one_y][0][0] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y]) {
                    options.add(new Frame(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.one_lastDirection, 4));
                    knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y] = true;
                }
                }
            }
            } else if (akk.one_x > 0){
            if (!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1) && akk.one_lastDirection != 2){
                if (one_pits[akk.one_x-1][akk.one_y]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y]) {
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection));
                    knownFrames[0][0][akk.two_x][akk.two_y] = true;
                }
                } else {
                if (!knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y]) {
                    options.add(new Frame(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection));
                    knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y] = true;
                }
                }
            }
            } else if (akk.two_x > 0){
            if (!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1) && akk.two_lastDirection != 2){
                if (two_pits[akk.two_x-1][akk.two_y]){
                if (!knownFrames[akk.one_x][akk.one_y][0][0]) {
                    options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 4, akk.one_lastDirection, 4));
                    knownFrames[akk.one_x][akk.one_y][0][0] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y]) {
                    options.add(new Frame(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.one_lastDirection, 4));
                    knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y] = true;
                }
                }
            }
            }
        }

        //↓
        if (akk.lastDirection != 1){
            if (!one_wall_h[akk.one_x][akk.one_y] && !two_wall_h[akk.two_x][akk.two_y]){
            if (one_pits[akk.one_x][akk.one_y+1] && two_pits[akk.two_x][akk.two_y+1]){
                if (!knownFrames[0][0][0][0]) {
                options.add(new Frame(0, 0, 0, 0, akk, 3, 3, 3));
                knownFrames[0][0][0][0] = true;
                }
            } else if (one_pits[akk.one_x][akk.one_y+1]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y+1]) {
                options.add(new Frame(0, 0, akk.two_x, akk.two_y+1, akk, 3, 3, 3));
                knownFrames[0][0][akk.two_x][akk.two_y+1] = true;
                }
            } else if (two_pits[akk.two_x][akk.two_y+1]){
                if (!knownFrames[akk.one_x][akk.one_y+1][0][0]) {
                options.add(new Frame(akk.one_x, akk.one_y+1, 0, 0, akk, 3, 3, 3));
                knownFrames[akk.one_x][akk.one_y+1][0][0] = true;
                }
            } else {
                if (!knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y+1]) {
                options.add(new Frame(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y+1, akk, 3, 3, 3));
                knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y+1] = true;
                }
            }
            } else if (!one_wall_h[akk.one_x][akk.one_y] && !(akk.one_x == x-1 && akk.one_y == y-1) && akk.one_lastDirection != 1){
            if (one_pits[akk.one_x][akk.one_y+1]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y]) {
                options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 3, 3, akk.two_lastDirection));
                knownFrames[0][0][akk.two_x][akk.two_y] = true;
                }
            } else {
                if (!knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y]) {
                options.add(new Frame(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y, akk, 3, 3, akk.two_lastDirection));
                knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y] = true;
                }
            }
            } else if (!two_wall_h[akk.two_x][akk.two_y] && !(akk.two_x == x-1 && akk.two_y == y-1) && akk.two_lastDirection != 1){
            if (two_pits[akk.two_x][akk.two_y+1]){
                if (!knownFrames[akk.one_x][akk.one_y][0][0]) {
                options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 3, akk.one_lastDirection, 3));
                knownFrames[akk.one_x][akk.one_y][0][0] = true;
                }
            } else {
                if (!knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y+1]) {
                options.add(new Frame(akk.one_x, akk.one_y, akk.two_x, akk.two_y+1, akk, 3, akk.one_lastDirection, 3));
                knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y+1] = true;
                }
            }
            }
        }

        //↑
        if (akk.lastDirection != 3){
            if (akk.one_y > 0 && akk.two_y > 0){
            if (!one_wall_h[akk.one_x][akk.one_y-1] && !two_wall_h[akk.two_x][akk.two_y-1]){
                if (one_pits[akk.one_x][akk.one_y-1] && two_pits[akk.two_x][akk.two_y-1]){
                if (!knownFrames[0][0][0][0]) {
                    options.add(new Frame(0, 0, 0, 0, akk, 1, 1, 1));
                    knownFrames[0][0][0][0] = true;
                }
                } else if (one_pits[akk.one_x][akk.one_y-1]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y-1]) {
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y-1, akk, 1, 1, 1));
                    knownFrames[0][0][akk.two_x][akk.two_y-1] = true;
                }
                } else if (two_pits[akk.two_x][akk.two_y-1]){
                if (!knownFrames[akk.one_x][akk.one_y-1][0][0]) {
                    options.add(new Frame(akk.one_x, akk.one_y-1, 0, 0, akk, 1, 1, 1));
                    knownFrames[akk.one_x][akk.one_y-1][0][0] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y-1]) {
                    options.add(new Frame(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y-1, akk, 1, 1, 1));
                    knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y-1] = true;
                }
                }
            } else if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == x-1 && akk.one_y == y-1) && akk.one_lastDirection != 3){
                if (one_pits[akk.one_x][akk.one_y-1]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y]) {
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection));
                    knownFrames[0][0][akk.two_x][akk.two_y] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y]) {
                    options.add(new Frame(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection));
                    knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y] = true;
                }
                }
            } else if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == x-1 && akk.two_y == y-1) && akk.two_lastDirection != 3){
                if (two_pits[akk.two_x][akk.two_y-1]){
                if (!knownFrames[akk.one_x][akk.one_y][0][0]) {
                    options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 1, akk.one_lastDirection, 1));
                    knownFrames[akk.one_x][akk.one_y][0][0] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1]) {
                    options.add(new Frame(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1, akk.one_lastDirection, 1));
                    knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1] = true;
                }
                }
            }
            } else if (akk.one_y > 0){
            if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == x-1 && akk.one_y == y-1) && akk.one_lastDirection != 3){
                if (one_pits[akk.one_x][akk.one_y-1]){
                if (!knownFrames[0][0][akk.two_x][akk.two_y]) {
                    options.add(new Frame(0, 0, akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection));
                    knownFrames[0][0][akk.two_x][akk.two_y] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y]) {
                    options.add(new Frame(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection));
                    knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y] = true;
                }
                }
            }
            } else if (akk.two_y > 0){
            if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == x-1 && akk.two_y == y-1) && akk.two_lastDirection != 3){
                if (two_pits[akk.two_x][akk.two_y-1]){
                if (!knownFrames[akk.one_x][akk.one_y][0][0]) {
                    options.add(new Frame(akk.one_x, akk.one_y, 0, 0, akk, 1, akk.one_lastDirection, 1));
                    knownFrames[akk.one_x][akk.one_y][0][0] = true;
                }
                } else {
                if (!knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1]) {
                    options.add(new Frame(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1, akk.one_lastDirection, 1));
                    knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1] = true;
                }
                }
            }
            }
        }

        return options;
    }

    public char[] findInstructions(int one_x, int one_y, int two_x, int two_y){
        
        Frame akkFrame = new Frame(one_x, one_y, two_x, two_y, null, 0, 0, 0);

        Frame lastFrame;

        Queue<Frame> options = new LinkedList<>();
        options.add(akkFrame);

        while(true){
            lastFrame = akkFrame;
            akkFrame = options.poll();

            if (akkFrame == null){
                return getInstructions(lastFrame, false);
            }
            
            if(akkFrame.one_x == x-1 && akkFrame.one_y == y-1 && akkFrame.two_x == x-1 && akkFrame.two_y == y-1){
                return getInstructions(akkFrame, true);
            }

            options.addAll(getOptions(akkFrame));
        }
    }

    private char[] getInstructions(Frame f, boolean successfull){
        ArrayList<Character> Instructions = new ArrayList<>();
        while(true){
            if (f.lastDirection == 0){
                if (!successfull){
                    Instructions.addLast('X');
                }
                char[] result = new char[Instructions.size()];
                for (int i = 0; i < Instructions.size(); i++) {
                    result[result.length-1-i] = Instructions.get(i);
                }
                return result;
            }else if (f.lastDirection == 1){
                Instructions.add('^');
            }else if (f.lastDirection == 2){
                Instructions.add('>');
            }else if (f.lastDirection == 3){
                Instructions.add('|');
            }else if (f.lastDirection == 4){
                Instructions.add('<');
            }
            f = f.dad;
        }
    }
}
