package com.zq.virtualmechine.classload;

/**
 * �ᱨ�Ƿ�����ǰ���룬
 * Created by zhengshouzi on 2015/11/25.
 */
public class StaticMethodFieldTest {

    static {
        i=0; //��������ֵ��������������ͨ��
        //System.out.println(i); //������
    }

    static int i=1;

    public static void main(String[] args) {

    }
}
