package volatiletest;

public class Main {
    public static void main(String[] args) {
        /*一个问题：
        * 这里NumClass对象是唯一的，使用这个唯一的对象new两个set线程进行累加，每个set累加1000
        * 预期结果是1000-2000之间的随机数值（因为未使用线程锁，所以是随机数值）
        * 但是实际结果只有1000
        * 见ThreaSet注释*/
        NumClass num=new NumClass();
        System.out.println(num.getNum());

        ThreadSet threadSet1=new ThreadSet(num);
        ThreadSet threadSet2=new ThreadSet(num);
        Thread thread1=new Thread(threadSet1);
        Thread thread2=new Thread(threadSet2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println(num.getNum());
    }
}
