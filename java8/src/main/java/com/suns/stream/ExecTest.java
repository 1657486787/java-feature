/**
 * @ProjectName java-feature <br>
 * @Package: com.suns.stream <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/7/13 20:15
 */
package com.suns.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName ExecTest <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2020/7/13 20:15
 */
public class ExecTest {

    private List<Student> list = new ArrayList();

    @Before
    public void before(){
        list.add(new Student("zhangsan", 18, 100));
        list.add(new Student("lisi", 17, 70));
        list.add(new Student("wangwu", 16, 85));
        list.add(new Student("zhaoliu", 15, 95));
        list.add(new Student("mazi", 14, 60));
//        list.add(new Student("mazi2", 13, 59));
    }


    public Stream<Student> students(){
        return list.stream();
    }


    @Test
    public void method1(){
        //数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
        Stream<Student> stream = list.stream();
        long count = stream.count();
        System.out.println("个数："+count);

        //多次使用stream，会报异常：java.lang.IllegalStateException: stream has already been operated upon or closed
//        stream.count();
    }

    @Test
    public void method2(){
        //collection操作：

        List<Student> collect = students().collect(Collectors.toList());
        System.out.println("stream转成list:"+collect);

        Set<Student> collect1 = students().collect(Collectors.toSet());
        System.out.println("stream转成set:"+collect1);

        Map<String, Student> collect2 = students().collect(Collectors.toMap(e -> e.getName(), e -> e));  //key:value -> name:Student
        Map<String, Double> collect3 = students().collect(Collectors.toMap(e -> e.getName(), e -> e.getScore()));//key:value -> name:score
        Map<String, Double> collect4 = students().collect(Collectors.toMap(Student::getName, Student::getScore));//key:value -> name:score
        System.out.println("stream转成map:"+collect2);
        System.out.println("stream转成map:"+collect3);
        System.out.println("stream转成map:"+collect4);
    }

    @Test
    public void method3(){
        //reduce 求和操作：
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> optional = stream.reduce((n1, n2) -> n1 + n2);
        System.out.println("reduce:"+optional.get());

        //求所有学生分数和
        Student student = new Student();
        Optional<Student> optional1 = students().reduce((n1, n2) -> Student.builder().score(n1.getScore() + n2.getScore()).build());
        System.out.println("reduce求所有学生分数和:"+optional1.get().getScore());
    }


    @Test
    public void method4(){
        //max 和 min
        Optional<Student> optional = students().max((n1, n2) -> (int) (n1.getScore() - n2.getScore()));
        System.out.println("max求分数最高的学生:"+optional.get());

        Optional<Student> optional2 = students().max((n1, n2) -> (int) (n2.getScore() - n1.getScore()));
        System.out.println("min求分数最低的学生:"+optional2.get());
    }


    @Test
    public void method5(){
        //anyMatch, allMatch, noneMatch
        boolean result = students().anyMatch(e -> e.getScore() >= 60);
        System.out.println("anyMatch是否有学生合格（只要有一个满足条件就返回true）:"+result);

        boolean result2 = students().allMatch(e -> e.getScore() >= 60);
        System.out.println("allMatch是否学生都合格（都满足条件才返回true）:"+result2);

        boolean result3 = students().noneMatch(e -> e.getScore() < 60);
        System.out.println("noneMatch是否学生都合格（都不满足条件）:"+result3);

    }

    @Test
    public void method6(){
        //forEach

        //匿名内部类写法
        students().forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
        //lambda写法
        students().forEach(e -> System.out.println(e));
        //实例方法引用
        students().forEach(System.out::println);

    }
}