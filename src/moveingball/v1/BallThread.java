package moveingball.v1;

import java.awt.*;

public class BallThread extends Thread{

    Graphics g;
    Ball ball;

    public BallThread(Graphics g,Ball ball){
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
            /*由于这个move是放在死循环里，和draw一起执行的。move完之后，下一轮循环就会开始draw
            所以在Ball类中，move这个方法本身并不需要考虑move之后怎样去draw的问题*/
            ball.drawBall(g);
            ball.move();
        }
    }

}
