package planewars;

import java.util.Vector;

public class IsCollideThread implements Runnable{

    Main main;
    Vector<Enemy> enemies;
    Plane plane;
    Vector<Bullet> planeBullets;

    public IsCollideThread(Main main) {
        this.main = main;
        this.enemies =main.getEnemies();
        this.plane = main.getPlane();
        this.planeBullets=plane.getPlaneBullets();
    }

    @Override
    public void run() {
        while (true){
            for (int i=0;i<enemies.size();i++){
                Enemy enemy=enemies.get(i);
                Boolean isCollde=plane.isCollide(enemy.getX(),enemy.getY(),enemy.getSize());
                if (isCollde){
                    enemy.setHP(0);
                    enemies.remove(i);
                }
            }
            for (int i=0;i<enemies.size();i++){
                Enemy enemy=enemies.get(i);
                for (int j=0;j<planeBullets.size();j++){
                    Bullet bullet=planeBullets.get(j);
                    Boolean isCollde=bullet.isCollide(enemy.getX(),enemy.getY(),enemy.getSize());
                    if (isCollde){
                        enemy.setHP(0);
                        enemies.remove(i);
                    }
                }
            }
        }
    }
}
