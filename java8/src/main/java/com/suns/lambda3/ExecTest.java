package com.suns.lambda3;

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
            public void send() {
                System.out.println("执行无参业务方法");
            }
        };
        myInterface.send();
    }

    @Test
    public void test2(){
        //lambda写法
        MyInterface myInterface = () -> { System.out.println("执行无参业务方法"); };
        myInterface.send();

        MyInterface myInterface2 = () ->  System.out.println("执行无参业务方法");
        myInterface2.send();

        MyInterface myInterface3 = () -> { };
        myInterface3.send();

    }
}
