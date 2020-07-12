package com.suns.defaultmethod;

/**
 * @author mk
 */
public interface MyInterface {

    default String defaultMethod(String str) {
        String result = "接口默认方法实现,参数："+str;
        System.out.println(result);
        return result;
    }
}
