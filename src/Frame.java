
public class Frame {
    int one_x;
    int one_y;
    int two_x;
    int two_y;

    Frame dad;
    int lastDirection;
    int one_lastDirection;
    int two_lastDirection;

    public Frame(int one_x, int one_y, int two_x, int two_y, Frame dad, int direction, int one_direction, int two_direction){
        this.one_x = one_x;
        this.one_y = one_y;
        this.two_x = two_x;
        this.two_y = two_y;
        this.dad = dad;
        this.lastDirection = direction;
        this.one_lastDirection = 0;
        this.two_lastDirection = 0;
    }
}
