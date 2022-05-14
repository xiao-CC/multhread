package planewars;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouLisen implements MouseMotionListener {
    Flying flying;

    public MouLisen(Flying flying) {
        this.flying=flying;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        flying.setX(e.getX());
        flying.setY(e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
