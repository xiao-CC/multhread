package locktest.v2;

public class RWLock {

    public static void main(String[] args) throws InterruptedException {
        Num numobj = new Num();

        ThreadSet threadSet=new ThreadSet(numobj);
        ThreadSet threadSet2=new ThreadSet(numobj);
        ThreadGet threadGet2=new ThreadGet(numobj);

        Thread t1 = new Thread (threadSet);
        Thread t2 = new Thread (threadSet2);
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
        System.out.println ("ThreadNum:"+ numobj.getNum());
    }
}
