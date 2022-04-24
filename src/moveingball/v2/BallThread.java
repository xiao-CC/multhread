package moveingball.v2;

import java.awt.*;

public class BallThread extends Thread{

    Graphics g;
    Ball ball;

    public BallThread(Graphics g, Ball ball){
        this.g=g;
        this.ball=ball;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ball.drawBall(g);
            ball.move();
        }
    }

}
