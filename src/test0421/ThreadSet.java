package test0421;

public class ThreadSet implements Runnable{
    static int num;
    Num numObj;
    Object obj;

    public ThreadSet(Num numObj, Object obj) {
        this.numObj = numObj;
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            for(int i = 0; i < 10000; i++){
                numObj.setNum (++num);
            }
        }
    }
}
