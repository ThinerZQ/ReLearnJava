package com.zq.reflection;

import java.lang.reflect.Array;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午3:51
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class ArrayDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //创建数组
        int[] intArray = (int[]) Array.newInstance(int.class, 3);

        //访问数组
        Array.set(intArray, 0, 123);

        Array.set(intArray, 1, 456);

        Array.set(intArray, 2, 789);

        System.out.println("intArray[0] = " + Array.get(intArray, 0));

        System.out.println("intArray[1] = " + Array.get(intArray, 1));

        System.out.println("intArray[2] = " + Array.get(intArray, 2));

        //编译器已知的反射
        Class stringClass = String[].class;
        //获取int数组的反射信息
        Class intArrays = Class.forName("[I");
        //获取string数组的反射信息
        Class stringArrayClass = Class.forName("[Ljava.lang.String;");


        //得到某一个对象的class信息
        Class classInfo = getClass("long");
        //得到对象对应的数组的class信息
        Class classArrayInfo = Array.newInstance(classInfo,10).getClass();

        //判断获取到的是不是数组类型
        System.out.println("is array: " + classArrayInfo.isArray());

        Class stringArrayComponentType = classArrayInfo.getComponentType();
        //获取数组中元素的具体类型
        System.out.println(stringArrayComponentType);



    }
    public static Class getClass(String className){

        if("int" .equals(className)) return int .class;

        if("long".equals(className)) return long.class;
        Class returnClass = null;
        try {
             returnClass =  Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returnClass;

    }

}
