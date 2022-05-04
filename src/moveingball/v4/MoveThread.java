package moveingball.v4;

import java.util.ArrayList;

public class MoveThread extends Thread{
    ArrayList<Ball> balls;

    public MoveThread(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public void run() {
        //想让线程一致运行，而不是像监听器那样监听，就要用死循环
        while(true){
            try {
                Thread.sleep (30);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

            for(int i = 0; i < balls.size (); i++){
                Ball ball = balls.get (i);
                ball.move();
            }
        }
    }
}
