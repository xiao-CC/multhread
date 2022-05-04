package moveingball.v4;

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
        BufferedImage buff=new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=(Graphics2D)buff.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(238,238,238));
        g2.fillRect(0,0,1000,1000);
        ball.draw(g2);
        g.drawImage(buff,0,0,null);
    }
}
