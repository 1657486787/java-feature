/**
 * @ProjectName java-feature <br>
 * @Package: com.suns.heap <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 16:56 <br>
 * Copyright ©2005-2020 Shenzhen ZuoBiao Software Group Co., Ltd Inc. All Rights Reserved.
 */
package com.suns.heap;

import java.util.Date;

/**
 * @ClassName StackOverflow <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 16:56
 */
public class StackOverflow {


    /**
     * Exception in thread "main" java.lang.StackOverflowError 演示
     * -Xss10m
     * @param args
     */
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        System.out.println("invoke:"+new Date());
        method1();
    }
}