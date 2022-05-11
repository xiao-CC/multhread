package planewars;

public class Plane extends Flying{

    public Plane(int x, int y, int vx, int vy, int size) {
        super(x, y, vx, vy, size);
    }

    //这个new对象放在了creat方法的外面，应该是与加载顺序有关？
    private static Plane plane=new Plane(500,50,0,0,50);

    public static Plane creatPlant(){
        return plane;
    }
}
