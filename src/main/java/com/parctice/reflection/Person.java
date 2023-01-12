package com.parctice.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name : " + this.name + ", age : " + age;
    }

    public static void main(String[] args) {

        Class<?> clazz = Person.class;  /// 클래스
        Field[] fields = clazz.getDeclaredFields(); // 해당 클래스의 필드들을 다 담음..
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        try {  // 생성자 조회..
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Person newPerson = (Person) constructor.newInstance("abc", 20);
            Method toString = newPerson.getClass().getMethod("toString");
            String result = (String) toString.invoke(newPerson);
            System.out.println(result);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }




    }
}
