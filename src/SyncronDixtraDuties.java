import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class SyncronDixtraDuties {
    boolean[][] one_wall_v;
    boolean[][] one_wall_h;
    boolean[][] one_pits;
    int[][][] one_pitCords;

    boolean[][] two_wall_v;
    boolean[][] two_wall_h;
    boolean[][] two_pits;
    int[][][] two_pitCords;

    int x;
    int y;

    boolean[][][][] knownFrames;

    public SyncronDixtraDuties(boolean[][] one_wall_v, boolean[][] one_wall_h, boolean[][] one_pits, boolean[][] two_wall_v, boolean[][] two_wall_h, boolean[][] two_pits, int x, int y, int[][][] one_pitCords, int[][][] two_pitCords){
        this.one_wall_v = one_wall_v;
        this.one_wall_h = one_wall_h;
        this.one_pits = one_pits;
        this.one_pitCords = one_pitCords;

        this.two_wall_v = two_wall_v;
        this.two_wall_h = two_wall_h;
        this.two_pits = two_pits;
        this.two_pitCords = two_pitCords;

        this.x = x;
        this.y = y;

        knownFrames = new boolean[x][y][x][y];
    }

    private Queue<FrameDuties> getOptions(FrameDuties akk, int f_one_x, int f_one_y, int f_two_x, int f_two_y){
        Queue<FrameDuties> options = new LinkedList<>();

        //->

        if(!one_wall_v[akk.one_x][akk.one_y] && !two_wall_v[akk.two_x][akk.two_y] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
            if (one_pits[akk.one_x+1][akk.one_y] && two_pits[akk.two_x+1][akk.two_y]){
                if (!knownFrames[one_pitCords[akk.one_x+1][akk.one_y][0]][one_pitCords[akk.one_x+1][akk.one_y][1]][two_pitCords[akk.two_x+1][akk.two_y][0]][two_pitCords[akk.two_x+1][akk.two_y][1]]) {
                    options.add(new FrameDuties(one_pitCords[akk.one_x+1][akk.one_y][0], one_pitCords[akk.one_x+1][akk.one_y][1], two_pitCords[akk.two_x+1][akk.two_y][0], two_pitCords[akk.two_x+1][akk.two_y][1], akk, 2, akk.cost + 1 + two_pitCords[akk.two_x+1][akk.two_y][2] + one_pitCords[akk.one_x+1][akk.one_y][1]));
                    knownFrames[one_pitCords[akk.one_x+1][akk.one_y][0]][one_pitCords[akk.one_x+1][akk.one_y][1]][two_pitCords[akk.two_x+1][akk.two_y][0]][two_pitCords[akk.two_x+1][akk.two_y][1]] = true;
                }
            } else if (two_pits[akk.two_x+1][akk.two_y]) {
                if (!knownFrames[akk.one_x+1][akk.one_y][two_pitCords[akk.two_x+1][akk.two_y][0]][two_pitCords[akk.two_x+1][akk.two_y][1]]) {
                    options.add(new FrameDuties(akk.one_x+1, akk.one_y, two_pitCords[akk.two_x+1][akk.two_y][0], two_pitCords[akk.two_x+1][akk.two_y][1], akk, 2, akk.cost + 1 + two_pitCords[akk.two_x+1][akk.two_y][2]));
                    knownFrames[akk.one_x+1][akk.one_y][two_pitCords[akk.two_x+1][akk.two_y][0]][two_pitCords[akk.two_x+1][akk.two_y][1]] = true;
                }
            } else if (one_pits[akk.one_x+1][akk.one_y]) {
                if (!knownFrames[one_pitCords[akk.one_x+1][akk.one_y][0]][one_pitCords[akk.one_x+1][akk.one_y][1]][akk.two_x+1][akk.two_y]) {
                    options.add(new FrameDuties(one_pitCords[akk.one_x+1][akk.one_y][0], one_pitCords[akk.one_x+1][akk.one_y][1], akk.two_x+1, akk.two_y, akk, 2, akk.cost + 1 + one_pitCords[akk.one_x+1][akk.one_y][2]));
                    knownFrames[one_pitCords[akk.one_x+1][akk.one_y][0]][one_pitCords[akk.one_x+1][akk.one_y][1]][akk.two_x+1][akk.two_y] = true;
                }
            } else {
                if (!knownFrames[akk.one_x+1][akk.one_y][akk.two_x+1][akk.two_y]) {
                    options.add(new FrameDuties(akk.one_x+1, akk.one_y, akk.two_x+1, akk.two_y, akk, 2, akk.cost + 1));
                    knownFrames[akk.one_x+1][akk.one_y][akk.two_x+1][akk.two_y] = true;
                }
            }
        } else if (!two_wall_v[akk.two_x][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y)) {
            if (two_pits[akk.two_x+1][akk.two_y]) {
                if (!knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x+1][akk.two_y][0]][two_pitCords[akk.two_x+1][akk.two_y][1]]) {
                    options.add(new FrameDuties(akk.one_x, akk.one_y, two_pitCords[akk.two_x+1][akk.two_y][0], two_pitCords[akk.two_x+1][akk.two_y][1], akk, 2, akk.cost + 1 + two_pitCords[akk.two_x+1][akk.two_y][2]));
                    knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x+1][akk.two_y][0]][two_pitCords[akk.two_x+1][akk.two_y][1]] = true;
                }
            } else {
                if (!knownFrames[akk.one_x][akk.one_y][akk.two_x+1][akk.two_y]) {
                    options.add(new FrameDuties(akk.one_x, akk.one_y, akk.two_x+1, akk.two_y, akk, 2, akk.cost + 1));
                    knownFrames[akk.one_x][akk.one_y][akk.two_x+1][akk.two_y] = true;
                }
            }
        } else if (!one_wall_v[akk.one_x][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y)) {
            if (one_pits[akk.one_x+1][akk.one_y]) {
                if (!knownFrames[one_pitCords[akk.one_x+1][akk.one_y][0]][one_pitCords[akk.one_x+1][akk.one_y][1]][akk.two_x][akk.two_y]) {
                    options.add(new FrameDuties(one_pitCords[akk.one_x+1][akk.one_y][0], one_pitCords[akk.one_x+1][akk.one_y][1], akk.two_x, akk.two_y, akk, 2, akk.cost + 1 + one_pitCords[akk.one_x+1][akk.one_y][2]));
                    knownFrames[one_pitCords[akk.one_x+1][akk.one_y][0]][one_pitCords[akk.one_x+1][akk.one_y][1]][akk.two_x][akk.two_y] = true;
                }
            } else {
                if (!knownFrames[akk.one_x+1][akk.one_y][akk.two_x][akk.two_y]) {
                    options.add(new FrameDuties(akk.one_x+1, akk.one_y, akk.two_x, akk.two_y, akk, 2, akk.cost + 1));
                    knownFrames[akk.one_x+1][akk.one_y][akk.two_x][akk.two_y] = true;
                }
            }
        }

        //<-
        
        if (akk.one_x > 0 && akk.two_x > 0){
        if (!one_wall_v[akk.one_x-1][akk.one_y] && !two_wall_v[akk.two_x-1][akk.two_y] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
            if (one_pits[akk.one_x-1][akk.one_y] && two_pits[akk.two_x-1][akk.two_y]){
            if (!knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, akk.cost + 1 + two_pitCords[akk.two_x-1][akk.two_y][2] + one_pitCords[akk.one_x-1][akk.one_y][2]));
                knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]] = true;
            }
            } else if (one_pits[akk.one_x-1][akk.one_y]){
            if (!knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][akk.two_x-1][akk.two_y]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], akk.two_x-1, akk.two_y, akk, 4, akk.cost + 1 + one_pitCords[akk.one_x-1][akk.one_y][2]));
                knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][akk.two_x-1][akk.two_y] = true;
            }
            } else if (two_pits[akk.two_x-1][akk.two_y]){
            if (!knownFrames[akk.one_x-1][akk.one_y][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]]) {
                options.add(new FrameDuties(akk.one_x-1, akk.one_y, two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, akk.cost + 1 + two_pitCords[akk.two_x-1][akk.two_y][2]));
                knownFrames[akk.one_x-1][akk.one_y][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]] = true;
            }
            } else {
            if (!knownFrames[akk.one_x-1][akk.one_y][akk.two_x-1][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x-1, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.cost + 1));
                knownFrames[akk.one_x-1][akk.one_y][akk.two_x-1][akk.two_y] = true;
            }
            }
        } else if (!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y) ){
            if (one_pits[akk.one_x-1][akk.one_y]){
            if (!knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], akk.two_x, akk.two_y, akk, 4, akk.cost + 1 + one_pitCords[akk.one_x-1][akk.one_y][2]));
                knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][akk.two_x][akk.two_y] = true;
            }
            } else {
            if (!knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4, akk.cost + 1));
                knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y] = true;
            }
            }
        } else if (!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y)){
            if (two_pits[akk.two_x-1][akk.two_y]){
            if (!knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, akk.cost + 1 + two_pitCords[akk.two_x-1][akk.two_y][2]));
                knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y] = true;
            }
            }
        }
        } else if (akk.one_x > 0){
        if (!one_wall_v[akk.one_x-1][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y)){
            if (one_pits[akk.one_x-1][akk.one_y]){
            if (!knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x-1][akk.one_y][0], one_pitCords[akk.one_x-1][akk.one_y][1], akk.two_x, akk.two_y, akk, 4, akk.cost + 1 + one_pitCords[akk.one_x-1][akk.one_y][2]));
                knownFrames[one_pitCords[akk.one_x-1][akk.one_y][0]][one_pitCords[akk.one_x-1][akk.one_y][1]][akk.two_x][akk.two_y] = true;
            }
            } else {
            if (!knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x-1, akk.one_y, akk.two_x, akk.two_y, akk, 4, akk.cost + 1));
                knownFrames[akk.one_x-1][akk.one_y][akk.two_x][akk.two_y] = true;
            }
            }
        }
        } else if (akk.two_x > 0){
        if (!two_wall_v[akk.two_x-1][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y)){
            if (two_pits[akk.two_x-1][akk.two_y]){
            if (!knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, two_pitCords[akk.two_x-1][akk.two_y][0], two_pitCords[akk.two_x-1][akk.two_y][1], akk, 4, akk.cost + 1 + two_pitCords[akk.two_x-1][akk.two_y][2]));
                knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x-1][akk.two_y][0]][two_pitCords[akk.two_x-1][akk.two_y][1]] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, akk.two_x-1, akk.two_y, akk, 4, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y][akk.two_x-1][akk.two_y] = true;
            }
            }
        }
        }

        //↓
        
        if (!one_wall_h[akk.one_x][akk.one_y] && !two_wall_h[akk.two_x][akk.two_y] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
        if (one_pits[akk.one_x][akk.one_y+1] && two_pits[akk.two_x][akk.two_y+1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y+1][0]][one_pitCords[akk.one_x][akk.one_y+1][1]][two_pitCords[akk.two_x][akk.two_y+1][0]][two_pitCords[akk.two_x][akk.two_y+1][1]]) {
            options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y+1][0], one_pitCords[akk.one_x][akk.one_y+1][1], two_pitCords[akk.two_x][akk.two_y+1][0], two_pitCords[akk.two_x][akk.two_y+1][1], akk, 3, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y+1][2] + one_pitCords[akk.one_x][akk.one_y+1][2]));
            knownFrames[one_pitCords[akk.one_x][akk.one_y+1][0]][one_pitCords[akk.one_x][akk.one_y+1][1]][two_pitCords[akk.two_x][akk.two_y+1][0]][two_pitCords[akk.two_x][akk.two_y+1][1]] = true;
            }
        } else if (one_pits[akk.one_x][akk.one_y+1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y+1][0]][one_pitCords[akk.one_x][akk.one_y+1][1]][akk.two_x][akk.two_y+1]) {
            options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y+1][0], one_pitCords[akk.one_x][akk.one_y+1][1], akk.two_x, akk.two_y+1, akk, 3, akk.cost + 1 + one_pitCords[akk.one_x][akk.one_y+1][2]));
            knownFrames[one_pitCords[akk.one_x][akk.one_y+1][0]][one_pitCords[akk.one_x][akk.one_y+1][1]][akk.two_x][akk.two_y+1] = true;
            }
        } else if (two_pits[akk.two_x][akk.two_y+1]){
            if (!knownFrames[akk.one_x][akk.one_y+1][two_pitCords[akk.two_x][akk.two_y+1][0]][two_pitCords[akk.two_x][akk.two_y+1][1]]) {
            options.add(new FrameDuties(akk.one_x, akk.one_y+1, two_pitCords[akk.two_x][akk.two_y+1][0], two_pitCords[akk.two_x][akk.two_y+1][1], akk, 3, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y+1][2]));
            knownFrames[akk.one_x][akk.one_y+1][two_pitCords[akk.two_x][akk.two_y+1][0]][two_pitCords[akk.two_x][akk.two_y+1][1]] = true;
            }
        } else {
            if (!knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y+1]) {
            options.add(new FrameDuties(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y+1, akk, 3, akk.cost + 1));
            knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y+1] = true;
            }
        }
        } else if (!one_wall_h[akk.one_x][akk.one_y] && !(akk.one_x == f_one_x && akk.one_y == f_one_y)){
        if (one_pits[akk.one_x][akk.one_y+1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y+1][0]][one_pitCords[akk.one_x][akk.one_y+1][1]][akk.two_x][akk.two_y]) {
            options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y+1][0], one_pitCords[akk.one_x][akk.one_y+1][1], akk.two_x, akk.two_y, akk, 3, akk.cost + 1 + one_pitCords[akk.one_x][akk.one_y+1][2]));
            knownFrames[one_pitCords[akk.one_x][akk.one_y+1][0]][one_pitCords[akk.one_x][akk.one_y+1][1]][akk.two_x][akk.two_y] = true;
            }
        } else {
            if (!knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y]) {
            options.add(new FrameDuties(akk.one_x, akk.one_y+1, akk.two_x, akk.two_y, akk, 3, akk.cost + 1));
            knownFrames[akk.one_x][akk.one_y+1][akk.two_x][akk.two_y] = true;
            }
        }
        } else if (!two_wall_h[akk.two_x][akk.two_y] && !(akk.two_x == f_two_x && akk.two_y == f_two_y)){
        if (two_pits[akk.two_x][akk.two_y+1]){
            if (!knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x][akk.two_y+1][0]][two_pitCords[akk.two_x][akk.two_y+1][1]]) {
            options.add(new FrameDuties(akk.one_x, akk.one_y, two_pitCords[akk.two_x][akk.two_y+1][0], two_pitCords[akk.two_x][akk.two_y+1][1], akk, 3, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y+1][2]));
            knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x][akk.two_y+1][0]][two_pitCords[akk.two_x][akk.two_y+1][1]] = true;
            }
        } else {
            if (!knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y+1]) {
            options.add(new FrameDuties(akk.one_x, akk.one_y, akk.two_x, akk.two_y+1, akk, 3, akk.cost + 1));
            knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y+1] = true;
            }
        }
        }
        

        //↑
        
        if (akk.one_y > 0 && akk.two_y > 0){
        if (!one_wall_h[akk.one_x][akk.one_y-1] && !two_wall_h[akk.two_x][akk.two_y-1] && !((akk.one_x == f_one_x && akk.one_y == f_one_y) || (akk.two_x == f_two_x && akk.two_y == f_two_y))){
            if (one_pits[akk.one_x][akk.one_y-1] && two_pits[akk.two_x][akk.two_y-1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y-1][2] + one_pitCords[akk.one_x][akk.one_y-1][2]));
                knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]] = true;
            }
            } else if (one_pits[akk.one_x][akk.one_y-1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][akk.two_x][akk.two_y-1]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], akk.two_x, akk.two_y-1, akk, 1, akk.cost + 1 + one_pitCords[akk.one_x][akk.one_y-1][2]));
                knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][akk.two_x][akk.two_y-1] = true;
            }
            } else if (two_pits[akk.two_x][akk.two_y-1]){
            if (!knownFrames[akk.one_x][akk.one_y-1][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y-1, two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y-1][2]));
                knownFrames[akk.one_x][akk.one_y-1][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y-1]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y-1, akk, 1, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y-1] = true;
            }
            }
        } else if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == f_one_x && akk.one_y == f_one_y)){
            if (one_pits[akk.one_x][akk.one_y-1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], akk.two_x, akk.two_y, akk, 1, akk.cost + 1 + one_pitCords[akk.one_x][akk.one_y-1][2]));
                knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][akk.two_x][akk.two_y] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y] = true;
            }
            }
        } else if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == f_two_x && akk.two_y == f_two_y)){
            if (two_pits[akk.two_x][akk.two_y-1]){
            if (!knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y-1][2]));
                knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1] = true;
            }
            }
        }
        } else if (akk.one_y > 0){
        if (!one_wall_h[akk.one_x][akk.one_y-1] && !(akk.one_x == f_one_x && akk.one_y == f_one_y)){
            if (one_pits[akk.one_x][akk.one_y-1]){
            if (!knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(one_pitCords[akk.one_x][akk.one_y-1][0], one_pitCords[akk.one_x][akk.one_y-1][1], akk.two_x, akk.two_y, akk, 1, akk.cost + 1 + one_pitCords[akk.one_x][akk.one_y-1][2]));
                knownFrames[one_pitCords[akk.one_x][akk.one_y-1][0]][one_pitCords[akk.one_x][akk.one_y-1][1]][akk.two_x][akk.two_y] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y-1, akk.two_x, akk.two_y, akk, 1, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y-1][akk.two_x][akk.two_y] = true;
            }
            }
        }
        } else if (akk.two_y > 0){
        if (!two_wall_h[akk.two_x][akk.two_y-1] && !(akk.two_x == f_two_x && akk.two_y == f_two_y)){
            if (two_pits[akk.two_x][akk.two_y-1]){
            if (!knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y,  two_pitCords[akk.two_x][akk.two_y-1][0], two_pitCords[akk.two_x][akk.two_y-1][1], akk, 1, akk.cost + 1 + two_pitCords[akk.two_x][akk.two_y-1][2]));
                knownFrames[akk.one_x][akk.one_y][two_pitCords[akk.two_x][akk.two_y-1][0]][two_pitCords[akk.two_x][akk.two_y-1][1]] = true;
            }
            } else {
            if (!knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1]) {
                options.add(new FrameDuties(akk.one_x, akk.one_y, akk.two_x, akk.two_y-1, akk, 1, akk.cost + 1));
                knownFrames[akk.one_x][akk.one_y][akk.two_x][akk.two_y-1] = true;
            }
            }
        }
        }
    


        return options;
    }

    public char[] findInstructions(int s_one_x, int s_one_y, int s_two_x, int s_two_y, int f_one_x, int f_one_y, int f_two_x, int f_two_y){
        
        FrameDuties akkFrame = new FrameDuties(s_one_x, s_one_y, s_two_x, s_two_y, null, 0, 0);

        FrameDuties lastFrame;
        Queue<FrameDuties> options;

        options = new PriorityQueue<>((f1, f2) -> Integer.compare(f1.cost, f2.cost));


        options.add(akkFrame);

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

    private char[] getInstructions(FrameDuties f, boolean successfull){
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
