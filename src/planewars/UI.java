package planewars;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    MouLisen mouLis;
    Graphics g;

    public UI(MouLisen mouLisen){

        this.setSize(1000,1000);
        this.setTitle("灰机大战");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        g=this.getGraphics();   //画笔必须在可见性后面获取
        mouLis=mouLisen;
        this.addMouseMotionListener(mouLis);
    }
}
