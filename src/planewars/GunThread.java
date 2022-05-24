package planewars;

import java.awt.*;
import java.util.Vector;

public class GunThread implements Runnable{
    private Enemy enemy;
    private Vector<Bullet> enemyBullets;

    public GunThread(Enemy enemy,Vector<Bullet> enemyBullets) {
        this.enemy = enemy;
        this.enemyBullets=enemyBullets;
    }

    @Override
    public void run() {
        while (true){   //这里想用enemy!=nill作为判断条件，但是不行，必须要用HP这种flag
            if (enemy.getHP()==0){
                break;
            }
            Bullet bullet=new Bullet(enemy.getX()+ enemy.getSize()/2, enemy.getY(), 0,30,10, Color.BLACK);
            enemyBullets.add(bullet);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
