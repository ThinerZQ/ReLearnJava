package com.zq.basic;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/7
 * Time: 19:48
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ReferenceDeliver {
    public static void main(int a){

    }
    public static void main(String[] args){
        ReferenceDeliver referenceDeliver = new ReferenceDeliver();
        Student student = new Student();
        student.name ="zq";
        student.id ="1";
        //不可变对象
        String string = "abc";

        String string_1 = new String("ABC");

        System.out.println(student);
        referenceDeliver.call_Object_0(student);
        System.out.println(student);
        referenceDeliver.call_Object_1(student);
        System.out.println(student);

        System.out.println(string);
        referenceDeliver.call_String_0(string);
        System.out.println(string);
        referenceDeliver.call_String_1(string);
        System.out.println(string);

        System.out.println(string_1);
        referenceDeliver.call_String_0(string_1);
        System.out.println(string_1);
        referenceDeliver.call_String_1(string_1);
        System.out.println(string_1);

    }
    public void call_Object_0(Student student){
        student.name = "lmm";
    }
    public void call_Object_1(Student student){
        student =null;
    }
    public void call_String_0(String string){
        string ="123";
    }
    public void call_String_1(String string){
        string =null;
    }
}



class Student{
    String name;
    String id;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}