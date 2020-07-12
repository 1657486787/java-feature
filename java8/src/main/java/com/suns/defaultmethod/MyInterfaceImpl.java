package com.suns.defaultmethod;

/**
 * @author mk
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public String defaultMethod(String str) {
        MyInterface.super.defaultMethod(str);
        String result = "接口实现类的默认方法实现,参数："+str;
        System.out.println(result);
        return result;
    }
}
