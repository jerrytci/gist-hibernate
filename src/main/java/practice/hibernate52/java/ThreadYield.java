package practice.hibernate52.java;

public class ThreadYield extends Thread{
    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i ==30) {
                this.yield();
            }
        }

    }
}


class MyThreadPrinter2 implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    public MyThreadPrinter2(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}


class Main4 {

    public static void main(String[] args) {
        printABC();
    }

    static void aaa(){
        ThreadYield yt1 = new ThreadYield("张三");
        ThreadYield yt2 = new ThreadYield("李四");
        yt1.start();
        yt2.start();
    }

    static void printABC(){
        try {
            Object a = new Object();
            Object b = new Object();
            Object c = new Object();
            MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
            MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
            MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);


            new Thread(pa).start();
            Thread.sleep(100);  //确保按顺序A、B、C执行
            new Thread(pb).start();
            Thread.sleep(100);
            new Thread(pc).start();
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



