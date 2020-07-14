# Java8 新特性
## 1.接口的静态方法
    1.可以在接口中增加静态方法，需要有方法体
    2.不能被子接口继承
    3.调用方式：接口.静态方法，如MyInterface.staticMethod();
    详见：com.suns.staticmethod
## 2.接口的默认方法
    1.可以在接口中增加默认方法，需要有方法体
    2.可以被实现类重写
    3.调用方式：实现类.默认方法，如new MyInterfaceImpl().defaultMethod();
    详见：com.suns.defaultmethod
## 3.函数式接口
    在一个接口中只有一个抽象接口
    可以有默认的方法和静态方法
    在接口上加上注解：@FunctionalInterface
    例如：Runnable,Callable,Comparator等
## 4.Lamdba表达式
    可以看成是匿名内部类的简写，使用Lamdba表示式，接口必须是函数式接口
    1.参数类型可以省略不写，会自动推断
    2.如果方法只有一行，那么可以省略掉{}，当然如果方法内有多行代码，那么是不能省略掉{}
    3.如果是return返回语句的，那么return 也可以省略掉
    例如：
    
    4.1有多个参数 ,有返回值
    (int a,int b) -> { System.out.println("打印点内容"); return a+b ; };
    (int a,int b) -> {return a+b;};
    (int a,int b) -> a+b;
    (a,b) -> a+b;
    详见：com.suns.lambda
    
    4.2只有一个参数，且没有返回值
    (String str) -> { System.out.println("send:"+str); };
    (str) -> { System.out.println("send:"+str); };
    str -> { System.out.println("send:"+str); };
    str ->  System.out.println("send:"+str);
    详见：com.suns.lambda2
    
    4.3没有参数，没有返回值
    () -> { System.out.println("执行无参业务方法"); };
    () ->  System.out.println("执行无参业务方法");
    () -> {};
    详见：com.suns.lambda3
    
    4.4 lambda作用域：lambda表达式，在方法中可以访问外层作用域的final修饰的局部变量。和匿名内部类一样。
    详见：com.suns.lambda4
    
## 5.构造方法引用
    5.1构造方法引用
    UserFactory userFactory = User::new;  等同于  UserFactory userFactory =  (name,age) -> new User(name,age);
    详见：com.suns.methodreference.constructor
    
    5.2静态方法引用
    MyInterface myInterface = Integer::parseInt;  等同于  MyInterface myInterface = str ->  Integer.parseInt(str);
    详见：com.suns.methodreference.staticref
    
    5.3实例方法引用
    已知String类中有一个实例方法（非静态的）endWith,  想要自己写一个类封装该方法。借助Function接口
    Function<String, Boolean> function = str::endsWith;   等同于   Function<String, Boolean> function = suffix -> str.endsWith(suffix);
    
    详见：com.suns.methodreference.instanceref
    
## 6.Stream流式操作
    详见：com.suns.stream

    