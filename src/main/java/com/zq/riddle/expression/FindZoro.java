package com.zq.riddle.expression;

/**
 * �����¸���Ի��Ҽ����Ƿǳ������ʵģ��������ܽ�0.1��������10���κθ��ݾ�ȷ�ı�ʾΪһ���������޵Ķ�����С��
 * <p/>
 * �������ʹ��int����λ������bigdecimal ��string��������bigdicimal
 * Created by zhengshouzi on 2015/7/7.
 */

public class FindZoro {
    public static void main(String[] args) {
        double k = 2.00 - 1.10;
        System.out.println(k);
        System.out.printf("%.2f%n", k);
        System.out.println(2.00 - 1.10);

        System.out.println(2.00 - 1.15);
    }
}
