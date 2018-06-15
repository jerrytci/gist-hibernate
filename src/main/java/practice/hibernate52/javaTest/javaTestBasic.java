package practice.hibernate52.javaTest;

public class javaTestBasic {
    public static void main(String[] args) {
        autoboxing();
    }

//    拆装箱
    public static void autoboxing(){
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
        System.out.println(i1.equals(i2) );
        System.out.println(i3.equals(i4) );
    }

    public static void a1(){

    }
}
