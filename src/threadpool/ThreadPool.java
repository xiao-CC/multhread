package threadpool;

import java.util.HashSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 有两个队列，分别是线程set和任务queue.
 */
public class ThreadPool{
    int corePoolSize; // 线程池核心线程数量（保活的线程）
    int maximumPoolSize;// 线程池最大线程数量（机器的线程），本用例中没用到
    int workThradSetSize;// 线程队列的容量
    int taskQueueSize;// 任务队列的容量

    HashSet<MyThread> workThradSet;// 线程池集合,无序
    BlockingDeque<Runnable> taskQueue;// 任务阻塞队列

    public ThreadPool(int corePoolSize, int maximumPoolSize, int workThradSetSize, int taskQueueSize){
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workThradSetSize = workThradSetSize;
        this.taskQueueSize = taskQueueSize;
        workThradSet = new HashSet<>(workThradSetSize);
        taskQueue = new LinkedBlockingDeque<>(taskQueueSize);
    }

    //1.start()就是根据核心线程的数量，用for循环new若干个线程，启动他们，并加入线程队列
    //2.每new一个线程，都要将任务队列传过去
    public void startWork() {
        for (int i=0;i<corePoolSize;i++){
            MyThread myThread=new MyThread(taskQueue);  //创建线程
            Thread thread=new Thread(myThread);     //启动线程
            thread.start();
            workThradSet.add(myThread);
        }
    }

    public void stopWork() {
        for (MyThread thread:workThradSet){
            thread.shutdown();
        }
        workThradSet.clear();
    }

    //提交任务，把测试类中的任务加入队列
    public void execute (Runnable task) throws InterruptedException{
        taskQueue.put(task);
    }

    //打印信息，没用上这个功能
    public void shoeInfo(){
        System.out.println("线程运行状态");
        System.out.println("taskQueueSize"+taskQueueSize);
        System.out.println("workThreadSize"+workThradSetSize);
    }
}
