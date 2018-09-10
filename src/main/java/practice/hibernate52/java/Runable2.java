package practice.hibernate52.java;

public class Runable2 implements Runnable{
    private String name;

    public Runable2(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
class Main2 {
    public static void main(String[] args) {
        new Thread(new Runable2("C")).start();
        new Thread(new Runable2("D")).start();
    }

}

