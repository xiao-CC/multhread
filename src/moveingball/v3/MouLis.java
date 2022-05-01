package moveingball.v3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class MouLis implements MouseListener, MouseMotionListener {

    private Random ran=new Random();
    private Graphics g;
    private Ui ui;
    public void setUi(Ui ui) {this.ui = ui;}
    /*List不支持线程安全
     * 就是说，一边向线程里add一边draw或者move会出现错误
     * 监听器本身也是个线程，此时会出现那个问题，即balls不知道是该add还是该draw(move)*/
    ArrayList<Ball> balls=new ArrayList<>();

    @Override
    public void mousePressed(MouseEvent e) {

        /*int x=e.getX();
        int y=e.getY();
        int size=ran.nextInt(50)+25;
        int vx=ran.nextInt(5)+1;
        int vy=ran.nextInt(5)+1;
        Color color=new Color(ran.nextInt(Integer.MAX_VALUE));

        Ball ball=new Ball(x,y,size,vx,vy,color);
        balls.add(ball);
        g=ui.getGraphics();
        DrawThread drawThread=new DrawThread(g,balls);
        MoveThread moveThread=new MoveThread(balls);
        new Thread(drawThread).start();
        new Thread(moveThread).start();*/
    }
    @Override
    public void mouseDragged(MouseEvent e) {

        int x=e.getX();
        int y=e.getY();

        MainBall mainBall=new MainBall(x,y);
        g=ui.getGraphics();

        MainBallThread thread=new MainBallThread(mainBall,g);
        new Thread(thread).start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
