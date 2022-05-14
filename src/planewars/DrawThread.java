package planewars;

public class DrawThread implements Runnable{
    Main main;
    Plane plane;
    UI ui;
    public DrawThread(Main main) {
        this.main=main;
        plane=main.plane;
        ui=main.ui;
        plane.draw(ui.getGraphics());

    }

    @Override
    public void run() {

    }
}
