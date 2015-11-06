package com.zq.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/10/26.
 */
public class IteratorPattern1 {
    public static void main(String[] args) {
        Aggregate1<String> aggregate = new ConcreteAggregate1();
        aggregate.add("java");
        aggregate.add("android");
        aggregate.add("php");
        aggregate.add("hadoop");
        Iterator1<String> iterator1 = aggregate.iterator();
        while (iterator1.hasNext()) {
            String string = iterator1.next();
            System.out.println(string);
        }
    }
}

interface Iterator1<T> {
    T next();

    boolean hasNext();
}

class ConcreteIterator1<T> implements Iterator1<T> {
    private List<T> list;
    private int cursor = 0;

    @Override
    public T next() {
        T object = null;
        if (hasNext()) {
            object = list.get(cursor++);
        }
        return object;

    }

    @Override
    public boolean hasNext() {
        if (cursor == list.size()) {
            return false;
        }
        return true;
    }

    public ConcreteIterator1(List list) {
        this.list = list;
    }
}

interface Aggregate1<T> {
    void add(T object);

    void remove(T object);

    Iterator1<T> iterator();
}

class ConcreteAggregate1<T> implements Aggregate1<T> {

    private List<T> list = new ArrayList<T>();

    @Override
    public void add(T object) {
        list.add(object);
    }

    @Override
    public void remove(T object) {
        list.remove(object);
    }

    @Override
    public Iterator1<T> iterator() {
        return new ConcreteIterator1<T>(list);
    }
}