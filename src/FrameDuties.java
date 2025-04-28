
public class FrameDuties {
    int one_x;
    int one_y;
    int two_x;
    int two_y;

    FrameDuties dad;
    int lastDirection;
    int cost;

    public FrameDuties(int one_x, int one_y, int two_x, int two_y, FrameDuties dad, int direction, int cost){
        this.one_x = one_x;
        this.one_y = one_y;
        this.two_x = two_x;
        this.two_y = two_y;
        this.dad = dad;
        this.lastDirection = direction;
        this.cost = cost;
    }
}
