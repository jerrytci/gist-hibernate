package org.remix.ssh.javaTest;
import java.util.UUID;

public class test {
    public static void main(String[] args) {
        uuid();
    }

    public static void uuid(){
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }
}
