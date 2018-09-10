package practice.hibernate52.java;

class Thread2 extends Thread{
    private String name;
    public Thread2(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class Main {

    public static void main(String[] args) {
        Thread2 mTh1=new Thread2("A");
        Thread2 mTh2=new Thread2("B");
        mTh1.start();
        mTh2.start();

    }

}

