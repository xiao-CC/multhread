package planewars;

import java.awt.*;

public class Bullet extends Flying{
    Color color;

    public Bullet(int x, int y, int vx, int vy, int size,Color color) {
        super(x, y, vx, vy, size);
        this.color=color;
    }

    @Override
    public void move() {
        super.move();
        this.setX(this.getX()+this.getVx());
        this.setY(this.getY()+this.getVy());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(this.getX(),this.getY(),getSize(),getSize());
    }
}
