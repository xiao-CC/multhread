package volatiletest;

public class ThreadSet implements Runnable{
    //volatile static int num;  使用非静态累加，结果不合预期
    volatile static int num;//使用静态的累加，结果符合预期
    NumClass numObj;

    public ThreadSet(NumClass numObj) {
        this.numObj = numObj;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            //当使用非静态累加时
            //这里的num++是先将本类的num累加，之后setNum再给numObj赋值。
            //本类的num最多加到1000，所以numObj的num业最多是1000
            numObj.setNum (++num);
        }
    }
}
