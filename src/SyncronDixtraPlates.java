import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
public class SyncronDixtraPlates {
    boolean[][] one_wall_v;
    boolean[][] one_wall_h;
    boolean[][] one_pits;
    int[][][] one_pitCords;
    boolean[][] one_plates;
    int[][][] one_plate_cords_action;


    boolean[][] two_wall_v;
    boolean[][] two_wall_h;
    boolean[][] two_pits;
    int[][][] two_pitCords;
    boolean[][] two_plates;
    int[][][] two_plate_cords_action;

    FramePlates akkFrame;
    FramePlates lastFrame;

    int x;
    int y;

    Set<FramePlates> knownFrames = new HashSet<>();

    public SyncronDixtraPlates(boolean[][] one_wall_v, boolean[][] one_wall_h, boolean[][] one_pits, boolean[][] two_wall_v, boolean[][] two_wall_h, boolean[][] two_pits, int x, int y, int[][][] one_pitCords, int[][][] two_pitCords, boolean[][] one_plates, boolean[][] two_plates, int[][][] one_plate_cords_action, int[][][] two_plate_cords_action){
        this.one_wall_v = one_wall_v;
        this.one_wall_h = one_wall_h;
        this.one_pits = one_pits;
        this.one_pitCords = one_pitCords;
        this.one_plates = one_plates;
        this.one_plate_cords_action = one_plate_cords_action;

        this.two_wall_v = two_wall_v;
        this.two_wall_h = two_wall_h;
        this.two_pits = two_pits;
        this.two_pitCords = two_pitCords;
        this.two_plates = two_plates;
        this.two_plate_cords_action = two_plate_cords_action;

        this.x = x;
        this.y = y;
    }

    private void addFrame(Queue<FramePlates> queue, FramePlates newFrame){
        if (!knownFrames.contains(newFrame)) {
            queue.add(newFrame);
            knownFrames.add(newFrame);
        }
    }

