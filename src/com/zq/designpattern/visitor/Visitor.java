package com.zq.designpattern.visitor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhengshouzi on 2015/10/23.
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(ConcreteElement1 concreteElement1) {
        concreteElement1.dosomething();
    }

    @Override
    public void visit(ConcreteElement2 concreteElement2) {
        concreteElement2.dosomething();
    }

    @Override
    public void visit(A a) {
        a.print();
    }
}

abstract class Element {
    public abstract void dosomething();

    public abstract void accept(IVisitor visitor);
}

class ConcreteElement1 extends Element {

    @Override
    public void dosomething() {
        System.out.println("我是ConcreteElement——1");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element {

    @Override
    public void dosomething() {
        System.out.println("我是ConcreteElement——2");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class A {
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public void print() {
        System.out.println(" i am a ");
    }
}

interface IVisitor {
    void visit(ConcreteElement1 concreteElement1);

    void visit(ConcreteElement2 concreteElement2);

    void visit(A a);
}

class ObjectElement {
    public static ArrayList<Object> getList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int temp = random.nextInt(100);
            if (temp < 33) {
                arrayList.add(new ConcreteElement1());
            } else if (temp < 66) {
                arrayList.add(new ConcreteElement2());
            } else {
                arrayList.add(new A());
            }
        }
        return arrayList;
    }
}

class Client {
    public static void main(String[] args) {

        ArrayList<Object> arrayList = ObjectElement.getList();
        Visitor visitor = new Visitor();
        for (Object element : arrayList) {
            if (element instanceof Element) {
                Element element1 = (Element) element;
            } else if (element instanceof A) {
                A a = (A) element;
            }

        }
    }
}