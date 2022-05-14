package threadpool;

import java.util.Random;
/**
 * 测试类。new一个线程池，start()这个线程池。使用execute向线程池中添加任务，execute的参数应该使一个线程形式的任务。下面的run()中为任务。
 */
public class TestPool {
    public static void main(String[] args) throws InterruptedException{
        Random random=new Random();

        ThreadPool pool = new ThreadPool (5, 100, 10, 500);
        pool.startWork ();

        for(int i = 0; i < 1500; i++){

            Thread.sleep (random.nextInt (50)+10);

            System.out.println ("已经添加任务->" + i);
            pool.execute (new Runnable (){  //虽然Runnable是个接口，但是这样写解释个实现了接口的匿名类
                @Override
                public void run(){
                    try {
                        Thread.sleep (1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
            });
        }
    }
}
