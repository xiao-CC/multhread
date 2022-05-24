package planewars;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class DrawThread implements Runnable{

    private Main main;
    private Plane plane;
    private Vector<Enemy> enemies;
    private Vector<Bullet> planeBullets;
    private Vector<Bullet> enemyBullets;
    private UI ui;
    private Graphics g;

    public DrawThread(Main main) {
        this.main=main;
        plane=main.getPlane();
        enemies=main.getEnemies();
        ui=main.getUi();
        planeBullets=main.getPlane().getPlaneBullets();
        enemyBullets=main.getEnemyBullets();
        g=ui.getGraphics();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //plane.draw(ui.getGraphics());不要把获取画笔放在while里面，每次循环都重新获取画笔，浪费资源。
            //画背景板
            BufferedImage bf=new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
            Graphics2D g2= (Graphics2D) bf.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(238,238,238));
            g2.fillRect(0,0,1000,1000);
            //画飞机们
            plane.draw(g2);
            for (int i=0;i<enemies.size();i++){
                enemies.get(i).draw(g2);
            }
            for (int i=0;i<planeBullets.size();i++){
                planeBullets.get(i).draw(g2);
            }
            for (int i=0;i<enemyBullets.size();i++){
                enemyBullets.get(i).draw(g2);
            }

            g.drawImage(bf,0,0,null);
        }
    }
}
