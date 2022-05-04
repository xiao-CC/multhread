package moveingball.v4;

import java.awt.*;

public class MainBall {
    private int x,y=0;
    private int size=20;

    public MainBall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor (Color.BLACK);
        g.fillOval (x, y, size,size);
    }

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}
}
