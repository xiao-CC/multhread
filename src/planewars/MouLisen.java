package planewars;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouLisen implements MouseMotionListener {

    Plane plane;

    public MouLisen(Flying flying) {
        this.plane= (Plane) flying;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //只有在飞机上点击的时候，才能拖动飞机，但是测试发现，这么做不能拖动过快，说明这个方案不太合理
        if (e.getX()>=plane.getX()-plane.getSize()
                &&e.getX()<=plane.getX()+plane.getSize()
                &&e.getY()>=plane.getY()-plane.getSize()
                &&e.getY()<=plane.getY()+plane.getSize()) {
            plane.move(e.getX(),e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
