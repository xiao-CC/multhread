package planewars;

public class Main {
    Plane plane;
    void init(){
        plane=Plane.creatPlant();
        MouLisen mouLisen=new MouLisen(plane);
        UI ui=new UI(mouLisen);

    }
    public static void main(String[] args) {
        Main main=new Main();
        main.init();

    }
}
