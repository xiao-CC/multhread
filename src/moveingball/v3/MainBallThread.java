package moveingball.v3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainBallThread implements Runnable{
    MainBall ball;
    Graphics g;

    public MainBallThread(MainBall ball, Graphics g) {
        this.ball = ball;
        this.g = g;
    }

    @Override
    public void run() {
        //1.new一个图片缓存器
        BufferedImage buff=new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
        //2.获取缓存器的画笔
        Graphics2D g2=(Graphics2D)buff.getGraphics();
        //这个能抗锯齿，好看一点
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //3.在缓存器上画背景。
        g2.setColor(new Color(238,238,238));
        g2.fillRect(0,0,1000,1000);
        //4.在缓存器上画小球
        ball.draw(g2);
        //在背景上画缓存器（即把缓存器中的小球和背景一起画出来）
        g.drawImage(buff,0,0,null);
    }
}
