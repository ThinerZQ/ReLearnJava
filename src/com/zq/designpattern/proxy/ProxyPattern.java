package com.zq.designpattern.proxy;

/**
 * Created by zhengshouzi on 2015/10/29.
 */
public class ProxyPattern {
    public static void main(String[] args) {


        //�����谷..........�����̷۴�������
        // ���ǲ���ÿ���˶��п���ʱȥ�¹�����Ϳ��Կ�����Զ�̴���
        // ��Ȼ�¹����̷�������Ҳ��������ֱ�Ӻ�ÿ�������̷۵��˴򽻵�����˵��ֻ���������̣�����Կ����Ǳ�����������Ӧ�ö�����в�ͬ�ķ���Ȩ�ޣ�
        // ��ʱ������Ȧ������������һ���̷۴������ã�
        //�̷�ԭ����100�����Ǵ����200���������Ӽ��ˣ��������һ���������ǰ��ִ���˸��ӵĲ���������Կ���������ָ���������ڷ���ǰ��ִ���˸��Ӳ�����
        MilkProxy milkProxy = new MilkProxy();

        //����׼����5���̷�
        milkProxy.sell(5);
        //������10��
        milkProxy.sell(10);
        //������20��
        milkProxy.sell(20);

        System.out.println("�������棺" + milkProxy.computeProfit());
    }
}


interface Milk {
    void sell(int number);
}

class Manufacturer implements Milk {

    private int number = 2000;
    private String name;
    private int price;
    private int saledCount = 0;

    public int getPrice() {
        return price;
    }

    public Manufacturer() {
        name = "ţ��";
        price = 100;
    }

    public void sell(int number) {
        System.out.println("��������  " + number + "  ���̷۸�����");
        saledCount += number;
    }
}

class MilkProxy implements Milk {

    //����֪�����������Ķ��������̣�
    Manufacturer manufacturer = new Manufacturer();
    private int price = 0;
    private int saledCount = 0;
    private long profit = 0;
    private int size = 0;

    public MilkProxy() {
        this.price = 200;
    }

    @Override
    public void sell(int number) {
        size += number;
        while (size > 20) {
            //�������ע������д��ʾ�����ܹ������̷�׬��Ǯ��ʱ��ֻ��1��������������ôԸ����һ�˵¹���������̲�������ȥ�������̣����Կ����������
            //manufacturer = new Manufacturer();
            System.out.println("ȥ�û�");
            //ʵ���������ڰ���������ţ�̣�Ȼ���Լ�׬���
            manufacturer.sell(size);
            System.out.println("������  " + size + "  ���̷۸��ͻ�");
            saledCount += size;
            size = 0;
        }
    }

    public long computeProfit() {
        profit = saledCount * (price - manufacturer.getPrice());
        return profit;
    }

}
