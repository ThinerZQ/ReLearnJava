package com.zq.designpattern.factory;

/**
 * Created by zhengshouzi on 2015/10/21.
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Factory factory = new Factory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }
}

interface IProduct {
    public void productMethod();
}

class Product implements IProduct {

    @Override
    public void productMethod() {
        System.out.println("product");
    }
}

interface IFactory {
    public IProduct createProduct();
}

class Factory implements IFactory {

    @Override
    public IProduct createProduct() {
        return new Product();
    }
}
