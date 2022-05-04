package locktest;

public class Main {
    public static void main(String[] args) {
        Object obj1=new Object ();
        Num numobj = new Num ();

        // 如果1 没有执行的时候 2 3 可以同时执行 没有锁
        ThreadSet threadSet=new ThreadSet(numobj,obj1);
        ThreadGet threadGet=new ThreadGet(numobj,obj1);
        ThreadGet threadGet2=new ThreadGet(numobj,obj1);

        Thread t1 = new Thread (threadSet);
        Thread t2 = new Thread (threadGet);
        Thread t3 = new Thread (threadGet2);

        t1.start ();
        t2.start ();
        t3.start ();

        try {
            t1.join ();
            t2.join ();
            t3.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println ("ThreadNum:"+ThreadGet.num);
    }
}
