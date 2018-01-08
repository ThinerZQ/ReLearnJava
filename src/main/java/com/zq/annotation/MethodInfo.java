package com.zq.annotation;

import java.lang.annotation.*;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2017/8/26 23:03
 * Project：learn
 * Package：com.zq.annotation
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
        String author() default "zhengqiang";
        String date();
        int revision() default 1;
        String comments();
}
