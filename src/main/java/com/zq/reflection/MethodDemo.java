package com.zq.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午2:32
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class MethodDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class infoClass = Info.class;

        Method[] methods = infoClass.getDeclaredMethods();

        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println("方法名字：" + method.getName() + "方法返回类型：" + method.getReturnType());
            System.out.println("调用该方法返回结果：" + method.invoke(new Info(), null));
        }
    }
}
