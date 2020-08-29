/**
 * @ProjectName java-feature <br>
 * @Package: com.suns.heap <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 16:20 <br>
 * Copyright ©2005-2020 Shenzhen ZuoBiao Software Group Co., Ltd Inc. All Rights Reserved.
 */
package com.suns.heap;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JavaHeapSpace <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 16:20
 */
public class JavaHeapSpace {

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded  演示：
     * -Xms10m
     * -Xmx20m
     * -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath=d:\temp\dump
     * @param args
     */
    public static void main(String[] args) {
        try {
//            Thread.sleep(20000);
            System.out.println("疯狂添加");
            List list = new ArrayList();
            int i=0;
            while(true){
                i++ ;
                list.add(String.valueOf(i));
                if(i<0){
                    break;
                }
            }
            System.out.println("挂了");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}