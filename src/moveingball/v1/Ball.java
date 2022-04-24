package moveingball.v1;

import java.awt.*;

public class Ball{

    private int x,y,size,vx,vy;
    private Color color;

    //画小球
    public void drawBall(Graphics g) {
        g.setColor (color);
        g.fillOval (x, y, size, size);
    }

    //移动
    public void move() {
        if (x>0&&x<1000){
            x+=vx;
        }else {
            x-=vx;
        }
        if (y>100&&y<1000){
            y+=vy;
        }else {
            y-=vy;
        }
    }

    public Ball(int x, int y, int size, int vx, int vy, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getVx() {
        return vx;
    }
    public void setVx(int vx) {
        this.vx = vx;
    }
    public int getVy() {
        return vy;
    }
    public void setVy(int vy) {
        this.vy = vy;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
