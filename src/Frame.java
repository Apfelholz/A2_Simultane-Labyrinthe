import java.util.Arrays;
import java.util.Objects;

public class Frame {
    int one_x;
    int one_y;
    int two_x;
    int two_y;

    Frame dad;
    int lastDirection;
    int one_lastDirection;
    int two_lastDirection;
    
    boolean[][] one_wall_v;
    boolean[][] one_wall_h;
    boolean[][] two_wall_v;
    boolean[][] two_wall_h;

    boolean[][] two_plates;
    int[][][] two_plate_cords_action;

    boolean[][] one_plates;
    int[][][] one_plate_cords_action;

    public Frame(int one_x, int one_y, int two_x, int two_y, Frame dad, int direction, int one_direction, int two_direction, boolean[][] one_wall_v, boolean[][] one_wall_h, boolean[][] two_wall_v, boolean[][] two_wall_h, boolean[][] two_plates, int[][][] two_plate_cords_action, boolean[][] one_plates, int[][][] one_plate_cords_action){
        this.one_x = one_x;
        this.one_y = one_y;
        this.two_x = two_x;
        this.two_y = two_y;
        this.dad = dad;
        this.lastDirection = direction;
        this.one_lastDirection = one_direction;
        this.two_lastDirection = two_direction;
        this.one_wall_v = one_wall_v;
        this.one_wall_h = one_wall_h;
        this.two_wall_v = two_wall_v;
        this.two_wall_h = two_wall_h;
        this.two_plates = two_plates;
        this.two_plate_cords_action = two_plate_cords_action;
        this.one_plates = one_plates;
        this.one_plate_cords_action = one_plate_cords_action;

        checkForPlates();
    }

    private void checkForPlates() {
        if (one_plates[one_x][one_y]){
            if (one_plate_cords_action[one_x][one_y][0] == 1) {
                if (one_plate_cords_action[one_x][one_y][3] == 1) {
                    one_wall_h[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = false;
                    one_wall_v[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = false;
                } else if (one_plate_cords_action[one_x][one_y][3] == 2) {
                    one_wall_v[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = true;
                } else if (one_plate_cords_action[one_x][one_y][3] == 3) {
                    one_wall_h[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = true;
                }
            } else if (one_plate_cords_action[one_x][one_y][0] == 2) {
                if (one_plate_cords_action[one_x][one_y][3] == 1) {
                    two_wall_h[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = false;
                    two_wall_v[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = false;
                } else if (one_plate_cords_action[one_x][one_y][3] == 2) {
                    two_wall_v[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = true;
                } else if (one_plate_cords_action[one_x][one_y][3] == 3) {
                    two_wall_h[one_plate_cords_action[one_x][one_y][1]][one_plate_cords_action[one_x][one_y][2]] = true;
                }
            }
        }

        if (two_plates[two_x][two_y]) {
            if (two_plate_cords_action[two_x][two_y][0] == 1) {
                if (two_plate_cords_action[two_x][two_y][3] == 1) {
                    two_wall_h[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = false;
                    two_wall_v[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = false;
                } else if (two_plate_cords_action[two_x][two_y][3] == 2) {
                    two_wall_v[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = true;
                } else if (two_plate_cords_action[two_x][two_y][3] == 3) {
                    two_wall_h[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = true;
                }
            } else if (two_plate_cords_action[two_x][two_y][0] == 2) {
                if (two_plate_cords_action[two_x][two_y][3] == 1) {
                    one_wall_h[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = false;
                    one_wall_v[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = false;
                } else if (two_plate_cords_action[two_x][two_y][3] == 2) {
                    one_wall_v[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = true;
                } else if (two_plate_cords_action[two_x][two_y][3] == 3) {
                    one_wall_h[two_plate_cords_action[two_x][two_y][1]][two_plate_cords_action[two_x][two_y][2]] = true;
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Frame other = (Frame) obj;

        return one_x == other.one_x &&
               one_y == other.one_y &&
               two_x == other.two_x &&
               two_y == other.two_y &&
               Arrays.deepEquals(one_wall_v, other.one_wall_v) &&
               Arrays.deepEquals(one_wall_h, other.one_wall_h) &&
               Arrays.deepEquals(two_wall_v, other.two_wall_v) &&
               Arrays.deepEquals(two_wall_h, other.two_wall_h);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(one_x, one_y, two_x, two_y);
        result = 31 * result + Arrays.deepHashCode(one_wall_v);
        result = 31 * result + Arrays.deepHashCode(one_wall_h);
        result = 31 * result + Arrays.deepHashCode(two_wall_v);
        result = 31 * result + Arrays.deepHashCode(two_wall_h);
        return result;
    }
}
