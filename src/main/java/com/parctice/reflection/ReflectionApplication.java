package com.parctice.reflection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class ReflectionApplication {

    public static void main(String[] args) throws NoSuchMethodException {

        Object obj = new Person("엄",12);
        Class personClass = Person.class;

//        obj.getName(); // 리플렉션을 안쓰면 컴파일 오류...
        // 메소드 실행시

        Method setName = personClass.getMethod("setName", String.class);
//  메서드 실행, invoke(메서드를 실행시킬 객체, 해당 메서드에 넘길 인자)
        try {
            setName.invoke(obj,"이름변경");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Method getName = personClass.getMethod("getName");
        try {
            String name = (String) getName.invoke(obj,null);
            System.out.println(name);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        SpringApplication.run(ReflectionApplication.class, args);
    }

}
