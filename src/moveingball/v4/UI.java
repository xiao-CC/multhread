package moveingball.v4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class UI extends JFrame {

    volatile Graphics g;
    moveingball.v4.MouLis mouLis=new moveingball.v4.MouLis();
    ArrayList<Ball> balls;

    public UI(){

        this.setSize(1000,1000);
        this.setTitle("我也不知道叫啥");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        g=this.getGraphics();   //画笔必须在可见性后面获取

        mouLis.setUi(this);
        this.addMouseListener(mouLis);
        this.addMouseMotionListener(mouLis);
        this.timedTask();
    }

    private void timedTask(){
        balls=new ArrayList<>();
        moveingball.v4.DrawThread drawThread=new moveingball.v4.DrawThread(g,balls);
        moveingball.v4.MoveThread moveThread=new moveingball.v4.MoveThread(balls);
        new Thread(drawThread).start();
        new Thread(moveThread).start();

        while (true){

            Random ran=new Random();
            int x=ran.nextInt(1000);
            int y=ran.nextInt(1000);
            int size=ran.nextInt(50)+25;
            int vx=ran.nextInt(5)+1;
            int vy=ran.nextInt(5)+1;
            Color color=new Color(ran.nextInt(Integer.MAX_VALUE));

            moveingball.v4.Ball ball=new moveingball.v4.Ball(x,y,size,vx,vy,color);
            balls.add(ball);

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    /**
     *通过设一个计数器的方式来实现10个小球小球创建线程。这玩意的启发就是：多想想计数器，多使用if,else结构去调整计数器。自带的for,while并不能解决所有问题*/
    private void timedTask1(){

        int count=0;    //计数器

        while (true){
            if (count==0){
                balls=new ArrayList<>();
                moveingball.v4.DrawThread drawThread=new moveingball.v4.DrawThread(g,balls);
                moveingball.v4.MoveThread moveThread=new moveingball.v4.MoveThread(balls);
                new Thread(drawThread).start();
                new Thread(moveThread).start();
            }
            Random ran=new Random();
            int x=ran.nextInt(1000);
            int y=ran.nextInt(1000);
            int size=ran.nextInt(50)+25;
            int vx=ran.nextInt(5)+1;
            int vy=ran.nextInt(5)+1;
            Color color=new Color(ran.nextInt(Integer.MAX_VALUE));
            moveingball.v4.Ball ball=new moveingball.v4.Ball(x,y,size,vx,vy,color);
            balls.add(ball);

            count++;
            if (count==2000){
                count=0;
            }

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
}
