package com.zq.designpattern.adatper;

/**
 * Created by zhengshouzi on 2015/10/26.
 */
//���ײ����ı�׼
interface ThreeHole {

    void doSomething();

}

//���ײ�����ʵ��
class ThreeHoleImpl implements ThreeHole {

    @Override
    public void doSomething() {
        System.out.println("ʹ��    ����   ���");
    }
}

//���ײ����ı�׼
interface TwoHole {
    void doSomething();
}

//���ײ�����ʵ��
class TwoHoleImpl implements TwoHole {
    @Override
    public void doSomething() {
        System.out.println("ʹ��    ����     ���");
    }
}

//���� ת ���׵�������
class Three_Swith_Two_Adapter implements ThreeHole {

    private TwoHole twoHole;

    //�������� ����Ҫ�� һ�����׵Ĳ�ڲ��ܹ���
    public Three_Swith_Two_Adapter(TwoHole twoHole) {
        this.twoHole = twoHole;
    }

    @Override
    public void doSomething() {
        twoHole.doSomething();
    }
}

class Hotel {

    //�ù�Ĭ�������׵ĳ����
    private ThreeHole threeHole = new ThreeHoleImpl();

    //���ùݼ���������
    public void setSwitcher(ThreeHole threeHole) {
        this.threeHole = threeHole;
    }

    //���
    public void charge() {
        threeHole.doSomething();
    }

}

public class AdapterPattern {

    public static void main(String[] args) {

        //����һ���ù�ס��
        Hotel hotel = new Hotel();
        //����������׵ĳ��������ʼ��磬ֱ�ӳ��
        hotel.charge();


        //���������Ƕ��׵ĳ�������ó����׵ĳ����������û�����
        TwoHole twoHole = new TwoHoleImpl();
        //��ʱ������¥��һ��  ����  ת��  ���׵�������
        //�������Ĺ��캯����˵����Ҫһ�����׵Ĳ�ͷ����������
        ThreeHole threeHole = new Three_Swith_Two_Adapter(twoHole);
        //���ʱ�������������ùݵ�  �����Ų���
        hotel.setSwitcher(threeHole);
        //��ʼ���
        hotel.charge();

    }
}

