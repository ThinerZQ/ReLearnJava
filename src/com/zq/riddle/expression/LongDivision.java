package com.zq.riddle.expression;

/**
 * MICROS_PER_DAY�ļ�������ˡ������������������int������ִ�еģ����е��������֮��Ž�������뵽long��
 *
 * Created by zhengshouzi on 2015/7/7.
 */
public class LongDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY =24*60*60*1000*1000;
        final long MILLIS_PER_DAY=24*60*60*1000;

        System.out.println(MICROS_PER_DAY/MILLIS_PER_DAY);

    }
}
