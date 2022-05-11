package locktest.v2;

public class ThreadSet implements Runnable{
    static int num;
    Num numObj;

    public ThreadSet(Num numObj) {
        this.numObj = numObj;
    }

    @Override
    public void run() {
        numObj.setNum(20000);
    }
}
