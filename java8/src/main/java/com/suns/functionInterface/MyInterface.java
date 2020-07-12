package com.suns.functionInterface;

/**
 * @author mk
 */
@FunctionalInterface
public interface MyInterface {
    void test1();
    static void test2(){};
    default void test3(){};
}
