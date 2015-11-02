package com.zq.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/10/26.
 */
public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("java");
        aggregate.add("android");
        aggregate.add("php");
        aggregate.add("hadoop");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()){
            String string = (String) iterator.next();
            System.out.println(string);
        }
    }
}

interface Iterator{
    Object next();
    boolean hasNext();
}
class ConcreteIterator implements Iterator{
    private List list = new ArrayList();
    private int cursor=0;

    @Override
    public Object next() {
        Object object = null;
        if (hasNext()){
            object = list.get(cursor++);
        }
        return  object;
    }
    @Override
    public boolean hasNext() {
       if (cursor == list.size()){
           return false;
       }
        return true;
    }
    public ConcreteIterator(List list){
        this.list = list;
    }
}

interface Aggregate{
    void add(Object object);
    void remove(Object object);
    Iterator iterator();
}
class ConcreteAggregate implements Aggregate{

    private List list = new ArrayList();
    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}