package planewars;

import java.util.Vector;

/**
 * 写一个Main类居中调度，负责居中传值，初始化一些东西
 */
public class Main {

    private Plane plane;
    private Vector<Enemy> enemies=new Vector<>();;
    private Vector<Bullet> enemyBullets=new Vector<>();
    private UI ui;

    void init(){
        plane=Plane.creatPlant();
        MouLisen mouLisen=new MouLisen(plane);
        ui=new UI(mouLisen);
        new Thread(new DrawThread(this)).start();
        new Thread(new MoveThread(this)).start();
        new Thread(new AutoCreatThread(this)).start();
        new Thread(new IsCollideThread(this)).start();
        while (true){
            plane.fire(plane);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Main main=new Main();
        main.init();
    }

    public Plane getPlane() {
        return plane;
    }
    public Vector<Enemy> getEnemies() {
        return enemies;
    }
    public UI getUi() {
        return ui;
    }
    public Vector<Bullet> getEnemyBullets() {
        return enemyBullets;
    }
    public void setEnemyBullets(Vector<Bullet> enemyBullets) {
        this.enemyBullets = enemyBullets;
    }
}
