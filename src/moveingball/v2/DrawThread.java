package moveingball.v2;

import java.awt.*;
import java.util.ArrayList;

public class DrawThread extends Thread{
    Graphics g;
    ArrayList<Ball> balls;

    public DrawThread(Graphics g, ArrayList<Ball> balls) {
        this.g = g;
        this.balls = balls;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep (30);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            for(int i = 0; i < balls.size (); i++){
                Ball ball = balls.get (i);
                ball.drawBall(g);
            }
            System.out.println(g.hashCode());
        }
    }
}
