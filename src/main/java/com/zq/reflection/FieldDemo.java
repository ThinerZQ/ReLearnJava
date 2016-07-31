package com.zq.reflection;

import java.lang.reflect.Field;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午2:25
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class FieldDemo {

    public static void main(String[] args) throws IllegalAccessException {
        Class infoClass = Info.class;
        Field[] fields = infoClass.getDeclaredFields();

        Info info = new Info();
        for (Field field : fields) {
            //get()方法不能返回private属性的值
            System.out.println("变量名字：" + field.getName() + "变量值：" + field.get(info));
        }
    }
}
