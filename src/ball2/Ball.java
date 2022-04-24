package ball2;

import java.awt.*;
import java.util.List;

public class Ball{

    public int x;
    public int y;
    int vx;
    int vy;
    List<Ball> balls;
    public void setBalls(List<Ball> balls){
        this.balls=balls;
    }

    public Ball(){
        x=200+(int)(Math.random()*800);
        y=200+(int)(Math.random()*800);
        if (Math.random()>0.5){vx=1;}else {vx=-1;}
        if (Math.random()>0.5){vy=1;}else {vy=-1;}
    }
    //画小球
    public void drawBall(Graphics g,int i) {
        g.fillOval(x,y, 20, 20);
        move();
    }
    //移动,这种写法很有意思
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

}
