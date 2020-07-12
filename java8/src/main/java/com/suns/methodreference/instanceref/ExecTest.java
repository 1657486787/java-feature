package com.suns.methodreference.instanceref;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author mk
 */
public class ExecTest {


    @Test
    public void method1(){
        String str = "我是原始字符串";
        //匿名内部类
//        Function<String,Boolean> function = new Function<String, Boolean>() {
//            @Override
//            public Boolean apply(String suffix) {
//                return str.endsWith(suffix);
//            }
//        };

        //lambda
//        Function<String, Boolean> function = suffix -> str.endsWith(suffix);

        //实例方法引用
        Function<String, Boolean> function = str::endsWith;

        Boolean aBoolean = function.apply("原始");
        System.out.println(aBoolean);

    }
}
