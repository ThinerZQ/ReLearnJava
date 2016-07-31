package com.zq.reflection;

import java.lang.annotation.Annotation;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午3:04
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class AnnationDemo {
    public static void main(String[] args) {
        Class infoClass = Info.class;
        Annotation[] annotations = infoClass.getAnnotations();
        for (Annotation annotation :
                annotations) {
            if (annotation instanceof MyAnnotation){
                System.out.println("MyAnnotation name = "+ ((MyAnnotation) annotation).name());
                System.out.println("MyAnnotation value = "+ ((MyAnnotation) annotation).value());
            }
        }

        //方法注解，与参数注解，变量注解都一样
    }
}
