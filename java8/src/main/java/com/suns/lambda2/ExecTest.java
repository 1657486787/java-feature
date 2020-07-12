package com.suns.lambda2;

import org.junit.Test;

/**
 * @author mk
 */
public class ExecTest {

    @Test
    public void test1(){
        //匿名内部类写法
        MyInterface myInterface = new MyInterface(){
            @Override
            public void send(String str) {
                System.out.println("send:"+str);
            }
        };
        myInterface.send("匿名内部类写法");
    }

    @Test
    public void test2(){
        //lambda写法
        MyInterface myInterface = (String str) -> { System.out.println("send:"+str); };
        myInterface.send("lambda写法1");

        MyInterface myInterface2 = (str) -> { System.out.println("send:"+str); };
        myInterface2.send("lambda写法2,参数类型可以省去");

        MyInterface myInterface3 = str -> { System.out.println("send:"+str); };
        myInterface3.send("lambda写法3,参数类型可以省去，参数的（）可以省去");

        MyInterface myInterface4 = str ->  System.out.println("send:"+str);
        myInterface4.send("lambda写法3,参数类型可以省去，参数的（）可以省去方法体中{}可以省区");

    }
}
