package ball3;

import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame {
    public Graphics g;
    public Ui(){
        this.setSize(1000,1000);
        this.setTitle("我也不知道叫啥");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        g=this.getGraphics();

        JButton jButton=new JButton("开始");
        JButton jButton2=new JButton("暂停");
        this.add(jButton);
        this.add(jButton2);

        ButLien butLien =new ButLien(g);
        jButton.addActionListener(butLien);
        jButton2.addActionListener(butLien);
        this.addKeyListener(butLien);
    }
}
