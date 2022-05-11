package locktest.v2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Num {
    private int num=0;
    ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();

    public int getNum() {
        try {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"正在读取");
            return num;
        }finally {
            System.out.println(Thread.currentThread().getName()+"读取完毕");
            rwLock.readLock().unlock();
        }
    }

    public void setNum(int a) {
        try {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"正在写入");
            for (int i=0;i<a;i++){
                num++;
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"写入完毕");
            rwLock.writeLock().unlock();
        }
    }
}
