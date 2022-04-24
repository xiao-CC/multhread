package ball3;

import java.util.List;

public class NewBall extends Thread{

    List<Ball> balls;
    public NewBall(List<Ball> balls){
        this.balls=balls;
    }
    boolean newFlag=false;

    @Override
    public void run() {
        /*
        * 线程的RUN方法中一般都用while(true)循环
        * 结束线程，一般是通过结束这个循环来实现*/
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (newFlag){
                Ball ball=new Ball();
                balls.add(ball);
                //newFlag=false;
            }

        }
    }
}
