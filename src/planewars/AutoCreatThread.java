package planewars;

import java.util.Random;
import java.util.Vector;

public class AutoCreatThread implements Runnable{

    private Main main;
    private Vector<Enemy> enemies;
    private Vector<Bullet> enemyBullet;

    public AutoCreatThread(Main main) {
        this.main = main;
        enemies=main.getEnemies();
        enemyBullet=main.getEnemyBullets();
    }

    @Override
    public void run() {
        while (true){
            int x= new Random().nextInt(1000);
            int y=new Random().nextInt(400);
            int vx=new Random().nextInt(10)-5;
            int vy=new Random().nextInt(10)-5;
            Enemy enemy=new Enemy(x,y,vx,vy,20);
            enemies.add(enemy);

            GunThread gunThread=new GunThread(enemy,enemyBullet);
            new Thread(gunThread).start();

            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
