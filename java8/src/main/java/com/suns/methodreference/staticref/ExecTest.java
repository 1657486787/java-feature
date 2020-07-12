package com.suns.methodreference.staticref;

import org.junit.Test;

/**
 * @author mk
 */
public class ExecTest {

    @Test
    public void method1(){
//        MyInterface myInterface = str -> {return Integer.parseInt(str);};
//        MyInterface myInterface = str ->  Integer.parseInt(str);
        MyInterface myInterface = Integer::parseInt;

        System.out.println(myInterface.parse("123456"));
    }
}
