package com.zq.designpattern.factory;

/**
 * Created by zhengshouzi on 2015/10/21.
 */
public class AbstractFactoryMethod {

    public static void main(String[] args) {
        IFactory1 factory1 = new Factory1();
        IProduct1 product1 = factory1.createProduct1();
        IProduct2 product2 = factory1.createProduct2();
        product1.show();
        product2.show();
    }
}
interface IProduct1{
    public void show();
}
interface IProduct2{
    public void show();
}
class Product1 implements IProduct1{



    @Override
    public void show() {
        System.out.println("product1 implement");
    }
}

class Product2 implements IProduct2{


    @Override
    public void show() {
        System.out.println("product2 implement");
    }
}

interface IFactory1 {
    IProduct1 createProduct1();
    IProduct2 createProduct2();
}
class Factory1 implements IFactory1{

    @Override
    public IProduct1 createProduct1() {
        return new Product1();
    }

    @Override
    public IProduct2 createProduct2() {
        return new Product2();
    }
}


