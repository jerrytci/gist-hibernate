package practice.hibernate52.javaTest;

public class Singleton2 {
    private Singleton2() {}
    private static Singleton2 single = null;
    public synchronized static Singleton2 getInstance() {
        if (single == null) {
            single = new Singleton2();
        }
        return single;
    }
}
