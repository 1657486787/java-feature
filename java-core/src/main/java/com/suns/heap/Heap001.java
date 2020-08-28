package com.suns.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mk
 */
public class Heap001 {

    private static Map map = new HashMap();

    /**
     * 1.执行main方法时加上该参数
     * -Xmx100M
     * -XX:+HeapDumpBeforeFullGC
     * -XX:+HeapDumpAfterFullGC
     * -XX:HeapDumpPath=d:\temp\dump
     * 2.使用jconsole实时查看内存变化
     * 3.使用MAT工具分析,下载地址：https://www.eclipse.org/mat/downloads.php
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(15000);
            for(int i=0;i<100000000;i++){
                map.put(i,new TestMemory());
                System.out.println("put :"+i);
            }
            Thread.sleep(Integer.MAX_VALUE);
            System.out.println("end...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class TestMemory{

}
