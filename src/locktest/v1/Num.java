package locktest.v1;

import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Num {
    private int num=0;
    ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();

    public int getNum() {
       return num;
    }

    public void setNum(int num) {
        this.num=num;
    }
}
