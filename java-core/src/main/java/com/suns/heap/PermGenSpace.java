/**
 * @ProjectName java-feature <br>
 * @Package: com.suns.heap <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 17:56 <br>
 * Copyright ©2005-2020 Shenzhen ZuoBiao Software Group Co., Ltd Inc. All Rights Reserved.
 */
package com.suns.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PermGenSpace <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/8/29 17:56
 */
public class PermGenSpace {


    /**
     *  演示？
     * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
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