package com.suns.staticmethod;

/**
 * @author mk
 */
public interface MyInterface {

    void method1();

    static String method2(String str) {
        return "接口静态方法实现,参数："+str;
    }
}
