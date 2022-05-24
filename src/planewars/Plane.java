package planewars;

import java.awt.*;
import java.util.Vector;

public class Plane extends Flying{

    private Boolean isCollide;
    private Vector<Bullet> planeBullets =new Vector<>();

    public Plane(int x, int y, int vx, int vy, int size) {
        super(x, y, vx, vy, size);
        isCollide=false;
    }

    //这个new对象放在了creat方法的外面，应该是与加载顺序有关，可以复习下新建对象加载顺序的东西
    private static Plane plane=new Plane(500,900,0,0,50);

    public static Plane creatPlant(){
        return plane;
    }

    public void move(int x,int y){
        this.setX(x);
        this.setY(y);
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRoundRect(getX(),getY(),getSize(),getSize(),4,4);
    }

    public void fire(Plane plane){
        Bullet bullet=new Bullet(plane.getX()+ plane.getSize()/2, plane.getY(), 0,-30,10,Color.WHITE);
        planeBullets.add(bullet);
    }

    public Vector<Bullet> getPlaneBullets() {
        return planeBullets;
    }
}
