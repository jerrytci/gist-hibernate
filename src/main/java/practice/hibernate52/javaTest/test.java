package practice.hibernate52.javaTest;
import java.util.UUID;

public class test {
    String haha = "sb";
    public static void main(String[] args) {
        testParam();
    }

    public static void uuid(){
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }
    public static void testParam(){
        String haha = "sb2";    //ok
        if(2-1>0){
//            String haha = "sb3";  //error
        }
        System.out.println(haha);
    }
}
