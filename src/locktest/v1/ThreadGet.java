package locktest.v1;

public class ThreadGet implements Runnable{
    static int num;
    Num numObj;
    Object obj;

    public ThreadGet(Num numObj, Object obj) {
        this.numObj = numObj;
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            num=numObj.getNum ();
        }
    }
}
