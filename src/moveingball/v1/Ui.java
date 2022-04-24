package moveingball.v1;

import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame {

    public Graphics g;
    MouLis mouLis=new MouLis();

    public Ui(){
        this.setSize(1000,1000);
        this.setTitle("我也不知道叫啥");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        g=this.getGraphics();
        mouLis.setG(g);
        this.addMouseListener(mouLis);
        this.addMouseMotionListener(mouLis);
    }
}
