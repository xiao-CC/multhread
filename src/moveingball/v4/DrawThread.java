package moveingball.v4;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawThread extends Thread{
    Graphics g;
    ArrayList<moveingball.v4.Ball> balls;

    public DrawThread(Graphics g, ArrayList<moveingball.v4.Ball> balls) {
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

            BufferedImage buff=new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
            Graphics2D g2=(Graphics2D)buff.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(238,238,238));
            g2.fillRect(0,0,1000,1000);

            for(int i = 0; i < balls.size (); i++){
                moveingball.v4.Ball ball = balls.get (i);
                ball.drawBall(g2);
            }
            g.drawImage(buff,0,0,null);
        }
    }
}
