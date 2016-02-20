package com.zq.designpattern.prototype;

//import com.zq.activemq.Sender;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/10/22.
 */
//实现了cloneable接口只是浅拷贝而已，深拷贝需要自己实现
public class Prototype implements Cloneable {

    @Override
    protected Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}

class ConcretePrototype extends Prototype {

    public void show() {
        System.out.println("原型实现类" + this);
    }
}

class Client {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        for (int i = 0; i < 3; i++) {
            ConcretePrototype clonecp = (ConcretePrototype) concretePrototype.clone();
            clonecp.show();
        }
        ConcreteProtype1 concreteProtype1 = new ConcreteProtype1();
        concreteProtype1.add("zhengqiang");
        concreteProtype1.add("zhengqiang3");
        concreteProtype1.add("zhengqian4");

        System.out.println(concreteProtype1.toString());
        for (int i = 0; i < 3; i++) {
            ConcreteProtype1 clonecp = (ConcreteProtype1) concreteProtype1.clone();
            clonecp.add(i + " ");
            System.out.println(clonecp.toString());
        }
        System.out.println(concreteProtype1.toString());

    }
}

//深拷贝实现，
class ConcreteProtype1 implements Cloneable {

    ArrayList<String> arrayList = new ArrayList<>();
    String name = "张三";

    public void add(String string) {
        arrayList.add(string);
    }

    @Override
    protected ConcreteProtype1 clone() {
        ConcreteProtype1 prototype = null;

        try {
            prototype = (ConcreteProtype1) super.clone();
            //取消掉注释和打开注释，又不一样的效果，一个是深拷贝，一个是浅拷贝
            //prototype.arrayList = (ArrayList<String>)this.arrayList.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    @Override
    public String toString() {
        return "ConcreteProtype1{" +
                "arrayList=" + arrayList +
                ", name='" + name + '\'' +
                '}';
    }
}