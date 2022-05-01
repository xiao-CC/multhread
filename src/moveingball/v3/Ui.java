package moveingball.v3;

import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame {

    MouLis mouLis=new MouLis();

    public Ui(){
        this.setSize(1000,1000);
        this.setTitle("我也不知道叫啥");
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        mouLis.setUi(this);
        this.addMouseListener(mouLis);
        this.addMouseMotionListener(mouLis);
    }
}
