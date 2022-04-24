package ball3;

import java.awt.*;
import java.util.List;

public class ContBall extends Thread{

    Graphics g;
    List<Ball> ballList;
    boolean contFlag =true;
    Board board;

    public ContBall(Graphics g,List<Ball> ballList){
        this.g=g;
        this.ballList=ballList;
        board=new Board();
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (contFlag){
                g.setColor(Color.WHITE);
                g.fillRect(0,100,1000,900);
                g.setColor(Color.BLACK);
                board.drawBoaed(g);

                for (int i=0;i<ballList.size();i++){
                    ballList.get(i).drawBall(g,i);
                }
            }
        }
    }

}
