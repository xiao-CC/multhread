package ball3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class ButLien implements KeyListener,ActionListener{

    Graphics g;
    List<Ball> balls=new ArrayList<>();

    NewBall newBall;
    ContBall contBall;

    public ButLien(Graphics g){
        this.g=g;
        contBall =new ContBall(g,balls);
        newBall=new NewBall(balls);
        contBall.start();
        newBall.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String butName=e.getActionCommand();
        if ("开始".equals(butName)){  //字符串放前面，可以避免butName空指针报错
            newBall.newFlag=true;
            contBall.contFlag =true;
            JButton btn = (JButton) e.getSource();
            Ui ui= (Ui) btn.getRootPane().getParent();
            ui.requestFocus();
        }
        if ("暂停".equals(e.getActionCommand())){
            contBall.contFlag =false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //typed指的是字符，包括字母、数字、标点、空格
        //这个方法一般都是打字用的
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();  //这玩意居然是个int
        switch (key){
            case KeyEvent.VK_A:
                Board.dx=Board.dx-5;
                break;
            case KeyEvent.VK_D:
                Board.dx=Board.dx+5;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //松开按钮触发此方法
    }
}
