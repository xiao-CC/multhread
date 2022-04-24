package moveingball.v2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MouLis implements MouseListener, MouseMotionListener {

    private Random ran=new Random();
    /*关于画笔，画笔对象是从ui中获取的
    * 这里使用setG,从ui中，把画笔传过来
    * 还可以写一个setUI，把Ui整个传国来，然后在监听器中获取画笔*/
    private Graphics g;
    public void setG(Graphics g) {
        this.g = g;
    }
    /*这样的话，每个线程得到的g均不是同一个对象
    private Ui ui;
    public void setUi(Ui ui) {this.ui = ui;}
    g=ui.getGraphics(); //这个放在run（）中
    */

    @Override
    public void mousePressed(MouseEvent e) {

        int x=e.getX();
        int y=e.getY();
        int size=ran.nextInt(50)+25;
        int vx=ran.nextInt(5)+1;
        int vy=ran.nextInt(5)+1;
        Color color=new Color(ran.nextInt(Integer.MAX_VALUE));

        Ball ball=new Ball(x,y,size,vx,vy,color);
        BallThread ballThread=new BallThread(g,ball);
        new Thread(ballThread).start();
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
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
