package com.zq.reflection;

import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午2:40
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

/**
 * 判断getter and setter方法
 */
public class SetterGetterDemo {
    public static void main(String[] args) {

        printGettersSetters(Info.class);
    }

    public static void printGettersSetters(Class aClass) {

        Method[] methods = aClass.getMethods();


        for (Method method : methods) {

            if (isGetter(method))
                System.out.println("getter: " + method);

            if (isSetter(method))
                System.out.println("setter: " + method);
        }
    }


    public static boolean isGetter(Method method) {

        if (!method.getName().startsWith("get"))
            return false;

        if (method.getParameterTypes().length != 0)
            return false;

        if (void.class.equals(method.getReturnType()))
            return false;

        return true;

    }


    public static boolean isSetter(Method method) {

        if (!method.getName().startsWith("set"))
            return false;
        if (method.getParameterTypes().length != 1)
            return false;

        return true;

    }
}
