package ball2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButLien implements ActionListener {

    Graphics g;
    List<Ball> balls=new ArrayList<>();

    NewBall newBall;
    ContBall contBall;//这个变量位置很有讲究
                      //放在这里，既可以调整线程的暂停，又可以再构造时new，保证只有一个线程

    public ButLien(Graphics g){
        this.g=g;
        contBall =new ContBall(g,balls);
        newBall=new NewBall(balls);
        contBall.start();
        newBall.start();
       /* this.contFlag= contBall.contFlag;
        this.newFlag=newBall.newFlag;*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String butName=e.getActionCommand();
        if ("开始".equals(butName)){  //字符串放前面，可以避免butName空指针报错
            newBall.newFlag=true;
            contBall.contFlag =true;
        }
        if ("暂停".equals(e.getActionCommand())){
            contBall.contFlag =false;
        }

    }
}
