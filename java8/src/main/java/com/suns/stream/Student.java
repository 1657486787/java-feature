/**
 * @ProjectName java-feature <br>
 * @Package: com.suns.stream <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/7/13 20:12
 */
package com.suns.stream;

import lombok.*;

/**
 * @ClassName Student <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/7/13 20:12
 */
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Student /**implements Comparable<Student> */ {

    private String name;
    private int age;
    private double score;

//    @Override
//    public int compareTo(Student  o) {
//        return (int)(this.getScore() - o.getScore());
//    }
}