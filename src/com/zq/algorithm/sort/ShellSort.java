package com.zq.algorithm.sort;

/**
 * Created by zhengshouzi on 2015/11/1.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {57,68,59,52,72,28,96,33,24,19};
        shellSort(a);
    }
    public static  void shellSort(int[] a){
        int d =a.length/2;
        int count=0;
        while (d>=1){
            for (int i = d; i <a.length ; i++) {
                //����
                if (a[i]<a[i-d]){
                    //��ס��Ҫ�����ֵ
                    int j = i-d;
                    int temp = a[i];
                    //��ǰ�Ҳ���λ��
                    //��j>=0����ʾ������λ���ڵ�һ��λ��ʱ����ѭ������temp<a[j]����һ��ѭ���϶�Ҫ���룬���Ų��ϸı�j��ֵ���жϴ������ֵ��֮ǰ��ÿһ��ֵ�Ǹ��󣬲��ѱȽϵ�ֵ����ƶ�dλ,ֱ���ҵ�����λ�á�
                    while (j>=0&&temp<a[j]){
                        a[j+d] = a[j];
                        j-=d;//j�ı仯�ٶ�Ӧ�ú�����һ������Ϊÿһ���붼�����������в�������
                        count++;
                    }
                    //����
                    a[j+d]=temp;
                }
            }
            System.out.print("���� ��");
            for (int i = 0; i <a.length ; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
            d=d/2;
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
        System.out.println(count);
    }
}
