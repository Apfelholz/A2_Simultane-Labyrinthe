
public class Frame {
    int one_x;
    int one_y;
    int two_x;
    int two_y;

    Frame dad;
    int lastDirection;

    public Frame(int one_x, int one_y, int two_x, int two_y, Frame dad, int direction){
        this.one_x = one_x;
        this.one_y = one_y;
        this.two_x = two_x;
        this.two_y = two_y;
        this.dad = dad;
        this.lastDirection = direction;
    }
}
