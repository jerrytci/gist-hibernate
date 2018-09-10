package practice.hibernate52.java;

class Thread3 extends Thread{
    private String name;
    public Thread3(String name) {
        super(name);
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}

class Main3 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread3 mTh1=new Thread3("A");
        Thread3 mTh2=new Thread3("B");
        mTh1.start();
        mTh2.start();
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");

    }

}




