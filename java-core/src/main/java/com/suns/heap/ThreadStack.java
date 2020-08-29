/**
 * @ProjectName java-feature <br>
 * @Package: com.suns.heap <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 17:00 <br>
 * Copyright ©2005-2020 Shenzhen ZuoBiao Software Group Co., Ltd Inc. All Rights Reserved.
 */
package com.suns.heap;

import java.util.Date;

/**
 * @ClassName ThreadStack <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 17:00
 */
public class ThreadStack {

    public void notStop(){
        while(true){
            System.out.println(Thread.currentThread().getId() + "--> 疯狂打印"+new Date());
        }
    }
    public void threadStack(){
        while(true) {
            Thread t = new Thread( () -> notStop());
            t.start();
        }
    }

    /**
     * ?
     */
    public static void main(String args[]){
        ThreadStack threadStack = new ThreadStack();
        threadStack.threadStack();
    }

}