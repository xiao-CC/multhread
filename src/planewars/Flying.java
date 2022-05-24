package planewars;

import java.awt.*;

public class Flying {
    private volatile int x;
    private volatile int y;
    private int vx;
    private int vy;
    private int size;

    public Flying(int x, int y, int vx, int vy, int size) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.size = size;
    }

    public void move(){}
    public void draw(Graphics g){}
    public boolean isCollide(int x,int y,int size){
        if (x>=this.x
            &&x<=this.x+this.size
            &&y>=this.y
            &&y<=this.y+this.size){
            return true;
        }else {
            return false;
        }
        //把return false放在else外面为什么不行？
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
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
