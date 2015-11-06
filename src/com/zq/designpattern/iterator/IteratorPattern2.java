package com.zq.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/10/26.
 */
public class IteratorPattern2 {
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

interface Iterator2<T> {
    T next();

    boolean hasNext();
}

interface Aggregate2<T> {
    void add(T object);

    void remove(T object);

    Iterator2<T> iterator();
}

class ConcreteAggregate2<T> implements Aggregate2<T> {

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
    public Iterator2<T> iterator() {
        return new ConcreteIterator2<T>();
    }

    class ConcreteIterator2<S> implements Iterator2<T> {

        private int cursor = 0;

        public T next() {
            T object = null;
            if (hasNext()) {
                object = list.get(cursor++);
            }
            return object;
        }

        public boolean hasNext() {
            if (cursor == list.size()) {
                return false;
            }
            return true;
        }
    }
}