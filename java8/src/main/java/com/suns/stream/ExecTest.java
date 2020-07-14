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
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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
        list.add(new Student("mazi2", 13, 59));
        list.add(new Student("mazi2", 13, 59));
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
        System.out.println("----------------------------------------------------");

        //lambda写法
        students().forEach(e -> System.out.println(e));
        //实例方法引用
        students().forEach(System.out::println);
    }



    // ---------------------------------------管道（中间操作）---------------------------------------
    @Test
    public void method10(){
        //filter
        //匿名内部类写法
        students().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getScore() >= 90;
            }
        }).forEach( e -> System.out.println(e));

        System.out.println("----------------------------------------------------");

        //lambda写法
        students().filter( e -> e.getScore()>= 90).forEach(System.out::println);
    }

    @Test
    public void method11(){
        //distinct  ,distinct需要重写equals 和 hashcode
        //匿名内部类写法
        students().distinct().forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
        System.out.println("----------------------------------------------------");

        //lambda写法
        students().distinct().forEach( System.out::println );
    }


    @Test
    public void method12(){
        //sorted
        //方法1.使用不带参数的sorted()排序，升序，需要实现Comparable接口，否则会报错 java.lang.ClassCastException: com.suns.stream.Student cannot be cast to java.lang.Comparable
        //匿名内部类写法
//        students().sorted().forEach(new Consumer<Student>() {
//            @Override
//            public void accept(Student student) {
//                System.out.println(student);
//            }
//        });
//        System.out.println("----------------------------------------------------");
//        //lambda写法
//        students().sorted().forEach(System.out::println);
//
//        System.out.println("------------------------方法2----------------------------");

        //方法2.使用带参数的sorted（）排序, 降序
        //匿名内部类写法
        students().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int)(o2.getScore() - o1.getScore());
            }
        }).forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });

        System.out.println("----------------------------------------------------");
        //lambda写法

        students().sorted( (e1,e2) -> (int)(e2.getScore() - e1.getScore()) ).forEach(System.out::println);

    }

    @Test
    public void method13(){
        //limit
        //匿名内部类写法
        System.out.println("----------------------------------------------------");

        //lambda写法
        students().limit(2).forEach(System.out::println);

        System.out.println("----------------------先排序后limit------------------------------");
        students().sorted( (e1,e2) -> (int)(e1.getScore() - e2.getScore()) ).limit(3).forEach(System.out::println);
    }


    @Test
    public void method14(){
        //skip
        //匿名内部类写法
        System.out.println("----------------------------------------------------");

        //lambda写法
        students().skip(1).forEach(System.out::println);

        System.out.println("----------------------先排序后skip------------------------------");
        students().sorted( (e1,e2) -> (int)(e1.getScore() - e2.getScore()) ).skip(2).forEach(System.out::println);

    }

    @Test
    public void method15(){
        //map  , 如果分数> 80 的输出学生具体信息，否则只输出名字
        //匿名内部类写法
        students().map(new Function<Student, Object>() {
            @Override
            public Object apply(Student student) {
                return student.getScore() > 80 ? student : student.getName();
            }
        }).forEach(new Consumer<Object>() {

            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        System.out.println("----------------------------------------------------");

        //lambda写法
        students().map( e -> e.getScore() > 80 ? e : e.getName()).forEach(System.out::println);
    }


    @Test
    public void method16(){
        //综合
        //1.所有及格学生信息
        List<Student> list = students().filter(e -> e.getScore() >= 60).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("----------------------------------------------------");
        //2.所有及格学生姓名
        List<String> list2 = students().filter(e -> e.getScore() >= 60).map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("----------------------------------------------------");
        //3.统计前3名学生信息，按成绩
        List<Student> list3 = students().sorted((e1, e2) -> (int) (e2.getScore() - e1.getScore())).limit(3).collect(Collectors.toList());
        System.out.println(list3);

        System.out.println("----------------------------------------------------");
        //4.统计前3-5名学生信息，按成绩
        List<Student> list4 = students().sorted((e1, e2) -> (int) (e2.getScore() - e1.getScore())).skip(2).limit(3).collect(Collectors.toList());
        System.out.println(list4);


        System.out.println("----------------------------------------------------");
        //5.汇总合格学生平均成绩
        Student stu = new Student();
        double score = students().filter(e -> e.getScore() >= 60).reduce(new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                stu.setScore(student.getScore() + student2.getScore());
                return stu;
            }
        }).get().getScore();

        long count = students().filter(e -> e.getScore() >= 60).count();

        System.out.println("汇总合格学生平均成绩:"+score/count);

        System.out.println("----------------------------------------------------");
        //6.输出学生信息，按成绩降序
        List<Student> list5 = students().sorted((e1, e2) -> (int) (e2.getScore() - e1.getScore())).collect(Collectors.toList());
        System.out.println(list5);

        System.out.println("----------------------------------------------------");

        //7.学生总分数
        System.out.println("----------------------------------------------------");
        Optional<Student> optional = students().reduce((e1, e2) -> Student.builder().score(e1.getScore() + e2.getScore()).build());
        System.out.println(optional.get().getScore());

    }

}