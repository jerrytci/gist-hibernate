package practice.hibernate52.javaTest;

public class JavaType {
    public static void main(String[] args){
        StringEqualTest();
    }

//    测试类型转换
    static void type(){
        short s1 = 1;
        s1 += 1;
//        s1 = s1 + 1;
    }

    static void AutoUnboxingTest(String[] args) {
        Integer a = new Integer(3);
        // 将3自动装箱成Integer类型
        Integer b = 3;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
    }

    static void test3() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

        String str = new String("hello");
    }

//    测试栈，堆和方法区
//    看看下面代码的执行结果是什么并且比较一下Java 7以前和以后的运行结果是否一致。
    static void test4(){
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }

//    测试StringEqual
    static void StringEqualTest() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

}

