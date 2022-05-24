package planewars;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Enemy extends Flying{

    private Color color;
    private int HP;

    public Enemy(int x, int y, int vx, int vy, int size) {
        super(x, y, vx, vy, size);
        color=new Color(new Random().nextInt(Integer.MAX_VALUE));
        HP=1;
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

    public void setColor(Color color) {
        this.color = color;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
}
