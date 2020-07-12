package com.suns.defaultmethod;

import org.junit.Test;

/**
 * @author mk
 */
public class ExecTest {

    @Test
    public void test1(){
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.defaultMethod("param");
    }


}
