import java.util.ArrayList;

public class Frame {
    int one_x;
    int one_y;
    int two_x;
    int two_y;

    ArrayList<Frame> childs = new ArrayList<Frame>();

    public Frame(int one_x, int one_y, int two_x, int two_y){
        this.one_x = one_x;
        this.one_y = one_y;
        this.two_x = two_x;
        this.two_y = two_y;
    }

    public void addChild(Frame child){
        childs.add(child);
    }
}
