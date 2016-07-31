package com.zq.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午2:45
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class PrivateFieldAndMethodDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //访问私有属性
        Class infoClass = Info.class;
        Field id = infoClass.getDeclaredField("id");

        //访问私有变量，设置可访问属性
        id.setAccessible(true);
        Info info = new Info();

        System.out.println("private int id = "+ id.get(info));

        //访问私有方法
        Method method = infoClass.getDeclaredMethod("getNameAddId",null);
        method.setAccessible(true);

        System.out.println("public String getNameAddId()'s return value = "+ method.invoke(info,null));
    }
}