    private Queue<FramePlates> getOptions(FramePlates akk, int f_one_x, int f_one_y, int f_two_x, int f_two_y){
        Queue<FramePlates> options = new LinkedList<>();

        one_wall_h = akk.one_wall_h;
        one_wall_v = akk.one_wall_v;
        two_wall_h = akk.two_wall_h;
        two_wall_v = akk.two_wall_v;


        if (akk.lastDirection != 4){
            if(!one_wall_v[akk.one_x][akk.one_y] && !two_wall_v[akk.two_x][akk.two_y] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
                if (one_pits[akk.one_x+1][akk.one_y] && two_pits[akk.two_x+1][akk.two_y]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x+1][akk.one_y][0], one_pitCords[akk.one_x+1][akk.one_y][1], two_pitCords[akk.two_x+1][akk.two_y][0], two_pitCords[akk.two_x+1][akk.two_y][1], akk, 2, 2, 2, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else if (two_pits[akk.two_x+1][akk.two_y]) {
                    addFrame(options, new FramePlates(akk.one_x+1, akk.one_y, two_pitCords[akk.two_x+1][akk.two_y][0], two_pitCords[akk.two_x+1][akk.two_y][1], akk, 2, 2, 2, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else if (one_pits[akk.one_x+1][akk.one_y]) {
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x+1][akk.one_y][0], one_pitCords[akk.one_x+1][akk.one_y][1], akk.two_x+1, akk.two_y, akk, 2, 2, 2, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x+1, akk.one_y, akk.two_x+1, akk.two_y, akk, 2, 2, 2, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            } else if (!two_wall_v[akk.two_x][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y) && akk.two_lastDirection != 4) {
                if (two_pits[akk.two_x+1][akk.two_y]) {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, two_pitCords[akk.two_x+1][akk.two_y][0], two_pitCords[akk.two_x+1][akk.two_y][1], akk, 2, akk.one_lastDirection, 2, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, akk.two_x+1, akk.two_y, akk, 2, akk.one_lastDirection, 2, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            } else if (!one_wall_v[akk.one_x][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) && akk.one_lastDirection != 4) {
                if (one_pits[akk.one_x+1][akk.one_y]) {
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x+1][akk.one_y][0], one_pitCords[akk.one_x+1][akk.one_y][1], akk.two_x, akk.two_y, akk, 2, 2, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x+1, akk.one_y, akk.two_x, akk.two_y, akk, 2, 2, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
        }

        //<-
        if (akk.lastDirection != 2){
            if (akk.one_x > 0 && akk.two_x > 0){
            if (!one_wall_v[akk.one_x-1][akk.one_y] && !two_wall_v[akk.two_x-1][akk.two_y] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
                if (one_pits[akk.one_x-1][akk.one_y] && two_pits[akk.two_x-1][akk.two_y]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, 4, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else if (one_pits[akk.one_x-1][akk.one_y]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], akk.two_x-1, akk.two_y, akk, 4, 4, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else if (two_pits[akk.two_x-1][akk.two_y]){
                    addFrame(options, new FramePlates(akk.one_x-1, akk.one_y, two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, 4, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x-1, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, 4, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            } else if (!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) && akk.one_lastDirection != 2){
                if (one_pits[akk.one_x-1][akk.one_y]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            } else if (!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y) && akk.two_lastDirection != 2){
                if (two_pits[akk.two_x-1][akk.two_y]){
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, akk.one_lastDirection, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.one_lastDirection, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
            } else if (akk.one_x > 0){
            if (!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) && akk.one_lastDirection != 2){
                if (one_pits[akk.one_x-1][akk.one_y]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4, 4, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
            } else if (akk.two_x > 0){
            if (!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y) && akk.two_lastDirection != 2){
                if (two_pits[akk.two_x-1][akk.two_y]){
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, akk.one_lastDirection, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.one_lastDirection, 4, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
            }
        }

        //↓
        if (akk.lastDirection != 1){
            if (!one_wall_h[akk.one_x][akk.one_y] && !two_wall_h[akk.two_x][akk.two_y] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
            if (one_pits[akk.one_x][akk.one_y+1] && two_pits[akk.two_x][akk.two_y+1]){
                addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y+1][0], one_pitCords[akk.one_x][akk.one_y+1][1], two_pitCords[akk.two_x][akk.two_y+1][0], two_pitCords[akk.two_x][akk.two_y+1][1], akk, 3, 3, 3, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            } else if (one_pits[akk.one_x][akk.one_y+1]){
                addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y+1][0], one_pitCords[akk.one_x][akk.one_y+1][1], akk.two_x, akk.two_y+1, akk, 3, 3, 3, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            } else if (two_pits[akk.two_x][akk.two_y+1]){
                addFrame(options, new FramePlates(akk.one_x, akk.one_y+1, two_pitCords[akk.two_x][akk.two_y+1][0], two_pitCords[akk.two_x][akk.two_y+1][1], akk, 3, 3, 3, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            } else {
                addFrame(options, new FramePlates(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y+1, akk, 3, 3, 3, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            }
            } else if (!one_wall_h[akk.one_x][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) && akk.one_lastDirection != 1){
            if (one_pits[akk.one_x][akk.one_y+1]){
                addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y+1][0], one_pitCords[akk.one_x][akk.one_y+1][1], akk.two_x, akk.two_y, akk, 3, 3, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            } else {
                addFrame(options, new FramePlates(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y, akk, 3, 3, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            }
            } else if (!two_wall_h[akk.two_x][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y) && akk.two_lastDirection != 1){
            if (two_pits[akk.two_x][akk.two_y+1]){
                addFrame(options, new FramePlates(akk.one_x, akk.one_y, two_pitCords[akk.two_x][akk.two_y+1][0], two_pitCords[akk.two_x][akk.two_y+1][1], akk, 3, akk.one_lastDirection, 3, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            } else {
                addFrame(options, new FramePlates(akk.one_x, akk.one_y, akk.two_x, akk.two_y+1, akk, 3, akk.one_lastDirection, 3, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
            }
            }
        }

        //↑
        if (akk.lastDirection != 3){
            if (akk.one_y > 0 && akk.two_y > 0){
            if (!one_wall_h[akk.one_x][akk.one_y-1] && !two_wall_h[akk.two_x][akk.two_y-1] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
                if (one_pits[akk.one_x][akk.one_y-1] && two_pits[akk.two_x][akk.two_y-1]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, 1, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else if (one_pits[akk.one_x][akk.one_y-1]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], akk.two_x, akk.two_y-1, akk, 1, 1, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else if (two_pits[akk.two_x][akk.two_y-1]){
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y-1, two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, 1, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y-1, akk, 1, 1, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            } else if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) && akk.one_lastDirection != 3){
                if (one_pits[akk.one_x][akk.one_y-1]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            } else if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == f_two_x && akk.two_y == f_two_y) && akk.two_lastDirection != 3){
                if (two_pits[akk.two_x][akk.two_y-1]){
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, akk.one_lastDirection, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1, akk.one_lastDirection, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
            } else if (akk.one_y > 0){
            if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) && akk.one_lastDirection != 3){
                if (one_pits[akk.one_x][akk.one_y-1]){
                    addFrame(options, new FramePlates(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1, 1, akk.two_lastDirection, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
            } else if (akk.two_y > 0){
            if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == f_two_x && akk.two_y == f_two_y) && akk.two_lastDirection != 3){
                if (two_pits[akk.two_x][akk.two_y-1]){
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y,  two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, akk.one_lastDirection, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                } else {
                    addFrame(options, new FramePlates(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1, akk.one_lastDirection, 1, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, akk.usedPlats));
                }
            }
            }
        }

        if (akk.one_x != f_one_x || akk.one_y != f_one_y){
            for (FramePlates f : options){
                if (f.one_x == f_one_x && akk.one_y == f_one_y){
                    f.lastDirection = -f.lastDirection;
                    f.two_lastDirection = -f.two_lastDirection;
                }
            }
        }
        if (akk.two_x != f_two_x || akk.two_y != f_two_y){
            for (FramePlates f : options){
                if (f.two_x == f_two_x && akk.two_y == f_two_y){
                    f.lastDirection = -f.lastDirection;
                    f.one_lastDirection = -f.two_lastDirection;
                }
            }
        }

        return options;
    }

    public char[] findInstructions(int s_one_x, int s_one_y, int s_two_x, int s_two_y, int f_one_x, int f_one_y, int f_two_x, int f_two_y){
        
        akkFrame = new FramePlates(s_one_x, s_one_y, s_two_x, s_two_y, null, 0, 0, 0, one_wall_v, one_wall_h, two_wall_v, two_wall_h, two_plates, two_plate_cords_action, one_plates, one_plate_cords_action, new ArrayList<Integer[]>());

        Queue<FramePlates> options = new LinkedList<>();
        addFrame(options, akkFrame);

        while(true){
            lastFrame = akkFrame;
            akkFrame = options.poll();

            if (akkFrame == null){
                return getInstructions(lastFrame, false);
            }
            
            if(akkFrame.one_x == f_one_x && akkFrame.one_y == f_one_y && akkFrame.two_x == f_two_x && akkFrame.two_y == f_two_y){
                return getInstructions(akkFrame, true);
            }

            options.addAll(getOptions(akkFrame, f_one_x, f_one_y, f_two_x, f_two_y));
        }
    }

    private char[] getInstructions(FramePlates f, boolean successfull){
        ArrayList<Character> Instructions = new ArrayList<>();
        while(true){
            if (f.lastDirection == 0){
                char[] result = new char[Instructions.size()+1];
                for (int i = 0; i < Instructions.size(); i++) {
                    result[result.length-2-i] = Instructions.get(i);
                }
                if (!successfull){
                    result[result.length-1] = 'X';
                }
                return result;
            }else if (f.lastDirection == 1 || f.lastDirection == -1){
                Instructions.add('^');
            }else if (f.lastDirection == 2 || f.lastDirection == -2){
                Instructions.add('>');
            }else if (f.lastDirection == 3 || f.lastDirection == -3){
                Instructions.add('|');
            }else if (f.lastDirection == 4 || f.lastDirection == -4){
                Instructions.add('<');
            }
            f = f.dad;
        }
    }
}
