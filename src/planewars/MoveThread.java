package planewars;

import java.util.Vector;

public class MoveThread implements Runnable{

    Main main;
    Vector<Enemy> enemies;
    Vector<Bullet> planeBullets;
    Vector<Bullet> enemyBullets;

    public MoveThread(Main main) {
        this.main = main;
        enemies=main.getEnemies();
        planeBullets=main.getPlane().getPlaneBullets();
        enemyBullets=main.getEnemyBullets();
    }

    @Override
    public void run() {
        while (true){
            //这个水面的意义在于，防止飞行物移动的太快，刚创建出来就移动没了
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            //实践证明，这个队列长度每次循环都会改变
            for (int i=0;i<enemies.size();i++){
                Enemy enemy=enemies.get(i);
                enemy.move();
                if (enemy.getX()>1000
                    ||enemy.getX()<0
                    ||enemy.getY()<0
                    ||enemy.getY()>1000){
                    enemies.remove(enemy);
                    enemy.setHP(0);
                }
            }

            for (int i=0;i<planeBullets.size();i++){
                Bullet bullet=planeBullets.get(i);
                bullet.move();
                if (bullet.getX()>1000
                        ||bullet.getX()<0
                        ||bullet.getY()<0
                        ||bullet.getY()>1000){
                    enemies.remove(bullet);
                }
            }

            for (int i=0;i<enemyBullets.size();i++){
                Bullet bullet=enemyBullets.get(i);
                bullet.move();
                if (bullet.getX()>1000
                        ||bullet.getX()<0
                        ||bullet.getY()<0
                        ||bullet.getY()>1000){
                    enemies.remove(bullet);
                }
            }
        }
    }
}
