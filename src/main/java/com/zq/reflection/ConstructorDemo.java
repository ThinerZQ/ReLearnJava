package com.zq.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午2:13
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class ConstructorDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class infoClass = Info.class;
        Constructor[] constructors = infoClass.getDeclaredConstructors();


        //构造器个数
        for (Constructor con :
                constructors) {
            System.out.println("构造器名字： " + con.getName());
            //得到构造器的参数类型
            Class[] paraTypes = con.getParameterTypes();
            System.out.print("参数类型：");
            for (Class para :
                    paraTypes) {
                System.out.print(para.getName() + ", ");
            }
            System.out.println();
        }


        //利用构造器和其参数实例化一个类
        Info info = (Info) infoClass.getConstructor(String.class).newInstance("lmm");

        System.out.println(info.name);


    }
}
