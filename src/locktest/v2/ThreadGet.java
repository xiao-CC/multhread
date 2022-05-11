package locktest.v2;

public class ThreadGet implements Runnable{
    static int num;
    Num numObj;

    public ThreadGet(Num numObj) {
        this.numObj = numObj;
    }

    @Override
    public void run() {
        numObj.getNum();
    }
}
