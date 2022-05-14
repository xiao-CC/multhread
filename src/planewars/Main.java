package planewars;

/**
 * 写一个Main类居中调度，负责居中传值，初始化一些东西
 */
public class Main {
    Plane plane;
    UI ui;

    void init(){
        plane=Plane.creatPlant();
        MouLisen mouLisen=new MouLisen(plane);
        ui=new UI(mouLisen);
        new Thread(new DrawThread(this)).start();
        new Thread(new MoveThread(this)).start();
    }
    public static void main(String[] args) {
        Main main=new Main();
        main.init();
    }
}
