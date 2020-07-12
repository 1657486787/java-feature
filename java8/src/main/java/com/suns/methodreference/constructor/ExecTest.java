package com.suns.methodreference.constructor;

import org.junit.Test;

/**
 * @author mk
 */
public class ExecTest {


    @Test
    public void method1(){
//        UserFactory userFactory = (name,age) -> {return new User(name,age);};
//        UserFactory userFactory = (name,age) -> new User(name,age);
        UserFactory userFactory = User::new;
        User user = userFactory.getUser("zhang", 18);
        System.out.println(user);
    }
}
