package com.zq.designpattern.observerpattern;


import java.util.Vector;

/**
 * Created by zhengshouzi on 2015/10/22.
 */
public class ObserverPattern {

    public static void main(String[] args) {
        ConcreteObserverObject1 concreteObserverObject1 = new ConcreteObserverObject1();
        ConcreteObserverObject2 concreteObserverObject2 = new ConcreteObserverObject2();

        Subject subject = new ConcreteSubject();
        subject.addObserver(concreteObserverObject1);
        subject.addObserver(concreteObserverObject2);
        subject.doSomething();
    }


}

abstract class Subject {
    private Vector<ObserverObject> observerObjects = new Vector<>();

    public void addObserver(ObserverObject observerObject) {
        observerObjects.add(observerObject);
    }

    public void delObserver(ObserverObject observerObject) {
        observerObjects.remove(observerObject);
    }

    public void notifyObserver() {
        for (ObserverObject observerObject : observerObjects) {
            observerObject.update();
        }
    }

    public abstract void doSomething();
}

class ConcreteSubject extends Subject {

    @Override
    public void doSomething() {
        System.out.println("do something");
        notifyObserver();
    }
}

abstract class ObserverObject {
    public abstract void update();
}

class ConcreteObserverObject1 extends ObserverObject {

    @Override
    public void update() {
        System.out.println("observer1 copy that");
    }
}

class ConcreteObserverObject2 extends ObserverObject {

    @Override
    public void update() {
        System.out.println("observer2 copy that");
    }
}
