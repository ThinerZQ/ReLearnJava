package com.zq.designpattern.builder;

/**
 * Created by zhengshouzi on 2015/10/21.
 */
public abstract class Builder {
    public abstract void setPair(String name,String type);
    public abstract Product3 getProduct3();
}
class ConcreateBuilder1 extends Builder{

    private Product3 product3;

    @Override
    public void setPair(String name, String type) {
        product3 = new Product3();
        product3.setName(name);
        product3.setType(type);
    }

    @Override
    public Product3 getProduct3() {
        return product3;
    }
}
//小册子上写法
class ConcreateBuilder extends Builder{

    private Product3 product3=new Product3();

    @Override
    public void setPair(String name, String type) {

        product3.setName(name);
        product3.setType(type);
    }

    @Override
    public Product3 getProduct3() {
        return product3;
    }
}

class Product3{
    private String name;
    private String type;

    public Product3(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Product3() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product3{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
//小册子上写法
class Director{
    public Builder builder = new ConcreateBuilder();

    public Product3 getProductBaoMa(){
        builder.setPair("宝马","X6");
        return builder.getProduct3();
    }

    public Product3 getProductAoDi(){
        builder.setPair("奥迪","Q7");
        return builder.getProduct3();
    }
}

class Director1{
    public Builder builder = new ConcreateBuilder1();

    public Product3 getProductBaoMa(){
        builder.setPair("宝马","X6");
        return builder.getProduct3();
    }

    public Product3 getProductAoDi(){
        builder.setPair("奥迪","Q7");
        return builder.getProduct3();
    }
}

class Client2{
    public static void main(String[] args) {
        Director director = new Director();
        Product3 product3 = director.getProductAoDi();
        System.out.println(product3.toString());
        Product3 product31 = director.getProductBaoMa();
        System.out.println(product31.toString());
        System.out.println("product3 == product31: "+(product3==product31));

        Director1 director1 = new Director1();
        Product3 product32 = director1.getProductAoDi();
        System.out.println(product32.toString());
        Product3 product33 = director1.getProductBaoMa();
        System.out.println(product33.toString());
        System.out.println("product32 == product33: "+(product32==product33));

    }
}

