package moveingball.v3;

import java.awt.*;

public class Ball{

    private int x,y,size,vx,vy;
    private Color color;

    //画小球
    public void drawBall(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        g2.setColor (color);
        g2.fillOval (x, y, size, size);
    }

    /*移动功能修改
    * 触界后修改速度为负值即可实现边界反弹
    * 并不是用位置减去速度*/
    public void move() {
        if (x<0||x>1000) {
            vx=-vx;
        }
        if (y<0||y>1000) {
            vy=-vy;
        }
        x+=vx;
        y+=vy;
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
