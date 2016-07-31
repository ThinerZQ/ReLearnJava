package com.zq.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Intellij IDEA
 * Date: 16-5-1
 * Time: 下午10:00
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class ReflectionBasic {

    public static void main(String[] args) throws ClassNotFoundException {

        Class infoClass = Info.class;

        System.out.println("全限定名：" + infoClass.getName());
        System.out.println("类名：" + infoClass.getSimpleName());

        int modifier = infoClass.getModifiers();

        System.out.println("是否时public的： " + Modifier.isPublic(modifier));

        Package packagename = infoClass.getPackage();

        System.out.println("包名：" + packagename.getName());

        Method[] methods = infoClass.getDeclaredMethods();
        for (Method method :
                methods) {
            System.out.println("方法签名： " + method.getModifiers() + " " + method.getReturnType() + " " + method.getName());
        }
        Field[] fields = infoClass.getDeclaredFields();
        for (Field field :
                fields) {
            System.out.println("属性签名： " + field.getModifiers() + " " + field.getType() + " " + field.getName());
        }

    }
}
