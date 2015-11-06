package com.zq.designpattern.strategy;

import sun.org.mozilla.javascript.internal.ast.ConditionalExpression;

/**
 * Created by zhengshouzi on 2015/10/26.
 */
public class Strategy {
    public static void main(String[] args) {
        Content content = new Content(new ConcreteStrategy1());
        content.execute();
    }
}

interface IStrategy {
    void doSomething();
}

class ConcreteStrategy1 implements IStrategy {

    @Override
    public void doSomething() {
        System.out.println(" strategy 1 ");
    }
}

class ConcreteStrategy2 implements IStrategy {

    @Override
    public void doSomething() {
        System.out.println(" strategy 2 ");
    }
}

class ConcreteStrategy3 implements IStrategy {

    @Override
    public void doSomething() {
        System.out.println(" strategy 3 ");
    }
}

class Content {
    IStrategy strategy;

    public Content(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doSomething();
    }
}