package com.suns.lambda4;

import org.junit.Test;

/**
 * @author mk
 */
public class ExecTest {

    @Test
    public void test1(){

        int age = 10;
        //匿名内部类写法
        MyInterface myInterface = new MyInterface(){
            @Override
            public void send() {
                System.out.println("访问局部变量，必须是final的"+age);
            }
        };
        myInterface.send();
//        age = 11;
    }

    @Test
    public void test2(){
        int age = 10;
        //lambda写法
        MyInterface myInterface2 = () ->  System.out.println("访问局部变量，必须是final的"+age);
        myInterface2.send();
//        age = 11;
    }
}
