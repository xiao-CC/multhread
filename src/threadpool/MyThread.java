package threadpool;

import java.util.concurrent.BlockingDeque;

/**
 * 虽然这是个线程，但是这个线程只负责调度。从任务queue中取出任务来交给线程set执行。
 */
public class MyThread extends Thread{

    BlockingDeque<Runnable> taskQueue;

    public MyThread(BlockingDeque<Runnable> taskQueue){
        this.taskQueue = taskQueue;
    }

    @Override
    public void run(){
        while(!interrupted ()){     //看线程是否中断
            System.out.println("这个线程在跑");
            Runnable task = null;
            try {
                task = taskQueue.take ();   //出队
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            if(task != null){
                task.run(); //因为是在run方法的内部，所以不需要start(),可以直接使用。run()启动线程
            }
            task = null;
        }
    }

    // 停止线程执行
    public void shutdown(){
        interrupt ();
    }
}
