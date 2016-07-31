package com.zq.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Intellij IDEA
 * Date: 16-5-2
 * Time: 下午3:25
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class GenericReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException {


        //泛型作为方法返回类型

        Class infoClass = Info.class;

        Method method = infoClass.getMethod("getListString",null);

        Type returnType = method.getGenericReturnType();


        if (returnType instanceof ParameterizedType){

            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();

            for (Type typeArgument:typeArguments){
                //java.lang.String
                System.out.println(typeArgument.getTypeName());
            }


        }
        //泛型变量，泛型参数类似

    }
}
