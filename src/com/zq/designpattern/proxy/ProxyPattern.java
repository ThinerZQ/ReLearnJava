package com.zq.designpattern.proxy;

/**
 * Created by zhengshouzi on 2015/10/29.
 */
public class ProxyPattern {
    public static void main(String[] args) {


        //三聚氰胺..........于是奶粉代购火了
        // 但是不是每个人都有空随时去德国（这就可以看成是远程代理）
        // 当然德国的奶粉生产商也不可以能直接和每个想买奶粉的人打交道，他说我只卖给代理商（这可以看成是保护代理，控制应用对象具有不同的访问权限）
        // 这时候朋友圈里面跳出来来一个奶粉代购妹妹，
        //奶粉原价是100，但是代理价200，代理给你加价了，这就是在一个代理对象前后执行了附加的操作（这可以看成是智能指引代理，他在访问前后执行了附加操作）
        MilkProxy milkProxy = new MilkProxy();

        //张三准备卖5罐奶粉
        milkProxy.sell(5);
        //李四买10罐
        milkProxy.sell(10);
        //王五买20罐
        milkProxy.sell(20);

        System.out.println("代购收益："+milkProxy.computeProfit());
    }
}


interface Milk{
    void sell(int number);
}

class Manufacturer implements Milk{

    private int number=2000;
    private String name;
    private int price;
    private  int saledCount=0;

    public int getPrice() {
        return price;
    }
    public Manufacturer(){
        name = "牛奶";
        price = 100;
    }
    public void sell(int number) {
        System.out.println("生产商卖  "+number+"  罐奶粉给代购");
        saledCount +=number;
    }
}

class MilkProxy implements Milk{

    //代理知道生产商上哪儿找生产商，
    Manufacturer manufacturer = new Manufacturer();
    private int price=0;
    private int saledCount=0;
    private long profit=0;
    private int size=0;

    public MilkProxy(){
        this.price=200;
    }

    @Override
    public void sell(int number) {
        size +=number;
        while(size>20){
            //打开下面的注释这样写表示当你能够靠卖奶粉赚到钱的时候（只买1两件，代理商怎么愿意跑一趟德国嘛），代理商才真正的去找生产商（可以看成是虚代理）
            //manufacturer = new Manufacturer();
            System.out.println("去拿货");
            //实际上他是在帮生产商卖牛奶，然后自己赚差价
            manufacturer.sell(size);
            System.out.println("代购卖  " + size + "  罐奶粉给客户");
            saledCount+=size;
            size=0;
        }
    }
    public long computeProfit(){
        profit = saledCount*(price-manufacturer.getPrice());
        return profit;
    }

}
