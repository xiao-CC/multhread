package test0421;

public class Test implements Runnable {
    int a = 0;

    @Override
    public void run() { // 覆写run()方法
        for (int i = 0; i < 100; i++) {
            System.out.println("a = " + a++);
        }
    }
}
