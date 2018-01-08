package com.zq.annotation;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2017/8/26 23:36
 * Project：learn
 * Package：com.zq.annotation
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParser {

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParser.class
                    .getClassLoader()
                    .loadClass(("com.zq.annotation.AnnotationExample"))
                    .getMethods()) {
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println(anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println();
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}