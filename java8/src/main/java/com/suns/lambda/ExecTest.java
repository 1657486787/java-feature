package com.suns.lambda;

import org.junit.Test;

/**
 * @author mk
 */
public class ExecTest {

    @Test
    public void test1(){
        //匿名内部类的写法；
       MyInterface myInterface = new MyInterface(){
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        System.out.println("匿名内部类的写法："+myInterface.sum(1, 2));
    }

    @Test
    public void test2(){
        //lambda的写法；
//        MyInterface myInterface = (int a,int b) -> {return a+b;};
//        MyInterface myInterface = (int a,int b) -> a+b;
//        MyInterface myInterface = (a,b) -> a+b;
        MyInterface myInterface = (int a,int b) -> { System.out.println("打印点内容"); return a+b ; };
        System.out.println("lambda的写法："+myInterface.sum(1, 2));
    }
}
